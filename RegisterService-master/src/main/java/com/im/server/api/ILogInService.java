package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.LoginResponse;
import com.im.server.mode.Response;
import com.im.server.mode.paramter.LoginRequestEntity;
import com.im.server.service.IMService;
import com.im.server.service.LoginService;
import com.im.server.service.PersonMgtService;
import com.im.server.utils.RandomVGenerator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.im.server.common.Constants.Status.ERROR;
import static com.im.server.utils.ParamerChecker.isNull;
import static com.im.server.utils.ParamerChecker.isNullOrEmpty;

/**
 * Created by majun on 16/3/2.
 */
@RestController
@RequestMapping("/register/login/service")
public class ILogInService {

    private Log logger = LogFactory.getLog(ILogInService.class);

    @Autowired
    private IMService imService;

    @Autowired
    private PersonMgtService personMgtService;

    @Autowired
    private LoginService loginService;


    //相当于getPassword
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public Response test(@RequestParam("name") String name) {
        return Response.success(name);
    }

    //相当于getPassword
    @RequestMapping(path = "/getValidateCode")
    public Response getValidateCode(@RequestBody LoginRequestEntity loginRequestEntity) {

        logger.info(String.format("获取手机验证码, 输入参数=%s", loginRequestEntity));
        if (isNull(loginRequestEntity) || isNull(loginRequestEntity.getPhone()) || isNull(loginRequestEntity.getIdentity())) {
            return Constants.ErrorResponse.miss_param_error;
        }

        //根据手机号+身份来判断学生是否存在
        Long pid;
        try {
            pid = personMgtService.getPid(loginRequestEntity.getPhone(), loginRequestEntity.getIdentity());
            //学生不存在
            if (pid == null || pid == 0) {
                return Constants.ErrorResponse.no_such_person;
            }
        } catch (ServiceException e) {
            return Constants.ErrorResponse.no_such_person;
        }

        try {
            //使用Redis设置过期时间
            //从数库中获取code, 如果
            String randomValue = loginService.getPWD(loginRequestEntity.getPhone());
            if (isNullOrEmpty(randomValue)) {
                randomValue = RandomVGenerator.getRandomValue();
                //保存登陆密码
                loginService.insertLoginEntity(pid, loginRequestEntity.getPhone(), randomValue);
            }
            //发送验证码
            imService.sendValidateCode(loginRequestEntity.getPhone(), randomValue);
        } catch (ServiceException exp) {
            logger.error(String.format("操作异常, errorCode=%s, msg=%s", exp.getCode(), exp.getMessage()));
            return Constants.ErrorResponse.send_validate_code_error;
        }
        return Response.success(pid);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequestEntity loginRequestEntity) {

        logger.info(String.format("login收到数据, loginRequestEntity=%s", loginRequestEntity));

        if (isNull(loginRequestEntity) ||
                isNull(loginRequestEntity.getIdentity()) || isNull(loginRequestEntity.getPhone())
                || isNull(loginRequestEntity.getPwd())) {
            return new Response().setStatus(ERROR).setData("缺少关键参数!!!");
        }

        try {
            boolean exist = loginService.isExist(loginRequestEntity.getPhone(),
                    loginRequestEntity.getPwd());

            if (!exist) {
                return Response.fail("登陆验证失败, 用户名或验证码有误!!!");
            }
        } catch (ServiceException exp) {
            logger.error(String.format("调用loginService判断登陆验证失败, errorCode=%s, msg=%s", exp.getCode(), exp.getMessage()));
            return Constants.ErrorResponse.access_db_error;
        }
        try {
            LoginResponse loginResponse = personMgtService.getPerInfo(loginRequestEntity.getPhone(), loginRequestEntity.getIdentity());
            return Response.success(loginResponse);
        } catch (ServiceException exp) {
            logger.error(String.format("调用personMgtService获取personInfo, errorCode=%s, msg=%s", exp.getCode(), exp.getMessage()));
            return Constants.ErrorResponse.access_db_error;

        }
    }


}

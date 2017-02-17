package com.im.server.api;

import com.im.server.common.ServiceException;
import com.im.server.dao.UnivMgtServiceDao;
import com.im.server.mode.Response;
import com.im.server.mode.db.Student;
import com.im.server.mode.db.University;
import com.im.server.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.im.server.common.Constants.Status.SUCCESS;

/**
 * Created by majun on 16/3/2.
 */
@RestController
@RequestMapping("/mgt/service")
public class IPersonMgtService {

    private Log logger = LogFactory.getLog(IPersonMgtService.class);
    //学生信息输入
    @Autowired
    private IdWorkerService idWorkerService;

    @Autowired
    private UnivMgtService univMgtService;

    @Autowired
    private CollegeMgtService collegeMgtService;

    @Autowired
    private GradeMgtService gradeMgtService;

    @Autowired
    private ClassMgtService classMgtService;

    @RequestMapping(path = "/create/student")
    public Response createStudentEntity(@RequestBody Student student) {

        logger.info(String.format("输入学生信息, student=%s", student));

        if(student.getUnivId() == null){

            try {
                List<University> universityEntities =
                        univMgtService.getUniversityEntities(student.getUnivName());
                University university = universityEntities.stream().findFirst().get();

                student.setUnivAddress(university.getAddress())
                        .setUnivId(Long.valueOf(university.getId()))
                        .setUnivCode(university.getCode());
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

        if(student.getCollegeId()==null) {
            try {
                Long collegeId = collegeMgtService.getCollegeId(student.getUnivId(), student.getCollegeName());
                student.setCollegeId(collegeId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

        //生成年级id
        if(student.getGradeId()==null){
            Long gradeId = gradeMgtService.getGradeId(student.getCollegeId(), student.getGradeName(), student.getLevel());
            student.setGradeId(gradeId);
        }
        //生成班级id
        if(student.getClassId() == null){

        }
        //直接写数据库
        long pid = idWorkerService.nextId();
        student.setPid(pid);

        return new Response().setData(pid).setStatus(SUCCESS);
    }
    //学生信息查询

    //学生xx账号管理

}

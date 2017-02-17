package com.im.server.api;

import com.im.server.ServerApplication;
import com.im.server.mode.db.Major;
import com.im.server.service.MajorMgtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by majun on 16/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class MajorFileService {
    @Autowired
    private MajorMgtService majorMgtService;

    @Test
    public void transform_major_from_txt_to_db() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("major.txt"));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] split = line.split(",");
            Major major = new Major().setName(split[0].trim()).setCode(split[1].trim());
            majorMgtService.createMajorEntity(major);
        }
    }

//    public void getPredictLabel(Point target, int k) {
//        ArrayList<Point> points = Lists.newArrayList(new Point(1.0, 1.1, "A"), new Point(1.0, 1.0, "A"), new Point(0, 0, "B"), new Point(1.0, 1.1, "B"));
//
//        points.stream().map(point -> point.setDistance(getDistance(point, target)))
//                .sorted((o1, o2) -> o1.getDistance() < o2.getDistance() ? 1 : 0)
//                .limit(k).map(point ->point.getLabel())
//                .collect(Collectors.groupingBy();
//    }
//
//    private double getDistance(Point A, Point B) {
//        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2));
//    }

}

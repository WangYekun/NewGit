package com.imooc.mvcdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imooc.mvcdemo.model.Chapter;
import com.imooc.mvcdemo.model.Course;
import com.imooc.mvcdemo.service.CourseService;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Override
    public Course getCourseById(Integer courseId) {

        Course course = new Course();

        course.setCourseId(courseId);
        course.setTitle("MVC");
        course.setImgPath("resources/imgs/spring-mvc.jpg");
        course.setLearningNum(12345);
        course.setLevel(2);
        course.setLevelDesc("intermediate");
        course.setDuration(7200L);
        course.setDescr("Threads also need to learn");

        List<Chapter> chapterList = new ArrayList<Chapter>();

        warpChapterList(courseId, chapterList);

        course.setChapterList(chapterList);

        return course;
    }

    private void warpChapterList(Integer courseId, List<Chapter> chapterList) {
        Chapter chapter = new Chapter();
        chapter.setId(1);
        chapter.setCourseId(courseId);
        chapter.setOrder(1);
        chapter.setTitle("Chapter 1 Introduction to Multithread Background Knowledge");
        chapter.setDescr("This chapter introduces background concepts related to multithreaded programming");
        chapterList.add(chapter);

        chapter = new Chapter();
        chapter.setId(2);
        chapter.setCourseId(courseId);
        chapter.setOrder(2);
        chapter.setTitle("Chapter 2 Java Thread Initial Experience");
        chapter.setDescr("Java language level support for threads, how to create, " +
                "start and stop threads. How to use common threading methods. Understanding Thread Code with Sui and Tang Dynasties");
        chapterList.add(chapter);

    }


}

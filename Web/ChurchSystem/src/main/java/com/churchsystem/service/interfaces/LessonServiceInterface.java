package com.churchsystem.service.interfaces;

import com.churchsystem.entity.LessonDisplayEntity;
import com.churchsystem.entity.LessonEntity;

import java.util.List;

/**
 * Created by Vongnlh on 9/9/2017.
 */
public interface LessonServiceInterface {


    List<LessonEntity> getAllLessonOfChurch(int churchId);

    void insertLesson(LessonEntity lessonEntity);


    List<LessonDisplayEntity> getAllLesson(int churchId);

}

package com.churchsystem.model.interfaces;

import com.churchsystem.entity.LessonDisplayEntity;
import com.churchsystem.entity.LessonEntity;

import java.util.List;

/**
 * Created by Vongnlh on 9/8/2017.
 */
public interface LessonModelInterface {
    List<LessonEntity> getAllLessonOfChurch(int churchId);

    void insertLesson(LessonEntity lessonEntity);

    List<LessonDisplayEntity> getAllLesson(int churchId);

}

package com.churchsystem.service;

import com.churchsystem.entity.LessonDisplayEntity;
import com.churchsystem.entity.LessonEntity;
import com.churchsystem.model.interfaces.LessonModelInterface;
import com.churchsystem.service.interfaces.LessonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vongnlh on 9/9/2017.
 */
@Service
@Transactional
public class LessonService implements LessonServiceInterface {
    @Autowired
    LessonModelInterface lessonModelInterface;

    @Override
    public List<LessonEntity> getAllLessonOfChurch(int churchId) {
        List<LessonEntity> lessonEntities = lessonModelInterface.getAllLessonOfChurch(churchId);

        return lessonEntities;
    }

    @Override
    public void insertLesson(LessonEntity lessonEntity) {
        lessonModelInterface.insertLesson(lessonEntity);
    }

    @Override
    public List<LessonDisplayEntity> getAllLesson(int churchId){
        return lessonModelInterface.getAllLesson(churchId);
    }

}

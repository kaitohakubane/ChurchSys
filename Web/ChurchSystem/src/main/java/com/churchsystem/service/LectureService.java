package com.churchsystem.service;

import com.churchsystem.entity.LectureEntity;
import com.churchsystem.model.interfaces.LectureModelInterface;
import com.churchsystem.service.interfaces.LectureServiceInterface;
import com.churchsystem.service.interfaces.LessonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vongnlh on 9/16/2017.
 */
@Service
@Transactional
public class LectureService implements LectureServiceInterface{
    @Autowired
    LectureModelInterface lectureModelInterface;

    @Override
    public List<LectureEntity> getAllLecture(int churchId) {
        List<LectureEntity> lectureEntities = lectureModelInterface.getAllLecture(churchId);
        return lectureEntities;
    }
    public void insertLecture(LectureEntity lectureEntity){
        lectureModelInterface.insertLecture(lectureEntity);
    }
}

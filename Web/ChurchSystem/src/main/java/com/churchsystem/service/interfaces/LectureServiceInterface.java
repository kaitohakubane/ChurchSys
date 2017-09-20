package com.churchsystem.service.interfaces;

import com.churchsystem.entity.LectureEntity;

import java.util.List;

/**
 * Created by Vongnlh on 9/16/2017.
 */
public interface LectureServiceInterface {
    List<LectureEntity> getAllLecture(int churchId);
    void insertLecture(LectureEntity lectureEntity);
}

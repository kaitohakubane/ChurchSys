package com.churchsystem.service;

import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Service
@Transactional
public class ChurchService implements ChurchServiceInterface{
    @Autowired
    ChurchModelInterface churchModelInterface;
    public ChurchEntity getChurchById(int churchId){
        return churchModelInterface.getChurchById(churchId);
    }
}

package com.churchsystem.service;

import com.churchsystem.entity.ManagerRefEntity;
import com.churchsystem.model.interfaces.ManagerModelInterface;
import com.churchsystem.service.interfaces.ManagerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Service
@Transactional
public class ManagerService implements ManagerServiceInterface{
    @Autowired
    ManagerModelInterface managerModelInterface;
    public List<ManagerRefEntity> getManagerBySub(int subId){
        List<ManagerRefEntity> results=managerModelInterface.getManagerBySub(subId);
        return results;
    }
}

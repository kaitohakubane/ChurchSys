package com.churchsystem.service;

import com.churchsystem.model.interfaces.TypeModelInterface;
import com.churchsystem.service.interfaces.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Service
@Transactional
public class TypeService implements TypeServiceInterface {
    @Autowired
    TypeModelInterface typeModelInterface;

    public List<TypeEntity> getAllType(){
        List<TypeEntity> results=typeModelInterface.getAllType();
        return results;
    }
}

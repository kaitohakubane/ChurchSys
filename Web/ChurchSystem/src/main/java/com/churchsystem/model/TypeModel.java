package com.churchsystem.model;

import com.churchsystem.entity.TypeEntity;
import com.churchsystem.model.common.CommonDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Repository
public class TypeModel extends CommonDAO {
    public List<TypeEntity> getAllType(){
        List<TypeEntity> results=getSession().createCriteria(TypeEntity.class).list();
        return results;
    }
}

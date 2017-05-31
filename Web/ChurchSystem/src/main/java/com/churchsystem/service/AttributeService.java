package com.sneakergo.service;

import com.sneakergo.entity.AttributeEntity;
import com.sneakergo.model.interfaces.AttributeModelInterface;
import com.sneakergo.service.interfaces.AttributeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hung on 11/29/2016.
 */
@Service
@Transactional
public class AttributeService implements AttributeServiceInterface {
    @Autowired
    AttributeModelInterface attributeModelInterface;

    @Override
    public AttributeEntity getAttributeBySize(String size) {
        return attributeModelInterface.getAttributeBySize(size);
    }

    @Override
    public void insertAttribute(AttributeEntity attributeEntity) {
        attributeModelInterface.insertAttribute(attributeEntity);
    }

    @Override
    public AttributeEntity getAttributeById(int attId){
        return attributeModelInterface.getAttributeById(attId);
    }


}

package com.sneakergo.service.interfaces;

import com.sneakergo.entity.AttributeEntity;

/**
 * Created by Hung on 11/29/2016.
 */
public interface AttributeServiceInterface {
    AttributeEntity getAttributeBySize(String size);

    void insertAttribute(AttributeEntity attributeEntity);

    AttributeEntity getAttributeById(int attId);
}

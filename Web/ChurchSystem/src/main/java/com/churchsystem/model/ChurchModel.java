package com.churchsystem.model;

import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Repository
public class ChurchModel extends CommonDAO implements ChurchModelInterface {
    @Override
    public ChurchEntity getChurchById(){
        return null;
    }
}

package com.churchsystem.service;

import com.churchsystem.model.interfaces.RoomModelInterface;
import com.churchsystem.service.interfaces.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
@Service
@Transactional
public class RoomService implements RoomServiceInterface{
    @Autowired
    RoomModelInterface roomModelInterface;
    public List<RoomEntity> getRoomBySub(Integer subId){
        List<RoomEntity> results=roomModelInterface.getRoomBySub(subId);
        return results;
    }
}

package com.churchsystem.service;

import com.churchsystem.entity.RoomEntity;
import com.churchsystem.model.interfaces.RoomModelInterface;
import com.churchsystem.service.interfaces.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
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
    public RoomEntity getRoomById(Integer roomId){
        return roomModelInterface.getRoomById(roomId);
    }
    public Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId){
        return roomModelInterface.getSuitableRoomForSlot(slotHourId,slotDate,churchId);
    }
    public List<RoomEntity> getListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId){
        return roomModelInterface.getListSuitableRoomForSlot(newStartTime,newEndTime,slotDate,churchId);
    }
    public Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId,int roomId){
        return roomModelInterface.checkRoomForSlot(slotHourId,slotDate,churchId,roomId);
    }
}

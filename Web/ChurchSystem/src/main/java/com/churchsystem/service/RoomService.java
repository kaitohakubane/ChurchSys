package com.churchsystem.service;

import com.churchsystem.entity.RoomEntity;
import com.churchsystem.entity.RoomcapableEntity;
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
public class RoomService implements RoomServiceInterface {
    @Autowired
    RoomModelInterface roomModelInterface;

    @Override
    public List<RoomEntity> getRoomBySub(Integer subId) {
        List<RoomEntity> results = roomModelInterface.getRoomBySub(subId);
        return results;
    }

    @Override
    public RoomEntity getRoomById(Integer roomId) {
        return roomModelInterface.getRoomById(roomId);
    }

    @Override
    public Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId, int subId) {
        return roomModelInterface.getSuitableRoomForSlot(slotHourId, slotDate, churchId, subId);
    }

    @Override
    public Integer getLastSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId, int subId) {
        return roomModelInterface.getLastSuitableRoomForSlot(slotHourId, slotDate, churchId, subId);
    }

    @Override
    public List<RoomEntity> getListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        return roomModelInterface.getListSuitableRoomForSlot(newStartTime, newEndTime, slotDate, churchId, subId);
    }

    @Override
    public Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId, int roomId, int subId) {
        return roomModelInterface.checkRoomForSlot(slotHourId, slotDate, churchId, roomId, subId);
    }

    @Override
    public List<Integer> getIdListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        return roomModelInterface.getIdListSuitableRoomForSlot(newStartTime, newEndTime, slotDate, churchId, subId);
    }

    @Override
    public List<RoomEntity> getAllRoom(int churchId) {
        return roomModelInterface.getAllRoom(churchId);
    }

    @Override
    public void insertRoom(RoomEntity roomEntity) {
        roomModelInterface.insertRoom(roomEntity);
    }

    @Override
    public RoomEntity getRoomByNameAndChurchId(String roomName, int churchId, int status) {
        return roomModelInterface.getRoomByNameAndChurchId(roomName, churchId, status);
    }

    @Override
    public void mapRoomWithSubject(int roomId, int subId) {
        RoomcapableEntity roomcapableEntity = new RoomcapableEntity();
        roomcapableEntity.setRoomId(roomId);
        roomcapableEntity.setSubId(subId);
        roomModelInterface.mapRoomWithSubject(roomcapableEntity);
    }

    @Override
    public void updateRoom(RoomEntity roomEntity) {
        roomModelInterface.updateRoom(roomEntity);
    }
}

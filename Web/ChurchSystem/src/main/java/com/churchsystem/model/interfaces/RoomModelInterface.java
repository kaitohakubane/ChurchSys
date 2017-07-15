package com.churchsystem.model.interfaces;

import com.churchsystem.entity.RoomEntity;
import com.churchsystem.entity.RoomcapableEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface RoomModelInterface {
    List<RoomEntity> getRoomBySub(Integer subId);

    RoomEntity getRoomById(Integer roomId);

    Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId);

    List<RoomEntity> getListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId);

    Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId, int roomId);

    List<Integer> getIdListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId);

    List<RoomEntity> getAllRoom(int churchId);

    void insertRoom(RoomEntity roomEntity);

    public RoomEntity getRoomByNameAndChurchId(String roomName, int churchId);

    void mapRoomWithSubject(RoomcapableEntity roomcapableEntity);
}

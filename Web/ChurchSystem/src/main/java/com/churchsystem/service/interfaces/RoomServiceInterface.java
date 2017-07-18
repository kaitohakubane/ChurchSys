package com.churchsystem.service.interfaces;

import com.churchsystem.entity.RoomEntity;
import com.churchsystem.entity.RoomcapableEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface RoomServiceInterface {
    List<RoomEntity> getRoomBySub(Integer subId);

    RoomEntity getRoomById(Integer roomId);

    Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId);

    List<RoomEntity> getListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId);

    List<Integer> getIdListSuitableRoomForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId);

    Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId, int roomId);

    List<RoomEntity> getAllRoom(int churchId);

    void insertRoom(RoomEntity roomEntity);

    RoomEntity getRoomByNameAndChurchId(String roomName, int churchId, int status);

    void mapRoomWithSubject(int roomId, int subId);
    void updateRoom(RoomEntity roomEntity);
}

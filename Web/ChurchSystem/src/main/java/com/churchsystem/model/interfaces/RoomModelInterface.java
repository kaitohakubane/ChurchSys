package com.churchsystem.model.interfaces;

import com.churchsystem.entity.RoomEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface RoomModelInterface {
    List<RoomEntity> getRoomBySub(Integer subId);
    Integer getSuitableRoomForSlot(int slotHourId, Date slotDate, int churchId);
    Integer checkRoomForSlot(int slotHourId, Date slotDate, int churchId,int roomId);
}

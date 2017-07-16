package com.churchsystem.service.interfaces;

import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.entity.TypeEntity;

import java.sql.Time;
import java.text.ParseException;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
public interface SlotServiceInterface {
    List<SlothourEntity> getListOfSlotHour();

    TypeEntity getTypeByDescription(String type);

    void addNewType(TypeEntity typeEntity);

    List<SlotEntity> getSlotByEventId(int eventId);

    SlotEntity getSlotById(int slotId);

    void deleteSlotHourBySlotId(int slotId);

    void updateSlot(SlotEntity SlotEntity);

    List<SlothourEntity> getSlotHourByTimeRange(String startTime, int estTime ) throws ParseException;

    List<SlotEntity> getListSlotOfClass (int slotId);

    void deleteSlot(int slotId);
}

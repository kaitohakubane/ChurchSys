package com.churchsystem.model.interfaces;

import com.churchsystem.entity.InclusionEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.entity.TypeEntity;

import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
public interface SlotModelInterface {
    List<SlothourEntity> getListOfSlotHour();

    void mappingSlotHour(InclusionEntity inclusionEntity);

    void addNewSlot(SlotEntity slotEntity);

    SlotEntity getUnassignedEventSlot(int conductorId);

    void updateSlot(SlotEntity slotEntity);

    List<SlotEntity> getSlotByEventId(int eventId);

    TypeEntity getTypeByDescription(String type);

    SlotEntity getSlotById(int slotId);

    void addNewType(TypeEntity typeEntity);

    void deleteSlotHourBySlotId(int slotId);

    List<SlothourEntity> getSlotHourByTimeRange(Time startTime, Time endTime);

    List<SlotEntity> getListSlotOfClass(int slotId);

    void deleteSlot(int slotId);

    List<SlothourEntity> getListSlotHourByTime(Time startTime, Time endTime);
}

package com.churchsystem.model.interfaces;

import com.churchsystem.entity.InclusionEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;

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
    List<SlotEntity> getSlotByEventId(int slotId);
}

package com.churchsystem.service;

import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.entity.TypeEntity;
import com.churchsystem.model.interfaces.SlotModelInterface;
import com.churchsystem.service.interfaces.SlotServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.text.ParseException;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Service
@Transactional
public class SlotService implements SlotServiceInterface {
    @Autowired
    SlotModelInterface slotModelInterface;

    public List<SlothourEntity> getListOfSlotHour() {
        return slotModelInterface.getListOfSlotHour();
    }

    @Override
    public TypeEntity getTypeByDescription(String type) {
        return slotModelInterface.getTypeByDescription(type);
    }

    @Override
    public void deleteSlotHourBySlotId(int slotId) {
        slotModelInterface.deleteSlotHourBySlotId(slotId);
    }

    @Override
    public SlotEntity getSlotById(int slotId) {
        return slotModelInterface.getSlotById(slotId);
    }

    @Override
    public void updateSlot(SlotEntity SlotEntity){
        slotModelInterface.updateSlot(SlotEntity);
    }

    @Override
    public void addNewType(TypeEntity typeEntity) {
        slotModelInterface.addNewType(typeEntity);
    }

    @Override
    public List<SlotEntity> getSlotByEventId(int eventId) {
        return slotModelInterface.getSlotByEventId(eventId);
    }

    @Override
    public List<SlothourEntity> getSlotHourByTimeRange(String startTimeStr, int estTime ) throws ParseException{
        Time startTime= DateUtils.parseStringToTime(startTimeStr);
        Time endTime=DateUtils.getEndTimeFromRange(startTime,estTime);
        return slotModelInterface.getSlotHourByTimeRange(startTime,endTime);
    }

    @Override
    public List<SlotEntity> getListSlotOfClass (int slotId){
        return slotModelInterface.getListSlotOfClass(slotId);
    }
}

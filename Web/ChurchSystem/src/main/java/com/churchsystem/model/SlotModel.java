package com.churchsystem.model;

import com.churchsystem.entity.InclusionEntity;
import com.churchsystem.entity.SlotEntity;
import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.SlotModelInterface;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Repository
public class SlotModel extends CommonDAO implements SlotModelInterface {

    @Override
    public List<SlothourEntity> getListOfSlotHour(){
        Criteria criteria=getSession().createCriteria(SlothourEntity.class);
        List<SlothourEntity> result=criteria.list();
        return result;
    }

    @Override
    public void addNewSlot(SlotEntity slotEntity){
        getSession().persist(slotEntity);
    }

    @Override
    public void mappingSlotHour(InclusionEntity inclusionEntity){
        getSession().persist(inclusionEntity);
    }
}

package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.SQLParamConstant;
import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.UserModelInterface;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
@Repository
public class UserModel extends CommonDAO implements UserModelInterface {

    @Override
    public UserEntity getUserByAccountId(String accountId) {
        Criteria criteria=getSession().createCriteria(UserEntity.class).add(Restrictions.eq("accountId",accountId));
        UserEntity result=(UserEntity) criteria.uniqueResult();
        return result;
    }


    @Override
    public int getChurchIdByUserId(int userId){
        Criteria criteria=getSession().createCriteria(InteractionEntity.class)
                .add(Restrictions.eq("userId",userId)).add(Restrictions.eq("enabled",true));
        InteractionEntity interactionEntity=(InteractionEntity) criteria.uniqueResult();
        return interactionEntity.getChurchId();
    }

    @Override
    public int getSuitableConductorForSlot(int slotHourId,Date slotDate,int churchId){
        Query query=getSession().createSQLQuery(SQLParamConstant.GET_SUITABLE_CONDUCTOR_FOR_SLOT)
                .setParameter(ParamConstant.SLOT_HOUR,slotHourId).setParameter(ParamConstant.CHURCH_ID,churchId)
                .setParameter(ParamConstant.SLOT_DATE,slotDate);
        int result=(Integer)query.uniqueResult();
        return result;
    }
}

package com.churchsystem.model;

import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.UserModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
}

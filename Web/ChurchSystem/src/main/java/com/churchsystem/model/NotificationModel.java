package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.NotificationEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.NotificationModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/11/2017.
 */
@Repository
public class NotificationModel extends CommonDAO implements NotificationModelInterface {

    @Override
    public void addNotification(NotificationEntity notificationEntity){
        getSession().persist(notificationEntity);
    }

    @Override
    public void updateNotification(NotificationEntity notificationEntity){
        getSession().saveOrUpdate(notificationEntity);
    }

    @Override
    public List<NotificationEntity> getUserNotification(int userId,int numberOfNoti){
        Criteria criteria=getSession().createCriteria(NotificationEntity.class)
                .add(Restrictions.eq(ParamConstant.USER_ID,userId)).addOrder(Order.desc(ParamConstant.NOTIFICATION_TIME))
                .setMaxResults(numberOfNoti);
        List<NotificationEntity> result=criteria.list();
        return result;
    }
}

package com.churchsystem.model;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChatmessageEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.ChatModelInterface;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hung on 9/12/2017.
 */
@Repository
public class ChatModel extends CommonDAO implements ChatModelInterface {
    @Override
    public void createChat(ChatmessageEntity message) {
        getSession().persist(message);
    }

    @Override
    public List<ChatmessageEntity> getChatHistory(int senderId, int receiverId) {
        Criteria criteria = getSession().createCriteria(ChatmessageEntity.class)
                .add(Restrictions.eq(ParamConstant.SENDER_ID, senderId))
                .add(Restrictions.eq(ParamConstant.RECEIVER_ID, receiverId)).addOrder(Order.asc(ParamConstant.MESSAGE_ID));
        List<ChatmessageEntity> result = criteria.list();
        return result;
    }
}

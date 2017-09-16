package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChatmessageEntity;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.SettingEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.interfaces.ChatServiceInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import com.mysql.fabric.xmlrpc.base.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Hung on 9/1/2017.
 */
@Controller
public class ChatController {
    @Autowired
    ChatServiceInterface chatServiceInterface;

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @RequestMapping(value = PageConstant.MANAGER_CONTACT_URL, method = RequestMethod.GET)
    public ModelAndView loadManagerContact(@RequestParam(value= ParamConstant.ACCOUNT_ID,required = false) String accountId) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.MANAGER_CONTACT_PAGE);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
        modelAndView.addObject(ParamConstant.USER_ID, userEntity.getUserId());
        UserEntity entity=null;
        if(accountId!=null){
            entity=userServiceInterface.getUserByAccountId(accountId);
        }
        modelAndView.addObject(ParamConstant.CHATTER_ID,entity);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHAT_URL, method = RequestMethod.POST)
    public void loadManagerContact(@RequestParam(value = ParamConstant.CHAT_MESSAGE) String message,
                                   @RequestParam(value = ParamConstant.CHURCH_ID, required = false) Integer churchId,
                                   @RequestParam(value = ParamConstant.ACCOUNT_ID, required = false) String accountId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
        if (churchId != null) {
            int receiverId = userServiceInterface.getChurchManager(churchId);
            chatServiceInterface.sendChat(userEntity.getUserId(), receiverId, message);
        }

        if (accountId != null) {
            UserEntity receiver = userServiceInterface.getUserByAccountId(accountId);
            chatServiceInterface.sendChat(userEntity.getUserId(), receiver.getUserId(), message);
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_CHAT_HISTORY, method = RequestMethod.POST)
    public List<ChatmessageEntity> loadChatHistory(@RequestParam(value = ParamConstant.ACCOUNT_ID) String senderId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity manager = userServiceInterface.getUserByAccountId(auth.getName());
        UserEntity sender = userServiceInterface.getUserByAccountId(senderId);
        List<ChatmessageEntity> result = chatServiceInterface.getChatHistory(sender.getUserId(), manager.getUserId());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.LOAD_USER, method = RequestMethod.POST)
    public UserEntity loadChatUser(@RequestParam(value = ParamConstant.ACCOUNT_ID) String senderId) {
        UserEntity sender = userServiceInterface.getUserByAccountId(senderId);
        return sender;
    }

}

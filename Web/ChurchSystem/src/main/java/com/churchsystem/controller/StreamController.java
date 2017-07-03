package com.churchsystem.controller;

import com.churchsystem.common.api.YoutubeAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.StreamEntity;
import com.churchsystem.entity.StreamJsonEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by hungmcse61561-admin on 7/1/2017.
 */
@Controller
public class StreamController {

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.STREAM_URL, method = RequestMethod.GET)
    public ModelAndView loadStreamPage() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.STREAM_PAGE);

        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_STREAM_URL, method = RequestMethod.POST)
    public StreamEntity loadPublicEventRegister(@RequestBody StreamJsonEntity streamJsonEntity, HttpServletRequest request) {
        StreamEntity streamEntity=new StreamEntity();
        try {
            String streamLink = YoutubeAPI.createBroadcast(streamJsonEntity.getStreamTitle(),
                    new Date(System.currentTimeMillis() + UtilsConstant.DEFAULT_DELAY_STREAM_CREATING)
                    , UtilsConstant.DEFAULT_VALIDATE_PORT);
            String streamCode = YoutubeAPI.createStream(streamLink, streamJsonEntity.getResolution());
            YoutubeAPI.bindingBroadcastAndStream(streamCode, streamLink);
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            churchEntity.setStreamLink(churchEntity.getStreamLink() + UtilsConstant.DEFAULT_DELIMETER + streamLink);
            churchServiceInterface.updateChurch(churchEntity);
            streamEntity.setStreamLink(streamLink);
            streamEntity.setStreamCode(streamCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return streamEntity;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.START_STREAM_URL, method = RequestMethod.POST)
    public int startStream(@RequestParam(value = ParamConstant.STREAM_LINK) String broadcastId) {
        try{
            YoutubeAPI.liveStream(broadcastId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return UtilsConstant.STREAM_ON_STATUS;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.FINISH_STREAM_URL, method = RequestMethod.POST)
    public void loadStreamPage(@RequestParam(value = ParamConstant.STREAM_LINK) String broadcastId) {
        try{
            YoutubeAPI.completeStream(broadcastId);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}

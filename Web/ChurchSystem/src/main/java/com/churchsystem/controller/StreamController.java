package com.churchsystem.controller;

import com.churchsystem.common.api.YoutubeAPI;
import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.StreamEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * Created by hungmcse61561-admin on 7/1/2017.
 */
@Controller
public class StreamController {

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.STREAM_URL, method = RequestMethod.POST)
    public ModelAndView loadStreamPage(@RequestParam(value = ParamConstant.STREAM_LINK, required = false) String streamLink,
                                       @RequestParam(value = ParamConstant.STREAM_CODE, required = false) String streamCode) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.STREAM_PAGE);
        modelAndView.addObject(ParamConstant.STREAM_CODE, streamCode);
        modelAndView.addObject(ParamConstant.STREAM_LINK, streamLink);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_STREAM_URL, method = RequestMethod.POST)
    public StreamEntity loadPublicEventRegister(@RequestParam(value = ParamConstant.STREAM_TITLE) String streamTitle,
                                                @RequestParam(value = ParamConstant.STREAM_RESOLUTION) String resolution, HttpServletRequest request) {
        StreamEntity streamEntity = new StreamEntity();
        try {
//            Runtime.getRuntime().exec("cmd /c start startObs.bat");
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(UtilsConstant.SCRIPT_AUTO_START_OBS).getFile());

            Runtime.getRuntime().exec( file.getAbsolutePath());
            String streamLink = YoutubeAPI.createBroadcast(streamTitle,
                    new Date(System.currentTimeMillis() + UtilsConstant.DEFAULT_DELAY_STREAM_CREATING)
                    , UtilsConstant.DEFAULT_VALIDATE_PORT);
            String streamCode = YoutubeAPI.createStream(streamLink, resolution, streamLink);
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);

            if (churchEntity.getStreamLink() == null || churchEntity.getStreamLink() == "") {
                churchEntity.setStreamLink(churchEntity.getStreamLink() + UtilsConstant.DEFAULT_DELIMETER + streamLink);
            } else {
                churchEntity.setStreamLink(streamLink);
            }

            if (churchEntity.getStreamName() == null || churchEntity.getStreamName() == "") {
                churchEntity.setStreamName(churchEntity.getStreamName() + UtilsConstant.DEFAULT_DELIMETER + streamTitle);
            } else {
                churchEntity.setStreamName(streamTitle);
            }
            churchServiceInterface.updateChurch(churchEntity);
            streamEntity.setStreamLink(streamLink);
            streamEntity.setStreamCode(streamCode);
            // Command to create an external process

        } catch (Exception e) {
            e.printStackTrace();
        }
        return streamEntity;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.START_STREAM_URL, method = RequestMethod.POST)
    public void startStream(@RequestParam(value = ParamConstant.STREAM_LINK) String broadcastId) {
        try {
            YoutubeAPI.liveStream(broadcastId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.FINISH_STREAM_URL, method = RequestMethod.POST)
    public void finishStream(@RequestParam(value = ParamConstant.STREAM_LINK) String broadcastId, HttpServletRequest request) {
        try {

            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            churchEntity.setStreamLink(churchEntity.getStreamLink().replace(broadcastId, ""));

            String title = YoutubeAPI.completeStream(broadcastId);

            churchEntity.setStreamName(churchEntity.getStreamLink().replace(title, ""));
            churchServiceInterface.updateChurch(churchEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = PageConstant.STREAM_INSTRUCTION_URL, method = RequestMethod.POST)
    public ModelAndView loadStreamInstruction(@RequestParam(value = ParamConstant.STREAM_LINK, required = false) String streamLink,
                                              @RequestParam(value = ParamConstant.STREAM_CODE, required = false) String streamCode) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.STREAM_INSTRUCTION_PAGE);
        modelAndView.addObject(ParamConstant.STREAM_CODE, streamCode);
        modelAndView.addObject(ParamConstant.STREAM_LINK, streamLink);
        return modelAndView;
    }
}

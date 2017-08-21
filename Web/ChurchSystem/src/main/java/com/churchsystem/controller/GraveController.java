package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.DateUtils;
import com.churchsystem.common.utils.FileUtils;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.GraveServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Trung on 7/30/2017.
 */
@Controller
public class GraveController {
    @Value("${product.image.location}")
    String imagePath;

    @Autowired
    GraveServiceInterface graveServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.GRAVE_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.GRAVE_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_GRAVE_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);

            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
                modelAndView = new ModelAndView(PageConstant.USER_GRAVE_PAGE)
                        .addObject(ParamConstant.CHURCH_OBJECT, churchEntity)
                        .addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE_YARD, method = RequestMethod.POST)
    public List<GraveyardEntity> getGraveYard(HttpServletRequest request, @RequestParam(value = ParamConstant.CHURCH_ID, required = false) String churchIdStr) {
        int churchId;
        if (churchIdStr == null) {
            churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        } else {
            churchId = Integer.parseInt(churchIdStr);
        }
        List<GraveyardEntity> result = graveServiceInterface.getGraveYardOfChurch(churchId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GENERATE_GRAVE_YARD, method = RequestMethod.POST)
    public List<GraveyardEntity> generate(HttpServletRequest request, @RequestParam(value = ParamConstant.WIDTH) String width,
                                          @RequestParam(value = ParamConstant.HEIGHT) String height,
                                          @RequestParam(value = ParamConstant.GRAVE_YARD_PROTOTYPE) String prototypeStr) {
        List<GraveyardEntity> result = new ArrayList<GraveyardEntity>();
        try {

            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            int widthInt = Integer.parseInt(width);
            int heightInt = Integer.parseInt(height);
            int prototype = Integer.parseInt(prototypeStr);
            if (prototype == 1) {
                graveServiceInterface.generateType1Prototype(widthInt, heightInt, churchId);
                result = graveServiceInterface.getGraveYardOfChurch(churchId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE, method = RequestMethod.POST)
    public List<GraveDisplayEntity> getGrave(@RequestParam(value = ParamConstant.GRAVE_YARD_ID) int graveYardId) {
        List<GraveDisplayEntity> result = graveServiceInterface.getGraveOfGraveYard(graveYardId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GENERATE_GRAVE, method = RequestMethod.POST)
    public GraveyardEntity generateGrave(@RequestParam(value = ParamConstant.WIDTH) String width,
                                         @RequestParam(value = ParamConstant.HEIGHT) String height,
                                         @RequestParam(value = ParamConstant.GRAVE_YARD_NAME) String graveYardName,
                                         @RequestParam(value = ParamConstant.GRAVE_YARD_ID) String graveYard) {
        GraveyardEntity result = new GraveyardEntity();
        try {
            int widthInt = Integer.parseInt(width);
            int heightInt = Integer.parseInt(height);
            int graveYardId = Integer.parseInt(graveYard);
            result = graveServiceInterface.getGraveYardById(graveYardId);
            result.setWidth(widthInt);
            result.setHeight(heightInt);
            result.setStatus(ParamConstant.GRAVE_YARD_INITIAL);
            result.setGraveAvailable(heightInt * widthInt);
            result.setName(graveYardName);
            graveServiceInterface.updateGraveYard(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.REGISTER_GRAVE, method = RequestMethod.POST)
    public GraveDisplayEntity registerGrave(@RequestParam(value = ParamConstant.GRAVE_YARD_ID) String graveYardIdStr,
                                            @RequestParam(value = ParamConstant.GRAVE_NAME) String graveNameStr,
                                            @RequestParam(value = ParamConstant.GRAVE_BIRTH) String graveBirthStr,
                                            @RequestParam(value = ParamConstant.GRAVE_HOME_TOWN) String graveTownStr,
                                            @RequestParam(value = ParamConstant.GRAVE_DEATH_DAY) String graveDeathStr,
                                            @RequestParam(value = ParamConstant.GRAVE_PARISH) String graveParishStr,
                                            @RequestParam(value = ParamConstant.GRAVE_IMAGE) MultipartFile graveImgStr,
                                            @RequestParam(value = ParamConstant.GRAVE_POSITION_X) String positionX,
                                            @RequestParam(value = ParamConstant.GRAVE_POSITION_Y) String positionY,
                                            @RequestParam(value = ParamConstant.GRAVE_PHONE, required = false) String phone,
                                            @RequestParam(value = ParamConstant.GRAVE_USER_IDENTITY, required = false) String userIdentity

    ) {
        GraveDisplayEntity result = new GraveDisplayEntity();
        try {
            int graveYardId = Integer.parseInt(graveYardIdStr);
            Date birthDay = DateUtils.getDate(graveBirthStr);
            Date deathDay = DateUtils.getDate(graveDeathStr);
            int x = Integer.parseInt(positionX);
            int y = Integer.parseInt(positionY);


            GraveEntity graveEntity = new GraveEntity();
            graveEntity.setStatus(ParamConstant.GRAVE_PROCESSING);
            graveEntity.setGraveYardId(graveYardId);
            graveEntity.setParish(graveParishStr);
            graveEntity.setHomeTown(graveTownStr);
            graveEntity.setName(graveNameStr);
            graveEntity.setDeathDay(deathDay);
            graveEntity.setBirthDay(birthDay);
            graveEntity.setX(x);
            graveEntity.setY(y);
            File imageDirectory = new File(imagePath);
            if (!imageDirectory.exists()) {
                imageDirectory.mkdirs();
            }

            if (!graveImgStr.isEmpty()) {
                String imageName = StringUtils.generateProductImageName() + StringUtils.getExtension(graveImgStr.getOriginalFilename());
                FileUtils.saveImageFile(graveImgStr, imageDirectory, imageName);
                graveEntity.setImage(imageName);
            }

            graveServiceInterface.addGrave(graveEntity);
            graveEntity = graveServiceInterface.getCreatingGrave(graveYardId, ParamConstant.GRAVE_PROCESSING);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            String loginUser = auth.getName();
            UserEntity userEntity = userServiceInterface.getUserByAccountId(loginUser);
            if (authorities.contains(new SimpleGrantedAuthority(UtilsConstant.MANAGER_USER))) {
                graveEntity.setStatus(ParamConstant.GRAVE_APPROVED);
                graveEntity.setPhone(phone);
                graveEntity.setIdentity(userIdentity);
            } else {
                graveEntity.setStatus(ParamConstant.GRAVE_WAITING_FOR_APPROVE);
                graveEntity.setUserId(userEntity.getUserId());
                graveEntity.setPhone(userEntity.getTel());
            }


            graveServiceInterface.updateGrave(graveEntity);
            result = graveServiceInterface.getGravebyId(graveEntity.getGraveId());

            GraveyardEntity graveyardEntity = graveServiceInterface.getGraveYardById(graveYardId);
            graveyardEntity.setGraveAvailable(graveyardEntity.getGraveAvailable() - 1);
            if(graveyardEntity.getGraveAvailable()==0){
                graveyardEntity.setStatus(ParamConstant.GRAVE_YARD_FULL);
            }
            graveServiceInterface.updateGraveYard(graveyardEntity);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.APPROVE_GRAVE_STATUS, method = RequestMethod.POST)
    public GraveDisplayEntity generateGrave(@RequestParam(value = ParamConstant.GRAVE_ID) String graveId,
                                            @RequestParam(value = ParamConstant.GRAVE_STATUS_TYPE) String type,
                                            @RequestParam(value=ParamConstant.GRAVE_USER_IDENTITY,required = false) String userIdentity) {
        GraveDisplayEntity result = new GraveDisplayEntity();
        try {
            int typeInt = Integer.parseInt(type);
            int graveInt = Integer.parseInt(graveId);
            GraveEntity entity = graveServiceInterface.getGrave(graveInt);
            if (typeInt == ParamConstant.ACCEPT_TYPE) {
                entity.setIdentity(userIdentity);
                entity.setStatus(ParamConstant.GRAVE_APPROVED);
            } else {
                entity.setStatus(ParamConstant.GRAVE_REJECT);
                GraveyardEntity graveyardEntity =graveServiceInterface.getGraveYardById(entity.getGraveYardId());
                graveyardEntity.setGraveAvailable(graveyardEntity.getGraveAvailable()+1);
                graveServiceInterface.updateGraveYard(graveyardEntity);
            }
            graveServiceInterface.updateGrave(entity);
            result = graveServiceInterface.getGravebyId(graveInt);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_GRAVE_OF_CHURCH, method = RequestMethod.POST)
    public List<GraveDisplayEntity> getGrave(HttpServletRequest request, @RequestParam(value = ParamConstant.CHURCH_ID, required = false) String churchIdStr) {
        int churchId;
        if (churchIdStr == null) {
            churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        } else {
            churchId = Integer.parseInt(churchIdStr);
        }
        List<GraveDisplayEntity> result = graveServiceInterface.getChurchGrave(churchId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_GRAVE_YARD, method = RequestMethod.POST)
    public GraveyardEntity createGraveYard(HttpServletRequest request, @RequestParam(value = ParamConstant.GRAVE_TYPE) String type) {
        GraveyardEntity result=new GraveyardEntity();
        try{
            int typeInt=Integer.parseInt(type);
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            if(typeInt==ParamConstant.GRAVE_YARD_NOT_INITIAL){
                result.setChurchId(churchId);
                result.setName("");
                result.setX(ParamConstant.GRAVE_YARD_DEFAULT_X);
                result.setY(ParamConstant.GRAVE_YARD_DEFAULT_Y);
                result.setStatus(ParamConstant.GRAVE_YARD_NOT_INITIAL);
                graveServiceInterface.addGraveYard(result);

            }else{
                result.setChurchId(churchId);
                result.setName(ParamConstant.GATE_DEFAULT_NAME);
                result.setStatus(ParamConstant.GRAVE_YARD_GATE);
                result.setX(ParamConstant.GRAVE_YARD_DEFAULT_X);
                result.setY(ParamConstant.GRAVE_YARD_DEFAULT_Y);
                graveServiceInterface.addGraveYard(result);
            }
            result=graveServiceInterface.getCreatingGraveYard(churchId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATE_GRAVE_YARD, method = RequestMethod.POST)
    public void createGraveYard(HttpServletRequest request,
                                @RequestParam(value = ParamConstant.GRAVE_YARD_ID) String graveYardId,
                                @RequestParam(value = ParamConstant.GRAVE_YARD_X) String xString,
                                @RequestParam(value = ParamConstant.GRAVE_YARD_Y) String yString) {
        try{
            int graveYard=Integer.parseInt(graveYardId);
            int x=Integer.parseInt(xString);
            int y=Integer.parseInt(yString);
            GraveyardEntity result=graveServiceInterface.getGraveYardById(graveYard);
            result.setX(x);
            result.setY(y);
            graveServiceInterface.updateGraveYard(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
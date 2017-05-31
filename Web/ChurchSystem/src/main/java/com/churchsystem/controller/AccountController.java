package com.sneakergo.controller;

import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.common.utils.NumbericUtils;
import com.sneakergo.common.utils.StringUtils;
import com.sneakergo.entity.AccountEntity;
import com.sneakergo.service.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

/**
 * Created by Hung on 12/3/2016.
 */
@Controller
public class AccountController {
    @Autowired
    AccountServiceInterface accountServiceInterface;

    @ResponseBody
    @RequestMapping(value = PageConstant.ACCOUNT_REGISTER_URL, method = RequestMethod.POST)
    public AccountEntity getAccount(@RequestParam(value = ParamConstant.ACCOUNT_ID) String accountId,
                                    @RequestParam(value = ParamConstant.PASSWORD) String password,
                                    @RequestParam(value = ParamConstant.NAME) String name,
                                    @RequestParam(value = ParamConstant.ADDRESS) String address,
                                    @RequestParam(value = ParamConstant.BIRTHDAY) String birthday,
                                    @RequestParam(value = ParamConstant.PHONE) String phone,
                                    @RequestParam(value = ParamConstant.EMAIL) String email) {
        AccountEntity accountEntity = accountServiceInterface.getAccountByID(accountId);
        if (accountEntity == null) {
            accountEntity = new AccountEntity();
            accountEntity.setAccountId(accountId);
            accountEntity.setPassword(StringUtils.generateEncodePassword(password));
            accountEntity.setName(name);
            accountEntity.setAddress(address);
            accountEntity.setPhone(phone);
            accountEntity.setEmail(email);
            String[] birth = StringUtils.formatDate(birthday);
            Date dateOfBirth = NumbericUtils.getDate(birth[UtilsConstant.ZERO],
                    birth[UtilsConstant.ONE], birth[UtilsConstant.TWO]);
            accountEntity.setBirthday(dateOfBirth);
            accountServiceInterface.createAccount(accountEntity);
            return accountEntity;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.CHECK_LOGIN_URL, method = RequestMethod.POST)
    public AccountEntity getAccount(@RequestParam(value = ParamConstant.ACCOUNT_ID) String accountId,
                                    @RequestParam(value = ParamConstant.PASSWORD) String password){
        return accountServiceInterface.checkLogin(accountId,password);
    }
}

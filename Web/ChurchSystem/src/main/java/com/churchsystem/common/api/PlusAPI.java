package com.churchsystem.common.api;


import com.churchsystem.common.constants.UtilsConstant;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Profile;
import com.google.common.collect.Lists;


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by hungmcse61561-admin on 7/26/2017.
 */
public class PlusAPI {
    public static String checkLoginAccount(String tokenName,String checkAccount,int port) throws IOException {

            if(tokenName.equals("-1")||tokenName.equals("")){
                Long randomNumber = System.currentTimeMillis()% UtilsConstant.DEFAULT_GOOGLE_DIVIDER_FOR_TOKEN_NAME;
                tokenName=randomNumber.toString();
            }
            Credential credential = Auth.authorize(Lists.newArrayList(GmailScopes.GMAIL_READONLY, CalendarScopes.CALENDAR), tokenName, port);
            Gmail gmail = new Gmail.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).build();
            Profile profile = gmail.users().getProfile("me").execute();
            if(profile.getEmailAddress().equals(checkAccount)){
                return tokenName;
            }else{
                return null;
            }


    }
}

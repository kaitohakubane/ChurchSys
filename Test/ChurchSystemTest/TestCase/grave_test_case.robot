*** Settings ***
Documentation           This is a test for grave
Library                 Selenium2Library
Resource                ${CURDIR}/Constant/testConstant.robot

*** Keywords ***
Open Browser To Login Page
    Open Browser        ${SERVER}   ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed  ${DELAY}

*** Test Cases ***

Test case prototype

    Open Browser To Login Page
    Click Element           xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Sleep           2
    Input Text              managerId            kietta_manager_hoaminh
    Input Password          password            Abcd1234
    Sleep           2
    Click Element           xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Sleep           5
    Click Element           xpath=//*[@id="sidebar-menu"]/div/ul/li[5]
    Sleep           15
    Click Element           xpath=//*[@id="prototype"]/div/div/div/div[2]/div/div[2]/div[1]/img
    Sleep           25
    Input Text              prototypeWidth          8
    Sleep           2
    Input Text              prototypeHeight         6
    Sleep           2
    Click Button            protoypePopupBtn
    Wait Until Page Contains Element            xpath=//*[@id="graveYard"]/div[2]/div[1]                15
    Sleep           15
    Double Click Element            xpath=//*[@id="graveYard"]/div[2]/div[1]
    Sleep           2
    Click Button            contextBtn
    Sleep           8
    Input Text              graveYardWidth          6
    Sleep           2
    Input Text              graveYardHeight         6
    Sleep           2
    Click Button            intialGraveYard
    Sleep           5
    Double Click Element            xpath=//*[@id="graveYard"]/div[2]/div[1]
    Click Button            contextBtn
    Sleep           15
    [Teardown]      Close Browser

Test case User Grave

    Open Browser To Login Page
    Click Element           xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Sleep          2
    Input Text              managerId            kietta_user
    Input Password          password            Abcd1234
    Sleep          2
    Click Element           xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Sleep          2
    Wait Until Page Contains Element        geocontainer       10
    Click Element           geocontainer
    Sleep          3
    Wait Until Page Contains Element        1       10
    Click Button            1
    Sleep          3
    Click Element           xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
    Sleep          5
    Click Element           xpath=//*[@id="graveYard"]/div[1]/div[1]
    Sleep          2
    Click Button            contextBtn
    Sleep          3
    Click Element           xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep          5
    Input Text              graveName           Huynh Van A
    Sleep          1
    Click Element           graveBirth
    Select From List By Value           xpath=//*[@id="ui-datepicker-div"]/div/div/select[2]            1990
    Click Element           xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[7]
    Input Text              graveHomeTown       TP HCM
    Sleep          1
    Click Element           graveDeathDay
    Click Element           xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[7]
    Input Text              graveParish         Hoa Khanh
    Sleep          1
    Click Button            regisBtn
    Sleep          2
    Click Element           xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep          5
    Click Button            detailReject
    Sleep          10
    [Teardown]

Test case Manager Grave

    Open Browser To Login Page
    Click Element               xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Sleep           2
    Input Text                  managerId            hungmc_manager_hoakhanh
    Input Password              password            Abcd1234
    Sleep           2
    Click Element               xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Sleep           2
    Click Element               xpath=//*[@id="sidebar-menu"]/div/ul/li[5]
    Sleep           8
    Double Click Element        xpath=//*[@id="graveYard"]/div[1]/div[1]
    Sleep           2
    Click Button                contextBtn
    Sleep           3
    Click Element               xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep           20
    Input Text                  detailRegisIdentity         025259777
    Sleep           5
    Click Button                detailProcess
    Sleep           3
    Click Element               xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep           5
    Click Button                detailReject
    Sleep           10
    Click Element               xpath=//*[@id="grave"]/div[6]/div[1]
    Sleep           2
    Input Text                  graveName           Nguyen Thi B
    Click Element               graveBirthDay
    Select From List By Value       xpath=//*[@id="ui-datepicker-div"]/div/div/select[2]         1980
    Click Element               xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[4]/td[4]
    Input Text                  graveHomeTown       TP HCM
    Click Element               graveDeathDay
    Click Element               xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[4]/td[3]
    Input Text                  graveParish         Hoa Khanh
    Input Text                  phoneNum            01213356679
    Input Text                  userIdentity        035756839
    Sleep           2
    Click Button                regisBtn
    Sleep           5
    Click Element               xpath=//*[@id="grave"]/div[1]/div[1]
    Sleep           8
    Click Button                detailProcess
    Sleep           3
    Reload Page
    Sleep           10
    Input Text                  xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              Nguyen Thi B
    Sleep           2
    Press Key                   xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              \\13
    Sleep           8
    Double Click Element        xpath=//*[@id="graveYard"]/div[1]/div[1]
    Sleep           1
    Click Button                contextBtn
    Sleep           5
    Click Element               xpath=//*[@id="grave"]/div[6]/div[1]
    Sleep           3
    Click Button                detailReject
    Sleep           2
    Input Text                  xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              Huynh Van A
    Sleep           5
    Press Key                   xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              \\13
    Sleep           2
    Click Element               xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep           2
    Click Button                detailReject
    Sleep           2
    Reload Page
    Sleep           8
    Click Button                xpath=//*[@id="step1"]/div[1]/div[3]/button
    Sleep           1
    Click Element               createGrave
    Sleep           1
    Click Button                xpath=//*[@id="step1"]/div[1]/div[3]/button
    Sleep           1
    Click Element               createGate
    Sleep           1
    [Teardown]
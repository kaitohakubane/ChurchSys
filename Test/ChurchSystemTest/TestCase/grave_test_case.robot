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
Test case User Grave

    Open Browser To Login Page
    Click Element           xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text              managerId            kietta_user
    Input Password          password            Abcd1234
    Click Element           xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Sleep          2
    Input Text      pac-input       Thanh Khê, Da Nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1       10
    Click Button            1
    Sleep          3
    Click Element           xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
    Sleep          6
    Click Element           xpath=//*[@id="graveYard"]/div[1]/div[1]
    Sleep          4
    Click Button            contextBtn
    Sleep          3
    Click Element           xpath=//*[@id="grave"]/div[13]/div[1]
    Input Text              graveName           Huynh Van A
    Click Element           graveBirth
    Select From List By Value           xpath=//*[@id="ui-datepicker-div"]/div/div/select[2]            1990
    Click Element           xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[7]
    Input Text              graveHomeTown       TP HCM
    Click Element           graveDeathDay
    Click Element           xpath=//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[7]
    Input Text              graveParish         Hoa Khanh
    Click Button            regisBtn
    Sleep          2
    Click Element           xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep          3
    Click Button            detailReject
    [Teardown]

Test case Manager Grave

    Open Browser To Login Page
    Click Element               xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text                  managerId            hungmc_manager_hoakhanh
    Input Password              password             Abcd1234
    Click Element               xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Sleep           2
    Click Element               xpath=//*[@id="sidebar-menu"]/div/ul/li[5]
    Sleep           6
    Double Click Element        xpath=//*[@id="graveYard"]/div[1]/div[1]
    Click Button                contextBtn
    Sleep           3
    Click Element               xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep           15
    Input Text                  detailRegisIdentity         025259777
    Click Button                detailProcess
    Sleep           1
    Click Element               xpath=//*[@id="grave"]/div[13]/div[1]
    Sleep           3
    Click Button                detailReject
    Click Element               xpath=//*[@id="grave"]/div[6]/div[1]
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
    Click Button                regisBtn
    Sleep           5
    Click Element               xpath=//*[@id="grave"]/div[1]/div[1]
    Sleep           3
    Click Button                detailProcess
    Sleep           2
    Reload Page
    Sleep           5
    Input Text                  xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              Nguyen Thi B
    Sleep           1
    Press Key                   xpath=/html/body/div[1]/div/div[3]/div/ul/li[3]/div/input              \\13
    Sleep           5
    Double Click Element        xpath=//*[@id="graveYard"]/div[1]/div[1]
    Click Button                contextBtn
    Sleep           3
    Click Element               xpath=//*[@id="grave"]/div[6]/div[1]
    Sleep           2
    Click Button                detailReject
    Reload Page
    Sleep           8
    Click Button                xpath=//*[@id="step1"]/div[1]/div[3]/button
    Click Element               createGrave
    Click Button                xpath=//*[@id="step1"]/div[1]/div[3]/button
    Click Element               createGate
    [Teardown]
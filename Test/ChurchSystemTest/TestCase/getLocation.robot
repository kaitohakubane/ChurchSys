*** Settings ***
Documentation           This is a test for get location
Library                 Selenium2Library
Resource                ${CURDIR}/Constant/trungConstant.robot


*** Keywords ***
Open Browser To Login Page
    Open Browser        ${SERVER}   ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed  ${DELAY}


*** Test Cases ***
#Test case 1
#
#    Open Browser To Login Page
#    Click Element       geocontainer
#    Wait Until Page Contains Element        1
#    Click Button       1
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[1]/a
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 2
#
#    Open browser to login page
#
#    Input Text      pac-input       thanh khe da nang
#    Press Key       pac-input       \\13
#    Wait Until Page Contains Element        1
#    Click Button       1
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[7]/a
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 3
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            kietta_user
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Wait Until Page Contains Element        geocontainer       10
#    Click Element       geocontainer
#    Wait Until Page Contains Element        2       10
#    Click Button        2
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
#    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[4]/div[1]/table/tbody/tr/td[5]
#    Select From List By Value       subjectId       27
#    Click Button        eventRegisteredBtn
#    Click Button        xpath=//*[@id="notifyPopup"]/div/div/div/div[2]/div/button
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 6
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            kietta_user
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Wait Until Page Contains Element        geocontainer       10
#    Click Element       geocontainer
#    Click Element       xpath=//*[@id="1"]/div[5]/a/i
#    Click Element       xpath=//*[@id="MainMenu"]/ul/li[2]
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 8
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            kietta_user
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Click Element       xpath=//*[@id="noti-user"]
#    Click Element       xpath=//*[@id="notification"]/li[21]/a
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 9
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            hungmc_manager_hoakhanh
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Click Element       xpath=//*[@id="sidebar-menu"]/div/ul/li[2]
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 10
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            hungmc_manager_hoakhanh
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Click Element       xpath=//*[@id="sidebar-menu"]/div/ul/li[2]
#    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[5]/div[1]/table/tbody/tr/td[7]
#    Input Text          creatingEventName       Sự kiện thánh lễ
#    Click Button       createEventbtn
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser

#Test case 11
#
#    Open Browser To Login Page
#    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
#    Input Text          managerId            hungmc_manager_hoakhanh
#    Input Password      password            Abcd1234
#    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
#    Click Element       xpath=//*[@id="sidebar-menu"]/div/ul/li[2]
#    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[6]/div[1]/table/tbody/tr/td[2]
#    Input Text          creatingEventName       Giáo lý hôn nhân
#    Select From List By Value       category       6
#    Click Button       createEventbtn
#    Clear Element Text          numberOfSlot
#    Input Text          numberOfSlot        6
#    Click Element     xpath=//*[@id="createClass"]/div/div/div[1]/div/div/div[2]/form/div[6]/label[2]/div/ins
#    Click Element     xpath=//*[@id="createClass"]/div/div/div[1]/div/div/div[2]/form/div[6]/label[4]/div/ins
#    Click Element     xpath=//*[@id="createClass"]/div/div/div[1]/div/div/div[2]/form/div[6]/label[6]/div/ins
#    Click Button        createClassbtn
#    Set Selenium Speed  ${DELAY}
#    [Teardown]     Close Browser
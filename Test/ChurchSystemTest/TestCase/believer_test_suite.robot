*** Settings ***
Documentation           This is a test for get location
Library                 Selenium2Library
Resource                ${CURDIR}/Constant/testConstant.robot


*** Keywords ***
Open Browser To Server Page
    Open Browser        ${SERVER}   ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed  ${DELAY}


*** Test Cases ***

Test case 2 Believer
    Open Browser To Server Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId           ${USER_ACCOUNT}
    Input Password      password            ${PASSWORD}
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        pac-input       10
    Input Text      pac-input               ${SEACH_LOCATION_2}
    Press Key       pac-input               \\13
    Wait Until Page Contains Element        1
    Sleep           4
    Click Button        1
    Sleep           2
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Execute JavaScript      window.scrollTo(0,100)
    Sleep           3
    Click Button        xpath=//*[@id="calendar"]/div[1]/div[1]/div/button[2]
    Sleep           2
    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[2]/table/tbody/tr[1]/td[4]/a
    Sleep           4
    Click Button        eventDetailBtn
    Click Button        xpath=//*[@id="calendar"]/div[1]/div[1]/div/button[2]
    Sleep           2
    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[1]/table/tbody/tr/td[3]
    Select From List By Value       subjectId       28
    Select From List By Value       estTime       2
    Click Button        eventRegisteredBtn
    Sleep           3
    Click Button        xpath=//*[@id="notifyPopup"]/div/div/div/div[2]/div/button
    Sleep           1
    Click Element       noti-user
    Sleep           2
    Execute JavaScript      window.scrollTo(0,0)
    Click Element           xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Execute JavaScript      window.scrollTo(0,200)
    Sleep           2
    Click Button        xpath=//*[@id="home"]/div[2]/div[2]/div/div[2]/div[13]/div/button
    Sleep           3
    Click Element       xpath=/html/body/div[3]/div/div/div/ul/li[2]/a
    Sleep           5
    Click Button        xpath=/html/body/div[3]/div/div/div/ul/li[3]/button
    Select From List By Value       category       11
    Sleep           1
    Click Button        btnRegister
    Sleep           5
    Click Element       xpath=//*[@id="MainMenu"]/ul/li[2]/a




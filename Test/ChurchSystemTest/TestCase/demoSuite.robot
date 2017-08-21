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
#Test case 1 Guest
#    Open Browser To Server Page
#    Input Text      pac-input       ${SEACH_LOCATION}
#    Press Key       pac-input       \\13
#    Wait Until Page Contains Element        1
#    Click Button       1
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[1]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[5]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
#    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
#    [Teardown]     Close Browser

Test case 2 Believer
    Open Browser To Server Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId           ${USER_ACCOUNT}
    Input Password      password            ${PASSWORD}
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Wait Until Page Contains Element        1
    Click Button        1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Click Button        xpath=//*[@id="calendar"]/div[1]/div[1]/div/button[2]
    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[3]/div[2]/table/tbody/tr[1]/td[4]/a
    Click Button        eventDetailBtn
    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[1]/table/tbody/tr/td[4]
    Select From List By Value       subjectId       28
    Select From List By Value       estTime       2
    Click Button        eventRegisteredBtn
    Click Button        xpath=//*[@id="notifyPopup"]/div/div/div/div[2]/div/button
    Click Element       noti-user
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Click Button        xpath=//*[@id="home"]/div[2]/div[2]/div/div[2]/div[13]/div/button
    Click Element       xpath=/html/body/div[3]/div/div/div/ul/li[2]/a
    Click Element       xpath=//*[@id="MainMenu"]/ul/li[2]/a



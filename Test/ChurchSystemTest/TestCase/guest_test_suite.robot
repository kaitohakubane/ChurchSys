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


Test case 1 Guest
    Open Browser To Server Page
    Input Text      pac-input       ${SEACH_LOCATION}
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Set Selenium Implicit Wait      5
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[1]/a
    Set Selenium Implicit Wait      10
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Set Selenium Implicit Wait      5
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Set Selenium Implicit Wait      5
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[5]/a
    Set Selenium Implicit Wait      5
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
    Set Selenium Implicit Wait      5
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
    [Teardown]     Close Browser

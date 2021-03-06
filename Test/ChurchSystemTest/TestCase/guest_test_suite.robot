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
    Wait Until Page Contains Element        pac-input       10
    sleep           3
    Input Text      pac-input       ${SEACH_LOCATION}
    Sleep           2
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Sleep           10
    Click Button       1
    Sleep           8
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[1]/a
    Sleep           10
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Sleep           2
    Execute JavaScript      window.scrollTo(0, 100)
    Sleep           4
    Execute JavaScript      window.scrollTo(0, 0)
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Sleep           2
    Execute JavaScript      window.scrollTo(0, 100)
    Sleep           2
    Execute JavaScript      window.scrollTo(0, 0)
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[5]/a
    Sleep           3
    Execute JavaScript      window.scrollTo(0, 600)
    Sleep           8
    Execute JavaScript      window.scrollTo(0, 0)
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
    Sleep           8
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
    Sleep           8
    [Teardown]     Close Browser

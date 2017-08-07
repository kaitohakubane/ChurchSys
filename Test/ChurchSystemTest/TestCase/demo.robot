*** Settings ***
Documentation           This is a simple test with Robot Framework
Library                 Selenium2Library
Resource                ${CURDIR}/Constant/generalConstant.robot


*** Keywords ***
Open Browser To Login Page
    Open Browser        ${SERVER}   ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed  ${DELAY}


*** Test Cases ***
Valid Login
    Open Browser To Login Page
    [Teardown]    Close Browser

Test Case 2
    Open Browser To Login Page
    Go To          http://www.hamtruyen.com
    Go To          http://cms-dn.fpt.edu.vn/
    Input Text          user_login            hungmcse61561
    Input Password      user_pass            akbskenmbhkt48
    Click Element       wp-submit
    [Teardown]     Close Browser
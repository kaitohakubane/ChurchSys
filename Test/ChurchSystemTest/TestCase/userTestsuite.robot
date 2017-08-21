*** Settings ***
Documentation    Suite description
Library                 Selenium2Library
Resource                ${CURDIR}/Constant/testConstant.robot
*** Keywords ***
Open Browser To Login Page
    Open Browser        ${SERVER}   ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed  ${DELAY}

*** Test Cases ***
Test case 1 (search near)

    Open Browser To Login Page
    Click Element       geocontainer
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 2 (go to main page of church)

    Open Browser To Login Page
    Click Element       geocontainer
    Wait Until Page Contains Element        1
    Click Button       1
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 3 (go to introduction page of church)

    Open Browser To Login Page
    Click Element       geocontainer
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[1]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 4 (search location)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 5 (go to main page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[7]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 6 (go to main page of near church)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 7 (go to event page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 8 (go to class page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 9 (go to pray page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[5]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 10 (go to contact page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[6]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 11 (go to donation page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[7]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 12 (go to grave page)

    Open browser to login page
    Input Text      pac-input       thanh khe da nang
    Press Key       pac-input       \\13
    Wait Until Page Contains Element        1
    Click Button       1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[8]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 13 (login with user roll)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 14 (login with user roll and search near)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Wait Until Page Contains Element        1       10
    Click Button        1
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 15 (set the event in event page)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Wait Until Page Contains Element        2       10
    Click Button        2
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[3]/a
    Click Element       xpath=//*[@id="calendar"]/div[2]/div/table/tbody/tr/td/div/div/div[4]/div[1]/table/tbody/tr/td[5]
    Select From List By Value       subjectId       27
    Click Button        eventRegisteredBtn
    Click Button        xpath=//*[@id="notifyPopup"]/div/div/div/div[2]/div/button
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 16 (register a class is now active)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Wait Until Page Contains Element        1       10
    Click Button        1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Click Button        xpaht=//*[@id="home"]/div[2]/div/div/div[2]/div[13]/div/button
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 17 (register a class will be active)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Wait Until Page Contains Element        1       10
    Click Button        1
    Click Element       xpath=/html/body/div[2]/div/div[2]/div/ul/li[4]/a
    Click Element       xpath=/html/body/div[3]/div/div/div/ul/li[2]
    Click Button        xpath=//*[@id="menu1"]/div/div/div/div[2]/div/div/div[2]/div[13]/div/button
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 18 (follow a church)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password             Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Click Element       xpath=//*[@id="1"]/div[5]/a/i
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 19 (go to dashboard page and see church followed)

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Wait Until Page Contains Element        geocontainer       10
    Click Element       geocontainer
    Click Element       xpath=//*[@id="1"]/div[5]/a/i
    Click Element       xpath=//*[@id="MainMenu"]/ul/li[2]
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser

Test case 20 (show notification and go to notification page )

    Open Browser To Login Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId            kietta_user
    Input Password      password            Abcd1234
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Click Element       xpath=//*[@id="noti-user"]
    Click Element       xpath=//*[@id="notification"]/li[21]/a
    Set Selenium Speed  ${DELAY}
    [Teardown]     Close Browser
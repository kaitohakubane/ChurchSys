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
Admin test case
    Open Browser To Server Page
    Click Element       xpath=//*[@id="MainMenu"]/div/ul/li[2]/a
    Input Text          managerId           ${ADMIN_ACCOUNT}
    Input Password      password            ${PASSWORD}
    Click Element       xpath=/html/body/div[1]/div/div/div/div[2]/form/fieldset/input
    Click Element       xpath=//*[@id="sidebar-menu"]/div/ul/li/a
    Execute JavaScript      window.scrollTo(0,200)
    Sleep                   5
    Execute JavaScript      window.scrollTo(0,0)
    Click Button            addChurch
    wait until page contains element            churchName
    input text          churchName              ${CHURCH_NAME}
    click button        btnGetLocation
    Sleep               3
    Input Text          us3-address             ${CHURCH_ADDRESS}
    Click Element           xpath=/html/body/div[4]/div
    Execute JavaScript      window.scrollTo(0,200)
    click button        btnOK
    input text          churchTel               05113835625
    input text          churchDescription       Ngày xây dựng nhà thờ: 1954 – đại tu : 1976 – xây mới hoàn toàn: 2012
    click button        btnSave
    wait until page contains element             addChurch
    Execute JavaScript      window.scrollTo(0,600)
    sleep                   2
    click button            xpath=//*[@id="datatable"]/tbody/tr[4]/td[8]/button
    input text              userName            Nguyễn Văn Minh
    input text              accountId           tamtoa_manager_minhnv
    input text              email               kiettase61469@fpt.edu.vn
    input text              phone               0123456789
    input text              cert                Cha xứ
    click button            btnOk

New church confirm
    Open Browser To Server Page
    Wait Until Page Contains Element        pac-input       10
    Input Text      pac-input       ${SEACH_LOCATION}
    Press Key       pac-input       \\13


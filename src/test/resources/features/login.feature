Feature: login

Scenario Outline: correctLogin
Given user open login page
When user enter Username and Password
* click login button
Then user pass to MainPage
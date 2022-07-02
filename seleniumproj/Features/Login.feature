Feature: Login

Scenario: Successful Login with valid Credentials

  Given User launch Chrome browser
  When user opens URL "https://www.facebook.com/"
  And user enters user name as "laxmisuresh300@gmail.com" and password as "Suresh@123"
  And click on Login
  Then page title should be "Facebook"
  
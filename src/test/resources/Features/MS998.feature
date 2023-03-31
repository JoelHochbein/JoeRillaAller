@DQALogin
Feature: LogIn Test

  Scenario: LogIn w valid Data.

  Given  user is on website!!
  When   he enters his valid data
  And    clicks on Log In!
  Then   user should be logged in.

  Scenario: LogIn w Invalid Data.

  Given  user is on website..
  When   he enters his invalid data
  And    clicks on Log In.
  Then   user shouldnt be able to login
@LoginTest
Feature: LogIn Test

  Scenario: Login with valid Data

    Given User is on the Login Page
    When  User enters a valid Email and Password
    Then  user should be logged in
    And   user should be automatically redirected to the homepage

  Scenario: Login with invalid Data

    Given User is on the Login Page1
    When  User enters a invalid Email and Password
    Then  The Site demands the user to enter valid login data
    And   User shouldnt be able to login
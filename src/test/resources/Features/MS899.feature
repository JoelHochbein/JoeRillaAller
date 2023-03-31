@LogIn_w_POM
Feature: Log In Test w POM

  Scenario: Log In

    Given  User is on Homepage
    When   User clicks on Login
    And    User enters Email and Password
    Then   User is logged in
    And    Automatically redirected to Homepage

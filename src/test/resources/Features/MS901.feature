@Register_w_POM
Feature: Register Test w POM

  Scenario: Register

    Given  User is on Homepage.
    When   User clicks on Register
    And    User enters his Data
    And    Clicks on Register
    Then   User is registered and logged in
    And    Automatically redirected to Homepage.

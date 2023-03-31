@CompatibilityTest
Feature: Browser-Compatibility Test of TDW

  Scenario: As a User i want test the TDW on different Browsers

    Given Website is live and available
    When  Website works on Firefox
    And   Website works on Chrome
    And   Website works on Edge
    Then  Website works on every browser

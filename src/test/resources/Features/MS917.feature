@CalcTest
Feature: CalculationTest

  Scenario: Calculation Test of the Total Price

    Given  User adds five different articles in the shopping cart
    When   User clicks on shopping cart
    Then   The sum of all individual items corresponds to the total price

@CalculationTest
Feature: Calculation of the "total" price

  Scenario: successfull calculation of the “total” price

    Given user openes the website
    When  he adds at least 3 articles to his shopping cart
    And   he clicks on shopping cart
    Then  the user receives a "total" price that corresponds to the sum of all articles

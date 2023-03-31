@RegistrationTest
Feature: Order a Product

  Scenario: Order a Product w valid Credit Card Informations

    Given  user has at least one product in the shopping cart2
    And    user has given valid credit card informations
    When   user clicks on purchase
    Then   user gets the message that the purchase was successful
    And    receives a order number

  Scenario: Order a Product w invalid Credit Card Informations

    Given  user has at least one product in the shopping cart3
    And    user has given invalid credit card informations
    When   user clicks on purchase1
    Then   user gets the message that he has to give valid credit card informations
    And    user shouldnt be able to purchase
@RemoveTest
Feature: remove a product from the shopping cart

  Scenario: as a user i want to remove a product from the shopping cart

    Given user has at least one product in the shopping cart
    When  user chooses a product he wants to remove
    And   clicks on update shopping cart
    Then  product shouldnt be in the shopping cart anymore

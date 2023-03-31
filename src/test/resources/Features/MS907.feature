@BuyJewelery
Feature: Buy Jewelery

  Scenario: As a User i want to buy Jewelery

    Given  user opens the website.
    And    User is logged in.
    When   user searches for a jewelery of his choice
    And    Adds it to the Shopping cart
    And    Clicks on Shopping cart
    Then   Jewelery should show up in Shopping cart


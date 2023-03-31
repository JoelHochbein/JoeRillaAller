@CompareList
Feature: Use the Compare Function

  Scenario: compare carmeras

    Given  user opens the site
    When   user chooses 3 products from the same group
    And    Adds them to compare List
    Then   Site should show a compare List

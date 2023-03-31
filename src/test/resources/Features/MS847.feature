@SearchTest
Feature: search for products

  Scenario: searchresults

    Given user opens the website tdw
    When  user searches for a product
    Then  search results are shown
    And   search results match the search term
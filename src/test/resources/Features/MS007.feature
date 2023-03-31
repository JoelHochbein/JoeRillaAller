@links
Feature: add user

  Scenario: add user in the web table

    Given  user is on website dqalinks
    When   he selects random link
    And    clickt it
    Then   he receives a status code and text
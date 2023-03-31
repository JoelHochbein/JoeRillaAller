@webtable
Feature: add user

  Scenario: add user in the web table

    Given  user is on website demoqawebtables
    When   he adds a user
    Then   user should appear in the webtable
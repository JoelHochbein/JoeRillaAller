@ShowLinks
Feature: show links

  Scenario: show all links on homepage

    Given  admin has his browser opened
    When   he opens the url
    Then   a list of all links are shown in the console

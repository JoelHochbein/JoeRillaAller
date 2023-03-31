@RegisterTestwFaker
Feature: Registration Test

  Scenario: Registration w Data from the Testdata Generator

    Given  Testdata is ready
    When   I register w Data from the Testdata Generator
    Then   The registration should be successful

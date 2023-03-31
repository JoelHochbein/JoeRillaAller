@PracticeForm
Feature: Practice Form

  Scenario: Fill every option on the practice form

    Given  user is on the website!
    When   user fills the form
    And    clicks on submit
    Then   user gets a list of his submitted data
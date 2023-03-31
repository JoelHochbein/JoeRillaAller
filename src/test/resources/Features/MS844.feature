@RegistrationTest
Feature: Registration w. random generated Email & Password

  Scenario: successful registration

    Given user opens the website
    When  user clicks on register
    And   fills the registration form w random generated data
    And   clicks on register
    Then  User gets the message "Your registration completed"
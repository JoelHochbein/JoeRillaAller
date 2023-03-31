@ÜberprüfungBestellhistorie
Feature: Überprüfung der Bestellhistorie

  Scenario: Als ein User möchte ich die Bestellhistorie prüfen

    Given user is on page and is logged in
    When  user clicks on orderhistory
    Then  website shows a list of the previous orders
    And   every order contains informations

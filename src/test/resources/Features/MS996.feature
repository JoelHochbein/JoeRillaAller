@SelectMenu
Feature: Select Menu

  Scenario: Select every dropdownbar

  Given  user is on website dqa
  When   he selects something from every dropdownbar
  Then   selected data should be present in the bar
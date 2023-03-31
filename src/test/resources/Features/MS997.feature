@chipde
Feature: Accept cookies

  Scenario: switch frame and accept cookies

  Given  user opens chipde
  When   accepts the cookies.
  Then   cookie windows should disappear
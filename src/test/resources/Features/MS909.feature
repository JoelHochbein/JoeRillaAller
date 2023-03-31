@CustomizeComputer
Feature: Customize a Computer

  Scenario: Customize a Computer and check the price

  Given  user opens the website "https://demowebshop.tricentis.com/"
  When   User customizes a expensive computer
  And    Adds it to the Shopping cart.
  And    Switches to Shopping cart
  Then   Computer should show up in Shopping cart
  And    cost more then twothousand dollar
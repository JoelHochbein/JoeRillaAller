@droppable

Feature: Drag Box

  Scenario: Drag Box and Drop it in other box

    Given  user is on website demoqadroppable
    When   he drags the box
    And    drops it in the other box
    Then   Drop Box shows message: Dropped!
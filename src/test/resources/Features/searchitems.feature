Feature: feature to test search funtionality
@Smoke
  Scenario: Check user is able to search the item
    Given user is on login page
    And user enter correct username and password
    And user clicks on login button
    When user clicks on search bar
    And user search an item
    Then system should return the item

Feature: Feature to test Add, Delete and Edit shopping cart
@Smoke
  Scenario: Check User is able to add the search item
    Given user is on login page
    And user enter correct username and password
    And user clicks on login button
    When user clicks on search bar
    And user search an item
    And user add an item in the cart
    Then system should add the item
    
   @Smoke 
    Scenario: Check User is able to delete the search item
    Given user is on login page
    And user enter correct username and password
    And user clicks on login button
    When user clicks on search bar
    And user search an item
    And user add an item in the cart
    When user again deletes that item
    Then system should delete the item
    
    
  @Smoke      
    Scenario: Check User is able to edit the search item
    Given user is on login page
    And user enter correct username and password
    And user clicks on login button
    When user clicks on search bar
    And user search an item
    And user add an item in the cart
    When user again updates an item in the cart
    Then system should update the cart
    
# Author
#Date


Feature: feature to test login functionality
@Smoke
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enter correct username and password
  And user clicks on login button
    Then user is navigated to the home page
 
@Smoke
  Scenario: Check login is successful with invalid credentials
    Given user is on login page
    When user enter incorrect username and password
    And user clicks on login button
    Then user should not navigate to the home page
 @Smoke   
     Scenario: Check login is successful with invalid credentials
    Given user is on login page
    When user enter correct username and invalid password
    And user clicks on login button
    Then user should not navigate to the home page
    
    
    
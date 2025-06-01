Feature: Login Functionality

  Scenario: Successful login
    Given User is on login page
    When User enters valid credentials
    Then User should be logged in successfully

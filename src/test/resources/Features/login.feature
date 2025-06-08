Feature: Login Functionality

  Scenario: Successful login
    Given User is on login page
    When User enters valid credentials
    Then User should be logged in successfully


#  Scenario: Invalid username login attempt
 #   Given User is on login page
  #  When User enters invalid username
   # Then An error message "Your username is invalid!" should be displayed

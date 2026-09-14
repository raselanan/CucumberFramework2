Feature: Login Functionality

  @smoke
  Scenario: Successful login
    Given User is on login page
    When User enters valid credentials
    Then User should be logged in successfully


  @smoke
  Scenario: Invalid username login attempt
    Given User is on login page
    When User enters invalid username
    Then An error message "Your username is invalid!" should be displayed

  Scenario: Invalid password login attempt
    Given User is on login page
    When User enters an invalid password
    Then An error message "Your password is invalid!" should be displayed

  @data-driven
  Scenario Outline: Login rejects invalid credentials
    Given User is on login page
    When User enters username "<username>" and password "<password>"
    Then An error message "<errorMessage>" should be displayed

    Examples:
      | username      | password          | errorMessage              |
      | incorrectUser | Password123       | Your username is invalid! |
      | student       | incorrectPassword | Your password is invalid! |
      | incorrectUser | incorrectPassword | Your username is invalid! |

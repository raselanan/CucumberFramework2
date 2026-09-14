Feature: Handling dynamic page elements

  Scenario: Wait for a delayed second row
    Given User is on the exceptions page
    When User adds a second row
    Then The second row should be displayed

  @smoke
  Scenario: Edit and save the first row
    Given User is on the exceptions page
    When User changes the first row text to "Sushi"
    Then The first row should contain "Sushi"

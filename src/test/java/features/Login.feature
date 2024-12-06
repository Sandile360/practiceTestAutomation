Feature: Simple login page where user performs positive and negative login test cases
  Scenario Outline: mock login credentials
    Given user navigates to login page
    When user type valid <user> <password> and click submit
    And verify page URL, expected text and click logout
    When user type invalid <incorrectUser> <password> and click submit
    Then verify error message
    When user type invalid <user> <incorrectPassword> and click submit
    Then verify error message

    Examples:
      | user     |  password   | incorrectUser | incorrectPassword |
      | student  | Password123 | incorrectUser | incorrectPassword |
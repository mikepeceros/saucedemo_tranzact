@Login
Feature: Login scenarios

  @SmokeTest
  Scenario: Successful login
    Given the user goes to saucedemo login page
    When the user logins with creds "standard_user" "secret_sauce"
    Then the system redirects to home page

  @smoke2
  Scenario: Failed Login
    Given the user goes to saucedemo login page
    When the user logins with creds "locked_out_use" "secret_sauce"
    Then Login is not allowed
    And  The error message "Sorry, this user has been locked out." is displayed in the Login
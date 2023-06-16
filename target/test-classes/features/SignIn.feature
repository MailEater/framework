@Regression
Feature: Sign In Features

  
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'hello1234@tekschool.us' and password 'Test1234$'
    And User click on login button
    Then User should be logged in into Account

	
  Scenario: Verify user can create an account into Retail Website
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name    | email | password  | confirmPassword |
      | fullName| email | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page

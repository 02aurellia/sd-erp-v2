@All
Feature: Login Page

    @login @positive
    Scenario: User success login
    Given User on login Page
    Then User input credentials
    And User click button login
    Then User go to dashboard page

    @login @negative
    Scenario: User failed login - invalid credential
    Given User on login Page
    Then User input invalid credentials
    And User click button login
    Then User get alert
@All
Feature: CRUD SD Issue

    @issue @view
    Scenario: User view list SD Issue
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    Then User see list SD Issue

    @issue @add
    Scenario: User add new SD Issue
    Given User on SD Issues Page
    And User click button Add SD Issue
    And User input issue
    And User click button Save
    Then User success add SD Issue
@All
Feature: CRUD SD Issue

    @issue @view
    Scenario: User view list SD Issue
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    Then User see list SD Issue

    @issue @add @positive
    Scenario: User success add new SD Issue
    Given User on SD Issues Page
    And User input issue
    And User click button Save
    Then User success add SD Issue

    @issue @add @negative
    Scenario: User failed add new SD Issue - Empty
    Given User on SD Issues Page
    And User click button Save
    Then User get alert require field

    @issue @edit
    Scenario: User edit SD Issue
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    Then User choose Issue
    And User edit Issue
    And User click button Save
    And User get alert success

    @issue @search @positive
    Scenario: User search issue - with result
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    And User search issue by subject
    Then User get the result

    @issue @search @negative
    Scenario: User search issue - no result
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    And User search invalid issue by subject
    Then User get no result

    @issue @assign
    Scenario: User filter assign to me
    Given User in homepage
    And User go to Projects page
    And User go to SD Issues page
    And User click assign to me
    Then User get result
@All
Feature: CRUD Timesheet

    @view @timesheet
    Scenario: User view list Timesheet
    Given User on homepage
    Then User click button view list
    And User see the list

    @add @timesheet @positive
    Scenario: User add new Timesheet
    Given User on timesheet page
    And User click button Start Timer
    Then User choose project
    And User click button Start

    @add @timesheet @negative
    Scenario: User failed add new Timesheet - Empty values
    Given User on timesheet page
    And User click button Start Timer
    And User click button Start
    Then User get modal alert required

    @edit @timesheet
    Scenario: User edit Timesheet
    Given User on homepage
    Then User choose timesheet
    And User click button edit timesheet
    Then User click button save

    @stop @timesheet
    Scenario: User stop timer
    Given User on homepage
    Then User choose timesheet
    And User click resume timer
    And User click button complete

    @delete @timesheet
    Scenario: User delete Timesheet
    Given User on homepage
    Then User choose timesheet
    And User click button delete
    And User click button Yes
    Then Timesheet success get delete

    @submit @timesheet
    Scenario: User submit timesheet
    Given User on homepage
    Then User choose timesheet
    And User click button Submit

    @filter @timesheet @positive
    Scenario: User filter timesheet - with result
    Given User on homepage
    Then User click button view list
    And User see the list
    Then User choose status timesheet
    And User get list timesheet with status

    @filter @timesheet @negative
    Scenario: User filter timesheet - no result
    Given User on homepage
    Then User click button view list
    And User see the list
    Then User choose status timesheet no result 
    And User get result not found

    @search @timesheet
    Scenario: User search timesheet by date
    Given User on homepage
    Then User click button view list
    And User see the list
    Then User pick date
    And User get result list timesheet with date
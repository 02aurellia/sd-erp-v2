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
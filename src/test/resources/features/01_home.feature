@Home
Feature: Home Page Module

Scenario: Verify Amazon home page loads successfully
Given User is on Amazon home page

Scenario: Verify search box present
Given User is on Amazon home page
Then Verify search box present

Scenario: Verify category navigation menu present
Given User is on Amazon home page
Then Verify category navigation menu present

Scenario: Verify banner section visible
Given User is on Amazon home page
Then Verify banner section visible

Scenario: Handle location popup
Given User is on Amazon home page
When User handles location popup

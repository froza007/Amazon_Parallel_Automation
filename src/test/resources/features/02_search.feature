@Search
Feature: Search Module

Scenario: Search using valid keyword
Given User is on Amazon home page
When User searches valid product "samsung phone"

Scenario: Search using invalid keyword
Given User is on Amazon home page
When User searches invalid product "zzzzzzzz"

Scenario: Search using special characters
Given User is on Amazon home page
When User searches special characters "@@@@"

Scenario: Verify search results page displayed
Given User is on Amazon home page
When User searches valid product "samsung phone"
Then Verify results page displayed

Scenario: Verify products are listed after search
Given User is on Amazon home page
When User searches valid product "samsung phone"
Then Verify products are listed

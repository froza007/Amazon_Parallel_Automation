@Listing
Feature: Product Listing Module

Scenario: Verify product listing page displays multiple products
Given User is on Amazon home page
When User searches valid product "samsung phone"
Then Verify multiple products displayed

Scenario: Apply price filter
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User applies price filter
Then Verify multiple products displayed

Scenario: Apply brand filter
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User applies brand filter
Then Verify multiple products displayed

Scenario: Clear filters and verify results reset
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User applies price filter
When User clears filters
Then Verify multiple products displayed

@Sorting
Feature: Sorting Module

Scenario: Sort products by price low to high
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User sorts by price low to high
Then Verify sorting applied

Scenario: Sort products by customer review
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User sorts by customer review
Then Verify sorting applied

Scenario: Verify sorting reflects correctly in product list
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User sorts by price low to high
Then Verify sorting applied

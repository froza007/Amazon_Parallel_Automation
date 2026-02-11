@Details
Feature: Product Details Module

Scenario: Navigate to product details page
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details

Scenario: Verify product title displayed
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
Then Verify product title visible

Scenario: Verify product price displayed
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
Then Verify product price visible

Scenario: Verify product image displayed
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
Then Verify product image visible

Scenario: Verify product description visible
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
Then Verify product description visible

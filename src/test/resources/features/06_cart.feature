@Cart
Feature: Cart Module

Scenario: Add product to cart
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
And User adds product to cart

Scenario: Verify product added to cart successfully
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
And User adds product to cart
And User opens cart
Then Verify product added to cart

Scenario: Remove product from cart
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
And User adds product to cart
And User opens cart
When User removes product from cart

Scenario: Verify cart empty after removal
Given User is on Amazon home page
When User searches valid product "samsung phone"
And User opens first product details
And User adds product to cart
And User opens cart
When User removes product from cart
Then Verify product added to cart

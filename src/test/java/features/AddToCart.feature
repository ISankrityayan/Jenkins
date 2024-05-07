@AddToCart
Feature: Add products to cart and verify cart functionality

  Background:
    Given User is a guest user

  Scenario Outline: Add product to cart and verify cart functionality
  When User enters the "<keyword>"
    Then User adds the product to cart 
    Then user updates the quantity 

  Examples:
    | keyword      |
    | One Plus 11 R |

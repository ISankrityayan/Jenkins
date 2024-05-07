@SortProductsTest

Feature: Sort Products Test

  Background:
    Given User is on the homepage of the application

  Scenario Outline: User searches for a product and verifies sorting functionality
    When User searches for "<keyword>"
    Then User verifies that products are sorted by price from low to high
Examples:
|keyword|
|Women Tops|
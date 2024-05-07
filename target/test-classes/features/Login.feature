@SignUpToAmazon

Feature: Sign up to amazon
Background: Given that User is on the homepage
Scenario Outline: User should be redirected to the signin page 
Given I click on the sign in button
Then I should be navigated to the signin page
When I enter Username as "<username>"
And click on continue button
Then I should land on the "<expected>" password page

Examples:
|username| |expected|
|ishitasankrityayan@gmail.com| |success|

#Preparer: Ibadullah Khan
#Dated: 12/oct/2020

Feature: Landing Page

  Background:
    Given Navigate to Web Application

  @TCNew
  Scenario: User Search for Product on Landing Page and Add to Cart
    When user search on landing page
    And User Clicks on the product
    And User Add product to the cart
    #And User Open Cart
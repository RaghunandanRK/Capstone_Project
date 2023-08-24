Feature: Buying Sporty Shoes

  Scenario: User buys shoes
    Given User is on the Landing page
    When User registers with valid credentials
    And User logs in with registered email and password
    And User adds shoes to the cart
    Then Success message is displayed after adding to cart
    And User goes to the cart and places an order
    Then Success message is displayed after placing an order

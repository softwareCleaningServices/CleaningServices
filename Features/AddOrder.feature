Feature: Add new order
  Scenario: order added successfully
    Given that the order is not added yet
    When I enter the correct order details
    And the customer is already exist in our customers
    Then the order added successfully

    Scenario: add order for new customer
      Given that the order is not added yet
      When I enter the correct order details
      And the customer is new customer
      Then I should add the customer details
      And the order added
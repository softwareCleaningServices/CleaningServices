Feature: Add new order

  Scenario: add order with two product for exist customer
    Given that the order is not added yet
    When I enter the correct order details and the product details
    And the customer is already exist in our customers and his name="Ali Mohammed"
    Then a unique order Id will generated to the order
    And the order added successfully



    Scenario: add order for new customer
      Given that the order is not added yet
      When I enter the correct order details and the product details
      And the customer is new customer and his name="Alaa Hasan"
      Then I should add the customer details
      And the order added
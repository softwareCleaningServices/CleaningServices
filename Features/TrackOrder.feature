Feature: Track the orders and status

    The customer can tracks his orders and see the order status and when finish the order

  Scenario: Customer tracks an order by enter correct order Id
    Given the customer with id=101
    And the order has a unique Id 11
    When the customer enters the Id number =11
    Then the system displays the status of the order
    And the system displays the other order details

  Scenario: Customer enters incorrect order Id
    Given the customer with id=101
    And the order has a unique Id 11
    When the customer enters the Id number =10
    Then the system displays a not exist message

#    As admin track the order and update the order status

  Scenario: Update order status
    Given admin login and enter the order id =12
    When the admin select to update order status
    And the order status is "waiting"
    And the order is updated to status "in terminate"
    Then the order status should be "in terminate"

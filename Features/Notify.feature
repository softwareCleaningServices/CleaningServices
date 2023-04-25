
Feature: Notify customer when the order complete
  Scenario: notify customer successfully
    Given  the admin select an order id=11
    When the admin set order status to "complete"
    Then a notify message will send to customer

  Scenario: not notify customer
    Given the admin select an order id=12
    When the admin set order status to "in terminate"
    Then no message will send to customer since the order not complete

Feature: Notify customer when the order complete
  Scenario: notify customer successfully
    Given the admin choose to change the order status
    When the admin set order status to "complete"
    Then a notify message will send to customer
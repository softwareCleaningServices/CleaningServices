Feature: Customer logged in and see his page
  Scenario: the customer wants to see his orders
    Given that the customer is logged in
    When he select to see his orders
    Then his orders will be printed

    Scenario: the customer wants to add new order
      Given that the customer is logged in
      When he select to add order
      Then the order will added
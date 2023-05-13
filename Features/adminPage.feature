Feature: Admin logged in to his page
  Scenario: admin want to invoice order
    Given tha the admin logged in
    When he select to invoice order wit id =12
    Then e will see the invoice for this order

    Scenario: admin want to see all customers
      Given tha the admin logged in
      When he select to see all customers
      Then the customers will printed

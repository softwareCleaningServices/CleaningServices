Feature: generate invoice for order
  Scenario: invoice generated successfully
    Given that the admin is logged in
    When the admin select to invoice the order
    And he enter the order Id
    Then the invoice will be printed

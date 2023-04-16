Feature: generate invoice for order
  Scenario: invoice generated successfully
    Given that the admin is logged in
    When the admin enter the order Id to invoiced
    Then the invoice will be generated
    And the order will be paid

    Scenario: invoice will not generated
      Given that the admin is logged in
      When the admin enter not exist order Id to invoiced
      Then the order Id is not exist on the recorded ordered

Feature: generate invoice for order

  Scenario: invoice order with three products
    Given  that the admin is logged in
    When the admin enter the order Id =11
    And the first product coast =245
    And the second product cost =100
    And the third product cost=250
    Then the total order cost =595
    And the customer id =101
    And the invoice will be generated
    And the order will set to paid

  Scenario: invoice order with only one product
    Given  that the admin is logged in
    When the admin enter the order Id =12
    And the first product coast =320
    Then the total order cost =320
    And the customer id =107
    And the invoice will be generated
    And the order will set to paid


  Scenario: invoice will not generated
    Given that the admin is logged in
    When the admin enter not exist order Id=9 to invoiced
    Then the order Id is not exist on the recorded ordered

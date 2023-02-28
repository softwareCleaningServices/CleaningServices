Feature:record full information for product
  Scenario: record successfully
    Given that I record a new product
    When I insert the necessary product information.
    Then the product will recorded successfully
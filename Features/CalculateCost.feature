Feature: Calculate costs of products

  Scenario: Calculate costs of carpet
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "CARPET"
    Then the carpet cost with dimensions 10.0 calculated will

  Scenario: Calculate costs of sofa
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "SOFA"
    Then the sofa cost with number of sofa 3 calculated will

  Scenario: Calculate costs of cover
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "COVER"
    Then the cover cost with size "KING" calculated will
  Scenario: Calculate costs of cover
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "COVER"
    Then the cover cost with size "QUEEN" calculated will
  Scenario: Calculate costs of cover
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "COVER"
    Then the cover cost with size "TWIN_XL" calculated will
  Scenario: Calculate costs of cover
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "COVER"
    Then the cover cost with size "TWIN" calculated will

  Scenario: Calculate costs of cover
    Given the cost of categories is defined in the cost file
    When I record a new product and set category "COVER"
    Then the cover cost with size "CRIB" calculated will

Feature: Distribute order products on the available workers based on product category and the available worker


  Scenario: add order product with Carpet category
    Given that add order contains product with category ="CARPET"
    When select to add order
    Then I get the worker who works on "CARPET" category
    And has the minimum number of waiting orders
    And the worker ID set to 110

  Scenario: add order product with Cover category
    Given that add order contains product with category ="COVER"
    When select to add order
    Then I get the worker who works on "COVER" category
    And has the minimum number of waiting orders
    And the worker ID set to 120



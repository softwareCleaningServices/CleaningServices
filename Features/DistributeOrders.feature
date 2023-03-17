Feature: Distribute order products on the available workers based on product category and the available worker

  Scenario: distribute done successfully
    Given that the order is not recorder yet
    When the order is added
    Then the worker who has less number of products is take the product

Feature: Update cost of product categories

  Scenario: User updates cost of product categories
    Given the admin wants to update the cost of a product category
    When the user enters a valid category number and a new cost
    Then the system updates the cost of the selected category
  Scenario: User updates cost of product categories
    Given the admin wants to update the cost of a product category
    When the user enters a valid many category number and a new cost
    Then the system updates the cost of all selected category
  Scenario: User updates cost of product categories
    Given the admin wants to update the cost of a product category
    When the user enters a Not valid category number up
    Then the system return the same cost of the selected category
  Scenario: User updates cost of product categories
    Given the admin wants to update the cost of a product category
    When the user enters a Not valid category number down
    Then the system return the same cost of the selected category
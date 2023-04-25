Feature: update Cost of the category
  Scenario Outline: change the cost of the category
    Given that I choose to update cost of the category
    When I select to update cost of category "<num>" to "<cost>"
    Then the cost will updated successfully
    Examples:
      | num | cost |
      | 1   | 8.0  |
      | 2   | 8.0  |
      | 3   | 8.0  |
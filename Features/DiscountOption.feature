#we have four scenario: 500 150 100 noDiscount
Feature:Discount on order
  Scenario Outline: discount on order five hundred or more
    Given that i add a new order
    When the total cost of the order more than or equal five hundred
    Then the order have a discount twenty percent <total>
    Examples:
      | total |
      | 600.0 |

#  Scenario: discount on order one hundred fifty and less than five hundred
#    Given that i add a new order
#    When the total cost of the order more than or equal one hundred fifty
#    And the total cost of the order less than five hundred
#    Then the order have a discount fifteen percent
#  Scenario: discount on order one hundred and less than one hundred fifty
#    Given that i add a new order
#    When the total cost of the order more than or equal one hundred
#    And the total cost of the order less than one hundred fifty
#    Then the order have a discount seven percent
#  Scenario: No discount on order less than one hundred
#    Given that i add a new order
#    When the total cost of the order less than one hundred
#    Then the order haven't discount
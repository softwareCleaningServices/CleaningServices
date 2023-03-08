Feature:record full information for product
#  Scenario: record successfully
#    Given that I recorded a new product
#    When I insert the necessary product information.
#    Then the product will recorded successfully
  Scenario: record with category carpet
    Given that I recorded a new "carpet"
    When I insert the necessary "carpet" information
    Then the "carpet" will recorded successfully
  Scenario: record with category cover
    Given that I recorded a new "cover"
    When I insert the necessary "cover" information
    Then the "cover" will recorded successfully
  Scenario: record with category sofa
    Given that I recorded a new "sofa"
    When I insert the necessary "sofa" information
    Then the "sofa" will recorded successfully
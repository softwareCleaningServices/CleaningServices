Feature: Add new order

  Scenario: add order with two product for exist customer
    Given a customer with name "ali@gmail.com" and id=101
    And a product with name "carpet" and category="CARPET" and dimension=4.5 and material="test" and specialTerminate="" and coast= 95.0
    And a product with name "cover" and category="COVER" and size="QUEEN" and material="test" and specialTerminate="" and coast= 110.0
    When the customer orders the two products
    Then a new order should be created with status="waiting"
    And the order should have a total price of 205.0
    And a unique order Id will generated to the order
    And the order added successfully



  Scenario: add order for new customer
    Given a customer with name "Alaa Hasan" and id=0
    And a product with name "carpet" and category="CARPET" and dimension=4.5 and material="test" and specialTerminate="" and coast= 95.0
    And a product with name "cover" and category="COVER" and size="QUEEN" and material="test" and specialTerminate="" and coast= 110.0
    When the customer orders the two products
    Then I should add the customer details
    And a new order should be created with status="waiting"
    And the order should have a total price of 205.0
    And a unique order Id will generated to the order
    And the order added successfully

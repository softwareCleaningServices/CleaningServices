Feature: Distribute Orders on Available Workers

  Scenario: Distribute orders on available workers
    Given a list of available workers
    And a list of orders to be distributed with status="waiting"
    When the admin select the distribution process
    Then the orders should be evenly distributed among the available workers
    And the orders status should change to "in terminate"

  Scenario: there is no available workers
    Given no workers are available
    And a list of orders to be distributed with status="waiting"
    When the admin select the distribution process
    Then the system should show that there are no available workers

  Scenario: there is no waiting orders
    Given no orders are waiting
    When the admin select the distribution process
    Then the system should show that there are no waiting orders




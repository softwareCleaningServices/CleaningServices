Feature: record new worker
  the admin is want to add new worker with his correct information

  Scenario: worker recorded successfully
    Given that the admin choose to add new worker
    When the admin enter all the required data about worker
    Then the worker added successfully
Feature: delete worker
  Scenario: worker deleted successfully
    Given I choose to delete worker
    When I enter the worker Id="130"
    Then the worker deleted successfully

  Scenario: wrong worker Id then the delete fail
    Given I choose to delete worker
    When I enter the worker Id="0"
    Then The message "This worker doesn't exist" will be shown
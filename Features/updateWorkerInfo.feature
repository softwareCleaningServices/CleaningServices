Feature: update worker information
  Scenario: change the salary of the worker
    Given that I choose to update worker info
    When I select to update Salary
    And I enter the new salary = "3000"
    Then the salary will updated successfully

  Scenario: change the phone of the worker
    Given that I choose to update worker info
    When I select to update Phone
    And I enter the new Phone = "058721355"
    Then the phone will updated successfully

  Scenario: change the address of the worker
    Given that I choose to update worker info
    When I select to update Address
    And I enter the new address = "Tulkarem"
    Then the address will updated successfully

  Scenario: change the email of the worker
    Given that I choose to update worker info
    When I select to update email
    And I enter the new email = "sdf@gmail.com"
    Then the email will updated successfully
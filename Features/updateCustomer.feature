Feature: update Customer information
  Scenario: change the phone of the customer
    Given that I choose to update customer info
    When I select to update my phone and I enter my new phone = "0287465182"
    Then my phone number will updated successfully

  Scenario: change the address of the customer
    Given that I choose to update customer info
    When I select to update my address and I enter my new address = "Jericho"
    Then my address will updated successfully
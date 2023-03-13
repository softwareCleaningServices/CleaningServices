Feature: record customer information
  Scenario: record done successfully
    Given that I choose to record new customer
    When I enter the correct required customer information
    Then the customer will recorded successfully
    And confirmation email will be sent to customer

  Scenario: record with taken email
    Given that I choose to record new customer
    When I enter the customer information but already taken email
    Then I show a message that the email is already taken
    And I show the customer details who has this email
    And I have option to reenter new email
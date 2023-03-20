Feature: record customer information
  when There is a new customer want to added to system then he
  should enter his name, email, phone, address, password
  then the email should not taken before

  Scenario: record done successfully
    Given that I choose to record new customer
    When I enter the correct required customer information
    Then a unique customer ID will be generated for the customer
    And the customer will recorded successfully
    And confirmation email will be sent to customer

  Scenario: record with taken email
    Given that I choose to record new customer
    When I enter the customer information but already taken email
    Then I show a message that the email is already taken
    And I show the customer details who has this email
    And I have option to reenter new email
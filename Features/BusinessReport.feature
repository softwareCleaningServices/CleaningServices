#num of customer, number of worker, num of category (carpet,cover,sofa),
# num of order by date ,num of category cover by size ,number of worker by category
Feature: Generate a business report
  Scenario: Number of all business customers.
    Given that needs the number of all business customers
    When the admin enters to show the report
    Then calculate number of all business customers

  Scenario: Number of all business worker.
    Given that needs the number of all business worker
    When the admin enters to show the report
    Then calculate number of all business worker

  Scenario: Number of all business worker in category sofa.
    Given that needs the number of all business worker in category sofa
    When the admin enters to show the report
    Then calculate number of all business worker in category sofa

  Scenario: Number of all business worker in category carpet.
    Given that needs the number of all business worker in category carpet
    When the admin enters to show the report
    Then calculate number of all business worker in category carpet

  Scenario: Number of all business worker in category cover.
    Given that needs the number of all business worker in category cover
    When the admin enters to show the report
    Then calculate number of all business worker in category cover

  Scenario: Number of all orders in this month.
    Given that needs the number of all orders in this month
    When the admin enters to show the report
    Then calculate number of all business orders in month 3 and year 2023

  Scenario: Number of sofas in all orders in this month.
    Given that needs the number of sofas in all orders in this month
    When the admin enters to show the report
    Then calculate number of sofas in all orders in month 3 and year 2023

  Scenario: Number of carpets in all orders in this month.
    Given that needs the number of carpets in all orders in this month
    When the admin enters to show the report
    Then calculate number of carpets in all orders in month 3 and year 2023

  Scenario: Number of covers in all orders in this month.
    Given that needs the number of covers in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers in all orders in month 3 and year 2023
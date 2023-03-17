#num of customer, number of worker, num of category (carpet,cover,sofa),
# num of order by date ,num of category cover by size
Feature: Generate a business report
  Scenario: Number of all business customers.
    Given that needs the number of all business customers
    When the admin enters to show the report
    Then calculate number of all business customers

  Scenario: Number of all business worker.
    Given that needs the number of all business worker
    When the admin enters to show the report
    Then calculate number of all business worker

  Scenario: Number of all orders in this month.
    Given that needs the number of all orders in this month
    When the admin enters to show the report
    Then calculate number of all business orders in this month

  Scenario: Number of carpets in all orders in this month.
    Given that needs the number of carpets in all orders in this month
    When the admin enters to show the report
    Then calculate number of carpets in all orders in this month

  Scenario: Number of sofas in all orders in this month.
    Given that needs the number of sofas in all orders in this month
    When the admin enters to show the report
    Then calculate number of sofas in all orders in this month

  Scenario: Number of covers in all orders in this month.
    Given that needs the number of covers in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers in all orders in this month

  Scenario: Number of covers size King in all orders in this month.
    Given that needs the number of covers size King in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers size King in all orders in this month

  Scenario: Number of covers size Queen in all orders in this month.
    Given that needs the number of covers size Queen in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers size Queen in all orders in this month

  Scenario: Number of covers size TWIN_XL in all orders in this month.
    Given that needs the number of covers size TWIN_XL in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers size TWIN_XL in all orders in this month

  Scenario: Number of covers size TWIN in all orders in this month.
    Given that needs the number of covers size TWIN in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers size TWIN in all orders in this month

  Scenario: Number of covers size CRIB in all orders in this month.
    Given that needs the number of covers size CRIB in all orders in this month
    When the admin enters to show the report
    Then calculate number of covers size CRIB in all orders in this month
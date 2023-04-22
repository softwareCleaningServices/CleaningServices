Feature: Generate About report for business include the cash information


  Scenario generate about report with all financial information:
    Given that the admin is logged in in the system
    When the admin select to generate About report
    Then the report will be generated with total cash and total dept and total paid

    Scenario: generate about report when there is no order
      Given that the admin is logged in in the system
      When the admin select to generate About report
      Then the report generated with all field puts to 0


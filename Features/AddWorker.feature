Feature: employment new worker
  the admin is want to add new worker with his name, email, phone, address, salary, category he worked on

  Scenario Outline: worker added successfully
    Given that the worker is not added yet
    When the admin enter the worker Name "<Name>"
    And the admin enter the worker Email "<Email>"
    And the admin enter the worker Phone "<Phone>"
    And the admin enter the worker Address "<Address>"
    And the admin enter the worker Category "<Category>"
    And the admin enter the worker Salary "<Salary>"
    And the admin enter the worker numOfProducts "<numOfProducts>"
    Then the system generate a unique ID for the worker
    And the worker will be added to system
    Examples:
      | Name         | Email           | Phone     | Address | Category | Salary | numOfProducts |
      | Salem        | salem@gmail.com | 059812346 | Nablus  | CARPET   | 2000   | 0             |
      | Ruba         | ruba@gmail.com  | 059812346 | Jericho | COVER    | 2500   | 0             |
      | Ali Mohammed | ali@gmail.com   | 059812346 | Nablus  | SOFA     | 1800   | 0             |

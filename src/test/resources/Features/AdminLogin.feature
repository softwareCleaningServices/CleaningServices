Feature: Admin login
  Scenario: admin success login
    Given that the admin is not logged in
    When the entered email is "adminClean@gmail.com"
    And the entered password is "adminCSS"
    Then the admin login success
    And the admin now logged in

  Scenario: admin fail login
    Given that the admin is not logged in
    When the entered email is "adminClean@gmail.com"
    And the entered password is "wrong password"
    Then the admin login fail
    And he asked to reenter email and password
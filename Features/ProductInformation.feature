Feature: Add a product

  Scenario: Add a carpet product
    Given the user wants to add a new product
    When the user enters a valid information for carpet
    Then a new carpet product with the given details is added to the system

  Scenario: Add a sofa product
    Given the user wants to add a new product
    When the user enters a valid information for sofa
    Then a new sofa product with the given details is added to the system

  Scenario: Add a cover product size King
    Given the user wants to add a new product
    When the user enters a valid information for cover King
    Then a new King cover product with the given details is added to the system

  Scenario: Add a cover product size Queen
    Given the user wants to add a new product
    When the user enters a valid information for cover Queen
    Then a new Queen cover product with the given details is added to the system

  Scenario: Add a cover product size TWIN_XL
    Given the user wants to add a new product
    When the user enters a valid information for cover TWIN_XL
    Then a new TWIN_XL cover product with the given details is added to the system

  Scenario: Add a cover product size TWIN
    Given the user wants to add a new product
    When the user enters a valid information for cover TWIN
    Then a new TWIN cover product with the given details is added to the system

  Scenario: Add a cover product size Crib
    Given the user wants to add a new product
    When the user enters a valid information for cover Crib
    Then a new Crib cover product with the given details is added to the system

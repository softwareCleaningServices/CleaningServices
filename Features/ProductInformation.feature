Feature:record product
  Scenario Outline: record with category carpet
    Given that I recorded a new "carpet"
    When the user  enter name "<name>"
    And enter picture Name "<pictureName>"
    And enter material "<material>"
    And enter dimension <dimension>
    And enter special Treatment "<specialTreatment>"
    And calculate the cost <cost>
    Then the product will be recorded successfully
    Examples:
      | name   | pictureName | dimension | material | specialTreatment | cost  |
      | carpet | carpet      | 20.0      | dd       | white            | 160.0 |
      | carpet | carpet      | 45.0      | tt       | white            | 360.0 |
      | carpet | carpet      | 30.0      | oi       | white            | 240.0 |

  Scenario Outline: record with category cover
    Given that I recorded a new "cover"
    When the user  enter name "<name>"
    And enter picture Name "<pictureName>"
    And enter cover "<cover>"
    And enter material "<material>"
    And enter special Treatment "<specialTreatment>"
    And calculate the cost <cost>
    Then the product will be recorded successfully
    Examples:
      | name | pictureName | cover   | material | specialTreatment | cost |
      | cov1 | cover1      | KING    | cc       | white            | 20   |
      | cov2 | cover2      | QUEEN   | tt       | white            | 18   |
      | cov3 | cover3      | TWIN_XL | as       | white            | 12   |
      | cov4 | cover4      | TWIN    | oai      | white            | 10   |
      | cov5 | cover5      | CRIB    | as       | white            | 8    |


  Scenario Outline: record with category sofa
    Given that I recorded a new "sofa"
    When the user  enter name "<name>"
    And enter picture Name "<pictureName>"
    And enter num Of Sofa <numOfSofa>
    And enter material "<material>"
    And enter special Treatment "<specialTreatment>"
    And calculate the cost <cost>
    Then the product will be recorded successfully
    Examples:
      | name  | pictureName | numOfSofa | material        | specialTreatment | cost |
      | sofa1 | sofa1       | 7         | Canvas and Wood | white            | 175  |
      | sofa2 | sofa2       | 9         | Canvas and Wood | white            | 225  |
      | sofa3 | sofa3       | 11        | Canvas and Wood | white            | 275  |
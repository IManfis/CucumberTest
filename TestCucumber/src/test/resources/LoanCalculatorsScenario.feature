Feature: Loan Calculator validation

  Scenario: Validate the output
    Given users open loan calculator
    When users enter 100 into amount field
    And users enter 10 into rate field
    And users enter 3 into months field
    And users click on calculate button
    Then users should get result as 18

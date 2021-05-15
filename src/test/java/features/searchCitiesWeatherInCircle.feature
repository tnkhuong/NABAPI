Feature: Search cities weather

  @Regression @Positive
  Scenario: Validate return cities weather correctly

    Given User call search cities weather in circle with lat "55.5" and lon "37.5" without number of city
    Then Body should return the info with "5" cities nearly that position
    And Should return status "200"

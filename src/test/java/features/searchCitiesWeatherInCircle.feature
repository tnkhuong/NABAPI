Feature: Search cities weather

  @Regression @Positive
  Scenario: Validate return default number of city weather correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" without number of city
    Then Should return status "200"
    And Body should return the info with "5" cities nearly that position

  @Regression @Positive
  Scenario: Validate return 1 city weather correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "1"
    Then Should return status "200"
    And Body should return the info with "1" cities nearly that position

  @Regression @Positive
  Scenario: Validate return 50 city weather correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "50"
    Then Should return status "200"
    And Body should return the info with "50" cities nearly that position

  @Regression @Negative
  Scenario: Validate return error message when input 0 of number city weather correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "0"
    Then Should return status "400"
    And Should return error message "cnt from 1 to 50"

  @Regression @Negative
  Scenario: Validate return error message when input 51 of number city weather correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "51"
    Then Should return status "400"
    And Should return error message "cnt from 1 to 50"

  @Performance
  Scenario: Validate response time of api number of cities weather in circle

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "1"
    Then Should response time less then "500" milliseconds

  @APIContract
  Scenario: Validate return city weather in circle schema body correctly

    When User call search cities weather in circle with lat "55.5" and lon "37.5" with number of city "1"
    Then Should return status "200"
    And Should return Content-Type "application/json; charset=utf-8"
    And Validate schema body return with json file "CurrentCitiesWeatherInCircle.json" for "Contracts"
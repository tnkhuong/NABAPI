Feature: Search cities weather

  @Regression
  Scenario: Validate response payload will return weather forecast of 5 cities by default

    When User calls Search Cities Weather in Circle API with lat "55.5" and lon "37.5" without number of city
    Then It should return status "200"
    And The response payload should return the weather info of "5" city(s) within the defined position

  @Regression
  Scenario: Validate response payload will return weather forecast of only 1 city

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "1"
    Then It should return status "200"
    And The response payload should return the weather info of "1" city(s) within the defined position

  @Regression
  Scenario: Validate response payload will return weather forecast of 50 cities

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "50"
    Then It should return status "200"
    And The response payload should return the weather info of "50" city(s) within the defined position

  @Regression
  Scenario: Validate the response payload will return error message when input number of city as zero

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "0"
    Then It should return status "400"
    And The response payload should return message "cnt from 1 to 50"

  @Regression
  Scenario: Validate the response payload will return error message when input number of city as 51

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "51"
    Then It should return status "400"
    And The response payload should return message "cnt from 1 to 50"

  @Performance
  Scenario: Validate the response payload will return time

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "1"
    Then It should response time less then "500" milliseconds

  @APIContract
  Scenario: Validate search cities weather in circle API’s schema body is correct

    When User calls Search Cities weather in circle API with lat "55.5", lon "37.5" and number of city "1"
    Then It should return status "200"
    And It should return Content-Type "application/json; charset=utf-8"
    And The response body schema must match with json file "CurrentCitiesWeatherInCircle.json" for checking the "Contracts"

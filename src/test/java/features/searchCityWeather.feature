Feature: Search city weather

    @Regression
    Scenario Outline: Validate response payload will return weather forecast of city by default multi times

        When User calls search cities weather API with "<city>"
        Then It should return status "200"
        And The response payload should return the weather info of "<city return>"

        Examples:
            | city        | city return      |
            | London      | London           |
            | Ho Chi Minh | Ho Chi Minh City |

    @Regression
    Scenario: Validate response payload will return weather forecast of city of country

        When User calls search cities weather API with "London" of "US"
        Then It should return status "200"
        And The response payload should return the weather info of "London" of "US"

    @Regression
    Scenario: Validate the response payload will return error message when input invalid city

        When User calls search cities weather API with "invalid city"
        Then It should return status "404"
        And The response payload should return message "city not found"

    @Performance
    Scenario: Validate the response time acceptable for search city weather API

        When User calls search cities weather API with "London" of "US"
        Then It should response time less then "500" milliseconds

    @APIContract
    Scenario: Validate search city weather API’s schema body is correct

        When User calls search cities weather API with "London"
        Then It should return status "200"
        And It should return Content-Type "application/json; charset=utf-8"
        And The response body schema must match with json file "CurrentWeatherSchema.json" for checking the "Contracts"
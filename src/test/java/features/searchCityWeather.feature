Feature: Search city weather

    @Regression @Positive
    Scenario Outline: Validate return city weather correctly

        Given User call searchWeatherAPI with http request for "<city>"
        Then Should return status "200"
        And Body should return the info "<city return>"

        Examples:
            | city        | city return      |
            | London      | London           |
            | Ho Chi Minh | Ho Chi Minh City |

    @Regression @Positive
    Scenario: Validate return city and country weather correctly

        Given User call searchWeatherAPI with http request for "London" of "US"
        Then Should return status "200"
        And Body should return the info "London" of "US"

    @Regression @Negative
    Scenario: Validate input invalid city

        Given User call searchWeatherAPI with http request for "invalid city"
        Then Should return status "404"
        And Should return error message "city not found"

    @Performance
    Scenario: Validate response time of api a city weather

        Given User call searchWeatherAPI with http request for "London" of "US"
        Then Should response time less then "500" milliseconds

    @APIContract
    Scenario: Validate return city weather schema body correctly

        Given User call searchWeatherAPI with http request for "London"
        Then Should return status "200"
        And Should return Content-Type "application/json; charset=utf-8"
        And Validate schema body return with json file "CurrentWeatherSchema.json" for "Contracts"
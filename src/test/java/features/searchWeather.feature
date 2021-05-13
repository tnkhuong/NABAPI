Feature: Search city weather

Scenario: Validate return city weather correctly

    Given Navigate the site
    When User call searchWeatherAPI with http request for "<city>"
    Then Body should return the info "<city return>"

    Examples:
        | city       | city return      |
        |London      |   London         |
        |Ho Chi Minh | Ho Chi Minh City |
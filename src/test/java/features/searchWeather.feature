Feature: Search city weather

Scenario: Validate return city weather correctly

    Given Navigate the site
    When User call searchWeatherAPI with http request
    Then Body should return the info "json"

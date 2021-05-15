Feature: Test RestCountriesAPI
Scenario: user is able to validate the RestCountriesApi response

Given user sets base API request "https://restcountries.eu/rest/v2/all"
When user sends Api request to get  all the countries
Then print the body.




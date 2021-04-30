Feature: Test RestCountriesAPI
Scenario: user is able to validate the RestCountriesApi response

Given : user sets base API request "https://restcountries.eu"
When : user sends Api request to get  all the countries
Then : Validate the statuscode "200"


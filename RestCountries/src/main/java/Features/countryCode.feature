Feature: Testcase for RestCountries API by given country code
Scenario Outline:user able to get country list
Given Set GET API endpoint "https://restcountries.eu/rest/v2/alpha/"<countrycode>
Then  Validate  the statuscode <code>
Then Validate the capital <capital>
Examples:
|countrycode | code| capital|
|"EG"|200|"Cairo"|
|"CF"|200|"Bangui"|


Scenario Outline:Wrong country code testcases
Given Set GET API endpoint "https://restcountries.eu/rest/v2/alpha/"<countrycode>
Then  Validate  the statuscode <code>
Examples:
|countrycode | code| 
|"xyz"|404|
|"34"|404|
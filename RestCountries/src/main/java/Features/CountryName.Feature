Feature: Testcase for RestCountries API by given country name
#Scenario Outline:  To get country details for a  given counrty name
#Given URL with countryname <countryName>
#Then  validate capital<capital> and stauscode<code>
#Examples:
#|countryName   |   capital| code|
#|"Ethiopia"|"Addis Ababa"| 200|
#|"Dominican Republic"|"Santo Domingo"|200|
#|"Georgia"|"null"|404|


Scenario Outline:user able to get country list
Given Set get API endpoint "https://restcountries.eu/rest/v2/name/"<countryname>
Then  Validate the statuscode <code>
Then validate the capital <capital>
Examples:
|countryname | code| capital|
|"india"|200|"Diego Garcia, New Delhi"|
|"Afghanistan"|200|"Kabul"|

Scenario Outline: Wrong country name testcase
Given Set get API endpoint "https://restcountries.eu/rest/v2/name/"<countryname>
Then  Validate the statuscode <code>
Examples:
|countryname|code|
|"GHB"|404|
|"abc"|404|
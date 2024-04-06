Feature: Verify Login API Feature for the User
  As a user of Phoenix Application if I provide valid credentials to the login api token should be generated

  Scenario: Valid Credentials for Login API
    Given the baseurl of the backend app is "http://139.59.91.96:9000/v1"
    And the header passed is "content-type"  "application/json"
    And the user credentials are "iamfd" "password"
    When I make a POST api request to the endpoint "login"
    Then the status code needs to be 200
    And the response time should be less 1500 ms
    And the response body should contain message as "Success"
    And a token should be generated
    And the response body should be a json body

  Scenario Outline: To check all the credentials
    Given the baseurl of the backend app is "http://139.59.91.96:9000/v1"
    And the header passed is "content-type"  "application/json"
    And the user credentials are "<userName>" "<password>"
    When I make a POST api request to the endpoint "login"
    Then the status code needs to be 200
    And the response time should be less 1500 ms
    And the response body should contain message as "Success"
    And a token should be generated
    And the response body should be a json body

    Examples:

      | userName | password |
      | iamfd    | password |
      | iamsup   | password |
      | iamqa    | password |

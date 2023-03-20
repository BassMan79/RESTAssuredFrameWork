@API
Feature: Request example

  Scenario: Test GET to endpoint
    Given I send a GET request to the https://api.github.com URI
    Then I get a 200 status code

  Scenario: Validate the entry length
    Given I send a GET request to the https://jsonplaceholder.typicode.com URI
    Then I validate there are 10 items /users endpoint

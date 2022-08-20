Feature: Example Application

  Scenario: redirect to github
    * configure followRedirects = false
    Given url baseUrl
    When method get
    Then status 302
    And match header location == 'https://github.com/42talents/blog-verify-database-content-from-a-karate-test'
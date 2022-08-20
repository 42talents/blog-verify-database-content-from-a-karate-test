Feature: Logs resource

  Background:
    * def LogDatabase = Java.type('dbutils.LogDatabase')
    * def logDb = new LogDatabase(postgresConfig)

  Scenario: Create a new log entry
    * def entry = 'example log entry d9175765-f8eb-4fb1-a98e-2359ef5a75f2'
    * karate.log('removed', logDb.deleteEntries(entry), 'log entries')
    Given url baseUrl + '/logs'
    And request entry
    When method post
    Then status 202
    And match true == logDb.hasEntry('example log entry d9175765-f8eb-4fb1-a98e-2359ef5a75f2')

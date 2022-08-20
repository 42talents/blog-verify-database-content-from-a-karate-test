Feature: Logs resource

  Background:
    * def LogDatabase = Java.type('dbutils.LogDatabase')
    * def config = { username: 'sa', password: 'sa', url: 'jdbc:h2:tcp://localhost:9090/mem:db', driverClassName: 'org.h2.Driver' }
    * def db = new LogDatabase(config)

  Scenario: Create a new log entry
    * def entry = 'example log entry d9175765-f8eb-4fb1-a98e-2359ef5a75f2'
    * karate.log('removed', db.deleteEntries(entry), 'log entries')
    Given url baseUrl + '/logs'
    And request entry
    When method post
    Then status 202
    And match true == db.hasEntry('example log entry d9175765-f8eb-4fb1-a98e-2359ef5a75f2')

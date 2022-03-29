Feature: User should be able login using credentials

  @wip
  Scenario: Positive login scenario
    Given user is on he login page of web table app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks login button
    Then user should see url contains orders
Feature: test

Scenario: Move email to Spam	
    Given I logged in with the second user
    Then I check the inbox 
    Then I mark letter as spam
    Then I check spam folder

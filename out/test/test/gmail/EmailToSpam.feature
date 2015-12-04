 Feature: Email to Spam

#  Scenario: Login and send the first email
#    Given I logged in with the first user
#    Then I click Compose button
#    Then I fill in To field with "Vlad.autotest4@gmail.com"
#    Then I fill in subject field with "Hey Hey Hey"
#    Then I click Send button

    
    
# Scenario: Move email to Spam	
#    Given I logged in with the second user
#    Then I check the inbox 
#    Then I mark letter as spam
#    Then I check spam folder
    
#  Scenario: Login and send the second email
#    Given I logged in with the first user
#    Then I click Compose button
#    Then I fill in To field with "Vlad.autotest4@gmail.com"
#    Then I fill in subject field with "Hey Hey Hey"
#    Then I click Send button
 
 
Scenario: Check Spam folder
 Given I logged in with the second user
 Then I check spam folder
 
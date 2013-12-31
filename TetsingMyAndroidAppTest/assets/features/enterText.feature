Feature: enter a text and verify the output

Scenario: Verify that the text entered is displayed correctly        
        Given I am launching the application
        When I submit a text
        Then I receive the same text on the next page
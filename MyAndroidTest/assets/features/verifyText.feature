Feature: Verify labels 

Scenario: Verify label for edit box and send button
	Given I open my android app 
	When I am on the first page
	Then I check that text label is correct
	And button label is correct
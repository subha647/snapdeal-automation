@tag
Feature: Snapdeal landing page

  @tag1
  Scenario: Open snapdeal page
    Given I am on landing page
    Then Snapdeal logo should redirect to homepage
    Then close the browser
  
  @tag2
  Scenario: Search for tshirt
  	Given I am on landing page
  	When I Search tshirt in search bar
  	And I click on search button
  	Then I got results for tshirt
  	Then close the browser
  
  @tag3
  Scenario: Sort search list by price
  	Given I am on landing page
  	Then I Search tshirt in search bar
  	And I click on search button
  	When I am sorting the results by price low to high
  	Then Verify the sort results based on price low to high
  	Then close the browser
  	
  @tag4
  Scenario: Show high rated products
  	Given I am on landing page
  	Then I Search tshirt in search bar
  	And I click on search button
  	When Clicking on high rated productes
  	Then Verify the results with more than four start rating
  	Then close the browser
  
  @tag5
  Scenario: Check for price range
  	Given I am on landing page
  	Then I Search tshirt in search bar
  	And I click on search button
  	When Updated the from min and max price
  	Then Verify the results with price between specified limit
  	Then close the browser
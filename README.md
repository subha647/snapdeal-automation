# Snapdeal landing page test cases

- Case 1: Icon should redirect to homepage
	- Check the navbar snapdeal icon content
	- Check for snapdeal link available in href parameter

- Case 2: Check if user able to get desired result through search box
	- Pass search test to search box
	- Click search button
	- Gather all the product names from search result
	- Check if product name having search string in it
	- At least 10 results having product name match with search string to pass the test case.

- Case 3: Check if user getting low to high price based on sort operation
	- Click on Sort by dropdown
	- Click on **Price Low to High** option
	- Get the product prices
	- Loop through prices and check if previous product price was less than or equal to current product price or not.

- Case 4: Check if user able to get all high star rated product
	- Click on the 4 star customer rating radio button
	- Get all the product ratings from result
	- Check if all the product having rating higher than or equal to 4

- Case 5: Check if user able to get result based on selected price range
	- Update the minimum price
	- Update the maximum price
	- Click on the GO button
	- Check for all the products, whether the price is between the selected range or not
	

## How to run ?

- Open [testRunner.java](src/test/java/testrunner/testRunner.java) from src/test/java, testrunner package, testRunner class
- Run the file JUnit test

## How it's work ?
- I have build using Java BDD framework.
- It contains 
	- elementRepository : here I have stored all web elements
	- steps : This is step definition of feature file
	- testrunner : It will execute the test cases
	- Features : It contains feature files with gherkin scenarios.

## How can I get the execution report ?
- Once we execute the testrunner, it will generate the report as [report1.html](report1.html)

Check the [Test report](https://raw.githack.com/subha647/snapdeal-automation/master/report1.html)
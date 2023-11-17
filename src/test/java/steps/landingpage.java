package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import ElementRepository.helper_element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class landingpage {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	
	WebDriver  driver = new EdgeDriver();
	String searchtext = "T-Shirt";
	int startingPrice = 200;
	int finalPrice = 1000;
	
	helper_element he = new helper_element(driver);
	
	@Given("I am on landing page")
	public void i_am_on_landing_page() {
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
	}

	@Then("Snapdeal logo should redirect to homepage")
	public void snapdeal_logo_should_redirect_to_homepage() {
//		WebElement title = driver.findElement(By.className("notIeLogoHeader"));
		WebElement title = he.homeButton;
		String href_element = title.getAttribute("href");
		assertEquals(href_element , "https://www.snapdeal.com/");
		
	}

	@When("I Search tshirt in search bar")
	public void i_search_tshirt_in_search_bar() {
//	    driver.findElement(By.cssSelector("[id='inputValEnter']")).sendKeys(searchtext);
	    he.searchBox.sendKeys(searchtext);
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
//		driver.findElement(By.className("searchformButton")).click();
		he.searchButton.click();
	}

	@Then("I got results for tshirt")
	public void i_got_results_for_tshirt() {
//		List<WebElement> productTitleElements = driver.findElements(By.className("product-title"));
		List<WebElement> productTitleElements = he.productTitles;
		System.out.println("-".repeat(50));
		System.out.println(productTitleElements.size());
		System.out.println("-".repeat(50));
		
		int count = 0;
		
		for (WebElement element : productTitleElements) {
            // Extract and print the text content of each element
			String search_result_title = element.getAttribute("title");
			String mod_title = search_result_title.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
			String mod_searchtext = searchtext.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
			
			if (mod_title.contains(mod_searchtext)) {
				count ++;
	            System.out.println(ANSI_BLUE+"The Search result contains\"" + searchtext + "\""+ANSI_RESET);
	        } else {
	            System.out.println(ANSI_YELLOW+"The Search result does not contain \"" + searchtext + "\""+ANSI_RESET);
	        }
        }
		System.out.println(ANSI_BLUE+"The Search result found \"" + searchtext + "\"" + count + "times"+ANSI_RESET);
		assertTrue(count > 10 );
	
	}
	
	@When("I am sorting the results by price low to high")
	public void i_am_sorting_the_results_by_price_low_to_high() throws InterruptedException {
//		driver.findElement(By.className("sort-label")).click();
		he.sortByDropdown.click();
//		driver.findElement(By.xpath("//*[@class='sort-value']/li[3]")).click();
		he.sortByPrice.click();
		Thread.sleep(3000);
	}

	@Then("Verify the sort results based on price low to high")
	public void verify_the_sort_results_based_on_price_low_to_high() {
//		List<WebElement> productPriceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<WebElement> productPriceElements = he.productPrices;
		
		int previous_price = 0;
		
		for (WebElement element : productPriceElements) {
            // Extract and print the text content of each element
			String result_price = element.getAttribute("display-price");
			int current_product_price = Integer.parseInt(result_price);
			System.out.println(ANSI_GREEN+"The sorted result previous product price is \"" + previous_price + ANSI_RESET);
			System.out.println(ANSI_GREEN+"The sorted result current product price is \"" + result_price + ANSI_RESET);
			assertTrue(previous_price <= current_product_price );
			previous_price = current_product_price;
        }
		
	}
	
	
	@When("Clicking on high rated productes")
	public void click_high_rated_product() throws InterruptedException {
//		driver.findElement(By.cssSelector("[for='avgRating-4.0']")).click();
		he.rating4Radio.click();
		Thread.sleep(4000);
	}

	@Then("Verify the results with more than four start rating")
	public void varify_highrated_product() {
//		List<WebElement> productRateElements = driver.findElements(By.xpath("//div[@class='clearfix rating av-rating']/div[@class='rating-stars ']/div[@class='filled-stars']"));
		List<WebElement> productRateElements = he.productRatings;
		System.out.println(ANSI_RED+"The sorted result current product rating is \"" + ANSI_RESET);
		for (WebElement element : productRateElements) {
            // Extract and print the text content of each element
			String result_rating = element.getAttribute("style");
			System.out.println(ANSI_GREEN+"The sorted result current product rating is \"" + result_rating + ANSI_RESET);
			String result_rating_str = result_rating.replaceAll("[a-zA-Z%:\";]", "").replaceAll(" ", "");
			System.out.println(ANSI_GREEN+"The sorted result current product rating is \"" + result_rating_str + ANSI_RESET);
			float result_rating_float = Float.parseFloat(result_rating_str);
			System.out.println(ANSI_GREEN+"The sorted result current product rating is \"" + result_rating_str + ANSI_RESET);
			assertTrue(result_rating_float >= 80 );
        }
		
	}
	
	@When("Updated the from min and max price")
	public void update_price_range() throws InterruptedException {
//		WebElement fromInput =  driver.findElement(By.xpath("//input[@name='fromVal']"));
		WebElement fromInput = he.priceRangeMin;
		fromInput.clear();
		fromInput.sendKeys(String.valueOf(startingPrice));
		
//		WebElement toInput = driver.findElement(By.cssSelector("[name='toVal']"));
		WebElement toInput = he.priceRangeMax;
		toInput.clear();
		toInput.sendKeys(String.valueOf(finalPrice));
		
//		driver.findElement(By.className("price-go-arrow")).click();
		he.priceUpdateButton.click();
		Thread.sleep(4000);
	}
	
	@Then("Verify the results with price between specified limit")
	public void verify_price_range() {
		List<WebElement> productPriceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		for (WebElement element : productPriceElements) {
            // Extract and print the text content of each element
			String result_price = element.getAttribute("display-price");
			int current_product_price = Integer.parseInt(result_price);
			int startingPrice_int = startingPrice;
			int finalPrice_int = finalPrice;
			assertTrue(startingPrice_int <= current_product_price && finalPrice_int >= current_product_price);
        }
		
	}
	

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}

	
}

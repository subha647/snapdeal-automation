package ElementRepository;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class helper_element {

	
	WebDriver driver;
	
	
	@FindBy(className = "notIeLogoHeader") public WebElement homeButton;
	@FindBy(css="[id='inputValEnter']") public WebElement searchBox;
	@FindBy(className="searchformButton") public WebElement searchButton;
	@FindBy(className="product-title") public List<WebElement> productTitles;
	@FindBy(className="sort-label") public WebElement sortByDropdown;
	@FindBy(xpath="//*[@class='sort-value']/li[3]") public WebElement sortByPrice;
	@FindBy(xpath="//span[@class='lfloat product-price']") public List<WebElement> productPrices;
	@FindBy(css="[for='avgRating-4.0']") public WebElement rating4Radio;
	@FindBy(xpath="//div[@class='clearfix rating av-rating']/div[@class='rating-stars ']/div[@class='filled-stars']") public List<WebElement> productRatings;
	@FindBy(xpath="//input[@name='fromVal']") public WebElement priceRangeMin;
	@FindBy(css="[name='toVal']") public WebElement priceRangeMax;
	@FindBy(className="price-go-arrow") public WebElement priceUpdateButton;
	
	public helper_element(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

}

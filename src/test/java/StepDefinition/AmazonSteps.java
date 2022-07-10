package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSteps {
	WebDriver driver = null;
	WebElements inputData = new WebElements();

	//public static WebElements elements;
	@Before
	public void data() throws IOException
	{

		inputData.Data();
	}
	@Given ("Open Chrome browser")
	public void Open_Chrome_browser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Then("Go to amazon.in")
	public void go_to_amazon_in() {
		driver.get(WebElements.website);
		driver.manage().window().maximize();
		
	}

	@Then("Login into the amazon")
	public void login_into_the_amazon() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(WebElements.SignInButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.username).sendKeys(WebElements.userName);
		driver.findElement(WebElements.useranameContinue).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.password).sendKeys(WebElements.passWord);
		driver.findElement(WebElements.passwordContinue).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("Search for shoes from search bar")
	public void Then_Search_for_shoes_from_search_bar() throws InterruptedException
	{
		driver.findElement(WebElements.SearchBox).sendKeys(WebElements.product);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.SearchButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("click on the first product from the result")
	public void click_on_the_first_product_from_the_result() throws InterruptedException
	{
		driver.findElement(WebElements.FirstProduct).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("Add shoes to cart and proceed to checkout with a valid address")
	public void Add_shoes_to_cart_and_proceed_to_checkout_with_a_valid_address() throws InterruptedException
	{	
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> Itr= s.iterator();
		while(Itr.hasNext())
		{
		String child_window=Itr.next();
		if(!parent.equals(child_window))
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		Select SelectShoeSize= new Select(driver.findElement(WebElements.ShoeSizes));
		SelectShoeSize.selectByIndex(1);
		//org.openqa.selenium.WebDriverException: unknown error: cannot determine loading status
		Thread.sleep(3000);
		driver.findElement(WebElements.AddToCart).click();
		Thread.sleep(3000);
		driver.findElement(WebElements.ProceedToBuy).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.DeliveryAddress).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try 
		{
			String paymentPageReached=driver.findElement(WebElements.PaymentPage).getText();
			if (paymentPageReached.equalsIgnoreCase("Select a payment method")) 
			{
				System.out.println("Can be delivered to this address");
			} 
			else 
			{
				System.out.println("Can not be delivered to this address");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("This is the exception occurred" +e);
		}
		driver.close();
		}
		}
		driver.switchTo().window(parent);
	}
	
	@Then("Close the browser")
	public void Close_the_browser()
	{
		driver.close();
	}
	@Then("Add shoes to cart and proceed to checkout with a Invalid address")
	public void Add_shoes_to_cart_and_proceed_to_checkout_with_a_Invalid_address() throws InterruptedException
	{
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> Itr= s.iterator();
		while(Itr.hasNext())
		{
		String child_window=Itr.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		Select SelectShoeSize= new Select(driver.findElement(WebElements.ShoeSizes));
		SelectShoeSize.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(WebElements.AddToCart).click();
		Thread.sleep(3000);
		driver.findElement(WebElements.ProceedToBuy).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.Name).sendKeys(WebElements.name);
		driver.findElement(WebElements.PhoneNumber).sendKeys(WebElements.phoneNumber);
		driver.findElement(WebElements.PostalCode).sendKeys(WebElements.postalCode);
		driver.findElement(WebElements.AddressLine1).sendKeys(WebElements.addressLine1);
		driver.findElement(WebElements.AddressLine2).sendKeys(WebElements.addressLine2);
		driver.findElement(WebElements.LandMark).sendKeys(WebElements.landMark);
		driver.findElement(WebElements.City).sendKeys(WebElements.city);
		driver.findElement(WebElements.DropDownForState).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(WebElements.SelectState).click();
		driver.findElement(WebElements.AddAddressButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try 
		{
			if (driver.findElement(WebElements.PostalErrorMessage).isDisplayed()) 
			{
				System.out.println("The postal code which is used is not a valid one");
			} 
			else 
			{
				System.out.println("Added address successfully");
			}
		} catch (Exception e) 
		{
			System.out.println("Error not found "+e);
		}
		driver.close();
		}
		}
		driver.switchTo().window(parent);
		driver.close();
	}
	
	
	}

package StepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class WebElements {
	static By SignInButton=By.xpath("//*[text()='Hello, Sign in']");
	
	static By username=By.xpath("//input[@id='ap_email' or @name='email']");
	static By useranameContinue=By.xpath("//*[@id='continue']");
	static By password=By.xpath("//input[@id='ap_password' and @name='password']");
	static By passwordContinue=By.xpath("//*[@id='signInSubmit']");
	static By SearchBox=By.xpath("//input[@id='twotabsearchtextbox' and @name='field-keywords']");
	static By SearchButton=By.xpath("//*[@id='nav-search-submit-button']");
	static By FirstProduct=By.xpath("//*[@class='a-section aok-relative s-image-tall-aspect']");
	static By ShoeSizes=By.xpath("//*[@id='native_dropdown_selected_size_name']");
	static By AddToCart=By.xpath("//*[@id='add-to-cart-button']");
	static By ProceedToBuy=By.xpath("//*[@id='sc-buy-box-ptc-button']");
	static By DeliveryAddress=By.xpath("(//*[@class='a-declarative a-button-text '])[3]");
	static By PaymentPage=By.xpath("//*[@class='a-spacing-base']");
	
	static By Name=By.xpath("//*[@id='address-ui-widgets-enterAddressFullName']");
	static By PhoneNumber=By.xpath("//*[@id='address-ui-widgets-enterAddressPhoneNumber']");
	static By PostalCode=By.xpath("//*[@id='address-ui-widgets-enterAddressPostalCode']");
	static By AddressLine1=By.xpath("//*[@id='address-ui-widgets-enterAddressLine1']");
	static By AddressLine2=By.xpath("//*[@id='address-ui-widgets-enterAddressLine2']");
	static By LandMark=By.xpath("//*[@id='address-ui-widgets-landmark']");
	static By City=By.xpath("//*[@id='address-ui-widgets-enterAddressCity']");
	static By DropDownForState=By.xpath("//*[@class='a-button-text a-declarative']");
	static By SelectState=By.xpath("//*[@id='1_dropdown_combobox']/li[32]/a");
	static By AddAddressButton=By.xpath("//*[@class='a-button-input']");
	static By PostalErrorMessage=By.xpath("(//*[@class='a-section a-spacing-none a-spacing-top-micro address-ui-widgets-inline-error-alert'])[2]");
	static String website;
	static String userName;
	static String passWord;
	static String product;
	static String name;
	static String phoneNumber;
	static String postalCode;
	static String addressLine1;
	static String addressLine2;
	static String landMark;
	static String city;
	
	public void Data() throws IOException
	{
		FileInputStream fis =new FileInputStream("C:\\Users\\Krupa\\Desktop\\loginmodule\\Configuration\\InputData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		website = prop.getProperty("url");
		userName=prop.getProperty("username");
		passWord=prop.getProperty("password");
		product=prop.getProperty("product");
		name=prop.getProperty("name");
		phoneNumber=prop.getProperty("mobileNumber");
		postalCode=prop.getProperty("postalCode");
		addressLine1=prop.getProperty("addressLine1");
		addressLine2=prop.getProperty("addressLine2");
		landMark=prop.getProperty("landMark");
		city=prop.getProperty("city");
	}
	
}

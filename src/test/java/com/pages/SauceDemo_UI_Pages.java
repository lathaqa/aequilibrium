package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.Driver;
import com.utilities.ReadPropertiesFile;

public class SauceDemo_UI_Pages extends Driver {
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);
	
	@FindBy(xpath = "//*[@id=\"login-button\"]")
	WebElement login_button;

	@FindBy(xpath = "//*[@id=\"login-button\"]/../div[3]/h3")
	WebElement error_message_no_username_no_password;

	@FindBy(xpath = "//*[@id=\"login-button\"]/../div[3]/h3")
	WebElement error_message_no_password;

	@FindBy(id = "user-name")
	WebElement username;

	public SauceDemo_UI_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_SauceDemoUI() {
		driver.get(prop.getProperty("URL"));
	}

	public void click_login_button() {
		login_button.click();
	}

	public String get_error_message_no_password() {
		String msg = error_message_no_password.getText();
		return msg;
	}

	public void enter_username_Valid() {
		username.sendKeys("srilatha123");
	}
	
	public void userName_Displayed() {
		username.isDisplayed();
	}

	public void enter_username_ValidCharacters() {
		username.sendKeys("srilatha");
	}

	public void enter_username_special_chars() {
		username.sendKeys(")&*$#@");
	}

	public void enter_username_numericals() {
		username.sendKeys("12345");
	}

	public void enter_username_numericals_and_splchars() {
		username.sendKeys("&%123*");
	}

	public void clear_username() {
		username.clear();
	}
}

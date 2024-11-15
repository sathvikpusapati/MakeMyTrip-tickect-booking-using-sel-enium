package com.PomPages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Flight {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public Flight(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));  
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[@class='commonModal__close']")
	private WebElement popupbutton;
	
	@FindBy(xpath="//li[text()='One Way']")
	private WebElement way;
	
	@FindBy(xpath="//input[@id='fromCity']")
	private WebElement fromcity;
	
	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement	fromcitytext;
	
	@FindBy(xpath="//span[text()='Bidar Airport']")
	private WebElement selectcity;
	
	@FindBy(xpath="//input[@id='toCity']")
	private WebElement tocity;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement tocitytext;
	
	@FindBy(xpath="//span[text()='Moradabad Airport']")
	private WebElement selecttocity;
	
	@FindBy(xpath="//div[@class='calHeading makeFlex']")
	private WebElement invi;
	
	@FindBy(xpath="//label[@for='departure']")
	private WebElement departure;
	
	@FindBy(xpath="//p[text()='15']")
	private WebElement nextday;
	
	@FindBy(xpath="//div[@data-cy='returnArea']")
	private WebElement returnn;
	
	@FindBy(xpath="//p[text()='17']")
	private WebElement returnday;
	
	@FindBy(xpath="//label[@for='travellers']")
	private WebElement travellers;
	
	@FindBy(xpath="//li[@data-cy='adults-4']")
	private WebElement adults;
	
	@FindBy(xpath="//li[@data-cy='children-2']")
	private WebElement children;
	
	@FindBy(xpath="//li[text()='First Class']")
	private WebElement clas;
	
	@FindBy(xpath="//button[text()='APPLY']")
	private WebElement apply;
	
	@FindBy(xpath="//a[text()='Search']")
	private WebElement search;
	
	public void bookflight(String from,String to) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(popupbutton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(way)).click();
		wait.until(ExpectedConditions.elementToBeClickable(fromcity)).click();
		wait.until(ExpectedConditions.visibilityOf(fromcitytext)).sendKeys(from);
		wait.until(ExpectedConditions.elementToBeClickable(selectcity)).click();
		wait.until(ExpectedConditions.elementToBeClickable(tocity)).click();
		wait.until(ExpectedConditions.visibilityOf(tocitytext)).sendKeys(to);
		wait.until(ExpectedConditions.elementToBeClickable(selecttocity)).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.invisibilityOf(invi));
		wait.until(ExpectedConditions.elementToBeClickable(nextday)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(returnn)).click();
	
		wait.until(ExpectedConditions.elementToBeClickable(returnday)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(travellers)).click();
		wait.until(ExpectedConditions.elementToBeClickable(adults)).click();
		wait.until(ExpectedConditions.elementToBeClickable(children)).click();
		wait.until(ExpectedConditions.elementToBeClickable(clas)).click();
		wait.until(ExpectedConditions.elementToBeClickable(apply)).click();
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		
	}
}

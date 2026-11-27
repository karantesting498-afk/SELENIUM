package trackofield.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import trackofield.pom_components.PomComponents;

public class DashboardPage  extends PomComponents{
	
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	By employeeCardList = By.xpath("//div[@id='cardListView']/child::div[contains(@class,'mb-3')]");
	
	@FindBy(xpath = "//li[@id='module-workforce-management']")
	WebElement workForceManagement;
	
	By subMenu = By.xpath("//li[@id='module-workforce-management']/descendant::div[@class='submenu-scroll-wrapper']/child::li[1]");
	
	@FindBy(xpath = "//li[@id='module-workforce-management']/descendant::div[@class='submenu-scroll-wrapper']/descendant::a[@href='/web/0/customer/list?lang=en']")
	WebElement customerSubMenuOption;
	
	
	public CustomerPage navigateToCustomerPage()
	{
		waitForVisbilityOfElementsBy(employeeCardList);
		
		Actions action = new Actions(driver);
		
		action.click(workForceManagement).build().perform();
		
		waitForVisibilityOfElementBy(subMenu);
		
		waitForElementToBeClickableElement(customerSubMenuOption);
		
		action.click(customerSubMenuOption).build().perform();
		
		CustomerPage customer = new CustomerPage(driver);
		return customer;
		
		
	}
	

}

package trackofield.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import trackofield.pom_components.PomComponents;

public class CustomerPage extends PomComponents{
	
	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By customerList = By.xpath("//table[@id='customer-list-table']/descendant::tbody/child::tr[1]");

	@FindBy(xpath ="//button[contains(@class,'add-customer-btn')]")
	WebElement addCustomer;
	
	@FindBy(xpath = "//table[@id='customer-list-table']/descendant::tbody/child::tr[1]")
	WebElement firstCustomers;
	
	@FindBy(xpath = "//div[@id='add-customer-modal']")
	WebElement addCustomerModal;
	
	@FindBy(xpath = "//span[@id='select2-add-customer-type-container']")
	WebElement customerType;
	
	@FindBy(xpath = "//span[contains(@class,'select2-dropdown')]")
	WebElement customerTypeDropdown;
	
	@FindBy(xpath = "//ul[@id='select2-add-customer-type-results']/child::li")
	List<WebElement> customerTypeOptionsList;
	
	@FindBy(id= "add-customer-name")
	WebElement customerName;
	
	
	@FindBy(id= "new-geofence-customer")
	WebElement addGeofence;
	
	@FindBy(id= "leaflet-map-modal")
	WebElement geofenceModal;
	
	@FindBy(id= "searchInput")
	WebElement geofenceLocationInput;
	
	@FindBy(id= "place")
	WebElement newGeofenceSearchSuggestions;
	
	@FindBy(xpath = "//input[contains(@class,'geo-name')]")
	WebElement newGeofenceName;
	
	@FindBy(xpath = "//div[contains(@class,'leaflet-popup-content')]")
	WebElement selectedGeofencePopupText; 
	
	@FindBy(id="save-customer-geofence-map")
	WebElement saveNewGeofence;
	
	@FindBy(id="save-customer-btn")
	WebElement saveCustomer;
	
	public void addCustomerModal()
	{
		waitForVisibilityOfElementBy(customerList);
				
		addCustomer.click();
	}
	

	public void addGeofenceInCustomer(String geoName)
	{
		addGeofence.click();
		
		waitForVisibilityOfElement(geofenceModal);
		
		geofenceLocationInput.sendKeys("Dilshad garden");
		
		waitForVisibilityOfElement(newGeofenceSearchSuggestions);

		//Now select location
		
		driver.findElement(By.xpath("//div[@id='place']/child::li[1]")).click();
		
		waitForVisibilityOfElement(selectedGeofencePopupText);
		
		newGeofenceName.sendKeys(geoName);
		
		saveNewGeofence.click();
		
		waitForVisibilityOfElement(addCustomerModal);

	}
	
	
	public void addCustomer(String name, String geoName)
	{
		boolean customerTypeFound = false;
		addCustomerModal();
		waitForVisibilityOfElement(addCustomerModal);
		customerType.click();
		
		waitForVisibilityOfElement(customerTypeDropdown);
		
		for(WebElement ele : customerTypeOptionsList)
		{
			waitForVisibilityOfElement(ele);

			if(ele.getText().equalsIgnoreCase("DELHI"))
			{
				waitForElementToBeClickableElement(ele);
				ele.click();
				customerTypeFound= true;
				break;
			}

		}
		
		if(customerTypeFound == false)
		{
			System.out.println("Customer type not found");
		}
		
		
		customerName.sendKeys(name);
		
		addGeofenceInCustomer(geoName);
		
		saveCustomer.click();
	}
	
	public String checkAddedName()
	{
		waitForVisibilityOfElementBy(customerList);

		return firstCustomers.findElement(By.xpath(".//a")).getAttribute("title");
	}
}

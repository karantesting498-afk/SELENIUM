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
	
	By customerSearchBar = By.xpath("//input[contains(@class,'select2-search__field')]");

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
	
	@FindBy(id="select2-customer-select-container")
	WebElement searchCustomerField;

	@FindBy(id="select2-customer-select-results")
	WebElement searchCustomerDropdownField;
	
	@FindBy(xpath = "//ul[@id='select2-customer-select-results']/child::li")
	List<WebElement> searchList;

	@FindBy(id = "pageLoader")
	WebElement pageLoader;
	
	@FindBy(xpath = "//div[@id='swal2-content']")
	WebElement successPopupMsg;
	
	@FindBy(xpath = "//button[contains(@class,'swal2-confirm') and normalize-space(.)='OK']")
	WebElement confirmButton;
	
	
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
	
	public String addCustomerWithoutGeofence(String name)
	{
		addCustomerModal();
		waitForVisibilityOfElement(addCustomerModal);
		customerName.sendKeys(name);
		saveCustomer.click();

		if(!name.isBlank())
		{
			waitForVisibilityOfElement(successPopupMsg);
			String msg = successPopupMsg.getText();
			
			waitForElementToBeClickableElement(confirmButton);
			confirmButton.click();
			return msg;
		}
		else
		{
			return null;
		}
		
	}
	
	public String addCustomer(String name, String geoName)
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
		
		waitForVisibilityOfElement(successPopupMsg);
		String msg = successPopupMsg.getText();
		
		waitForElementToBeClickableElement(confirmButton);
		confirmButton.click();
		return msg;
	}
	
	public String checkAddedNameInCustomerList()

	{
		waitForVisibilityOfElementBy(customerList);

		return firstCustomers.findElement(By.xpath(".//a")).getAttribute("title");
	}
	
	public String  returnStyleOfName()
	{
		
		return customerName.getAttribute("style");
	}
	
	public String Search(String name)
	{
		waitForVisibilityOfElementBy(customerList);

		waitForElementToBeClickableElement(searchCustomerField);
		searchCustomerField.click();
		
		waitForVisibilityOfElement(searchCustomerDropdownField);
		
		waitForElementToBeClickableBy(customerSearchBar);
		
		driver.findElement(customerSearchBar).sendKeys(name);

		waitForVisibilityOfElements(searchList);
		
		searchList.get(0).click();
		
		waitForInvisibilityOfElment(pageLoader);
		
		waitForVisibilityOfElementBy(customerList);

		
		return firstCustomers.findElement(By.xpath(".//a")).getAttribute("title");

		
	}
	
	
}

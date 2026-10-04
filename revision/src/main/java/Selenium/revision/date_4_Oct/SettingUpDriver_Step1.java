package Selenium.revision.date_4_Oct;

public class SettingUpDriver_Step1 {
	
	
	//1. Install selenium java and testNG dependency in the project pom.xml
	//2. Download java and save bin path in system and enviornment variables
	//3. Download Web Driver( but from selenium 4.6, just invoking driver , selenium will download driver automatically
	//4. invoking driver --> WebDriver driver = new ChromeDriver()
	/*
	 * ChromeDriver is a class. WebDriver is an interface
	 * When we write ChromeDriver driver = new ChromeDriver()
	 * Then driver can access methods of webdriver and chrome. But if we want to run the code with firefox driver, then it will fail as
	 * firefox driver cannot access chrome methods.So to restrict we use
	 * WebDriver driver = new ChromeDriver()
	 */
	

}

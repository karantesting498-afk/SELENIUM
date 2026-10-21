// This file contains ssl handling questions

package Selenium.revision.date_13_Oct;

public class SSL_Handling_Step2 {
	
	/*
	 * Q1. SSL configuration is enabled, but Chrome still shows a warning
You have written the following code:
ChromeOptions options = new ChromeOptions();
options.setAcceptInsecureCerts(true);

WebDriver driver = new ChromeDriver();
driver.get("https://test-environment.example");


Chrome still displays a certificate warning page.

Questions:
1. Identify the mistake in the code.
2. How should you initialize ChromeDriver correctly?
3. If the warning persists after correcting the code, what would you investigate next?
4. How would you distinguish a certificate-validation issue from a proxy or network issue?
	 */
	
	public void ques_01()
	{
		/*
		 * 1. it should be WebDriver driver = new ChromeDriver(options);
		 * 2. same as 1
		 *
		 * 3. Whether the issue is a certificate error or a proxy/network error.
 Whether the page is actually loaded inside the expected browser session.
. Whether the certificate problem requires fixing the test environment itself.
Do not automatically assume every HTTPS loading failure is an SSL certificate issue.

4. don't know


		 */
	}
	
	/*
	 * 
	 */
	

}

//This class contain knowledge about ssl handling
package Selenium.revision.date_13_Oct;

public class SSL_Handling_Step1 {
	
	/*
	 * 1. What is an SSL certificate error?
SSL/TLS helps secure communication between a browser and a website using HTTPS.

Examples of certificate-related browser errors:
- NET::ERR_CERT_AUTHORITY_INVALID — the certificate authority isn't trusted.
- NET::ERR_CERT_DATE_INVALID — the certificate is expired or not yet valid.
- NET::ERR_CERT_COMMON_NAME_INVALID — the certificate doesn't match the website hostname.
In Selenium automation, these errors can prevent the browser from loading the application normally.
	 */
	
	/*
	 * 2. Handling SSL errors using ChromeOptions
Selenium provides browser options to configure how Chrome handles certificate errors.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHandling {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://your-test-environment.example");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}


Important line
options.setAcceptInsecureCerts(true);


This tells Selenium to accept insecure certificates for the session, where supported by the browser.

Remember: This is useful for controlled test environments. It should not be used as a general solution for production certificate problems because it reduces certificate-validation protection
	 */
	
	/*
	 * 3. Using DesiredCapabilities — older approach
Older Selenium examples may use DesiredCapabilities. In modern Selenium 4 code, browser-specific options are generally preferred.

Older-style example:
DesiredCapabilities capabilities =
    new DesiredCapabilities();

capabilities.setAcceptInsecureCerts(true);


For Chrome, use ChromeOptions in modern Selenium and pass the options to ChromeDriver.
	 */
	
	/*
	 * 4. SSL handling in Firefox
Firefox can also be configured to accept insecure certificates.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSSLHandling {

    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();

        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://your-test-environment.example");

        driver.quit();
    }
}

	 */

	/*
	 * 5. What if the browser still shows an SSL warning?
	 * 
If the browser displays a certificate warning even after configuring the option, investigate:

1. Whether the option was passed to the correct driver.
2. Whether the browser is controlled by enterprise policies.
3. Whether the issue is a certificate error or a proxy/network error.
4. Whether the page is actually loaded inside the expected browser session.
5. Whether the certificate problem requires fixing the test environment itself.
Do not automatically assume every HTTPS loading failure is an SSL certificate issue.
	 */
	
	/*
	 * 6. Common interview questions
Q1. What does setAcceptInsecureCerts(true) do?
It configures the WebDriver session to accept insecure certificates where supported.Hide answer
Q2. Is accepting insecure certificates safe in production?
Generally no. It weakens certificate validation and can hide genuine security problems.Hide answer
Q3. Does SSL handling fix every HTTPS error?
No. DNS, proxy, network, TLS compatibility, and server failures may remain.Hide answer
Q4. Where should ChromeOptions be passed?
To the ChromeDriver constructor when creating the WebDriver session.Hide answer
Q5. Should SSL validation be disabled for all test cases?
No. Keep certificate-validation tests separate so invalid certificates are still detected.
	 */
	
	/*
	 * 7. Best practices for QA
- Use setAcceptInsecureCerts(true) only when the test objective permits it.
- Keep a separate test for invalid, expired, or untrusted certificates when certificate security is in scope.
- Prefer fixing invalid certificates in the test environment over bypassing validation.
- Use explicit waits to handle page loading after navigation; SSL configuration does not replace synchronization.
Interview takeaway: In Selenium 4, the key configuration to remember is options.setAcceptInsecureCerts(true). Know what it does, its limitations, and why bypassing certificate validation must be controlled.
	 */
}

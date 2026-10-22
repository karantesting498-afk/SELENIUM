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
	 * Q2. SSL handling versus security testing
Your QA environment uses a self-signed certificate. Your automation suite sets setAcceptInsecureCerts(true) globally, and all login tests pass.

However, the application is now being tested for certificate security.

Questions:
1. Why could the existing suite miss a certificate-related defect?
2. How would you separate normal functional tests from certificate-validation tests?
3. Should you use the same browser configuration for both test types? Explain.
4. How would you verify that an invalid or expired certificate is rejected when certificate validation is required?
	 */
	
	public void ques_02()
	{
		/*1. Why could the existing suite miss a certificate-related defect?
The existing suite uses:
options.setAcceptInsecureCerts(true);


This capability tells the WebDriver session to accept insecure certificates rather than require normal certificate validation.

As a result, a browser session may continue to the application despite certificate problems. The functional login tests could pass even though the certificate is invalid, expired, or untrusted.

Key point: Successful login does not prove that certificate validation is working correctly.
		 * 
		 */
		
		/*
		 * 2. How would you separate normal functional tests from certificate-validation tests?
Use separate test configurations.

Functional testing: Configure the browser to accept the self-signed certificate in the controlled QA environment, allowing login and other application functionality to be tested.

Certificate-security testing: Use a separate browser session with insecure certificates not accepted. Verify that the browser rejects the invalid certificate or displays the expected certificate error.
		 */
		
		/*
		 * 3. Should you use the same browser configuration for both test types?
No. The configurations should reflect different testing objectives.
Test type	acceptInsecureCerts	Objective
Functional tests	true, if required by the QA environment	Test application functionality despite the known self-signed certificate
Certificate-security tests	false	Verify that certificate validation is enforced
Setting it to false does not itself guarantee rejection of every certificate problem; browser trust, policies, and other configuration also matter
		 */
		
		/*
		 * 4. How would you verify that an invalid or expired certificate is rejected?
1. Configure a controlled test endpoint with an invalid, expired, or otherwise untrusted certificate.
2. Start a new browser session with acceptInsecureCerts set to false.
3. Navigate to the endpoint.
4. Verify that the browser blocks normal access and presents the expected certificate error.
5. Confirm that the test does not proceed to the application's login page.
Use a controlled test certificate or test server rather than deliberately breaking a production certificate.
		 */
	}
	
	/*
	 * Q3. SSL errors occur inconsistently across test machines
Your Selenium test passes on your local Windows machine but fails on a CI machine with a certificate warning. Both machines use Selenium 4 and Chrome.

Questions:
1. What environment-specific factors would you investigate?
2. How would browser policies, proxy configuration, certificate trust stores, and browser versions affect your diagnosis?
3. Would setAcceptInsecureCerts(true) necessarily resolve the issue? Why or why not?
4. How would you make the test reliable without blindly bypassing certificate validation?
	 */
	public void ques_03()
	{
		/*
		 * 1. What environment-specific factors would you investigate?
Investigate the following:
- Certificate trust: Is the relevant root or intermediate CA trusted on both machines?
- System date and time: Is either machine's clock incorrect, making a certificate appear expired or not yet valid?
- Browser version: Are both machines running compatible Chrome versions?
- Proxy configuration: Does the CI environment intercept HTTPS traffic or use a different proxy?
- Browser policies: Are enterprise policies enforcing certificate checks or restricting exceptions?
- Network differences: Does CI reach a different server, load balancer, or certificate chain?
- Runtime configuration: Are the same Chrome options and capabilities actually applied in both environments?
		 */
		
		/*
		 * 2. How do browser policies, proxies, trust stores, and versions affect the diagnosis?
- Browser policies: Managed Chrome policies can restrict certificate-error bypasses or enforce particular trust settings.
- Proxy configuration: An HTTPS-inspecting proxy may present its own certificate. If its issuing CA is not trusted, CI can show a certificate warning.
- Certificate trust stores: The Windows machine and CI container may trust different root CAs. Chrome's trust behavior also depends on its version and platform.
- Browser versions: Different versions may change certificate handling, trust-store integration, or error-page behavior.
Compare the actual certificate presented to each machine, not just the certificate configured on the application server.
		 */
		
		/*
		 * 3. Would setAcceptInsecureCerts(true) necessarily resolve the issue?
No.

Although this capability requests that the browser accept insecure certificates, it does not guarantee that every certificate-related failure will be bypassed.

For example, browser policies, proxy issues, browser-specific restrictions, and failures unrelated to certificate validation may still prevent navigation.

Also, if the browser is connecting to a different endpoint in CI, enabling this option can conceal the underlying configuration problem rather than fix it.
		 */
		
		/*
		 * 4. How would you make the test reliable without blindly bypassing certificate validation?
1. Compare the browser version, capabilities, proxy settings, system clock, and certificate chain across environments.
2. Confirm that both machines reach the intended HTTPS endpoint.
3. Configure the correct CA certificate in the relevant trust store when the environment is supposed to trust that CA.
4. Keep functional tests and certificate-security tests in separate configurations.
5. In certificate-security tests, set acceptInsecureCerts to false and verify the expected rejection behavior.
6. Record the browser version, endpoint, and certificate details when failures occur.
Important distinction: Fix trust configuration when the certificate is supposed to be trusted. Do not add a CA to the trust store merely to make a security test pass; doing so would undermine a test intended to verify rejection of an untrusted certificate.
		 */
		
		
		
	}

}

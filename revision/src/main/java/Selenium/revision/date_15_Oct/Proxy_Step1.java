// this class contain knowledge regarding proxy
package Selenium.revision.date_15_Oct;

public class Proxy_Step1 {
	
	/*
	 * Selenium Java Notes: Proxy Handling
Proxy handling is an important Selenium topic for interviews and real-world automation, especially when testing applications behind corporate networks, debugging network traffic, or running tests through a proxy server.
1. What is a proxy server?
A proxy server acts as an intermediary between the client (browser) and the destination server.
Selenium WebDriver + Browser

Proxy Server

IP, routing, filtering, or traffic inspection

Target Website


Common reasons to use a proxy:
- Access applications through a corporate network.
- Route test traffic through a specific network endpoint.
- Inspect HTTP/HTTPS traffic during debugging.
- Test application behavior from different network environments.
- Validate proxy authentication and connectivity.
=========================================================================================
	 */
	
	/*
	 * 2. Types of proxies
Proxy type	Purpose
HTTP proxy	Routes HTTP traffic
HTTPS proxy	Commonly supports HTTPS tunneling using CONNECT
SOCKS proxy	Routes supported network traffic at a lower level
Transparent proxy	Intercepts or routes traffic without requiring explicit client configuration in some environments
Authenticated proxy	Requires credentials or another authentication mechanism
Interview point: An HTTPS proxy does not necessarily decrypt HTTPS traffic. Ordinary HTTPS tunneling can preserve end-to-end TLS encryption.
	 */
	
	/*
	 * 3. Configure a proxy in Selenium 4
Selenium provides the Proxy class and browser options to configure proxy settings.
Example: Chrome with an HTTP proxy
Suppose your proxy server is proxy.example.com and its port is 8080.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxyHandling {

    public static void main(String[] args) {

        Proxy proxy = new Proxy();

        proxy.setHttpProxy("proxy.example.com:8080");
        proxy.setSslProxy("proxy.example.com:8080");

        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://example.com");
            System.out.println(driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}


Important methods
- setHttpProxy() configures the HTTP proxy endpoint.
- setSslProxy() configures the proxy used for HTTPS traffic.
- options.setProxy(proxy) applies the configuration to the browser session.
Replace the example hostname and port with the values supplied by your network administrator or test environment.
	 */
	
	/*
	 * 4. Configure a proxy using Chrome arguments
Chrome also supports a command-line proxy argument.
ChromeOptions options = new ChromeOptions();

options.addArguments(
    "--proxy-server=http://proxy.example.com:8080"
);

WebDriver driver = new ChromeDriver(options);


This is an alternative configuration approach. Prefer one clear configuration strategy rather than setting conflicting proxy options.

Important: The exact syntax and behavior can vary by proxy protocol and browser configuration. For HTTPS destinations, an HTTP proxy commonly establishes a tunnel using CONNECT.
	 */
	
	/*
	 * 5. Handle a proxy that requires authentication
Some corporate proxies require a username and password.

You should know that setting the proxy hostname and port does not automatically handle proxy authentication.

Possible approaches include:
- Using an organization-approved proxy authentication mechanism.
- Configuring browser-managed authentication or policies.
- Using a supported authentication extension when permitted.
- Using a test environment with controlled proxy credentials.
Avoid putting real usernames and passwords directly in source code or committing them to Git.

Do not assume that adding credentials to a proxy URL will work in every Chrome/Selenium version
	 */
	
	/*
	 * 6. Proxy versus SSL certificate handling
These topics are related but solve different problems.
Proxy handling	SSL certificate handling
Controls how browser traffic is routed	Controls certificate validation behavior
Helps route traffic through a proxy server	Helps determine whether the HTTPS server certificate is trusted
Affects network connectivity and traffic flow	Affects TLS identity and trust validation
Incorrect settings may cause proxy connection errors	Certificate problems may cause browser security warnings
If a corporate proxy inspects HTTPS traffic, it may present certificates signed by an organization-specific certificate authority. The correct solution is normally to establish the approved certificate trust configuration, not automatically disable certificate validation.
	 */
	
	/*
	 * 7. Common proxy errors in Selenium
Problem	What to investigate
ERR_PROXY_CONNECTION_FAILED	Proxy host, port, connectivity, firewall, and proxy availability
Website does not load	Proxy configuration, DNS, routing, authentication, and destination access
HTTP 407 Proxy Authentication Required	Proxy authentication credentials or authentication mechanism
HTTPS certificate warning	Certificate chain, trust store, hostname, and possible TLS inspection
Works locally but fails on CI	Network access, environment-specific proxy settings, firewall, and credentials
Some sites work but others fail	Proxy rules, allowlists, DNS resolution, or protocol restrictions
A proxy error and an SSL certificate error are not interchangeable. Diagnose the actual browser or network error before changing configuration.
	 */
	
	/*
	 * 8. Common interview questions
Q1. How do you configure a proxy in Selenium 4?
Create a Proxy object, set the required proxy endpoints, and apply it through browser options such as ChromeOptions.setProxy().Hide answer
Q2. Does configuring a proxy handle authentication automatically?
No. Proxy routing and proxy authentication are separate concerns.Hide answer
Q3. What does HTTP 407 mean?
The proxy requires valid authentication before it will process the request.Hide answer
Q4. Does an HTTPS proxy automatically decrypt HTTPS traffic?
No. HTTPS commonly uses CONNECT tunneling; TLS inspection requires additional proxy behavior and trust configuration.Hide answer
Q5. Why might a proxy work locally but fail in CI?
The CI environment may have different network access, DNS, firewall rules, credentials, or proxy configuration.Hide answer
	 */
	
	/*
	 * 9. Best practices
1. Configure proxy settings before creating the WebDriver session.
2. Use environment-specific configuration for local machines and CI.
3. Store credentials securely; never hardcode production secrets.
4. Verify proxy connectivity independently when browser navigation fails.
5. Keep proxy configuration separate from SSL certificate-validation settings.
6. Use only authorized proxies and approved traffic-inspection configurations.
	 */
	
	
	

}

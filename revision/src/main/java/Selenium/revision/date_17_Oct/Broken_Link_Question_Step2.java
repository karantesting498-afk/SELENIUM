// this class contain knowledge regarding the broken link handling
package Selenium.revision.date_17_Oct;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Broken_Link_Question_Step2 {
	WebDriver driver;

	
	/*
	 * Q1. Understand and modify existing code
Medium

Study the following code:
List<WebElement> links =
    driver.findElements(By.tagName("a"));

for (WebElement link : links) {
    String url = link.getAttribute("href");
    System.out.println(url);
}


Tasks:
1. What will findElements() return?
2. What does getAttribute("href") retrieve?
3. Modify the code to skip links whose href is null or blank.
4. Can this code alone confirm that a link is broken? Why or why not?
	 */
	
	public void ques_01()
	{
		/*
		 * 1. It will return all the webElement which have tagName with 'a'.		 * 
		 * 2. It retrieves the value of the element's href attribute, usually the link's destination URL, 
		 * not the text inside the element.
		 * 
		 * 
		 * 3. code
		 * 4. No this alone cannot confirm whether link is broken or not because we have to fetch the responseCode for verifcation
		 */
		
		List<WebElement> links =
			    driver.findElements(By.tagName("a"));

			for (WebElement link : links) {
			    String url = link.getAttribute("href");
			    
			    if(url == null || url.isBlank())
			    {
			    	continue;
			    }
			    System.out.println(url);
			}
	}
	
	/*
	 * Q2. Check an HTTP response code
Medium

An interviewer asks you to check whether a link returns HTTP 404.

You are given this code:
URL url = new URI(href).toURL();

HttpURLConnection connection =
    (HttpURLConnection) url.openConnection();

connection.setRequestMethod("GET");

int code = connection.getResponseCode();
System.out.println(code);


Tasks:
1. Complete the code so it prints "Broken link" when the status is 404 and "Not a 404" otherwise.
2. Add a basic try-catch block to handle exceptions.
3. Why do we use HttpURLConnection instead of simply checking whether the Selenium element exists?
4. What does HTTP status 200 generally indicate?
	 */
	
	public void ques_02()
	{
		/*
		 * 1. code
		 * 2. code
		 * 3. HttpUrlConnection is used to create a connection between url and browser.
		 * through this we can get response header
		 * 
		 * The correction is that HttpURLConnection makes an HTTP request to the URL and allows you to inspect the server's response, including its status code and headers. It does not create a connection between the URL and the browser.

Selenium finding an element only confirms that the element exists in the DOM; it does not verify that its destination resource is available.


		 * 
		 * 4. Code 200 means OK.
		 * 
		 */
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			try {
				HttpURLConnection connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
				
				connection.setRequestMethod("GET");
				int responseCode = connection.getResponseCode();
				
				if(responseCode == 404)
				{
					System.out.println("Broken link");
					continue;
				}
				else
				{
					System.out.println("Not a 404");
				}
				
	            connection.disconnect();

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Q3. Handle different status codes
Hard

Your code checks links and receives these responses:
URL	Status code
Link A	200
Link B	404
Link C	403
Link D	500
Tasks:
1. Write an if-else block to print the status of each URL.
2. Explain what each of these four status codes means.
3. Should you automatically report both 403 and 404 as broken links? Explain your reasoning.
4. If a URL returns 500, what would you investigate before deciding how to report it?
	 */
	
	public void ques_03()
	{
		/*
		 * 1. code
		 * 2. 200 = OK
		 * 404 = Not Found
		 * 403 = forbidden
		 * 500 = Internal server error
		 * 
		 * 3. Yes, we can report both 404 and 403 as broken link because user cannot access url in these cases.
		 * Task 3: Should both 403 and 404 automatically be reported as broken links?
Your answer: “Yes, because the user cannot access the URL.”

This needs correction.
- 404: Usually indicates that the requested resource was not found. It is reasonable to flag it as a potentially broken link.
- 403: Indicates that access is forbidden. The resource may exist, but permissions, authentication, security rules, or automated-request restrictions may prevent access.
Therefore, do not automatically classify both as broken links. Report them according to their meanings and the application's requirements.

	
		 * 
		 * 4. No,in case code is 500, we can simply report it.
		 * as in case of 500, we cannot access url
		 * 
		 * Task 4: What would you investigate for a 500 response?
Your answer: “We can simply report it because we cannot access the URL.”

Partially correct, but incomplete.

A 500 response should be reported as an internal server error, but before deciding whether it represents a reproducible application defect, investigate:
- Whether the error occurs consistently or temporarily.
- Server logs and application exceptions.
- Whether the server or dependent services are experiencing an outage.
- Whether the same URL fails in a normal browser or with another valid request.
A single 500 response is evidence of a server-side failure at that time, but additional investigation helps determine its cause and reproducibility.
		 */
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			if(url==null || url.isBlank())
			{
				System.out.println("URL is broken");
				continue;
			}
			
			try {
				HttpURLConnection connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
				
				connection.setRequestMethod("GET");
				int responseCode = connection.getResponseCode();
				
				 if (responseCode == 200) {
		                System.out.println(url + " : OK");
		            } else if (responseCode == 404) {
		                System.out.println(url + " : Not Found");
		            } else if (responseCode == 403) {
		                System.out.println(url + " : Forbidden");
		            } else if (responseCode == 500) {
		                System.out.println(url + " : Internal Server Error");
		            } else {
		                System.out.println(url + " : Status " + responseCode);
		            }
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/*
	 * Q4. Fix a common exception
Hard

Consider this code:
String href = "/contact";

URL url = new URI(href).toURL();

HttpURLConnection connection =
    (HttpURLConnection) url.openConnection();


When you execute it, an exception occurs because the URL is relative.

Tasks:
1. Explain why the code fails.
2. Use driver.getCurrentUrl() to obtain the current page URL.
3. Modify the code to convert "/contact" into an absolute URL.
4. Explain the difference between relative and absolute URLs.
	 */
	
	public void ques_04()
	{
		/*
		 * 1. You are already using URI and toURL() in the given code. 
		 * The problem is that "/contact" is a relative URI. 
		 * It does not contain a scheme such as https or http and a host name, 
		 * so it cannot be converted directly into an absolute URL using toURL().
		 * 
		 * 
		 * 2. code
		 * 3. don't know
		 * 
		 * 3. Understand how resolve() works
Suppose the current browser URL is:
https://example.com/products


Your relative path is:
/contact


This statement:
URI absoluteUri = URI.create(currentUrl).resolve(href);


produces:
https://example.com/contact


Because the relative path begins with /, it resolves from the root of the host rather than from the /products path.

One important detail: if the current URL is https://example.com/products/, resolving "contact" without the leading slash would produce https://example.com/products/contact. 
The exact result depends on the base URL and relative reference


		 * 4. don't know
		 * 
		 * 1. Absolute URL
An absolute URL specifies the complete address of a resource, including the scheme and host.

Example:
https://example.com/contact


- https — scheme (protocol)
- example.com — host (domain)
- /contact — resource path
Key point: An absolute URL identifies the destination without needing the current page URL as its base.
2. Relative URL
A relative URL specifies a path or reference that is resolved against a base URL.

Example:
/contact


If the current page URL is:
https://example.com/products


Then resolving /contact against that base URL produces:
https://example.com/contact


Key point: A relative URL requires a base URL to determine its destination.

3. Quick comparison
Feature	Absolute URL	Relative URL
Complete destination	Yes	No
Requires a base URL	No	Yes
Example	https://example.com/contact	/contact
Common use	Linking to a specific full address	Linking within a website

Selenium interview tip: When checking links using HttpURLConnection, a relative href such as /contact must first be resolved against an appropriate base URL, 
such as the current page URL obtained through driver.getCurrentUrl().
		 */
		
		String href = "/contact";
		
		String currentURL = driver.getCurrentUrl();
		
		URI base = URI.create(currentURL);
		URI Absolute = base.resolve(href);
		
		

		
		try {
			HttpURLConnection connection =
			    (HttpURLConnection) URI.create(href).toURL().openConnection();
			
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			
			URL url = Absolute.toURL();

			System.out.println(url);
			System.out.println(responseCode);
			

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Q5. Handle blank links and exceptions
Hard

Your webpage contains several links. Some have valid URLs, some have blank href attributes, and some cause exceptions during HTTP validation.

Code given:
for (WebElement link :
        driver.findElements(By.tagName("a"))) {

    String href = link.getAttribute("href");

    URL url = new URI(href).toURL();

    HttpURLConnection connection =
        (HttpURLConnection) url.openConnection();

    int code = connection.getResponseCode();

    if (code == 404) {
        System.out.println("Broken: " + href);
    }
}


Tasks:
1. Identify at least three issues in this code.
2. Modify it to skip blank URLs and handle exceptions without terminating the entire loop.
3. Add a connection timeout of 5 seconds.
4. Explain why one failed URL should not prevent the remaining links from being checked.
	 */
	
	public void ques_05()
	{
		/*
		 * 1.
		 * 
		 * Hint 1

What happens if href is null or contains only whitespace? Think about new URI(href).

Hint 2

What happens if one URL throws an exception? Will the loop continue to the next link?

Hint 3

What happens if a server takes a very long time to respond? Is there a timeout?

Other issues you can consider:
1. Null or blank href: The code does not validate href before creating the URI.
2. Exception handling: There is no try-catch, so an exception can terminate the method and stop the remaining links from being checked.
3. No connection timeout: A connection attempt can take too long without an explicitly configured timeout.
4. Relative URLs: A relative URL such as /contact cannot be converted directly to an absolute URL using toURL().

Answer 4: Each url is an independent.
If one is failed, then it should not impact verification of other links
		 * 
		 */
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			if(url ==null || url.isBlank())
			{
				System.out.println("Broken Link");
				continue;
			}
			
			try {
				HttpURLConnection connection = (HttpURLConnection) URI.create(url).toURL().openConnection();
				
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
	            connection.setReadTimeout(5000);

	            int code = connection.getResponseCode();
				

	            if (code == 404) {
	                System.out.println("Broken: " + url);
	            }

	            connection.disconnect();
	            
	            
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

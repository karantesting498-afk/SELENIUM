// this class contain knowledge regarding broken link handler
package Selenium.revision.date_17_Oct;

public class Broken_Link_Handler_Step1 {
	
	/*
	 * 1. What is a broken link?
A link is generally considered broken when its destination cannot be accessed as expected.

Examples:
- A link returns 404 Not Found.
- A destination returns 500 Internal Server Error.
- A URL points to a non-existent resource.
- A link returns a redirect that eventually leads to an unavailable page.
Important: A link is not necessarily broken just because it returns a status code other than 200. For example, 301 and 302 are redirect responses, and 401 or 403 may indicate authentication or permission restrictions.
	 */
	
	/*
	 * 2. How does Selenium detect broken links?
Selenium does not provide a dedicated isBrokenLink() method.

A common approach is:
1. Use Selenium to find all anchor elements.
2. Extract each link's href attribute.
3. Send an HTTP request to the URL.
4. Read the HTTP response status code.
5. Report links that meet your broken-link criteria.
Find links using Selenium
Extract and validate href

Send HTTP request
Evaluate HTTP response
	 */
	
	
	/*
	 * 3. Java example using Selenium and HttpURLConnection
This example uses Selenium to collect links and Java's HttpURLConnection to check their HTTP responses.
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com");

            List<WebElement> links =
                driver.findElements(By.tagName("a"));

            for (WebElement link : links) {

                String url = link.getAttribute("href");

                if (url == null || url.isBlank()) {
                    System.out.println("Missing href");
                    continue;
                }

                HttpURLConnection connection = null;

                try {
                    connection = (HttpURLConnection)
                        URI.create(url).toURL().openConnection();

                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setInstanceFollowRedirects(true);

                    int statusCode = connection.getResponseCode();

                    if (statusCode >= 400) {
                        System.out.println(
                            "Potentially broken: " + url
                            + " | Status: " + statusCode
                        );
                    } else {
                        System.out.println(
                            "Response: " + url
                            + " | Status: " + statusCode
                        );
                    }

                } catch (Exception e) {
                    System.out.println(
                        "Unable to validate: " + url
                        + " | Reason: " + e.getMessage()
                    );
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        } finally {
            driver.quit();
        }
    }
}


This is a basic learning example, not a complete production checker. For a production test, restrict checks to approved HTTP/HTTPS URLs, handle redirects and authentication deliberately, and distinguish connection failures from HTTP error responses.
	 */
	
	
	/*
	 * 4. Important methods explained
Method											Purpose
findElements(By.tagName("a"))					Finds anchor elements on the page
getAttribute("href")							Retrieves the destination URL
setRequestMethod("GET")							Requests the resource using GET
setConnectTimeout()								Limits time spent establishing a connection
setReadTimeout()								Limits waiting for response data
getResponseCode()								Returns the HTTP status code
disconnect()									Releases the HTTP connection
	 */
	
	
	/*
	 * 5. GET vs HEAD requests
You may see examples that use:
connection.setRequestMethod("HEAD");


A HEAD request asks for response headers without the response body. It can be faster, but some servers do not support it correctly or return a different response than they would for GET.

For more reliable checks:
- Try HEAD if the target server supports it.
- Use GET when HEAD is unsupported or unsuitable.
- Do not assume every failed HEAD request proves the link is broken.
	 * 
	 * 
	 */
	
	/*
	 * 6. Common edge cases
- Missing href: An anchor may not have a destination.
- mailto: and tel: links: These are not ordinary HTTP URLs.
- JavaScript links: javascript: URLs should not be checked as HTTP resources.
- Authentication: A 401 or 403 response may require a logged-in session or permissions.
- Redirects: Check the final destination where appropriate.
- Network failures: DNS, proxy, TLS, or timeout errors are not HTTP status codes.
- Rate limiting: Checking many URLs quickly can trigger 429 Too Many Requests.
- Dynamic pages: Links may appear after scrolling or waiting for content to load.
	 */
	
	/*
	 * 7. Common interview questions
Q1. Why use HTTP requests instead of clicking every link?
HTTP checks are generally faster and can inspect response status codes directly; clicking is needed for navigation and UI behavior.Hide answer
Q2. Does status code 403 mean the link is broken?
Not necessarily. It may be a valid resource restricted by authentication or permissions.Hide answer
Q3. Why might HEAD report an error while GET succeeds?
The server may not support HEAD correctly or may handle HEAD and GET differently.Hide answer

Interview takeaway: Selenium collects the links; Java HTTP APIs check their responses. The key is to classify the result correctly rather than treating every non-200 response as a broken link.
	 */

}

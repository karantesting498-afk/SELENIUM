// This class contains knowledge regarding the cookies
package Selenium.revision.date_16_oct;

public class Cookies_Step1 {
	
	/*
	 * 
	 * 1. What is a cookie?
A cookie is a small piece of data stored by the browser for a website. The server can use cookies to identify a session or remember information across requests.

For example, after a successful login, a website may store a session cookie so the user does not need to log in again on every page.

Common uses:
- Session management
- Authentication and login sessions
- User preferences
- Shopping cart persistence
- Analytics and tracking
	 */
	
	/*
	 * 2. Selenium cookie methods
Selenium WebDriver provides cookie methods through driver.manage().getCookies() and related APIs.
Method										Purpose
getCookies()								Retrieves all cookies available for the current browser context and domain
getCookieNamed("name")						Retrieves a cookie by name
addCookie(cookie)							Adds a cookie
deleteCookie(cookie)						Deletes a specified cookie
deleteCookieNamed("name")					Deletes a cookie by name
deleteAllCookies()							Deletes all cookies accessible in the current context
	 */
	
	/*
	 * 3. Get all cookies
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieHandling {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com");

            for (Cookie cookie : driver.manage().getCookies()) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("Path: " + cookie.getPath());
                System.out.println("Expiry: " + cookie.getExpiry());
                System.out.println("Secure: " + cookie.isSecure());
                System.out.println("HttpOnly: " + cookie.isHttpOnly());
                System.out.println("--------------------");
            }
        } finally {
            driver.quit();
        }
    }
}


Important: Navigate to the target domain before reading or adding cookies. Cookies are domain-scoped, and Selenium generally requires the current browsing context to be compatible with the cookie's domain.

Avoid printing real authentication cookie values in logs because they may contain sensitive session credentials.
	 */

	
	/*
	 * 4. Get a specific cookie
Cookie cookie =
    driver.manage().getCookieNamed("sessionId");

if (cookie != null) {
    System.out.println(cookie.getName());
}


If the cookie does not exist, getCookieNamed() returns null.
	 */
	
	/*
	 * 5. Add a cookie
Selenium's Cookie.Builder allows you to create a cookie with specific attributes.
import org.openqa.selenium.Cookie;

Cookie cookie = new Cookie.Builder(
        "testCookie", "selenium123")
    .path("/")
    .isSecure(true)
    .build();

driver.manage().addCookie(cookie);


Then verify it:
Cookie added =
    driver.manage().getCookieNamed("testCookie");

if (added != null) {
    System.out.println("Cookie added successfully");
}


The cookie must be compatible with the current website's domain and browser security rules. A Secure cookie is intended to be sent over secure connections.
When is adding a cookie useful?
For example, a test may create an authenticated session using an approved test cookie rather than executing the entire login flow in every test. This only works if the application accepts that cookie and the session is valid.
	 */
	
	
	/*
	 * 6. Delete cookies
A. Delete a specific cookie by name
driver.manage().deleteCookieNamed("testCookie");


B. Delete a cookie object
Cookie cookie =
    driver.manage().getCookieNamed("testCookie");

if (cookie != null) {
    driver.manage().deleteCookie(cookie);
}


C. Delete all accessible cookies
driver.manage().deleteAllCookies();


This is useful for testing logout, session expiration, and clean test setup.

Important: Deleting browser cookies does not necessarily log the user out everywhere. The server-side session might remain valid, and authentication may also rely on local storage, session storage, or other mechanisms.
	 */
	
	/*
	 * 7. Cookie attributes you should know
Attribute	Meaning
Name	Cookie identifier
Value	Data stored in the cookie
Domain	Host or domain associated with the cookie
Path	URL path for which the cookie is applicable
Expiry	Expiration date, if the cookie has one
Secure	Cookie is intended for HTTPS connections
HttpOnly	Prevents ordinary page JavaScript from reading the cookie
SameSite	Controls cross-site cookie sending behavior
A cookie without an explicit expiry is generally a session cookie, although the browser determines session behavior.
Interview distinction: HttpOnly
An HttpOnly cookie cannot ordinarily be accessed using page JavaScript such as document.cookie. However, Selenium's WebDriver cookie API may still expose it. Do not confuse JavaScript restrictions with WebDriver capabilities.
	 */
	
	/*
	 * 
	 * 8. Common real-world scenarios
Scenario A: Test whether a session cookie exists
Cookie sessionCookie =
    driver.manage().getCookieNamed("sessionId");

assert sessionCookie != null;


This checks that the cookie exists, but does not prove the session is authenticated or valid. A server request or protected-page check may be needed.
Scenario B: Test session behavior after deleting cookies
driver.manage().deleteAllCookies();

driver.navigate().refresh();


Afterward, verify the application's actual behavior. It may redirect to login, display an access error, or restore the session through another mechanism.
Scenario C: Reuse a cookie for test setup
1. Navigate to the correct domain.
2. Obtain a valid cookie from an authorized test setup.
3. Add the cookie to the browser.
4. Refresh or navigate to the protected page.
5. Verify the authenticated state.
Do not reuse production session cookies or expose credentials in test reports.
	 */
	
	/*
	 * 9. Common mistakes
1. Adding cookies before opening the target website.
2. Trying to add a cookie for an unrelated domain.
3. Assuming a cookie's existence means the user is logged in.
4. Forgetting to refresh or navigate after changing cookies.
5. Assuming deleteAllCookies() clears local storage and session storage.
6. Printing session tokens in logs.
7. Assuming every cookie has an expiry date.
8. Assuming JavaScript can read HttpOnly cookies.
	 */
	
	/*
	 * 10. Difficult interview questions
Q1. Cookie added, but login fails
You add a session cookie using Selenium, but the application redirects to login. Explain the possible causes involving domain, path, expiry, Secure, server-side session validity, and other authentication state.In your answer, cover Selenium APIs, browser security rules, and how you would verify the behavior.
Hide hint
Q2. HttpOnly cookie
A session cookie is marked HttpOnly. JavaScript cannot read it through document.cookie, but Selenium's getCookieNamed() returns it. Explain why these observations are not contradictory.In your answer, cover Selenium APIs, browser security rules, and how you would verify the behavior.
Hide hint
Q3. Logout and session persistence
You call deleteAllCookies(), refresh the page, and the user remains logged in. Explain possible reasons and design a test to determine whether authentication is restored from another storage mechanism or server-side state.In your answer, cover Selenium APIs, browser security rules, and how you would verify the behavior.
Hide hint

Interview takeaway: Be comfortable with getCookies(), getCookieNamed(), addCookie(), deleteCookieNamed(), and deleteAllCookies(). Understand domain restrictions, HttpOnly, session validity, and the difference between cookies and browser storage.
	 */
	
	
}



/*
 * Section C – Advanced (3 Questions)
Q8. Output Prediction – Reference Type vs Actual Object
(Advanced) Upcasting, Overriding, Method Visibility

Predict the exact output and explain every line.
abstract class Browser {

    Browser() {
        System.out.println("Browser Constructor");
    }

    abstract void launch();

    void close() {
        System.out.println("Browser Closed");
    }
}

interface Screenshot {

    void capture();
}

class Chrome extends Browser implements Screenshot {

    Chrome() {
        System.out.println("Chrome Constructor");
    }

    @Override
    void launch() {
        System.out.println("Chrome Launched");
    }

    @Override
    public void capture() {
        System.out.println("Chrome Screenshot Captured");
    }

    void chromeSettings() {
        System.out.println("Chrome Settings");
    }
}

public class Main {

    public static void main(String[] args) {

        Browser browser = new Chrome();

        browser.launch();
        browser.close();

        // browser.capture();
        // browser.chromeSettings();

        Screenshot screenshot = new Chrome();

        screenshot.capture();
    }
}

Tasks:
1. Write the exact output.
2. Why does the Chrome constructor execute after the Browser constructor?
3. Why can launch() execute even though the reference type is Browser?
4. Why can't capture() be called through the Browser reference?
5. Why can't chromeSettings() be called through the Browser reference?
6. Explain the difference between the two reference types used in this program.
7. How many Chrome objects are created?
 */
package RahulShettyAcademy.date_2026_11_07;

public class Q8_Step8_Parent {
	
	
	/*
	 * 1. Output:
	 * Browser Constructor
	 * Chrome Constructor
	 * Chrome Launched
	 * Browser Closed
	 * Browser Constructor
	 * Chrome Constructor
	 * Chrome Screenshot Captured
	 * 
	 * Browser Constructor        -> new Chrome() runs the parent constructor first (implicit super())
Chrome Constructor         -> then Chrome's own constructor body
Chrome Launched            -> launch() is overridden, so Chrome's version runs
Browser Closed             -> Chrome doesn't override close(), so Browser's version runs
Browser Constructor        -> second new Chrome(): a brand new object, parent constructor again
Chrome Constructor         -> Chrome constructor again
Chrome Screenshot Captured -> capture() through the Screenshot reference runs Chrome's version


	 * 
	 * 
	 * 2. Because browser is parent class of chrome. When chrome constructor is called, first jVM checks for parent class,
	 * if parent class exist, then it is passed to the parent class constructor.
	 * 
	 * Chrome’s constructor starts with an implicit super(), so Browser’s constructor finishes first.
	 * 
	 * 
	 * 
	 * 3. Becuase child class have override that method.
	 * 
	 * 4. Because browser class do not have capture method.
	 * 
	 * 5. Because browser class do not have chromeSettings method.
	 * 
	 * 6. Browser browser = new Chrome();=> reference type is browser and reference object is chrome.
	 * browser variable can only access browser class methods and variables.
	 * 
	 * it can only see capture(), not launch(), close() or chromeSettings(). Also “reference object” should be “actual object”.
	 * 
	 * 
	 * 
	 *  Screenshot screenshot = new Chrome(); ==> reference type is screenshot and reference object is chrome.
	 *  
	 *  
	 *  7. 2 objects
	 *  
	 * 
	 */

}

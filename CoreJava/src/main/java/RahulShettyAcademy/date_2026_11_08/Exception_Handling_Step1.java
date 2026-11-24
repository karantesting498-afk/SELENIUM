// This class contains knowledge regarding the exception handling
package RahulShettyAcademy.date_2026_11_08;

public class Exception_Handling_Step1 {
/*
 * Part 1 – Exception Handling
1. What is an Exception?
An exception is an unexpected event that occurs during program execution and interrupts the normal flow of the program.

Consider:
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println(result);
        System.out.println("Program completed");
    }
}


This program attempts to divide an integer by zero.

Output:
Exception in thread "main" java.lang.ArithmeticException: / by zero


The program terminates before executing the remaining statements.

Problem: An unexpected situation interrupted the normal execution of the program.

We use exception handling to manage such situations.

Handling the exception
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        try {

            int result = a / b;
            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program completed");
    }
}


Output:
Cannot divide by zero
Program completed


Now the exception is handled, and the remaining program continues executing.
 */
	
	/*
	 * 2. Exception Hierarchy in Java
Java provides a built-in hierarchy for handling errors and exceptions.
Object


Throwable


Error

Serious JVM or system problems
- OutOfMemoryError
- StackOverflowError



Exception

Conditions applications may handle
- IOException
- RuntimeException




RuntimeException (Unchecked Exceptions)
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException
- ClassCastException

A. Error
An Error represents a serious problem that applications generally should not attempt to recover from.

Examples:

OutOfMemoryError

Occurs when the JVM cannot allocate the required memory.

StackOverflowError

Usually occurs when recursive method calls continue without reaching a terminating condition.

Example:

public class Main {

    static void display() {
        display();
    }

    public static void main(String[] args) {
        display();
    }
}


The method keeps calling itself until the call stack is exhausted.

B. Exception
An Exception represents a condition that an application may be able to handle.

Exceptions are divided into two major categories:
1. Checked Exceptions.
2. Unchecked Exceptions.
	 */
	
	
	/*
	 * 3. Checked vs Unchecked Exceptions
This is one of the most frequently asked Java interview questions.
A. Checked Exceptions
Checked exceptions are checked by the compiler.

The compiler requires you to either:
- Handle the exception using try-catch, or
- Declare it using throws.
Examples:


Exception	Typical reason
IOException	Input/output operation failure
FileNotFoundException	Requested file cannot be found
SQLException	Database operation failure
ClassNotFoundException	Required class cannot be located
InterruptedException	Thread is interrupted while waiting


Example:
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {

            FileReader reader = new FileReader("data.txt");

        } catch (IOException e) {

            System.out.println("File operation failed");
        }
    }
}


If you remove the try-catch without declaring the exception using throws, compilation will fail.


B. Unchecked Exceptions
Unchecked exceptions are not checked by the compiler.

They generally occur because of programming mistakes or invalid runtime conditions.

Examples:


Exception	Typical reason
ArithmeticException	Division by zero
NullPointerException	Accessing a member through null
ArrayIndexOutOfBoundsException	Accessing an invalid array index
NumberFormatException	Invalid numeric conversion
IllegalArgumentException	Invalid method argument
ClassCastException	Invalid object type conversion

Example:


public static void main(String[] args) {

        String value = "ABC";

        int number = Integer.parseInt(value);

        System.out.println(number);
    }
}


This compiles successfully but throws NumberFormatException at runtime.

Comparison
Checked Exception	Unchecked Exception
Checked by compiler	Not checked by compiler
Must catch or declare	Catching or declaring is optional
Usually external or recoverable conditions	Often programming or runtime conditions
Example: IOException	Example: NullPointerException

Interview important
Remember: RuntimeException and its subclasses are unchecked. Other subclasses of Exception are generally checked, except for Error and its hierarchy.



	 */
	
	
	/*
	 * Part 2 – try-catch
4. How Does try-catch Work?
The try block contains code that may throw an exception.

The catch block handles a matching exception.

Syntax:
try {

    // Risky code

} catch (ExceptionType e) {

    // Exception handling code
}


Example:
public class Main {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

            System.out.println("Result: " + result);

            System.out.println("Inside try block");

        } catch (ArithmeticException e) {

            System.out.println("Exception handled");
        }

        System.out.println("Outside try-catch");
    }
}


Output:
Exception handled
Outside try-catch


Why didn't "Inside try block" print?

Because when the exception occurred, the remaining statements inside the try block were skipped.

Execution moved directly to the matching catch block.


5. Multiple Catch Blocks
A single try block can have multiple catch blocks.

Example:
public class Main {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

            int result = 10 / 0;

            System.out.println(result);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index");

        } catch (ArithmeticException e) {

            System.out.println("Division by zero");

        } catch (Exception e) {

            System.out.println("General exception");
        }
    }
}


Output:
Invalid array index


The first exception interrupts the try block, so the division operation never executes.

Important rule: Catch order
Always place more specific exceptions before more general exceptions.

Correct:
try {

    // Code

} catch (ArithmeticException e) {

    // Specific exception

} catch (Exception e) {

    // General exception
}


Incorrect:
try {

    // Code

} catch (Exception e) {

    // General exception

} catch (ArithmeticException e) {

    // Compilation error: unreachable catch block
}


Why?

Exception already catches ArithmeticException, so the second catch block becomes unreachable.


6. Multi-Catch
Java 7 introduced multi-catch.

It allows multiple unrelated exception types to be handled by one catch block.

Example:
try {

    int[] numbers = {10, 20};

    System.out.println(numbers[5]);

} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid calculation or array access");
}


Use multi-catch when different exceptions require the same handling logic.

You cannot combine exception types that are related through inheritance in a way that makes one a subtype of another.
	 */
	
	
	/*
	 * Part 3 – finally Block
7. What is finally?
The finally block is used to execute cleanup code after a try-catch structure.

It generally executes whether an exception occurs or not.

Example without an exception:
public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

        } catch (Exception e) {

            System.out.println("Inside catch");

        } finally {

            System.out.println("Inside finally");
        }
    }
}


Output:
Inside try
Inside finally


Example with an exception:
public class Main {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Exception handled");

        } finally {

            System.out.println("Finally executed");
        }
    }
}


Output:
Exception handled
Finally executed


Why is finally useful?
It is commonly used for cleanup operations such as:
- Closing files.
- Releasing resources.
- Closing database connections.
- Cleaning up temporary resources.
For resources that implement AutoCloseable, Java also provides try-with-resources, which we will briefly cover later.


8. Does finally Always Execute?
No. It executes in normal control-flow situations, but there are exceptions.

Examples where it may not execute:
- JVM crashes.
- Operating system forcibly terminates the process.
- System.exit() terminates the JVM before finally executes.
Example:
public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

            System.exit(0);

        } finally {

            System.out.println("Inside finally");
        }
    }
}


Output:
Inside try

Important interview trap: return inside finally
Consider:
public class Main {

    static int display() {

        try {
            return 10;

        } finally {
            return 20;
        }
    }

    public static void main(String[] args) {

        System.out.println(display());
    }
}

Output:
20

The return statement inside finally overrides the earlier return value.

Avoid returning from a finally block. It can hide exceptions and produce confusing behaviour.


	 */

	/*
	 * Part 4 – throw vs throws
9. What is throw?
The throw keyword is used to explicitly throw an exception.

Example:
public class Main {

    static void validateAge(int age) {

        if (age < 18) {

            throw new IllegalArgumentException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        validateAge(15);
    }
}

Output:
Exception in thread "main" java.lang.IllegalArgumentException:
Age must be 18 or above

Here, we explicitly created and threw an exception when the age was invalid.

10. What is throws?
The throws keyword is used in a method declaration to indicate that the method may pass an exception to its caller.

Example:
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void readFile() throws IOException {

        FileReader reader = new FileReader("data.txt");
    }

    public static void main(String[] args) {

        try {

            readFile();

        } catch (IOException e) {

            System.out.println("Unable to read file");
        }
    }
}

Here:
- readFile() declares that it may throw IOException.
- main() handles the exception.

Difference between throw and throws

| throw | throws |
|--------|--------|
| Used to explicitly throw an exception | Used to declare possible exceptions |
| Used inside a method or block | Used in method signature |
| Followed by an exception object | Followed by exception class names |
| Throws one exception object at a time | Can declare multiple exception types |

Example:
throw new ArithmeticException("Invalid calculation");

void readFile() throws IOException {
    // File operation
}

(Interview important)

throws does not handle an exception. It transfers the responsibility to the calling method.


	 */
	
	/*
	 * Part 5 – Custom Exceptions
11. What is a Custom Exception?
Java provides many predefined exceptions, but sometimes application requirements need a specific exception type.

For example:
- Invalid employee age.
- Insufficient bank balance.
- Invalid account status.
- Invalid test configuration.
We can create our own exception class.
A. Creating a Checked Custom Exception
Extend the Exception class.
class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {

        super(message);
    }
}

Use it:
public class Main {

    static void validateAge(int age) throws InvalidAgeException {

        if (age < 18) {

            throw new InvalidAgeException("Age must be 18 or above");
        }

        System.out.println("Age is valid");
    }

    public static void main(String[] args) {

        try {

            validateAge(15);

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());
        }
    }
}

Output:
Age must be 18 or above


B. Creating an Unchecked Custom Exception
Extend RuntimeException.
class InvalidSalaryException extends RuntimeException {

    InvalidSalaryException(String message) {

        super(message);
    }
}

Use it:
public class Main {

    static void validateSalary(double salary) {

        if (salary <= 0) {

            throw new InvalidSalaryException("Salary must be positive");
        }

        System.out.println("Valid salary");
    }

    public static void main(String[] args) {

        validateSalary(-5000);
    }
}

Checked vs Unchecked Custom Exception
Checked Custom Exception	Unchecked Custom Exception
Extends Exception	Extends RuntimeException
Must be caught or declared	No mandatory catch or declaration
Useful when caller is expected to handle a recoverable condition


What is super(message) doing?
The parent exception class has a constructor that accepts a message.
super(message);

It passes the message to the parent class so it can be retrieved using:
e.getMessage();

	 */

/*
 * Part 6 – Exception Propagation
12. What is Exception Propagation?
Exception propagation means an exception travels up the method call stack until a matching handler is found.

Consider:
public class Main {

    static void method3() {

        int result = 10 / 0;
    }

    static void method2() {

        method3();
    }

    static void method1() {

        method2();
    }

    public static void main(String[] args) {

        try {

            method1();

        } catch (ArithmeticException e) {

            System.out.println("Exception handled in main");
        }
    }
}

Output:
Exception handled in main

Execution flow:

main()

Calls method1()

method1()

Calls method2()

method2()

Calls method3()

method3()

ArithmeticException occurs

Exception travels back up

main() catch block

Exception handled

The exception travels from method3() to method2(), then method1(), and finally reaches main().
Important
For unchecked exceptions, propagation can happen without declaring throws.

For checked exceptions, each method must handle the exception or declare it appropriately.


 */
	
	/*
	 * Part 7 – Common Java Exceptions
13. Important Exceptions You Should Recognize
Exception	Example
ArithmeticException	10 / 0
NullPointerException	Calling a method on null
ArrayIndexOutOfBoundsException	Accessing an invalid array index
StringIndexOutOfBoundsException	Invalid String index
NumberFormatException	Integer.parseInt("ABC")
ClassCastException	Invalid downcasting
IllegalArgumentException	Passing an invalid argument
NoSuchElementException	Requesting an unavailable element from certain iterators or scanners


Example of NullPointerException:
String name = null;

System.out.println(name.length());

Example of NumberFormatException:
String value = "ABC";

int number = Integer.parseInt(value);

Example of ArrayIndexOutOfBoundsException:
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);

You should understand why each exception occurs rather than simply memorizing names.

	 */

	/*
	 * Part 8 – Selenium Exception Handling
14. Common Selenium Exceptions
In Selenium automation, exceptions frequently occur because of browser state, page loading, locators, and element interactions.

These are especially important for automation interviews.
Selenium Exception	When it occurs
NoSuchElementException	Element cannot be located
StaleElementReferenceException	Previously located element is no longer attached to the current DOM
TimeoutException	Explicit wait condition is not satisfied within the timeout
ElementNotInteractableException	Element is present but cannot be interacted with
ElementClickInterceptedException	Another element prevents the click
NoSuchWindowException	Requested browser window or tab is unavailable
NoSuchFrameException	Requested frame is unavailable
InvalidSelectorException	Locator syntax is invalid
WebDriverException	General WebDriver-related failure


Example 1: NoSuchElementException
try {

    driver.findElement(By.id("invalidId")).click();

} catch (NoSuchElementException e) {

    System.out.println("Element not found");
}

Example 2: TimeoutException
try {

    WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.id("username")
        )
    );

} catch (TimeoutException e) {

    System.out.println("Username field was not visible within timeout");
}

Example 3: StaleElementReferenceException
A common situation:
1. Locate an element.
2. Page updates or DOM changes.
3. Use the old WebElement reference.
4. Selenium throws StaleElementReferenceException.
Example:
try {

    WebElement button = driver.findElement(By.id("submit"));

    driver.navigate().refresh();

    button.click();

} catch (StaleElementReferenceException e) {

    System.out.println("Element reference became stale");
}

The correct approach is usually to locate the element again after the DOM changes, rather than repeatedly catching and ignoring the exception.
Best Practices for Selenium Exception Handling
1. Catch specific exceptions whenever possible.
2. Do not use empty catch blocks.
3. Do not hide failed test cases.
4. Capture useful logs and screenshots when appropriate.
5. Use explicit waits to handle synchronization.
6. Retry only when the situation is genuinely transient and the retry is controlled.
7. Do not catch Exception everywhere without a clear reason.
Important: Catching a Selenium exception and printing a message does not automatically make a failed test pass. The test should still report the failure appropriately.



	 */
	
	/*
	 * Part 9 – try-with-resources
15. What is try-with-resources?
Java 7 introduced try-with-resources.

It automatically closes resources that implement AutoCloseable when the try block finishes.

This is useful for files, database resources, and streams.

Traditional approach:
FileReader reader = null;

try {

    reader = new FileReader("data.txt");

} catch (IOException e) {

    System.out.println("File error");

} finally {

    try {

        if (reader != null) {
            reader.close();
        }

    } catch (IOException e) {

        System.out.println("Unable to close file");
    }
}

With try-with-resources:
try (FileReader reader = new FileReader("data.txt")) {

    System.out.println("File opened");

} catch (IOException e) {

    System.out.println("File operation failed");
}

The resource will be closed automatically when execution leaves the try block.
Important rules
- The resource must implement AutoCloseable.
- Multiple resources can be declared.
- Resources are closed automatically, including when an exception occurs.
- Resources close in reverse order of declaration when multiple resources are used.
	 */
}

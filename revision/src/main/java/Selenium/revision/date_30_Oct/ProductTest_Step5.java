/*
 * Question 5 – Advanced debugging and data-driven execution
Consider this code:
public class ProductTest {

    @DataProvider(name = "products")
    public Object[][] getProducts() {
        return new Object[][] {
            {"Laptop", 50000},
            {"Mobile", 20000},
            {"Tablet", 30000}
        };
    }

    @Test(dataProvider = "products", invocationCount = 2)
    public void verifyProduct(String name, int price) {
        System.out.println(name + " - " + price);
    }
}


Answer these:
1. How many total test invocations should TestNG execute?
2. Does invocationCount = 2 mean each data set executes twice?
3. What happens if invocationCount is changed to 3?
4. If threadPoolSize = 2 is added, what changes?
5. Explain the difference between invocationCount, threadPoolSize, and parallel = true in the context of DataProvider execution.
 */

package Selenium.revision.date_30_Oct;

public class ProductTest_Step5 {
	
	/*
	 * 1. 6 invocation
	 * 2. yes
	 * 3. each test will be executed thrice.
	 * 4. don't know
	 * 
	 * threadPoolSize = 2 allows the invocation-count execution to use a pool of two threads.

This means:
- Maximum two invocation threads can execute concurrently.
- The total number of invocations remains six.
- Thread execution order is not guaranteed.




	 * 5. don't know
	 * 
	 * This is the most important question.
Attribute	Purpose	What it controls
invocationCount	Repeats test method invocations	Number of executions
threadPoolSize	Uses a thread pool for repeated invocations	Concurrent execution capacity
parallel = true	Enables parallel DataProvider execution	Concurrent execution of data-driven invocations
	 */

}

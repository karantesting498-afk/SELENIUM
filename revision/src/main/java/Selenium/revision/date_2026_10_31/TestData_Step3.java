/*
 * Question 2 – DataProvider in a separate class
You have the following two classes:
public class TestData {

    @DataProvider(name = "userData")
    public Object[][] getUsers() {
        return new Object[][] {
            {"Karan", 25},
            {"Rahul", 30}
        };
    }
}


public class UserTest {

    @Test(dataProvider = "userData", dataProviderClass = TestData.class)
    public void verifyUser(String name, int age) {
        System.out.println(name + " " + age);
    }
}


Answer these:
1. Is this code valid as written? Explain why.
2. What modification is required in TestData?
3. What happens if the DataProvider method is private?
4. Can you reuse the same DataProvider in multiple test classes?
 */
package Selenium.revision.date_2026_10_31;

public class TestData_Step3 {

	
	/*
	 * 1. It is incorrect. method getUsers should be static method for other class to access it.
	 * 2. Make method getUsers static.
	 * 3. Class userTest will not be able to access it.
	 * 4. Yes we can resuse but dataProvider method must be public and static
	 */
}

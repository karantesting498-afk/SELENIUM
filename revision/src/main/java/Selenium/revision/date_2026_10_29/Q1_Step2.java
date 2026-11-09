/*
 * Question 1 – Class-level vs method-level enabled
Difficulty: Hard

Consider the following code:
@Test(enabled = false)
public class UserTest {

    @Test
    public void createUser() {
        System.out.println("Create User");
    }

    @Test(enabled = true)
    public void updateUser() {
        System.out.println("Update User");
    }

    @Test(enabled = false)
    public void deleteUser() {
        System.out.println("Delete User");
    }
}


Answer the following:
1. Which methods will execute?
2. Does method-level enabled = true override class-level enabled = false?
3. What will be the execution status of each method?
4. What happens if you remove enabled = true from updateUser()?
 */
package Selenium.revision.date_2026_10_29;

public class Q1_Step2 {

	
	/*
	 * 1. only updateUser will be executed
	 * 2. yes
	 * 3. createUser(), deleteUser()- skipped
	 * updateUser()- executed
	 * 4. updateUser() will also be skipped
	 */
}

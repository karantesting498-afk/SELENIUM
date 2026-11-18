// THis class contains knowledge regarding the Core Java: Control Statements and Arrays
package RahulShettyAcademy.date_2026_11_03;

public class Control_Statements_and_Arrays_Step1 {
	
	/*
	 * Topic 1: Conditional Statements
Conditional statements allow a program to make decisions based on whether a condition is true or false.
1. if statement
Executes a block only when the condition is true.
int age = 22;

if (age >= 18)
{
    System.out.println("Eligible to vote");
}


Execution:
- Java checks age >= 18.
- If true, the block executes.
- If false, Java skips the block.
	 */
	
	
	/*
	 * 2. if-else statement
Use this when there are two possible execution paths.
int number = 7;

if (number % 2 == 0)
{
    System.out.println("Even number");
}
else
{
    System.out.println("Odd number");
}


Only one of the two blocks will execute.


	 */

	/*
	 * 3. else-if ladder
Use this when you have multiple conditions to evaluate.
int marks = 76;

if (marks >= 90)
{
    System.out.println("Grade A");
}
else if (marks >= 75)
{
    System.out.println("Grade B");
}
else if (marks >= 60)
{
    System.out.println("Grade C");
}
else
{
    System.out.println("Fail");
}


Important: Java checks conditions from top to bottom. Once a condition is true, its block executes and the remaining conditions are skipped.

For example, if marks are 95, Java will not check the second or third condition.

Interview point: Why should conditions be arranged carefully?

Because a broader condition placed before a narrower condition can prevent the narrower condition from ever being evaluated.
	 */
	
	
	/*
	 * 4. Nested if
An if statement inside another if statement is called a nested if.
String username = "admin";
String password = "12345";

if (username.equals("admin"))
{
    if (password.equals("12345"))
    {
        System.out.println("Login successful");
    }
    else
    {
        System.out.println("Invalid password");
    }
}
else
{
    System.out.println("Invalid username");
}


The inner condition is evaluated only when the outer condition is true.
	 */
	
	
	/*
	 * 5. Common mistakes
Mistake	Explanation
if (a = 10)	Assignment, not a comparison; invalid as a boolean condition in Java
if (a == 10);	Semicolon creates an empty if statement
Incorrect condition order	Can cause an earlier condition to capture cases intended for later conditions
Missing braces	Can cause unexpected control flow when multiple statements are intended
Using == for String content	Use .equals() to compare String values


Selenium application
Conditional statements are useful when validating an element's state.
WebElement loginButton = driver.findElement(By.id("login"));

if (loginButton.isDisplayed() && loginButton.isEnabled())
{
    loginButton.click();
}
else
{
    System.out.println("Login button is not available");
}


Here:
- isDisplayed() checks visibility.
- isEnabled() checks whether the element is enabled.
- The click happens only when both conditions are true.
	 */
	
	
	/*
	 * Topic 2: Switch Statements
A switch statement is useful when you need to compare one expression against multiple fixed values.
1. Traditional switch
int day = 3;

switch (day)
{
    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid day");
}


Important concepts:
- case: Defines a possible matching value.
- break: Exits the switch block.
- default: Executes when no case matches.
- Without break, execution can continue into subsequent cases. This is called fall-through.
	 */
	
	
	/*
	 * 2. Multiple cases
You can group cases when they should produce the same result.
int day = 6;

switch (day)
{
    case 1:
    case 7:
        System.out.println("Weekend");
        break;

    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
        System.out.println("Working day");
        break;

    default:
        System.out.println("Invalid day");
}

	 */
	
	
	/*
	 * 3. Modern switch expression
Java also supports switch expressions, which can return a value.
int day = 3;

String result = switch (day)
{
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Invalid day";
};

System.out.println(result);


The arrow syntax avoids traditional fall-through behavior.
	 */
	
	
	/*
	 * Interview comparison:
Traditional switch	Switch expression
Uses case:	Can use case ->
Commonly uses break	Arrow cases do not fall through
Can execute statements	Can return a value
default is optional	A switch expression must cover all possibilities, often using default
	 */
	
	/*
	 * Topic 3: Loops
Loops execute a block of code repeatedly while a condition or iteration rule allows it.
1. for loop
Best when the number of iterations is known.
for (int i = 1; i <= 5; i++)
{
    System.out.println(i);
}


Execution order:
1. Initialization: int i = 1
2. Condition: i <= 5
3. Execute loop body.
4. Update: i++
5. Check the condition again.
	 */
	
	/*
	 * 2. while loop
Best when the number of iterations is not known in advance and depends on a condition.
int i = 1;

while (i <= 5)
{
    System.out.println(i);
    i++;
}


The condition is checked before the loop body executes.
	 */
	
	/*
	 * 	The condition is checked before the loop body executes.
3. do-while loop
The body executes at least once, even if the condition is initially false.
int i = 10;

do
{
    System.out.println(i);
    i++;
}
while (i <= 5);


Output:
10

	 */


/*
 * Important interview question: What is the difference between while and do-while?
- while: Checks the condition before execution.
- do-while: Checks the condition after execution.

 */

	/*
	 * 4. Nested loops
A loop inside another loop is called a nested loop.
for (int i = 1; i <= 3; i++)
{
    for (int j = 1; j <= 3; j++)
    {
        System.out.print("* ");
    }

    System.out.println();
}


Output:
* * *
* * *
* * *


The inner loop completes all its iterations for each iteration of the outer loop.
	 */
	
	/*
	 * Topic 4: break and continue
1. break
Terminates the nearest enclosing loop or switch.
for (int i = 1; i <= 10; i++)
{
    if (i == 5)
    {
        break;
    }

    System.out.println(i);
}


Output:
1
2
3
4
	 */

	/*
	 * 2. continue
Skips the current iteration and moves to the next iteration.
for (int i = 1; i <= 5; i++)
{
    if (i == 3)
    {
        continue;
    }

    System.out.println(i);
}


Output:
1
2
4
5
	 */

	/*
	 * Difference:
break	continue
Terminates the loop	Skips current iteration
Control moves outside the loop	Control moves to the next iteration
Useful when the required result is found	Useful when an item should be skipped
	 */
	
	/*
	 * Selenium application
Suppose you want to find a particular product from a list.
List<WebElement> products =
    driver.findElements(By.cssSelector(".product"));

for (WebElement product : products)
{
    if (product.getText().contains("Laptop"))
    {
        System.out.println("Product found");
        break;
    }
}


Once the product is found, there is no need to continue checking the remaining products.
	 */
	
	
	/*
	 * Topic 5: Arrays
An array stores multiple values of the same data type in a single variable.
1. Array declaration
int[] numbers;


This declares an array reference.

2. Array initialization
int[] numbers = {10, 20, 30, 40, 50};


You can also create an array with a fixed size:
int[] numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;




	 */
	
	/*
	 * 3. Array indexing
Array indexing starts from zero.
Example: int[] numbers = {10, 20, 30, 40, 50};
10

Index 0


20

Index 1


30

Index 2


40

Index 3


50

Index 4



First index = 0; last index = length - 1.

System.out.println(numbers[0]); // 10
System.out.println(numbers[4]); // 50
System.out.println(numbers.length); // 5


Accessing numbers[5] will throw ArrayIndexOutOfBoundsException
	 */
	
	/*
	 * 4. Iterating through an array
Traditional for loop:
int[] numbers = {10, 20, 30, 40};

for (int i = 0; i < numbers.length; i++)
{
    System.out.println(numbers[i]);
}


Use this when you need the index.

Enhanced for loop:
for (int number : numbers)
{
    System.out.println(number);
}


Use this when you only need the values and do not need to manage the index.

	 */
	
	/*
	 * 5. Default values
When an array is created using new, Java assigns default values.
Data type	Default value
int	0
double	0.0
boolean	false
char	'\u0000'
Object references, including String	null
	 */
	
	/*
	 * Topic 6: Two-Dimensional Arrays
A 2D array stores data in rows and columns.
1. Declaration and initialization
int[][] matrix =
{
    {10, 20, 30},
    {40, 50, 60},
    {70, 80, 90}
};


Matrix representation
10

[0][0]


20

[0][1]


30

[0][2]


40

[1][0]


50

[1][1]


60

[1][2]


70

[2][0]


80

[2][1]


90

[2][2]




System.out.println(matrix[0][0]); // 10
System.out.println(matrix[1][2]); // 60
System.out.println(matrix[2][1]); // 80
	 */
	
	
	/*
	 * 2. Iterating through a 2D array
Use nested loops.
for (int i = 0; i < matrix.length; i++)
{
    for (int j = 0; j < matrix[i].length; j++)
    {
        System.out.print(matrix[i][j] + " ");
    }

    System.out.println();
}

Here:
- matrix.length gives the number of rows.
- matrix[i].length gives the number of columns in row i.
	 *
	 *
	 */
	
	/*
	 * 3. Jagged arrays
Java supports arrays where each row has a different length.
int[][] numbers = new int[3][];

numbers[0] = new int[2];
numbers[1] = new int[3];
numbers[2] = new int[4];


This is called a jagged array.


	 */
	
}


/*
 * THis class contains knowledge regarding arrays in java.
 */

package RahulShettyAcademy.date_2026_11_09;

public class Arrays_Step1 {

	/*
	 * 1. What is an Array?
An array is an object in Java that stores multiple values under a single variable name.

All elements in an array must be compatible with the same declared element type.

For example, suppose you want to store five employee IDs.

Without an array:
int employee1 = 101;
int employee2 = 102;
int employee3 = 103;
int employee4 = 104;
int employee5 = 105;


With an array:
int[] employeeIds = {101, 102, 103, 104, 105};


Instead of maintaining five separate variables, we maintain one array.

Important characteristics:
- Stores multiple elements.
- Uses indexes to access elements.
- Indexing starts from 0.
- Has a fixed length after creation.
- Can store primitive values or object references.
- Arrays are objects in Java, even when they store primitive values.


2. Why do we need Arrays?
Consider a real testing scenario.

You need to test login functionality with 100 usernames.

Without arrays, you would need to declare 100 separate variables.

With arrays:
String[] usernames = {
    "admin",
    "manager",
    "employee",
    "supervisor"
};


You can process all usernames using a loop.

Arrays help us:
- Reduce repetitive code.
- Store related information together.
- Process multiple values efficiently.
- Pass multiple values to methods.
- Work with test data.


3. Array Declaration
There are two valid declaration styles.
int[] numbers;


Or:
int numbers[];


Both are valid, but the first is preferred.

Why?

Because it clearly indicates that numbers is an array of integers.


Declaration vs initialization
Declaration:
int[] numbers;


At this stage, we have declared a reference variable but have not created an array object.

Initialization:
numbers = new int[5];


Now Java creates an array object that can store five integers.

You can combine both:
int[] numbers = new int[5];



	 */

	/*
	 * 4. How is an Array Created?
Let's understand this statement:
int[] numbers = new int[5];


Part	Meaning
int	Element data type
[]	Array declaration
numbers	Reference variable
new	Creates an object
int[5]	Creates an array of length 5

The array has five positions.
Array of length 5
0
Index
0


1
Index
0


2
Index
0


3
Index
0


4
Index
0



All five elements initially contain the default integer value 0.
Valid indexes are 0, 1, 2, 3, 4.


5. Array Initialization
There are three common ways to initialize an array.

Method 1 – Direct initialization
int[] numbers = {10, 20, 30, 40, 50};


Method 2 – Create first, assign values later
int[] numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;


Method 3 – Declare and create separately

int[] numbers;

numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;


Remember: the array length is fixed once the array object is created.
	 */
	
	/*
	 * 6. Accessing and Updating Array Elements
You access an element using its index.
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]);
System.out.println(numbers[2]);
System.out.println(numbers[4]);


Output:
10
30
50


Updating an element:
int[] numbers = {10, 20, 30, 40, 50};

numbers[2] = 100;

System.out.println(numbers[2]);


Output:
100


The value at index 2 is replaced. The array still has five elements.


	 */
	
	/*
	 * 7. Default Values in Arrays
When you create an array using new, Java automatically initializes its elements with default values.
Data type	Default value
byte	0
short	0
int	0
long	0L
float	0.0f
double	0.0
char	'\u0000'
boolean	false
Object references	null

Example:
int[] numbers = new int[3];

System.out.println(numbers[0]);
System.out.println(numbers[1]);
System.out.println(numbers[2]);


Output:
0
0
0


String array:
String[] names = new String[3];

System.out.println(names[0]);


Output:
null


Interview question: Do local variables also receive default values?

No. Local variables must be initialized before they are used. Array elements receive default values automatically.
	 */
	
	/*
	 * 8. Finding Array Length
Use the length property.
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);


Output:
5


Important difference:
Type	Syntax
Array	numbers.length
String	name.length()

Array length is a property, not a method.
	 */
	
	
	/*
	 * 9. Iterating Through Arrays
Iteration means accessing array elements one by one.
A. Normal for loop
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}


How does it work?
1. i = 0: Start from the first index.
2. i < numbers.length: Continue while the index is valid.
3. numbers[i]: Access the current element.
4. i++: Move to the next index.
B. Enhanced for loop
Also called the for-each loop.
int[] numbers = {10, 20, 30, 40, 50};

for (int number : numbers) {
    System.out.println(number);
}


Here, Java automatically takes each element and assigns it to number.

Difference between normal and enhanced for loop:
Normal for loop	Enhanced for loop
Uses an index	No index required
Can access a specific position	Reads elements sequentially
Can update elements using index	Assigning to loop variable does not update array elements
Can traverse backward	Traverses forward
Useful when index matters	Useful for reading all elements

Example of an important trap:
int[] numbers = {10, 20, 30};

for (int number : numbers) {
    number = 100;
}

System.out.println(numbers[0]);


Output:
10


Why? Because number is a separate local variable holding a copy of the current primitive value.
C. While loop
int[] numbers = {10, 20, 30};

int i = 0;

while (i < numbers.length) {
    System.out.println(numbers[i]);
    i++;
}


All three approaches are valid.
	 */
	
	/*
	 * 10. ArrayIndexOutOfBoundsException
This is one of the most common array exceptions.
int[] numbers = {10, 20, 30};

System.out.println(numbers[3]);


The array contains three elements.

Valid indexes:
- 0
- 1
- 2
Index 3 does not exist.

Java throws:
ArrayIndexOutOfBoundsException


Remember:

For an array of length n, valid indexes range from 0 to n - 1.

Incorrect loop:
for (int i = 0; i <= numbers.length; i++) {
    System.out.println(numbers[i]);
}


Correct loop:
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
	 */

	/*
	 * 11. Basic Array Programming Operations
These are important because they build the logic needed for array-based interview questions.
A. Calculate the sum
int[] numbers = {10, 20, 30, 40, 50};

int sum = 0;

for (int i = 0; i < numbers.length; i++) {
    sum = sum + numbers[i];
}

System.out.println("Sum: " + sum);


Output:
Sum: 150


B. Calculate the average
int[] marks = {70, 80, 90, 60, 100};

int sum = 0;

for (int mark : marks) {
    sum += mark;
}

double average = (double) sum / marks.length;

System.out.println(average);


Output:
80.0


Why use (double)?

Without type casting, integer division would discard the decimal portion.
C. Find maximum value
int[] numbers = {10, 50, 20, 90, 30};

int max = numbers[0];

for (int i = 1; i < numbers.length; i++) {

    if (numbers[i] > max) {
        max = numbers[i];
    }
}

System.out.println(max);


Output:
90


Why initialize max with numbers[0] instead of zero?

Consider:
int[] numbers = {-10, -50, -20};


If max starts at zero, the answer would incorrectly remain zero.
D. Find minimum value
int[] numbers = {10, 50, 20, 90, 30};

int min = numbers[0];

for (int i = 1; i < numbers.length; i++) {

    if (numbers[i] < min) {
        min = numbers[i];
    }
}

System.out.println(min);


Output:
10


E. Count even and odd numbers
int[] numbers = {10, 15, 20, 25, 30};

int evenCount = 0;
int oddCount = 0;

for (int number : numbers) {

    if (number % 2 == 0) {
        evenCount++;
    } else {
        oddCount++;
    }
}

System.out.println("Even: " + evenCount);
System.out.println("Odd: " + oddCount);


Output:
Even: 3
Odd: 2


F. Copy elements manually
int[] original = {10, 20, 30};

int[] copy = new int[original.length];

for (int i = 0; i < original.length; i++) {
    copy[i] = original[i];
}


Now original and copy refer to different array objects.
	 */
	
	/*
	 * 12. One-Dimensional Array vs Two-Dimensional Array
One-dimensional array
Stores elements in a single sequence.
int[] marks = {70, 80, 90, 60};


One-dimensional array
70

[0]


80

[1]


90

[2]


60

[3]




Two-dimensional array
Stores elements in rows and columns.
int[][] marks = {
    {70, 80, 90},
    {60, 75, 85},
    {90, 95, 80}
};


Two-dimensional array
Row	Column 0	Column 1	Column 2
0	70	80	90
1	60	75	85
2	90	95	80


Access elements:
System.out.println(marks[0][0]); // 70
System.out.println(marks[1][2]); // 85
System.out.println(marks[2][1]); // 95


The first index represents the row; the second represents the column.


Iterating through a 2D array
We use nested loops.
int[][] marks = {
    {70, 80, 90},
    {60, 75, 85},
    {90, 95, 80}
};

for (int i = 0; i < marks.length; i++) {

    for (int j = 0; j < marks[i].length; j++) {

        System.out.print(marks[i][j] + " ");
    }

    System.out.println();
}


Output:
70 80 90
60 75 85
90 95 80


Understand these two expressions:
- marks.length = number of rows.
- marks[i].length = number of elements in the current row.
	 */
	
	/*
	 * 13. Jagged Arrays
A jagged array is a two-dimensional array in which each row can have a different length.
int[][] numbers = {
    {10, 20},
    {30, 40, 50},
    {60}
};


Here:
Row	Number of elements
Row 0	2
Row 1	3
Row 2	1

Java supports this because each row is itself an individual array.

You can also create it step by step:
int[][] numbers = new int[3][];

numbers[0] = new int[2];
numbers[1] = new int[3];
numbers[2] = new int[1];
	 */
	
	/*
	 * 14. Arrays and Memory References
This is an important interview concept.

Consider:
int[] a = {10, 20, 30};

int[] b = a;

b[0] = 100;

System.out.println(a[0]);
System.out.println(b[0]);


Output:
100
100


Why?

Because a and b refer to the same array object.

Assigning one array reference to another does not create a separate array.
Both references point to one object
a


b



Same array object
100

[0]


20

[1]


30

[2]






Creating a separate array using clone()
int[] a = {10, 20, 30};

int[] b = a.clone();

b[0] = 100;

System.out.println(a[0]);
System.out.println(b[0]);


Output:
10
100


clone() creates a separate array object.

Important: For a two-dimensional array, clone() performs a shallow copy. The outer array is copied, but its inner arrays are still shared.
	 */
	
	/*
	 * 15. Comparing Arrays
Consider:
int[] a = {10, 20, 30};
int[] b = {10, 20, 30};

System.out.println(a == b);


Output:
false


Why? Because they are two different array objects.

For comparing contents, use:
import java.util.Arrays;

System.out.println(Arrays.equals(a, b));


Output:
true


For nested arrays, use Arrays.deepEquals() to compare nested contents.

	 */
	
	/*
	 * 16. Important Arrays Utility Class
Java provides a utility class called Arrays.

Import it:
import java.util.Arrays;


Some useful methods:
Method	Purpose
Arrays.toString()	Displays a one-dimensional array
Arrays.deepToString()	Displays nested array contents
Arrays.equals()	Compares one-dimensional array contents
Arrays.deepEquals()	Compares nested array contents
Arrays.copyOf()	Copies an array to a specified length
Arrays.fill()	Fills an array with a value
Arrays.sort()	Sorts an array
Arrays.binarySearch()	Searches a sorted array

Examples:

Print an array
int[] numbers = {30, 10, 20};

System.out.println(Arrays.toString(numbers));


Output:
[30, 10, 20]


Copy an array
int[] original = {10, 20, 30};

int[] copy = Arrays.copyOf(original, 5);

System.out.println(Arrays.toString(copy));


Output:
[10, 20, 30, 0, 0]


Fill an array
int[] numbers = new int[5];

Arrays.fill(numbers, 100);

System.out.println(Arrays.toString(numbers));


Output:
[100, 100, 100, 100, 100]


We'll study sort() and binarySearch() in detail on Day 9.
	 */

	/*
	 * 17. Passing Arrays to Methods
Arrays can be passed as method arguments.
public class ArrayExample {

    public static void printNumbers(int[] numbers) {

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {

        int[] values = {10, 20, 30};

        printNumbers(values);
    }
}


This is useful when you want to reuse array-processing logic.
Can a method modify an array?
Yes.
public class ArrayExample {

    public static void updateArray(int[] numbers) {
        numbers[0] = 100;
    }

    public static void main(String[] args) {

        int[] values = {10, 20, 30};

        updateArray(values);

        System.out.println(values[0]);
    }
}


Output:
100


Java passes the reference value by value. The method receives a copy of the reference, but both references point to the same array object.

18. Returning an Array from a Method
A method can also return an array.
public class ArrayExample {

    public static int[] getNumbers() {

        int[] numbers = {10, 20, 30};

        return numbers;
    }

    public static void main(String[] args) {

        int[] result = getNumbers();

        System.out.println(Arrays.toString(result));
    }
}


Output:
[10, 20, 30]


The array object remains accessible through the returned reference.



	 */
	
	
	/*
	 * 19. Arrays in Selenium Automation
Arrays can be useful for storing multiple test values.

Example: Login test data.
String[] usernames = {
    "admin",
    "manager",
    "employee"
};

for (String username : usernames) {

    System.out.println("Testing login: " + username);
}


Example: Expected page titles.
String[] expectedTitles = {
    "Dashboard",
    "Employee",
    "Attendance"
};

for (String title : expectedTitles) {

    System.out.println("Expected title: " + title);
}


One important Selenium distinction:
List<WebElement> elements = driver.findElements(By.tagName("input"));


findElements() returns a List<WebElement>, not an array. Lists belong to the Collections module, which comes later in our roadmap.
	 */
	
	/*
	 * 20. Common Array Interview Questions
Question	Answer
Is an array an object?	Yes
Can an array store different primitive types?	No
Can array size change after creation?	No
What is the first index?	0
What is the last index?	length - 1
What is the default value of an int array?	0
What is the default value of a String array?	null
What happens on an invalid index?	ArrayIndexOutOfBoundsException
What is a jagged array?	An array whose rows can have different lengths
What does a = b do for arrays?	Copies the reference
What does clone() do?	Creates a shallow copy
What does Arrays.equals() do?	Compares array contents
Can arrays be passed to methods?	Yes
Can methods return arrays?	Yes


21. Important Interview Traps
Try to predict these outputs before reading the answers.

Example 1 – Default values
int[] a = new int[3];

System.out.println(a[0] + a[1] + a[2]);


Output: 0

Example 2 – Array reference
int[] a = {1, 2, 3};
int[] b = a;

b[1] = 50;

System.out.println(a[1]);


Output: 50

Example 3 – Enhanced for loop
int[] a = {1, 2, 3};

for (int n : a) {
    n = n * 2;
}

System.out.println(Arrays.toString(a));


Output: [1, 2, 3]


Example 4 – Array length
int[] a = {10, 20, 30};

System.out.println(a[a.length - 1]);


Output: 30

Example 5 – Two-dimensional array
int[][] a = {
    {1, 2},
    {3, 4, 5}
};

System.out.println(a.length);
System.out.println(a[1].length);


Output: 2 and 3


	 */
}

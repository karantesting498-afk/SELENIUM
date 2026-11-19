// This class contains knowledge regarding the string
package RahulShettyAcademy.date_2026_11_04;

public class String_Step1 {
	
	/*
	 * 1. What is a String in Java?
A String is a sequence of characters.

For example:
"Hello"
"Java"
"Karan"
"Welcome to Selenium"
"12345"

Each of these is a String.

A String can contain:
- Alphabets: "Java"
- Numbers: "12345"
- Special characters: "@#$"
- Spaces: "Hello World"
- A combination of all of them: "Java@123"
In Java, String is a predefined class, not a primitive data type.

Compare:
int age = 25;
double salary = 45000.50;
char grade = 'A';

String name = "Karan";


| Data type | Type | Example |
|--------|--------|--------|
| int | Primitive | `25` |
| double | Primitive | `45000.50` |
| char | Primitive | `'A'` |
| String | Non-primitive (class) | `"Karan"` |


Important: char stores a single character using single quotes, whereas String stores a sequence of characters using double quotes.
char letter = 'A';

String word = "Apple";


----------------------------------------------------------------------------------
	 */

	/*
	 * Why is String a class?
Because Java provides String with built-in methods to manipulate and work with text.

For example:
String name = "Karan";

System.out.println(name.length());
System.out.println(name.toUpperCase());
System.out.println(name.toLowerCase());

Output:
5
KARAN
karan

You can use these methods because String is a class.



	 */
	
	/*
	 * 2. How to create a String in Java
There are two commonly used ways.
Method 1: Using String literal
String s1 = "Java";
String s2 = "Selenium";

This is the most common approach.

When you create a String literal, Java checks the String Pool before creating a new pooled String object.

We'll understand the String Pool shortly.

Method 2: Using the new keyword
String s1 = new String("Java");
String s2 = new String("Java");

Here, Java explicitly creates a new String object on the heap for each new expression.

Even though the text is the same, these are separate objects.

Important difference:
String s1 = "Java";
String s2 = "Java";

String s3 = new String("Java");
String s4 = new String("Java");

- s1 and s2 refer to the same pooled String object.
- s3 and s4 refer to two different heap objects.
- The literal "Java" used in the new expressions can refer to the pooled object as well.
We'll use this example again when studying == and equals().

	 */

	/*
	 * 3. String Pool – How Java stores Strings
This is one of the most important String concepts for interviews.

Java maintains a special area called the String Pool, which is part of the heap.

Its purpose is to reuse String literals instead of creating duplicate pooled objects unnecessarily.

Consider:
String s1 = "Java";
String s2 = "Java";
String s3 = "Java";

What happens?

Conceptual memory representation

(String Pool)

"Java"

One pooled String object

(s1)

(s2)

(s3)

All three references point to the same pooled object.

Java reuses the pooled String object because the literal value is identical.


Now consider:
String s1 = new String("Java");
String s2 = new String("Java");

Conceptual memory representation

(String Pool)

"Java" (pooled object)

(Heap objects)

"Java"

Object 1

"Java"

Object 2

Each new String() creates a separate heap object. The literal may also be pooled.
	 */
	
	/*
	 * What is intern()?
Java provides the intern() method to get the canonical pooled representation of a String.

The intern() method returns the canonical representation of a string from a shared memory cache called the String Pool. Instead of keeping multiple duplicate string objects in memory, it ensures that identical text values point to the exact same memory address. 

Wikipedia
 +3
How It Works
When you call intern() on a string (most commonly in Java via String.intern(), though similar concepts exist in C# and Python), the runtime performs two steps: 

Microsoft Learn
 +2
Checks the pool. It searches the String Constant Pool to see if an identical string value already exists. 

Medium
·Gaddam.Naveen
 +1
Returns or adds the reference. If a match is found, it returns the memory reference to that existing pooled string. If no match exists, it adds the string to the pool and returns the new reference. 





Example:
String s1 = new String("Java");
String s2 = s1.intern();

System.out.println(s1 == s2);

Output:
false

Why?
- s1 refers to the explicitly created heap object.
- s2 refers to the pooled String object.
Interview point: String Pool helps save memory by reusing identical String literals.


	 */
	
	
	/*
	 * 4. Difference between == and equals()
This is a very important interview question.
== operator
It compares references when used with objects.

It checks whether two references point to the same object.
equals() method
The String class overrides equals() to compare the actual content of two Strings.

Let's understand with code.
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));

Output:
true
true

Both references point to the same pooled object, and their contents are equal.

Now:
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));

Output:
false
true

Why?
- == returns false because they are different objects.
- equals() returns true because their contents are the same.

| Comparison | What it checks |
|--------|--------|
| `==` | Reference identity |
| `equals()` | String content |
| `equalsIgnoreCase()` | Content, ignoring letter case |


Example:
String s1 = "JAVA";
String s2 = "java";

System.out.println(s1.equals(s2));
System.out.println(s1.equalsIgnoreCase(s2));

Output:
false
true


Selenium practical example
Suppose you retrieve a product name from a web page:
String actualProduct = driver.findElement(
    By.cssSelector(".product-name")
).getText();

String expectedProduct = "ZARA COAT 3";

if (actualProduct.equals(expectedProduct)) {
    System.out.println("Product matched");
}

Here, you want to compare the text content, not whether both variables point to the same object.

Rule: When comparing String values, generally use equals() or equalsIgnoreCase(), not ==.
	 */
	
	
	/*
	 * 5. String Immutability
This is probably the most important concept before learning StringBuilder.

First understand the word immutable.

Immutable means the original object cannot be changed after it is created.

String objects in Java are immutable.

Let's understand.
String s1 = "Java";

s1.concat(" Selenium");

System.out.println(s1);

Output:
Java

You might expect:

You might expect:
Java Selenium

But that doesn't happen.

Why?

Because concat() does not modify the original String. It returns a new String containing the combined text.


Because concat() does not modify the original String. It returns a new String containing the combined text.

Correct approach:
String s1 = "Java";

s1 = s1.concat(" Selenium");

System.out.println(s1);

Output:
Java Selenium


What happens internally?

Original object
"Java"

Cannot be modified

concat(" Selenium")

New object
"Java Selenium"

After assignment, s1 refers to the new String. The old object remains unchanged until it becomes eligible for garbage collection.



More examples
String name = "Karan";

name.toUpperCase();

System.out.println(name);

Output:
Karan

Correct:
name = name.toUpperCase();

System.out.println(name);

Output:
KARAN

Why is String immutable?
Some important reasons:
1. Security: Strings are commonly used for file paths, URLs, class names and other sensitive values. Immutability prevents their content from being unexpectedly changed.
2. String Pool: Reusing immutable objects is safe because one reference cannot change the content for all other references.
3. Thread safety: Multiple threads can safely read the same String without worrying that another thread will modify its content.
4. Hashing: A String's content-based hash code remains consistent while the String is used as a key in collections such as HashMap.
Interview question: Can we change the value of a String variable?

Yes. We can reassign the reference to another String, but we cannot modify the existing String object.

Example:
String s = "Java";
s = "Python";

This does not modify "Java". It makes s refer to "Python".


	 */

	/*
	 * 6. Important String methods
Now let's learn the methods you'll frequently use in Java coding and Selenium automation.

We'll use this String for most examples:
String text = "  Hello Java World  ";

6.1 length()
Returns the number of characters, including spaces.
String name = "Karan";

System.out.println(name.length());

Output:
5

Remember: length() is a method for String, but length is a property for arrays.


String s = "Java";
System.out.println(s.length());

int[] numbers = {10, 20, 30};
System.out.println(numbers.length);



6.2 charAt(index)
Returns the character at a particular index.

String indexing starts from zero.
String name = "Java";

System.out.println(name.charAt(0));
System.out.println(name.charAt(1));
System.out.println(name.charAt(3));

Output:
J
a
a

(Important) Accessing an invalid index causes StringIndexOutOfBoundsException.
String s = "Java";
System.out.println(s.charAt(4)); // Exception

Valid indexes are 0 to length() - 1.


6.3 toUpperCase() and toLowerCase()
String s = "Java Selenium";

System.out.println(s.toUpperCase());
System.out.println(s.toLowerCase());

Output:
JAVA SELENIUM
java selenium

These return new Strings. They do not modify the original String.


6.4 trim() and strip()
Both are used to remove leading and trailing whitespace.
String s = "   Java   ";

System.out.println(s.trim());
System.out.println(s.strip());

Output:
Java
Java

Difference:
- trim() removes characters with code points up to U+0020.
- strip() uses Java's Unicode-aware whitespace definition.
strip() was introduced in Java 11.

Neither removes spaces from the middle:
String s = "  Hello Java  ";

System.out.println(s.trim());

Output:
Hello Java


6.5 contains()
Checks whether a String contains a particular sequence of characters.

Returns boolean.
String s = "Welcome to Selenium";

System.out.println(s.contains("Selenium"));
System.out.println(s.contains("Java"));

Output:
true
false


6.6 startsWith() and endsWith()
String url = "https://www.amazon.in";

System.out.println(url.startsWith("https"));
System.out.println(url.endsWith(".in"));

Output:
true
true

These methods are case-sensitive.


6.7 equals() and equalsIgnoreCase()
String s1 = "Java";
String s2 = "java";

System.out.println(s1.equals(s2));
System.out.println(s1.equalsIgnoreCase(s2));

Output:
false
true


6.8 substring()
Extracts a portion of a String.

There are two common forms.

Form 1: substring(beginIndex)

Returns characters from the given index until the end.
String s = "Selenium";

System.out.println(s.substring(4));

Output:
nium


Form 2: substring(beginIndex, endIndex)

Returns characters from the starting index up to, but excluding, the ending index.
String s = "Selenium";

System.out.println(s.substring(0, 4));

Output:
Sele


(Interview point) The start index is included, but the end index is excluded.


6.9 indexOf() and lastIndexOf()
indexOf() returns the first occurrence of a character or substring.

lastIndexOf() returns the last occurrence.
String s = "Java Programming";

System.out.println(s.indexOf('a'));
System.out.println(s.lastIndexOf('a'));
System.out.println(s.indexOf("Program"));

Output:
1
3
5

If the character or substring is not found, the result is -1.


6.10 replace() and replaceAll()
String s = "Java is easy";

System.out.println(s.replace("easy", "powerful"));

Output:
Java is powerful

replaceAll() uses regular expressions.
String phone = "987-654-3210";

System.out.println(phone.replaceAll("-", ""));

Output:
9876543210


Difference:
| Method | Purpose |
|--------|--------|
| `replace()` | Replaces literal characters or character sequences |
| `replaceAll()` | Replaces matches of a regular expression |
| `replaceFirst()` | Replaces only the first regex match |


6.11 split()
Splits a String into an array of Strings based on a delimiter or regular expression.
String data = "Java,Python,Selenium";

String[] result = data.split(",");

for (String value : result) {
    System.out.println(value);
}

Output:
Java
Python
Selenium

This method is especially useful when processing CSV-like text.

Remember that split() returns a String[]. We will study arrays separately on Day 4.


6.12 isEmpty() and isBlank()
String s1 = "";
String s2 = "   ";

System.out.println(s1.isEmpty());
System.out.println(s2.isEmpty());

System.out.println(s2.isBlank());

Output:
true
false
true

Difference:
- isEmpty() checks whether the length is zero.
- isBlank() checks whether the String is empty or contains only whitespace.
isBlank() was introduced in Java 11.


6.13 concat()
Combines two Strings and returns a new String.
String first = "Hello";
String second = " Java";

String result = first.concat(second);

System.out.println(result);

Output:
Hello Java


6.14 valueOf()
Converts different data types into their String representation.
int number = 100;
double price = 99.50;
boolean status = true;

String s1 = String.valueOf(number);
String s2 = String.valueOf(price);
String s3 = String.valueOf(status);

System.out.println(s1);
System.out.println(s2);
System.out.println(s3);

Output:
100
99.5
true


6.15 compareTo()
Compares two Strings lexicographically (based on character values).
String s1 = "Apple";
String s2 = "Banana";

System.out.println(s1.compareTo(s2));
System.out.println(s1.compareTo("Apple"));
System.out.println("Banana".compareTo("Apple"));

Output:
-1
0
1

The important rule is:
- Negative result: first String comes before the second.
- Zero: both Strings are equal.
- Positive result: first String comes after the second.
Do not depend on the exact negative or positive number; focus on its sign.


	 */
	
	/*
	 * 7. StringBuilder – Understanding it from zero
Now we come to an important question:

If String is immutable, how do we modify text repeatedly without creating a new String object for every change?

Java provides StringBuilder.

StringBuilder is a mutable sequence of characters.

Mutable means its existing content can be modified.
Example using String
String s = "Java";

s = s + " Selenium";
s = s + " Automation";
s = s + " Testing";

System.out.println(s);

Output:
Java Selenium Automation Testing

Each concatenation produces a new String. The variable s is reassigned to the new result.

Same example using StringBuilder
StringBuilder sb = new StringBuilder("Java");

sb.append(" Selenium");
sb.append(" Automation");
sb.append(" Testing");

System.out.println(sb);

Output:
Java Selenium Automation Testing

Here, StringBuilder modifies its existing character sequence instead of creating a new String object for every append operation


Conceptual difference

String

(Immutable)

"Java" → new "Java Selenium" → new "Java Selenium Testing"

StringBuilder

(Mutable)

One builder → append → append → updated content

Conceptual illustration; StringBuilder may internally resize its character storage when required.



	 */

	/*
	 * 7.1 Creating StringBuilder
StringBuilder sb1 = new StringBuilder();

StringBuilder sb2 = new StringBuilder("Java");

StringBuilder sb3 = new StringBuilder(50);

- new StringBuilder() creates an empty builder with default capacity (16).
- new StringBuilder("Java") creates a builder initialized with that text.
- new StringBuilder(50) creates an empty builder with an initial capacity of 50.


	 */

	/*
	 * 7.2 Important StringBuilder methods
1. append() – Add content at the end
StringBuilder sb = new StringBuilder("Java");

sb.append(" Selenium");

System.out.println(sb);

Output:
Java Selenium




2. insert() – Insert content at a particular index
StringBuilder sb = new StringBuilder("Java");

sb.insert(4, " Selenium");

System.out.println(sb);

Output:
Java Selenium


3. replace() – Replace a portion
StringBuilder sb = new StringBuilder("Java Testing");

sb.replace(5, 12, "Coding");

System.out.println(sb);

Output:
Java Coding

The ending index is excluded.


4. delete() – Delete a portion
StringBuilder sb = new StringBuilder("Java Selenium");

sb.delete(4, 13);

System.out.println(sb);

Output:
Java


5. deleteCharAt() – Delete one character
StringBuilder sb = new StringBuilder("Java");

sb.deleteCharAt(1);

System.out.println(sb);

Output:
Jva



6. reverse() – Reverse the content
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb);

Output:
avaJ


7. charAt() – Read a character
StringBuilder sb = new StringBuilder("Java");

System.out.println(sb.charAt(2));

Output:
v


8. setCharAt() – Change a character
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'K');

System.out.println(sb);

Output:
Kava

Notice that this modifies the existing builder.

9. length() and capacity()
StringBuilder sb = new StringBuilder("Java");

System.out.println(sb.length());
System.out.println(sb.capacity());

Output:
4
20

Why is capacity 20?

The default capacity is 16. When initialized with "Java" (length 4), the initial capacity becomes:

\[
16 + 4 = 20
\]
- length() = number of characters currently stored.
- capacity() = amount of character storage available before resizing is needed.




10. toString() – Convert StringBuilder into String
StringBuilder sb = new StringBuilder("Java");

String result = sb.toString();

System.out.println(result);

Output:
Java

This is useful when a method or API requires a String instead of StringBuilder.



	 */
	
	
	/*
	 * 8. StringBuffer – What is it?
StringBuffer is also a mutable sequence of characters, just like StringBuilder.

The major difference is synchronization.
- StringBuilder is not synchronized.
- StringBuffer is synchronized.
In simple terms, StringBuffer's methods are designed to coordinate access when multiple threads use the same buffer.
Example
StringBuffer sb = new StringBuffer("Java");

sb.append(" Selenium");
sb.append(" Testing");

System.out.println(sb);

Output:
Java Selenium Testing

It provides methods similar to StringBuilder:
- append()
- insert()
- replace()
- delete()
- reverse()
- charAt()
- setCharAt()
- length()
- capacity()
Why do we need StringBuffer?
Imagine multiple threads are trying to modify the same shared text buffer.

StringBuffer synchronizes its methods, which helps prevent conflicting simultaneous method operations on that shared object.

However, synchronization does not automatically make an entire sequence of multiple operations atomic.

For normal single-threaded String manipulation, StringBuilder is generally the preferred choice.



9. String vs StringBuilder vs StringBuffer
This is a very common Java interview question.

| Feature | String | StringBuilder | StringBuffer |
|--------|--------|--------|--------|
| Mutable? | No | Yes | Yes |
| Thread-safe? | Safe to share immutable content | Not synchronized | Synchronized methods |
| Modification | Creates new String result | Modifies builder | Modifies buffer |
| Performance for repeated modification | Often less efficient | Generally faster | Synchronization adds overhead |
| Introduced | Java 1.0 | Java 1.5 | Java 1.0 |




When should you use each?
Use String when:

Storing names, URLs, messages or product names.
Comparing text.
Working with text that doesn't need repeated modification.

Use StringBuilder when:
- Concatenating many values in a loop.
- Building dynamic messages.
- Reversing or modifying text.
- Working in normal single-threaded code.

Use StringBuffer when:
- Multiple threads share and modify the same buffer.
- You specifically need synchronized buffer methods.

Practical example: Selenium
Suppose you are collecting product names from multiple web elements and building a report message.
StringBuilder report = new StringBuilder();

for (WebElement product : products) {

    String productName = product.getText();

    report.append(productName);
    report.append("\n");
}

System.out.println(report);

This is a practical use of StringBuilder because you're repeatedly adding text.

This is a practical use of StringBuilder because you're repeatedly adding text.



	 */
	
	/*
	 * 10. Important String concepts for interviews
	 * 
	 * 10.1 String concatenation using +
You can combine Strings using the + operator.
String firstName = "Karan";
String lastName = "Kumar";

String fullName = firstName + " " + lastName;

System.out.println(fullName);

Output:
Karan Kumar

You can also combine a String with a number:
int age = 25;

String result = "Age: " + age;

System.out.println(result);

Output:
Age: 25

Important: Once one operand in a + expression is a String, Java performs String concatenation for
 the remaining expression from left to right.


Compare:
System.out.println(10 + 20 + "Java");
System.out.println("Java" + 10 + 20);
System.out.println("Java" + (10 + 20));

Output:
30Java
Java1020
Java30

Why?
- First: 10 + 20 is calculated as integer addition.
- Second: String concatenation starts immediately.
- Third: parentheses force the addition to happen first.


10.2 String and null
A String reference can hold null.
String name = null;

System.out.println(name);

Output:
null

But calling a method on a null reference causes NullPointerException.
String name = null;

System.out.println(name.length()); // NullPointerException

This is different from an empty String:
String s1 = "";
String s2 = null;


| Value | Meaning |
|--------|--------|
| `""` | String object with zero characters |
| `" "` | String containing one space |
| `null` | Reference does not point to a String object |

This distinction is important when validating web elements, API responses and test data.



	 */


	/*
	 * 10.3 String formatting
Java provides String.format() to create formatted Strings.
String name = "Karan";
int age = 25;

String result = String.format(
    "Name: %s, Age: %d",
    name,
    age
);

System.out.println(result);

Output:
Name: Karan, Age: 25

Common format specifiers:


| Specifier | Used for |
|--------|--------|
| `%s` | String |
| `%d` | Integer |
| `%f` | Floating-point number |
| `%c` | Character |
| `%b` | Boolean |


10.4 String implements CharSequence
String, StringBuilder and StringBuffer all implement the CharSequence interface.

This means they provide a common way to represent a sequence of characters.

For example:
CharSequence text = "Java";

System.out.println(text.length());
System.out.println(text.charAt(0));

Output:
4
J

You can also assign a StringBuilder to a CharSequence reference:
CharSequence text = new StringBuilder("Selenium");

System.out.println(text);

Output:
Selenium

You don't need to memorize the entire interface now. Just understand that these classes share a common character-sequence abstraction.






11. Common mistakes to avoid

| Mistake | Correct understanding |
|--------|--------|
| Using `==` to compare String values | Use `equals()` |
| Assuming `concat()` changes the original String | It returns a new String |
| Thinking StringBuilder is immutable | StringBuilder is mutable |
| Thinking `substring(0, 4)` includes index 4 | Ending index is excluded |
| Using `length` for String | Use `length()` |
| Using `length()` for arrays | Use `length` |
| Assuming `trim()` removes middle spaces | It only removes leading/trailing characters |
| Calling methods on null | Check for null first |
| Assuming StringBuffer makes every multi-step operation atomic | Synchronization applies to its individual synchronized methods |


12. Quick revision sheet
Remember these key points

String (Immutable)
StringBuilder (Mutable, not synchronized)
StringBuffer (Mutable, synchronized methods)
- == → compares object references.
- equals() → compares String content.
- String Pool → reuses String literals.
- intern() → returns the canonical pooled String.
- append() → adds content.
- reverse() → reverses content.
- substring() → extracts a portion.
- split() → splits into a String array.
- isEmpty() → checks zero length.
- isBlank() → checks empty or whitespace-only content.

13. What you should be able to answer after Day 3
These are the interview questions we will use to assess your understanding:
1. What is a String, and why is it a class rather than a primitive?
2. What is the difference between String literal and new String()?
3. What is the String Pool?
4. What is the difference between == and equals()?
5. Why is String immutable?
6. What happens internally when you concatenate two Strings?
7. What is the difference between concat() and append()?
8. What is the difference between StringBuilder and StringBuffer?
9. Why is StringBuilder generally preferred in loops?
10. What is the difference between length() and capacity()?
11. What is the difference between isEmpty() and isBlank()?
12. What does substring(2, 5) return?
13. What happens when you call a method on a null String?
14. What is the purpose of intern()?
15. Can we modify a String without creating a new String object?


	 */









}

// This class contains knowledge about java stream and lambda expression

package Selenium.revision.date_20_Oct;

public class JAVA_Stream_And_Lambda_Expression_Step1 {
	
	/*
	 * Java Lambda Expressions and Stream API are important concepts for automation testers because they help you write shorter,
	 *  cleaner code when working with collections of web elements, filtering test data, validating dropdowns, and processing test results.

We'll learn these concepts from the basics, then apply them to Selenium examples.

=================================================================================================
	 */
	
	// Part 1: Lambda Expressions in Java
	
	/*
	 * 1. What is a Lambda Expression?
A lambda expression is a concise way to implement a functional interface without writing a separate class or an anonymous inner class.

Let's understand this with an example.

Suppose you have a list of names and want to print each name.
Traditional approach
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Karan", "Aman", "Rahul");

        for (String name : names) {
            System.out.println(name);
        }
    }
}


Using a Lambda Expression

names.forEach(name -> System.out.println(name));

Output:
Karan
Aman
Rahul


Here:
name -> System.out.println(name)

is the lambda expression.

===========================================================================================

	 */

	
	/*
	 * 
	 * Lambda syntax
(parameters) -> expression

Or:
(parameters) -> {
    // multiple statements
}


Examples:
x -> x * 2

(a, b) -> a + b

name -> {
    System.out.println(name);
    System.out.println(name.length());
}

Remember: When the lambda body contains multiple statements, use {}. If the lambda body is a single expression, braces are optional.

=================================================================================================
	 * 
	 */
	
	
	/*
	 * 
	 * 2. Understanding Lambda Syntax
Consider:
name -> System.out.println(name)

It contains three parts:


Part														Meaning
name														Parameter
->															Lambda operator
System.out.println(name)									Body









The compiler determines the parameter type from the context in which the lambda is used.

For example:
List<String> names = Arrays.asList("Karan", "Aman");

names.forEach(name -> System.out.println(name));

Because names contains strings, Java understands that name is a String.


You can also explicitly specify the type:
names.forEach((String name) -> System.out.println(name));

Both are valid.


=========================================================================================
	 */
	
	/*
	 * 3. What is a Functional Interface?
A functional interface is an interface with exactly one abstract method.

Lambda expressions can provide an implementation of that abstract method.

Example:
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

Implementing it with a traditional anonymous class:
Calculator calculator = new Calculator() {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
};

System.out.println(calculator.add(10, 20));

Output:
30

Now implement the same interface using a lambda:

Calculator calculator = (a, b) -> a + b;

System.out.println(calculator.add(10, 20));

Output:

30


1. Functional Interface
A functional interface is an interface that has exactly one abstract method.
@FunctionalInterface
interface NumberValidator {
    boolean validate(int number);
}


- @FunctionalInterface ensures that the interface follows the single abstract method rule.
- boolean is the return type.
- validate is the method name.
- int number is the input parameter.
2. Lambda Expression
Instead of creating a separate class to implement the interface, we can use a lambda expression.
NumberValidator validator =
        number -> number > 0 && number % 2 == 0;


Component	Meaning
NumberValidator	Target functional-interface type
validator	Reference variable
number	Input parameter
->	Separates parameters from the lambda body
number > 0 && number % 2 == 0	Validation logic returning a boolean
Java infers the parameter type from the interface method, so writing int number explicitly is unnecessary.
3. How the lambda executes
System.out.println(validator.validate(10)); // true
System.out.println(validator.validate(7));  // false
System.out.println(validator.validate(0));  // false


Execution flow:
1. validate(10) passes 10 to the lambda parameter number.
2. Java evaluates the expression.
3. The expression returns true or false.
4. println() displays the result.
The lambda implements validate() because it is the interface's only abstract method.
4. What if the interface has multiple methods?
interface NumberValidator {
    boolean isEven(int number);
    boolean isPositive(int number);
}


This will not work:
NumberValidator validator = number -> number > 0;


Both methods are abstract. Java cannot use one lambda to implement both methods.

Solutions:
- Use a normal class that implements both methods.
- Create separate functional interfaces if you want to implement each operation using a lambda.
5. What about default methods?
@FunctionalInterface
interface NumberValidator {

    boolean validate(int number);

    default void display() {
        System.out.println("Validating number");
    }
}


This is valid because only validate() is abstract. A default method already has an implementation, so it does not violate the functional-interface rule.
6. Important rules to remember
- A functional interface has exactly one abstract method.
- A lambda expression supplies the implementation of that method.
- Java determines the lambda's target type from the context.
- The method's parameter type determines the lambda parameter type.
- A lambda can implement an interface with additional default methods.
- A lambda expression with an expression body can return its result implicitly.
Remember this relationship:
Interface

Declares what operation is required

Lambda expression

Provides the implementation

Method call

Executes the implementation with an input





The lambda provides the implementation of the interface's single abstract method.


=========================================================================================
	 */
	
	
	/*
	 * Important interview points
- @FunctionalInterface is optional but useful.
- A functional interface can contain multiple default and static methods.
- It must have exactly one abstract method, after accounting for methods that match public methods of Object.
- A lambda expression is not a standalone block of code that can be assigned to any variable. 
Its target type must be a compatible functional interface.



Common built-in functional interfaces

Java provides several functional interfaces in java.util.function.

Interface					Main method					Purpose												Example
Predicate<T>				test(T)						Tests a condition									x -> x > 10
Function<T, R>				apply(T)					Converts one value into another						s -> s.length()
Consumer<T>					accept(T)					Consumes a value without returning a result			x -> System.out.println(x)
Supplier<T>					get()						Supplies a value without taking an argument			() -> "Hello"


These interfaces are frequently used with streams.

==========================================================================================

	 */
	
	
	/*
	 * Part 2: Java Stream API
4. What is a Stream?
The Stream API, introduced in Java 8, lets you process a sequence of elements using operations such as 
filtering, transforming, sorting, and collecting.

For example, suppose you have these numbers:
List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

You want to find all even numbers.


Traditional approach
List<Integer> evenNumbers = new ArrayList<>();

for (Integer number : numbers) {
    if (number % 2 == 0) {
        evenNumbers.add(number);
    }
}

System.out.println(evenNumbers);

Output:
[10, 20, 30]



Using Streams
List<Integer> evenNumbers = numbers.stream()
        .filter(number -> number % 2 == 0)
        .collect(Collectors.toList());

System.out.println(evenNumbers);

Output:
[10, 20, 30]


Let's break down the stream pipeline:
numbers.stream()
       .filter(number -> number % 2 == 0)
       .collect(Collectors.toList());

1. numbers.stream() creates a stream from the list.
2. filter() retains elements that satisfy the condition.
3. collect() gathers the results into a list.
Important: A stream does not normally store the elements itself. It processes elements from a source, such as a collection.




========================================================================
	 */
	
	
	/*
	 * 5. The Three Stages of a Stream Pipeline
	 * 
A typical stream pipeline has three stages.


Stage 1: Source


The source provides the elements.

numbers.stream()


Stage 2: Intermediate operations
These transform or filter the stream.

Examples:

	.filter()
.map()
.sorted()
.distinct()
.limit()


Intermediate operations are generally lazy.
 They do not process the stream until a terminal operation triggers execution.


Stage 3: Terminal operation
A terminal operation triggers the pipeline and produces a result or side effect.

Examples:


.collect()
.forEach()
.count()
.anyMatch()
.findFirst()
.reduce()


Example:
List<Integer> numbers = Arrays.asList(5, 10, 15, 20);

numbers.stream()
       .filter(n -> n > 10)
       .forEach(System.out::println);
       
       
       
       Output:
15
20


Here, forEach() is the terminal operation.
Interview question
What happens if you create a stream pipeline but don't call a terminal operation?

The intermediate operations are not executed, so the pipeline does not process the elements.




====================================================================================================



	 */
	
	
	//Part 3: Important Stream Operations
	
	/*
	 * 6. filter() — Select elements based on a condition
filter() retains elements for which the supplied predicate returns true.

Example:
List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

numbers.stream()
       .filter(n -> n > 20)
       .forEach(System.out::println);
       
       Output:
25
30

Here:
n -> n > 20

is a lambda expression that checks each number.


Use case: Select employees whose salaries exceed a particular amount or web elements whose text matches a condition.

	=====================================================================================
	 */
	
	
	/*
	 * 7. map() — Transform each element
map() converts each element into another value.

Example: Convert names to uppercase.


List<String> names = Arrays.asList("karan", "aman", "rahul");

List<String> upperNames = names.stream()
        .map(name -> name.toUpperCase())
        .collect(Collectors.toList());

System.out.println(upperNames);


Output:
[KARAN, AMAN, RAHUL]

You can also write:
.map(String::toUpperCase)

This is called a method reference.

substring to find index position


1. substring(int beginIndex)

This extracts everything from your starting position all the way to the end of the string.
java
String text = "JavaStream";
String result = text.substring(4); 

System.out.println(result); // Output: Stream



AI Mode conversation: Is distinct in stream a terminator?


Is distinct in stream a terminator?

No, distinct() in Java Streams is not a terminal operation (terminator). It is a stateful intermediate operation.
Here is a breakdown of how it works and why:

🧩 Intermediate vs. Terminal Operations

• Intermediate Operations (like distinct(), filter(), map(), and sorted()) transform a stream into another stream. They are lazy and do not execute any processing until a terminal operation is called.
• Terminal Operations (like collect(), forEach(), count(), and reduce()) consume the stream, trigger the actual data processing, and return a final non-stream result (like a List, a number, or void).

⚖️ Why is it called "Stateful"?

Most intermediate operations (like filter()) are stateless—they evaluate each element individually without needing to know about previous elements.
In contrast, distinct() is stateful because it must remember the elements it has already processed to identify and filter out subsequent duplicates. Internally, it maintains a temporary, hash-based structure (like a LinkedHashSet for ordered streams) to track "seen" elements as the data flows through.
AI can make mistakes, so double-check responses 
• 
HowToDoInJava
Java Stream distinct(): Remove Duplicates, Keep Order
The distinct() method is a stateful intermediate operation. It remembers every element it has already passed on, and it drops a ne...
• 
Oracle Help Center
Stream (Java Platform SE 8 ) - Oracle Help Center
Returns a stream consisting of the distinct elements. For unordered streams, no stability guarantees are made. This is a stateful ...
• 
GeeksforGeeks
Stream.distinct() in Java - GeeksforGeeks
Removes duplicate elements from a stream returning a new stream with unique values using equals() and hashCode() methods. stateful...
Show all

is skip a terminator

No, skip() is not a terminal operation (terminator). It is a stateless intermediate operation.
Here is a quick look at why it falls into this category:

⏳ What skip(n) Does

• Purpose: It discards the first n elements of the stream and passes the remaining elements down the pipeline.
• Output: It returns a new Stream, allowing you to chain further operations (like filter(), map(), or a terminal operation).

🧩 Stateless vs. Stateful

Unlike distinct(), which is stateful because it needs to remember every element it has ever seen to check for duplicates, skip() is stateless (or carries negligible state). It only needs a simple counter to keep track of how many elements have passed by until it reaches n. Once n elements are skipped, it simply lets everything else pass through freely.
If you are building a specific stream pipeline, let me know what you are trying to achieve (e.g., pagination, filtering, or aggregating data). I can help you put the right intermediate and terminal operations together!

convert first index of string to upper case when array of string is provided using strea,s

To convert the first character of each string to uppercase in a Java Stream, you map over the strings and apply substring manipulation.
Here is the cleanest way to do it:
java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry", "", null};

        List<String> capitalized = Arrays.stream(array)
            // 1. Filter out nulls and empty strings to prevent errors
            .filter(s -> s != null && !s.isEmpty())
            // 2. Capitalize the first letter and append the rest
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
            .collect(Collectors.toList());

        System.out.println(capitalized); // Output: [Apple, Banana, Cherry]
    }
}
Use code with caution.

🔍 Key Elements of the Pipeline

• Arrays.stream(array): Converts your array into a sequential stream.
• .filter(...): A stateless intermediate operation that safely removes null or empty values to avoid StringIndexOutOfBoundsException.
• .map(...): A stateless intermediate operation that transforms each individual string.
• s.substring(0, 1).toUpperCase(): Grabs the very first character and converts it to uppercase.
• s.substring(1): Extracts the entire remainder of the string starting from index 1.
• .collect(Collectors.toList()): The terminal operation that packages the transformed stream back into a collection.
Quick questions if you have time:
• Did you need to modify the original array directly?Yes, modify array
No, returning a list is perfect
• How should strings with multiple words be handled?Capitalize every word
Only the very first letter
My strings are single words

explain substring

In Java, the substring() method is a built-in tool used to extract a specific part (a slice) of an existing string. It doesn't modify the original string; instead, it returns a brand-new string containing the specified section.
The method has two different forms (overloads):

1. substring(int beginIndex)

This extracts everything from your starting position all the way to the end of the string.
java
String text = "JavaStream";
String result = text.substring(4); 

System.out.println(result); // Output: Stream
Use code with caution.
Note: In programming, counting always starts at 0. So index 4 is the letter 'S'.

2. substring(int beginIndex, int endIndex)

This extracts a specific window between two indexes.
The most important rule to remember here is: The beginIndex is inclusive, but the endIndex is exclusive. It grabs everything up to, but not including, the final index.
java
String text = "JavaStream";
String result = text.substring(0, 4); 

System.out.println(result); // Output: Java





=======================================================================
	 */
	
	
	
	/*
	 * Difference between filter() and map()
	 * 
filter()													map()
Selects elements											Transforms elements
Usually retains the same element type						Can change the element type
Uses a predicate											Uses a function


Example: retain numbers greater than 10						Example: convert names to uppercase



Example:
List<String> names = Arrays.asList("Aman", "Karan", "Ravi");

names.stream()
     .filter(name -> name.length() > 4)
     .map(name -> name.toUpperCase())
     .forEach(System.out::println);

Output:
KARAN


First, filter() selects names longer than four characters. Then, map() converts those names to uppercase.
	 */
	
	
	/*
	 * 
	 * 8. sorted() — Sort elements
	 * 
	 * 
	 * Example:
List<Integer> numbers = Arrays.asList(50, 10, 40, 20, 30);

numbers.stream()
       .sorted()
       .forEach(System.out::println);

Output:
10
20
30
40
50


For descending order:
numbers.stream()
       .sorted(Comparator.reverseOrder())
       .forEach(System.out::println);
       
       
       
       Output:
50
40
30
20
10



For strings:
names.stream()
     .sorted()
     .forEach(System.out::println);

Strings are sorted according to their natural ordering, which is lexicographic and case-sensitive.


============================================================================================
	 */
	
	/*9. distinct() — Remove duplicates
	 * 
	 * 
Example:
List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 20, 40);

List<Integer> uniqueNumbers = numbers.stream()
        .distinct()
        .collect(Collectors.toList());

System.out.println(uniqueNumbers);

Output:
[10, 20, 30, 40]


distinct() uses equality to determine whether elements are duplicates. For custom objects, 
their equals() and hashCode() implementations matter.


======================================================================================================
	 * 
	 * 
	 */
	
	
	/*
	 * 10. limit() and skip()
limit()
Restricts the stream to at most the specified number of elements.
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

numbers.stream()
       .limit(3)
       .forEach(System.out::println);
       
       
       Output:
10
20
30





skip()
Skips the first specified number of elements.
numbers.stream()
       .skip(2)
       .forEach(System.out::println);

Output:
30
40
50

Interview point: With an ordered stream, skip(2) skips the first two elements in the encounter order.


Note : It only limit or skip the first (count) items.

=============================================================
	 */
	
	
	/*
	 * 
	 * 11. count(), anyMatch(), allMatch(), and noneMatch()
These are useful terminal operations for validations.
count()
Returns the number of elements in the stream.
long count = numbers.stream()
        .filter(n -> n > 20)
        .count();

System.out.println(count);

Output:
3




anyMatch()
Returns true if at least one element satisfies the condition.
boolean result = numbers.stream()
        .anyMatch(n -> n == 30);
        
 The anyMatch() method in Java returns true as soon as it finds one element that satisfies the condition.
 
 
 
        
        allMatch()
Returns true if every element satisfies the condition.
boolean result = numbers.stream()
        .allMatch(n -> n > 0);
        
        
        
        
        noneMatch()
Returns true if no element satisfies the condition.
boolean result = numbers.stream()
        .noneMatch(n -> n < 0);

These matching operations can stop processing as soon as their result is determined.

======================================================================================


	 */
	
	
	/*
	 * 12. findFirst() and findAny()
	 * 
	 * Both return an Optional<T>.

Example:
Optional<Integer> result = numbers.stream()
        .filter(n -> n > 20)
        .findFirst();

result.ifPresent(System.out::println);


OutPut:

30


Correction: Because the example uses findFirst(), it prints only the first matching value, 30.

findAny() can return any matching element.

 For a sequential stream, it often returns the first matching element, but you should not rely on that behavior.

Why Optional?
The stream might contain no matching element. Optional represents the possibility that a value may or may not be present.

Example:



Optional<Integer> result = numbers.stream()
        .filter(n -> n > 100)
        .findFirst();

if (result.isPresent()) {
    System.out.println(result.get());
} else {
    System.out.println("No matching element");
}


Output:
No matching element
====================================================================================================

	 */
	
	//Part 4: Lambda Expressions and Method References
	
	
	
	/*
	 * 13. What is a Method Reference?
A method reference is a shorter way to express a lambda that calls an existing method.

For example:
names.forEach(name -> System.out.println(name));

Can be written as:
names.forEach(System.out::println);


Another example:
names.stream()
     .map(name -> name.toUpperCase())
     .forEach(name -> System.out.println(name));
     
     
     Can be written as:
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
     
     
     Common forms of method references include:
- System.out::println — reference to an instance method of a particular object.
- String::toUpperCase — reference to an instance method of an arbitrary object of a particular type.
- Integer::parseInt — reference to a static method.
- ArrayList::new — reference to a constructor.
Remember: A method reference is not a separate replacement for every lambda. 
It is suitable when the lambda's behavior matches the referenced method's signature.
	 *
	 * ========================================================================================================
	 */
	
	
	//Part 5: collect() and Collectors
	
	/*
	 * 14. Collect a stream into a list
Example:
List<String> names = Arrays.asList("Aman", "Karan", "Rahul");

List<String> filteredNames = names.stream()
        .filter(name -> name.length() > 4)
        .collect(Collectors.toList());
        
        
        Output:
[Karan, Rahul]

For Java 16 and later, you can also use:
List<String> filteredNames = names.stream()
        .filter(name -> name.length() > 4)
        .toList();
        
        
        
        
        Important difference: Stream.toList() returns an unmodifiable list. 
        Collectors.toList() does not guarantee a particular list implementation or mutability contract.
        
        
        Collect into a Set
Set<Integer> uniqueNumbers = numbers.stream()
        .collect(Collectors.toSet());

A Set removes duplicates, but Collectors.toSet() does not guarantee a particular set implementation or iteration order.


============================================================================================
	 */
	
	
	
	//Part 6: Selenium WebDriver Examples
	
	/*
	 * Now let's apply Streams and Lambdas to real automation scenarios.
15. Example 1 — Extract all dropdown options


Suppose a dropdown contains these options:
India
Australia
Canada
India
Japan

Selenium code:


List<WebElement> options = driver.findElements(
        By.cssSelector("#country option")
);

List<String> optionTexts = options.stream()
        .map(option -> option.getText().trim())
        .collect(Collectors.toList());

System.out.println(optionTexts);

Output:
[India, Australia, Canada, India, Japan]



Here:
- findElements() returns a List<WebElement>.
- stream() creates a stream from the list.
- map() extracts and trims the visible text.
- collect() stores the text values in a list.


Remove duplicate option names
List<String> uniqueOptions = options.stream()
        .map(option -> option.getText().trim())
        .distinct()
        .collect(Collectors.toList());
        
        
        Output:
[India, Australia, Canada, Japan]
=========================================================================================================================



	 * 
	 */
	

	/*
	 * 16. Example 2 — Verify whether a dropdown contains a value
	 * 
	 * List<WebElement> options = driver.findElements(
        By.cssSelector("#country option")
);

boolean isIndiaPresent = options.stream()
        .map(option -> option.getText().trim())
        .anyMatch(text -> text.equals("India"));

System.out.println(isIndiaPresent);


Output:
true

This is useful when validating that required dropdown values are available.

If case-insensitive matching is needed:


boolean isIndiaPresent = options.stream()
        .map(option -> option.getText().trim())
        .anyMatch(text -> text.equalsIgnoreCase("india"));
        
     =========================================================================================================================
   
        
	 */
	
	
	
	
	
	/*
	 * 
	 * 17. Example 3 — Find all displayed elements
Suppose a page contains several buttons, some visible and some hidden.

List<WebElement> buttons = driver.findElements(
        By.tagName("button")
);

List<WebElement> displayedButtons = buttons.stream()
        .filter(WebElement::isDisplayed)
        .collect(Collectors.toList());

Now displayedButtons contains only the elements that Selenium reports as displayed.



To print their text:


displayedButtons.stream()
        .map(button -> button.getText().trim())
        .forEach(System.out::println);

Important: isDisplayed() checks Selenium's visibility criteria. 
It does not guarantee that an element is unobstructed, clickable, or interactable at that exact moment.


=========================================================================================================================
	 */
	
	/*
	 * 18. Example 4 — Verify whether a table contains an employee
Suppose a table contains employee names.
List<WebElement> employees = driver.findElements(
        By.cssSelector("table tbody tr td.employee-name")
);

boolean employeeExists = employees.stream()
        .map(WebElement::getText)
        .map(String::trim)
        .anyMatch(name -> name.equalsIgnoreCase("Karan"));

System.out.println(employeeExists);

Output:
true

This is useful for validating records displayed in tables.


All three methods return a primitive boolean and are terminal operations.



Interview follow-up

What is the difference between these two statements?

employees.stream().anyMatch(e -> e.getText().equals("Karan"));

employees.stream()
         .map(WebElement::getText)
         .anyMatch("Karan"::equals);

Both can check for an exact text match, but the second separates text extraction from comparison. 
The first version can also be written with equalsIgnoreCase() if the requirement is case-insensitive.

=========================================================================================================================

	 */
	
	
	/*
	 * Part 7: Important Interview Concepts
	 * 
	 * 
19. Can we reuse a stream?
No. A stream can be consumed only once.


Incorrect:
Stream<String> stream = names.stream();

stream.forEach(System.out::println);

stream.count(); // IllegalStateException

After the terminal operation, the stream has been consumed.

Correct:
names.stream().forEach(System.out::println);

long count = names.stream().count();

Create a new stream from the source for each separate pipeline.





20. What is lazy evaluation?
Intermediate operations such as filter() and map() are generally lazy.

Example:
List<Integer> numbers = Arrays.asList(10, 20, 30);

Stream<Integer> stream = numbers.stream()
        .filter(n -> {
            System.out.println("Checking: " + n);
            return n > 10;
        });
        
        
        Nothing is printed when this pipeline is created because no terminal operation has been called.
        
        
        Now add:
stream.forEach(System.out::println);

The filter runs as the terminal operation consumes the stream.


================================================================================================

	 */
	
	
	/*
	 * 21. Difference between forEach() and map()
	 * 
forEach()													map()
Terminal operation											Intermediate operation

Performs an action on elements								Transforms elements

Does not return a stream									Returns another stream

Commonly used for printing or actions						Commonly used for extracting or converting values


Example:
numbers.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);

Here, map() doubles each number, while forEach() prints the results.



==================================================================================================
	 */
	
	
	/*
	 * 22. Can we modify a collection while streaming it?
Avoid structurally modifying a collection from inside its stream pipeline.

For example, removing elements from the same ArrayList inside forEach()
 can cause ConcurrentModificationException or other undesirable behavior.
 
 
 Instead, use a filtering operation:
List<Integer> numbers = new ArrayList<>(
        Arrays.asList(10, 20, 30, 40)
);

numbers.removeIf(n -> n > 20);

System.out.println(numbers);


Output:
[10, 20]

removeIf() is a collection operation that removes elements matching the predicate.


========================================================================================
	 */
	
	/*
	 * 23. What is reduce()?
reduce() combines stream elements into a single result.

Example: Calculate the sum.
int sum = Arrays.asList(10, 20, 30, 40)
        .stream()
        .reduce(0, (a, b) -> a + b);

System.out.println(sum);

Output:
100

Here:
- 0 is the identity value.
identity value is the mathematical identity element of the accumulation function

1. The Starting Point: It acts as the initial value for the accumulator before any elements from the collection are processed.
2. The Fallback / Default: If the collection or stream is empty, the reduce function safe-returns the identity value directly.



Common Identity Elements

Choosing the correct identity depends entirely on your accumulator function:

Operation						Mathematical Function			Identity Value			Why?
Addition / Summing				(a, b) => a + b					0						0 + 5 = 5 (Zero doesn't change a sum)
Multiplication / Product		(a, b) => a * b					1						1 × 5 = 5 (One doesn't change a product)
String Concatenation			(a, b) => a + b					"" (Empty string)		"" + "hello" = "hello"
Array Flattening / List append	(a, b) => a.concat(b)			[] (Empty array)		Appending elements to an empty list yields the element.
Object Merging					(a, b) => ({...a, ...b})		{} (Empty object)		Merging keys into an empty object keeps them unchanged.

- (a, b) -> a + b combines the accumulated result with the next element.


For numeric collections, mapToInt() and sum() may be more readable:



int sum = numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
        
  ===========================================================================      
        
	 */
	
	/*
	 * 
	 * 24. What is the difference between sequential and parallel streams?
A sequential stream processes its pipeline in a sequential manner.


numbers.stream()
       .forEach(System.out::println);
       
       
       	A parallel stream can process elements concurrently using multiple threads.
numbers.parallelStream()
       .forEach(System.out::println);

With parallel streams, output order may differ from encounter order. 
Parallel processing is not automatically faster and should be used only when the workload and thread-safety requirements justify it.


Selenium interview note: Avoid using parallel streams to interact with a single WebDriver instance.

 WebDriver instances are generally not thread-safe, and concurrent operations can cause unpredictable failures.
 
 
 ===============================================================================================================
	 */
	
	
	/*
	 * Part 8: Quick Revision Table
	 * 
Concept						Purpose													Example
Lambda						Implement a functional interface concisely				x -> x * 2
Predicate					Test a condition										n -> n > 10
Function					Transform a value										s -> s.length()
Consumer					Consume a value											System.out::println
Supplier					Supply a value											() -> "Hello"
stream()					Create a sequential stream								list.stream()
filter()					Select elements											.filter(n -> n > 10)
map()						Transform elements										.map(String::toUpperCase)
sorted()					Sort elements											.sorted()
distinct()					Remove duplicates										.distinct()
limit()						Restrict the number of elements							.limit(5)
skip()						Skip initial elements									.skip(2)
count()						Count elements											.count()
anyMatch()					Check whether any element matches						.anyMatch(x -> x > 10)
collect()					Gather results											.collect(Collectors.toList())
reduce()					Combine elements into one result						.reduce(0, Integer::sum)
forEach()					Perform an action for each element						.forEach(System.out::println)

====================================================================================================================
	 */
	
	
	/*
	 * In Java Streams, .peek() is an intermediate operation used to perform an action on each element as it passes through the stream pipeline, without changing that element.

It is commonly used for debugging, such as printing values between stream operations.
1. Basic example
List<String> browsers = Arrays.asList(
    "Firefox", "Chrome", "Edge"
);

browsers.stream()
    .peek(s -> System.out.println("Before filter: " + s))
    .filter(s -> s.startsWith("C"))
    .forEach(s -> System.out.println("Result: " + s));


Output:
Before filter: Firefox
Before filter: Chrome
Result: Chrome
Before filter: Edge


How does it work?
1. peek() prints every browser that reaches it.
2. filter() keeps only browsers starting with "C".
3. forEach() prints the matching browser.
Notice that peek() prints "Firefox" and "Edge" too, because they reach peek() before being rejected by filter().
2. Is peek() a terminal operation?
No. peek() is an intermediate operation, just like filter() and map().
browsers.stream()
    .peek(s -> System.out.println("Checking: " + s));


Output: Nothing.

Why? Because there is no terminal operation to trigger execution of the pipeline.

Add .forEach():
browsers.stream()
    .peek(s -> System.out.println("Checking: " + s))
    .forEach(System.out::println);


Now the pipeline executes.
3. Difference between peek(), filter() and map()
Method	Purpose	Changes the stream's elements?
peek()	Performs an action, often for debugging	No
filter()	Selects elements that satisfy a condition	Removes nonmatching elements
map()	Transforms elements	Yes, potentially changes their values or types

For example:
numbers.stream()
    .peek(n -> System.out.println("Original: " + n))
    .filter(n -> n > 10)
    .map(n -> n * 2)
    .forEach(System.out::println);


If numbers is [5, 15, 20], the output is:
Original: 5
Original: 15
30
Original: 20
40


4. Important rule
Use .peek() primarily for debugging and observing stream elements. Avoid relying on it for essential application logic or side effects,
 because stream implementations may optimize execution in ways that mean some intermediate actions are not performed.
	 */
	
	
	/*
	 * 3. What is short-circuiting?
Short-circuiting means an operation can stop processing elements as soon as it has enough information to determine its result.

In your example, anyMatch() only needs to find one matching element. Once it finds 8, 
it already knows the answer is true, so it doesn't need to examine the remaining elements.

4. Two other short-circuiting operations
- findFirst() — stops when it finds the first element, if one exists.
- findAny() — can stop when it finds any element, if one exists.

===========================================================================================================================

	 */
	
	/*
	 * how does grouping work
In Java Streams, Collectors.groupingBy() groups elements based on a condition or classification function and stores the groups in a Map.

Think of it as dividing one list into multiple groups.

1. Basic example: Group names by their length
Suppose you have:

List<String> names = Arrays.asList(
    "Karan", "Neha", "Aman", "Vishal", "Raj"
);

You want to group names that have the same length.

Map<Integer, List<String>> result = names.stream()
    .collect(Collectors.groupingBy(n -> n.length()));

System.out.println(result);

Possible output:

{3=[Raj], 4=[Neha, Aman], 5=[Karan, Vishal]}
How grouping works
Original list

Karan, Neha, Aman, Vishal, Raj

Group by n.length()

3
Raj

4
Neha

Aman

5
Karan

Vishal

2. Understand the return type
The result is a Map<Integer, List<String>>.

Map<Integer, List<String>> result

Why?

Integer is the key: the name's length (3, 4, or 5).

List<String> is the value: all names belonging to that length group.

The general structure is:

Map<K, List<T>>

Here, K is the grouping key and T is the element type.

3. How does the lambda determine the group?
Consider:

Collectors.groupingBy(n -> n.length())

For each name, Java evaluates the lambda and uses its result as the map key.

Element

n.length()

Group

"Karan"

5

Key 5

"Neha"

4

Key 4

"Aman"

4

Key 4

"Vishal"

6

Key 6

"Raj"

3

Key 3

Elements with the same key go into the same list.

You can also write the lambda using a method reference:

Collectors.groupingBy(String::length)

4. Practical example: Group even and odd numbers
List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);

Map<String, List<Integer>> result = numbers.stream()
    .collect(Collectors.groupingBy(
        n -> n % 2 == 0 ? "Even" : "Odd"
    ));

System.out.println(result);

Possible output:

{Even=[10, 20, 30], Odd=[15, 25, 35]}
Here, the grouping function returns a String, so the map key type is String.

5. Grouping vs. filtering
filter()

groupingBy()

Selects elements that satisfy a condition

Divides elements into groups

Returns a Stream<T>

Used with collect() to produce a Map

Can discard nonmatching elements

Normally assigns every input element to a group

For example, filter(n -> n % 2 == 0) keeps only even numbers, while groupingBy(n -> n % 2 == 0 ? "Even" : "Odd") keeps both even and odd numbers in separate groups.

Remember: groupingBy() classifies each element using a function, then collects elements with the same classification key into the same group.


	 */
	
	
	
}



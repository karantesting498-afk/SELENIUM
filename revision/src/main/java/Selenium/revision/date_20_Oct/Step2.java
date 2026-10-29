// This class contain question regarding the lambda expression and streams

package Selenium.revision.date_20_Oct;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Step2 {
	WebDriver driver;
	
	//Section 1: Lambda Expressions
	
	
	/*
	 * Q1. Convert Logic into a Lambda Expression
You have the following functional interface:
@FunctionalInterface
interface NumberValidator {
    boolean validate(int number);
}

Tasks:
1. Implement NumberValidator using a lambda expression that returns true if a number is even.
2. Use the lambda to validate 10, 7, and 0.
3. Modify the lambda to return true if the number is positive and even.
4. Explain the syntax of your lambda expression.


	 */
	
	@FunctionalInterface
	interface NumberValidator {
	    boolean validate(int number);
	}
	
	public void ques_01()
	{
		
		/*
		 * 1. Code
		 * 2. code
		 * 3. code
		 * 4. 
		 * number is the lambda parameter corresponding to validate(int number).



-> separates the parameter from the lambda body.



number > 0 checks whether the number is positive.



number % 2 == 0 checks whether the number is even.



&& requires both conditions to be true.



The entire expression evaluates to a boolean value, which is returned by the lambda.

		 * 
		 */
		NumberValidator validator = (number -> (number%2==0));
		
		System.out.println(validator.validate(10));//true
		System.out.println(validator.validate(7));//false
		System.out.println(validator.validate(0));//true
		
		 validator = (number ->number >0 && (number%2==0));
		 
			System.out.println(validator.validate(10));//true
			System.out.println(validator.validate(7));//false
			System.out.println(validator.validate(0));//false

	}
	
	
	
	/*
	 * Q2. Lambda Expression with Multiple Statements
Consider the following functional interface:
@FunctionalInterface
interface EmployeeValidator {
    boolean validate(String name);
}

Write a lambda expression that:
1. Prints the employee name.
2. Checks whether the name has at least five characters.
3. Returns true if the condition is satisfied; otherwise, returns false.
Additional questions:
- Why do you need curly braces in this lambda?
- When using a block lambda, when is the return keyword required?
- Can a lambda expression have multiple statements?
	 */
	
	@FunctionalInterface
	interface EmployeeValidator {
	    boolean validate(String name);
	}
	
	public void ques_02()
	{
		
		/*
		 * 1. Code
		 * 2. Code
		 * 3. code
		 * 4. We need curly braces in the lambda expression because we have multiple condition which need to be satisfy before
		 * getting the value.
		 * 
		 * Curly braces are required here because your lambda body contains multiple statements: printing the name,
		 *  executing the if-else logic, and returning a value. This is called a block lambda.
		 * 
		 * 5. During if condition
		 * Correct explanation: When a block lambda implements a method that returns a value, such as boolean,
		 *  it must return a compatible value on every possible execution path. 
		 * You can use return inside an if or else, or use a single return statement after evaluating a condition
		 * 
		 * 
		 * 
		 * 6. Yes using {} curly braces or &&
		 * 
		 * Q6. Can a lambda expression have multiple statements?
Your answer is partially correct.

Correct explanation: Yes. A lambda can contain multiple statements inside {}.
 The && operator combines boolean expressions; it does not allow multiple statements.

For example:
name -> {
    System.out.println(name);
    int length = name.length();
    return length >= 5;
}


This is a valid block lambda containing three statements.
		 * 
		 *  
		 */
		EmployeeValidator validator = name -> {
			System.out.println(name);
			if(name.length()>=5)
			{
				return true;
			}
			else
			{
				return false;
			}
		};
		
		System.out.println(validator.validate("kar"));//false
		System.out.println(validator.validate("karan"));//true
		
	}

	/*
	 * Q3. Effectively Final Variables
Consider this code:
int minimumLength = 5;

List<String> names = Arrays.asList(
    "Karan", "Aman", "Neha", "Vishal"
);

names.forEach(name -> {
    if (name.length() >= minimumLength) {
        System.out.println(name);
    }
});

Tasks:
1. Will this code compile?
2. Explain why the lambda can access minimumLength.
3. What would happen if you reassigned minimumLength before the forEach() call?
4. Modify the code so the minimum length is 6 and the lambda compiles successfully.
	 */
	
	public void ques_03()
	{
		/*
		 * 1. Yes
		 * 2. Because minimumLength variable in inside same class 
		 * 
		 * Incorrect explanation. The important reason is that minimumLength is a 
		 * local variable that is effectively final, not that it belongs to the same class.
		 * 
		 * 
		 * 3. Next call will use the updated value of minimumLength.
		 * Incorrect. If you reassign this local variable, the lambda will fail to
		 *  compile because the variable is no longer effectively final.
		 *  
		 *  
		 * 4. 
		 * 
		 * int minimumLength = 5;
minimumLength = 6;


The reassignment makes minimumLength no longer effectively final, so the lambda cannot capture it.


		 * int minimumLength = 6;

List<String> names = Arrays.asList(
    "Karan", "Aman", "Neha", "Vishal"
);

names.forEach(name -> {
    if (name.length() >= minimumLength) {
        System.out.println(name);
    }
});


		 */
		int minimumLength = 5;

		List<String> names = Arrays.asList(
		    "Karan", "Aman", "Neha", "Vishal"
		);

		names.forEach(name -> {
		    if (name.length() >= minimumLength) {
		        System.out.println(name);
		    }
		});
	}
	
	
	//Section 2: Functional Interfaces
	
	
	/*
	 * Q4. Predicate
Given:
List<Integer> numbers = Arrays.asList(
    10, 15, 20, 25, 30, 35, 40
);

Tasks:
1. Create a Predicate<Integer> that checks whether a number is greater than 20.
2. Use it with filter() to obtain the matching numbers.
3. Modify the predicate so only numbers greater than 20 and divisible by 10 are accepted.
4. Explain what the test() method of a Predicate does.
	 */
	
	public void ques_04() {
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

		// Task1
		Predicate<Integer> num = n -> n >=20;

		// Task2
		List<Integer> greater20 = numbers.stream().filter(num).collect(Collectors.toList());

		System.out.println(greater20);

		// Task3

		Predicate<Integer> num2 = (n -> n > 20 && n % 10 == 0);

		greater20 = numbers.stream().filter(num2).collect(Collectors.toList());

		System.out.println(greater20);
		
		//task 4
		/*
		 * In predicate, test method is to create a condition like
		 * x-> x>10;
		 * Your explanation is partially correct. A predicate represents a condition,
		 *  but test() is the method that evaluates that condition for a supplied input and returns true or false.
		 */
		System.out.println(num.test(10));//false
		System.out.println(num.test(20));//true
		
		System.out.println(num2.test(40));//true
	}
	
	/*
	 * Q5. Function
Given:
List<String> names = Arrays.asList(
    "karan", "NEHA", "Aman", "sanket"
);

Tasks:
1. Create a Function<String, String> that converts a name to uppercase.
2. Apply the function to each name using map().
3. Collect the transformed names into a list.
4. Explain the difference between Function.apply() and Predicate.test().
	 */
	
	public void ques_05()
	{
		
		List<String> names = Arrays.asList(
			    "karan", "NEHA", "Aman", "sanket"
			);
		
		//Task1
		Function<String, String> name = n-> n.toUpperCase();
		
		//Task2
		//Task3
		List<String> upperNames =names.stream().map(name).collect(Collectors.toList());
		
		System.out.println(upperNames);
		
		//Task4
		/*
		 * 2. Correct explanation for Task 4
Method			Functional 				interface										Purpose	Return type

apply()			Function<T, R>			Transforms an input into a result				R

test()			Predicate<T>			Checks whether a condition is satisfied			boolean


Example:

Function<String, String> name = n -> n.toUpperCase();

System.out.println(name.apply("karan")); // KARAN

Predicate<String> check = n -> n.length() >= 5;

System.out.println(check.test("karan")); // true


Remember:

- apply() returns a transformed value.

- test() returns true or false.

Your existing line:

name.apply(upperNames.get(0));


is valid, but since upperNames.get(0) is already "KARAN", the result will still be "KARAN". 
The return value is simply discarded because you don't print or assign it.
		 */
		name.apply(upperNames.get(0));
		
	}
	
	
	/*
	 * Q6. Consumer and Supplier
Tasks:
1. Create a Consumer<String> that prints a message in this format: "Test case: Login".
2. Use forEach() to print each value from this list:
   List<String> testCases = Arrays.asList(
       "Login", "Logout", "Add Employee"
   );
3. Create a Supplier<String> that returns "Chrome".
4. Call the supplier and print the returned browser name.
5. Explain why Consumer accepts an input but does not return a result, whereas Supplier returns a result without accepting an input.
	 */
	
	public void ques_06()
	{
		   List<String> testCases = Arrays.asList(
			       "Login", "Logout", "Add Employee"
			   );
		   
		   //Task 1
		   Consumer<String> str = s-> System.out.println("Test Case:" + s);
		   
		   //Task2
		   testCases.stream().forEach(str);
		   
		   //Task3
		   
		   Supplier<String> str2 = () -> "Chrome";
		   
		   //task4
		   System.out.println(str2.get());
		   
		   str.accept("Karan");
		   
		   /*
		    * Task 5
		    * 
		    * Consumer consumes a value of the stream but supplier returns a value.
		    * Your answer is partially correct. A Consumer does not necessarily consume a stream value; 
		    * 
		    * it accepts an input of its specified type and performs an operation without returning a result.
		    * 
		    *  A Supplier provides a result without accepting an input.
		    */
		   
	}
	
	
	//Section 3: Stream Fundamentals
	
	
	/*
	 * Q7. Predict the Output
Consider:
List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 13);

numbers.stream()
       .filter(n -> {
           System.out.println("Filter: " + n);
           return n % 2 == 0;
       })
       .map(n -> {
           System.out.println("Map: " + n);
           return n * 2;
       })
       .forEach(System.out::println);

Tasks:
1. Write the complete output in the correct order.
2. Explain why map() doesn't execute for every number.
3. Does filter() process the entire list before map() begins?
4. What role does forEach() play in executing the pipeline?
	 */
	
	
	public void ques_07()
	{
		List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 13);

		numbers.stream()
		       .filter(n -> {
		           System.out.println("Filter: " + n);
		           return n % 2 == 0;
		       })
		       .map(n -> {
		           System.out.println("Map: " + n);
		           return n * 2;
		       })
		       .forEach(System.out::println);
		
		
		/*
		 * 1. Output :
		 * Filter: 2
		 * Map: 2
		 * 4
		 * Filter: 5
		 * Filter: 8
		 * Map: 8
		 * 16
		 * Filter: 10
		 * Map:10
		 * 20
		 * Filter:13
		 * 
		 * 
		 * 2. Map does not execute for all numbers because before map we have executed a filter condition to filter the even number.
		 * If condition fail in the filter , then number will not proceed with map.
		 * 
		 * 
		 * Your answer is correct.

The filter() operation returns true only for even numbers.
 If the predicate returns false, that element is discarded and never reaches map().

For example, when the stream processes 5:
1. Filter: 5 is printed.
2. 5 % 2 == 0 evaluates to false.
3. The element is discarded, so neither map() nor forEach() processes it.


		 * 
		 * 3. No, map only process the filtered data.
		 * 
		 * 3. Task 3 — Does filter() process the entire list before map() begins?
Your answer, "No, map only processes the filtered data," is on the right track, but it doesn't fully explain the execution order.

Correct answer: No. Because streams use lazy evaluation, the pipeline processes each element through filter() and then, 
if it passes, through map() before moving to the next element.

For example:
- 2 → filter passes → map doubles it → forEach prints 4.
- 5 → filter rejects it → map is skipped.
- 8 → filter passes → map doubles it → forEach prints 16.
This behavior is called vertical execution of the stream pipeline.
		 * 
		 * 
		 * 4. in this forEach will print every value in the map
		 * 
		 * 4. Task 4 — What role does forEach() play?
Your answer is correct, with one small refinement.

forEach() is a terminal operation. It triggers execution of the entire stream pipeline and
 performs the specified action on each element that survives the intermediate operations.

In your code:
.forEach(System.out::println);


It prints the transformed values returned by map(). Without a terminal operation such as forEach(), the pipeline would not execute.
		 */
	}
	
	
	
	/*
	 * Q8. Stream Reuse — Difficult
Consider:
Stream<String> stream = Stream.of("Login", "Logout", "Dashboard");

long count = stream.count();

List<String> result = stream
        .filter(name -> name.startsWith("L"))
        .collect(Collectors.toList());

Tasks:
1. Will the code execute successfully? Explain.
2. Identify the exact problem.
3. Rewrite the code so you can obtain both the count and the filtered list.
4. Explain whether you can solve this problem by simply adding another terminal operation to the original
	 */
	
	public void ques_08()
	{
		/*
		 * 1. No code will  not execute successfully.
		 * Your answer: No.

Correct. The second operation on the same stream will throw an IllegalStateException because
 the stream has already been consumed by count().
 
 
		 * 
		 * 2. two error i guess
		 * A. We cannot use Stream<String> like this.
		 * B. = stream
        .filter(name -> name.startsWith("L"))
        .collect(Collectors.toList());

It should be stream.stream.filter(...)...


Task 2: Identify the exact problem

You identified two errors, but neither explanation is quite right.
- A. Stream<String> is perfectly valid Java syntax.
- B. You do not need stream.stream.filter(...). The problem is that count() has already consumed the stream.
Once a terminal operation has been performed, the stream cannot be reused.


3. Code

4. No .
		 */
		
		List<String> modules = Arrays.asList("Login", "Logout", "Dashboard");
		
		int count = modules.size();
		
		List<String> result = modules.stream().filter(name-> name.startsWith("L")).collect(Collectors.toList());
		
		
	}
	
	/*
	 * Q9. Intermediate vs Terminal Operations — Difficult
Consider:
List<String> names = Arrays.asList("Karan", "Neha", "Aman");

names.stream()
     .filter(name -> {
         System.out.println("Checking: " + name);
         return name.length() > 4;
     })
     .map(String::toUpperCase);

Tasks:
1. What happens when this code runs?
2. Will "Checking: Karan" be printed?
3. Add the minimum change required to make the pipeline execute.
4. Explain the role of lazy evaluation in this example.
	 */
	
	public void ques_09()
	{
		/*
		 * 1. When code runs, it will first print name at index 0, then check name length >4. If true then it will be converted into
		 * Upper Case.
		 * Since we are not saving it in another list or printing upper case name, then it will only change value in local 
		 * but it will not change anything.
		 * 
		 * Task 1: What happens when this code runs?

Your answer: It checks the name, then converts matching names to uppercase.

Incorrect. Neither the filter() operation nor the map() operation executes because the pipeline has no terminal operation.

Therefore, nothing is printed, and no names are converted.


		 * 
		 * 2. Yes it will be printed
		 * 
		 * Your answer: Yes.

Incorrect. It will not be printed. The System.out.println() statement is inside the filter's lambda body,
 and that body executes only when the stream pipeline is triggered by a terminal operation.
		 * 
		 * 3. Pipeline will not be executed because we are not collecting the changes in another list or printing it.
		 * 
		 * .forEach(System.out::println);
		 * 
		 * 
		 * 4. Map will convert names which pass the filter into uppercase, but pipeline will not be executed because we are not collecting
		 * it into another List or printing it
		 * 
		 * Lazy evaluation means intermediate operations such as filter() and map() are not executed until a terminal operation is invoked.
		 */
		
		List<String> names = Arrays.asList("Karan", "Neha", "Aman");
		
		names.stream().filter(n->{
			System.out.println("Checking "+n);
			return n.length()>4;
			
		}).map(n->n.toUpperCase()).forEach(n-> System.out.println(n));
		
/*
 * 		names.stream().filter(n->System.out.println("Checking "+n) && n->(n.length())>4).map(n->n.toUpperCase()).forEach(n-> System.out.println(n));
 * 
 * names.stream().filter(n->
		System.out.println("Checking "+n)).filter(n->(n.length())>4)).map(n->n.toUpperCase()).forEach(n-> System.out.println(n));
		
		
		
 * These will not work because syso return void and n.length return boolean. We need boolean condition in filter option.
 * 
 * 
 */
			
		
	}
	
	
	
	//Section 4: filter(), map(), distinct(), sorted(), limit() and skip()
	
	
	/*
	 * Q10. Combine Multiple Stream Operations
Given:
List<Integer> numbers = Arrays.asList(
    12, 5, 8, 12, 20, 7, 8, 25, 30, 5
);

Write a stream pipeline that:
1. Removes duplicate numbers.
2. Keeps numbers greater than 7.
3. Sorts the numbers in descending order.
4. Skips the first two numbers.
5. Takes the next two numbers.
6. Collects the result into a list.
Additional questions:
- What is the final list?
- What would happen if limit(2) were applied before sorting?
- Does distinct() automatically sort the numbers?
	 */
	
	public void ques_10()
	{
		/*
		 * 7. nums2 is the final list
		 * 2. then sort will only work for starting 2 values
		 * 3. no distinct only discard the duplicate value
		 */
		List<Integer> numbers = Arrays.asList(12, 5, 8, 12, 20, 7, 8, 25, 30, 5);
		
		//Task1
		numbers.stream().distinct().forEach(n-> System.out.println(n));
		
		//Task2
		
		numbers.stream().filter(n-> n>7).forEach(System.out::println);
		
		//Task3
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//Task4
		numbers.stream().skip(2).forEach(n-> System.out.println(n));

		//Task5 and task 6
		List<Integer> nums = numbers.stream().skip(2).limit(2).collect(Collectors.toList());
		
		System.out.println(nums);
		
		
		List<Integer> nums2 = numbers.stream().distinct().filter(n-> n>7).sorted(Comparator.reverseOrder()).skip(2).limit(2).collect(Collectors.toList());
		
		System.out.println(nums2);

	}
	
	
	/*
	 * Q11. Transform Strings Using map()
Given:
List<String> names = Arrays.asList(
    "karan", "NEHA", "aman", "sanket"
);

Write a stream pipeline that:
1. Converts all names to lowercase.
2. Converts the first character of each name to uppercase.
3. Sorts the names alphabetically.
4. Collects the result into a list.
Additional questions:
- Why is map() suitable for transforming each element?
- Does map() modify the original list?
- What happens if a mapping function returns null?
	 */
	
	public void ques_11()
	{
		/*
		 * 5. Becuase map is an intermediate function and after execution it return the stream.
		 * 
		 * Q1. Why is map() suitable for transforming each element?

Your answer is partially correct. 
Saying that map() is an intermediate operation that returns a stream explains its classification,
 but not why it is suitable for transformation.

Correct explanation: map() applies a mapping function to each element of a 
stream and produces a new stream containing the transformed elements.

For example:

names.stream()
     .map(s -> s.toLowerCase())

Each name is converted to lowercase, and the resulting stream contains the transformed strings.


		 * 
		 * 6. No, map does not modify original list. It only make changes in the stream.
		 * 
		 *  7. NullPointerException Exception will be displayed
		 *  
		 *  Q3. What happens if a mapping function returns null?

Your answer, "Exception will be displayed," is not always correct.

Consider:

List<String> result = names.stream()
    .map(s -> (String) null)
    .collect(Collectors.toList());

This can produce a list containing four null elements:

[null, null, null, null]

However, if you subsequently execute:

.map(s -> s.toUpperCase())

a NullPointerException occurs because s is null.

Key rule: map() can produce null elements. An exception occurs only if a later operation or terminal operation cannot handle those nulls.
 Some downstream operations, such as sorted() with its natural ordering, can also fail when they encounter null elements.
		 */
		List<String> names = Arrays.asList(
			    "karan", "NEHA", "aman", "sanket"
			);
		
		 List<String> result = names.stream().map(s->s.toLowerCase()).map(s-> s.substring(0, 1).toUpperCase() + s.substring(1)).sorted().collect(Collectors.toList());
		System.out.println(result);
	}
	
	
	/*
	 * Q12. Filter Email-Like Strings
Given:
List<String> emails = Arrays.asList(
    "karan@example.com",
    "neha@gmail.com",
    "invalid-email",
    "",
    null,
    "aman@example.com",
    "test@"
);

Write a stream pipeline that:
1. Removes null and empty values.
2. Keeps strings containing @.
3. Keeps strings ending in .com.
4. Converts the results to lowercase.
5. Collects the results into a list.
Additional questions:
- Why should null handling happen before calling string methods?
- Does checking for @ and .com guarantee that an email address is valid?
	 */
	
	public void ques_12()
	{
		/*
		 * 6. Because if data is null and we are further processing it in the stream then it will give nullPointerException
		 * 
		 * 7. No, because there might be multiple @ or string might be like .com , @.com, a.com.
		 * 
		 */
		List<String> emails = Arrays.asList(
			    "karan@example.com",
			    "neha@gmail.com",
			    "invalid-email",
			    "",
			    null,
			    "aman@example.com",
			    "test@"
			);
		
		Predicate<String> nullCheck = s-> {
			if(s == null|| s.isEmpty())
			{
				return false;
			}
			else if(!s.contains("@") || !s.endsWith(".com"))
			{
				return false;
			}
			else
			{
				return true;
			}
			
		};
		
		List<String> result =emails.stream().filter(nullCheck).map(s->s.toLowerCase()).collect(Collectors.toList());
		System.out.println(result);
	}
	
	//Section 5: Match and Find Operations
	
	
	/*
	 * Q13. anyMatch(), allMatch() and noneMatch()
Given:
List<Integer> marks = Arrays.asList(
    45, 60, 75, 80, 90
);

Write code to determine:
1. Whether at least one student scored more than 85.
2. Whether every student passed, assuming the passing mark is 40.
3. Whether no student scored below 35.
Additional questions:
- Explain the difference between the three methods.
- What do these methods return when used on an empty stream?
	 */
	
	
	public void ques_13()
	{
		/*
		 * 4. anyMatch - return true if any of the value satisfy condition.
		 * all match = return true if all value satisfy condition
		 * noneMatch = return true if none value satisfy condition
		 * 
		 * 5. In an empty string, these method return null
		 * 
		 * What happens with an empty stream?
Your answer says these methods return null. That is incorrect. They return boolean values, never null.
Method	Empty stream result	Reason

anyMatch()	false	No element exists that can satisfy the condition.
allMatch()	true	There is no element that violates the condition.
noneMatch()	true	There is no element that satisfies the condition.





		 */
		List<Integer> marks = Arrays.asList(
			    45, 60, 75, 80, 90
			);
		
		//Task1
		System.out.println(marks.stream().anyMatch(n-> n>85));
		
		//Task2
		System.out.println(marks.stream().allMatch(n-> n>40));
		
		//task3
		System.out.println(marks.stream().noneMatch(n-> n<35));
	}
	
	/*
	 * Q14. Finding Elements — Difficult
Given:
List<String> browsers = Arrays.asList(
    "Firefox", "Chrome", "Edge", "Chrome", "Safari"
);

Tasks:
1. Find the first browser whose name starts with "C".
2. Find any browser whose name starts with "C".
3. Handle the case where no matching browser exists.
4. Explain why findFirst() and findAny() return an Optional.
5. Is findAny() guaranteed to return the first matching element?
	 */
	
	public void ques_14()
	{
		/*
		 * 4. findFirst() and findAny() return optional because the result might or might not exist after the condition validation
		 * 
		 * 5. Yes, it will return the first matching value
		 * 
		 * No. This is the important correction.
Method	Guarantee
findFirst()	Returns the first matching element according to the stream's encounter order, if one exists.
findAny()	Returns some matching element, without guaranteeing it is the first.

For your list:
Arrays.asList("Firefox", "Chrome", "Edge", "Chrome", "Safari")


Both methods may return "Chrome" because it is the first matching element and also a valid matching element for findAny().

However, findAny() is allowed to return another matching element, such as the second "Chrome". This matters especially for parallel streams, where findAny() can allow more implementation flexibility.

Interview tip: Use findFirst() when encounter order matters. Use findAny() when any matching element is sufficient.
		 */
		List<String> browsers = Arrays.asList(
			    "Firefox", "Chrome", "Edge", "Chrome", "Safari"
			);
		
		
		//Task 1
		System.out.println(browsers.stream().filter(s-> s.subSequence(0, 1).equals("C")).findFirst());
		
		//Task 2
		Optional<String> result =browsers.stream().filter(s-> s.substring(0,1).equals("C")).findAny();
		
		//Task 3
		if(result.isPresent())
		{
			System.out.println(result);
		}
		else
		{
			System.out.println("No browser starts with C present in the list");
		}
		
	}
	
	/*
	 * Q15. Short-Circuiting — Difficult
Consider:
List<Integer> numbers = Arrays.asList(3, 5, 8, 11, 14, 17);

boolean result = numbers.stream()
        .peek(n -> System.out.println("Checking: " + n))
        .anyMatch(n -> n % 2 == 0);

System.out.println(result);

Tasks:
1. Write the complete output.
2. Explain why the program might not print "Checking: 11".
3. What is short-circuiting in the Stream API?
4. Name two other stream operations that can short-circuit.
	 */
	public void ques_15()
	{
		List<Integer> numbers = Arrays.asList(3, 5, 8, 11, 14, 17);

		boolean result = numbers.stream()
		        .peek(n -> System.out.println("Checking: " + n))
		        .anyMatch(n -> n % 2 == 0);

		System.out.println(result);
		
		/*
		 * 1. Output:
		 * Checking: 3
		 * Checking: 5
		 * Checking: 8
		 * true
		 * 
		 * 
		 * 2. Because anyMatch will return true when condition for even is satisfied at 8 value.
		 * 
		 * 3. Don't know
		 *4. don't know
		 *
		 *
		 *
		 *3. What is short-circuiting?
Short-circuiting means an operation can stop processing elements as soon as it has enough information to determine its result.

In your example, anyMatch() only needs to find one matching element. Once it finds 8, it already knows the answer is true, so it doesn't need to examine the remaining elements.

The peek() operation prints only the elements that actually reach it during execution.
4. Two other short-circuiting operations
- findFirst() — stops when it finds the first element, if one exists.
- findAny() — can stop when it finds any element, if one exists.
Other examples include allMatch() and noneMatch(), which can stop as soon as they find a counterexample to their respective conditions.

Important distinction: peek() is an intermediate operation; anyMatch() is a short-circuiting terminal operation. The terminal operation triggers execution and determines when processing can stop.
		 */
	}
	
	
	//Section 6: collect(), Collectors and reduce()
	
	/*
	 * Q16. Collecting Data — Difficult
Given:
List<String> names = Arrays.asList(
    "Karan", "Neha", "Aman", "Karan", "Neha", "Vishal"
);

Use streams to:
1. Collect the distinct names into a list.
2. Collect the distinct names into a set.
3. Convert the names to uppercase and collect them into a list.
4. Explain the difference between collecting into a List and a Set.
5. Is the order guaranteed to be the same when collecting into a Set?
	 * 
	 */
	
	public void ques_16()
	{
		List<String> names = Arrays.asList(
			    "Karan", "Neha", "Aman", "Karan", "Neha", "Vishal"
			);
		
		//task1
		List<String> nameList = names.stream().distinct().collect(Collectors.toList());
		
		//Task2
		Set<String> nameSet = names.stream().distinct().collect(Collectors.toSet());
		
		//task 3
		List<String> upperName = names.stream().map(n-> n.toUpperCase()).collect(Collectors.toList());
		
		/*
		 * 4. Collection to list, saves the updated value in a list
		 * while collection to set , saves the updated value in a set.
		 * 
		 * 3. Difference between collecting into a List and a Set
Feature					List																Set
Duplicates				Allowed																Not allowed
Order					Preserves insertion/encounter order for this collection				Depends on the Set implementation
Access by index			Supported															Not supported
Example collector		Collectors.toList()													Collectors.toSet()

Your statement that a list or set saves the updated values is broadly correct,
 but collecting does not necessarily update the original collection. It produces a result collection
		 * 
		 * 5. 
		 * No, not with Collectors.toSet().

For example, your stream's encounter order is:
Karan, Neha, Aman, Karan, Neha, Vishal


After collecting into a set, you will have the four distinct names, but you cannot rely on their iteration order being:
Karan, Neha, Aman, Vishal


A set implementation may display them in a different order.

If you need uniqueness and encounter order, use a LinkedHashSet:
Set<String> nameSet = names.stream()
    .collect(Collectors.toCollection(LinkedHashSet::new));


This preserves the first-occurrence order: Karan, Neha, Aman, Vishal.

One final correction: your comment about values not satisfying a condition applies to filtering, such as .filter(...). 
Collecting into a List or Set does not itself remove elements based on a condition; distinct() 
removes duplicates, and a Set also enforces uniqueness.
		 */
		
	}
	
	
	/*
	 * Q17. Grouping and Counting — Difficult
Given:
List<String> employees = Arrays.asList(
    "Karan", "Neha", "Aman", "Kabir", "Nisha", "Ankit"
);

Use streams and collectors to:
1. Group employees by the first character of their names.
2. Count how many employees belong to each first-character group.
3. Explain the role of Collectors.groupingBy().
4. Explain the difference between groupingBy() and partitioningBy().
Challenge: What would happen if the list contained a null employee name and your grouping function called name.charAt(0)?
	 */
	
	public void ques_17()
	{
		List<String> employees = Arrays.asList(
			    "Karan", "Neha", "Aman", "Kabir", "Nisha", "Ankit"
			);

		//Task 1
		
		Map<String, List<String>> result = employees.stream().collect(Collectors.groupingBy(n->n.substring(0, 1)));
		
		//Task 2

		Map<String , Long> result2 = employees.stream().collect(Collectors.groupingBy(n->n.substring(0, 1),Collectors.counting()
				));
		System.out.println(result2);
		/*
		 * {A=[Aman, Ankit], K=[Karan, Kabir], N=[Neha, Nisha]}
			{A=2, K=2, N=2}
		 * 
		 * 
		 * 3. GroupingBy , groups the output as the per key value and stores it in a map.
		 * 
		 * 4. Don't know
		 * 
		 *  Difference between groupingBy() and partitioningBy()
Feature	groupingBy()	partitioningBy()
Classification	Can create multiple groups	Always divides elements into two groups
Key type	Depends on the classification function	Boolean (true or false)
Typical use	Group employees by department or first letter	Divide numbers into even and odd
Result	Map<K, List<T>> by default	Map<Boolean, List<T>> by default

Example of partitioningBy():
Map<Boolean, List<String>> result = employees.stream()
    .collect(Collectors.partitioningBy(n -> n.startsWith("A")));


Possible result:
{
    true=[Aman, Ankit],
    false=[Karan, Neha, Kabir, Nisha]
}


Here, true means the name starts with "A", and false means it does not.

Rule: Use groupingBy() when elements can belong to many different categories.
 Use partitioningBy() when you want to split elements according to one boolean condition.
		 * 
		 * 
		 * 5. Don't know
		 * 
		 * 
		 * Challenge: What happens if a name is null?
Suppose the list contains null and your grouping function is:
n -> n.charAt(0)


When Java tries to evaluate n.charAt(0) for the null element, it throws a NullPointerException. The same issue occurs with your n.substring(0, 1) expression.

You can prevent this by filtering out null names first:
Map<String, Long> counts = employees.stream()
    .filter(Objects::nonNull)
    .collect(Collectors.groupingBy(
        n -> n.substring(0, 1),
        Collectors.counting()
    ));


This ignores null names and counts only valid employee names. 
If null names are meaningful in your application, you should instead define explicitly how they should be handled.
		 */
	}
	
	/*
	 * Q18. Using reduce() — Difficult
Given:
List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

Tasks:
1. Calculate the sum using reduce().
2. Calculate the product using reduce().
3. Explain the purpose of the identity value in reduce().
4. What is the difference between reduce() and collect()?
5. What could go wrong if you use an unsuitable identity value?
	 */
	
	
	public void ques_18()
	{
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

		//Task 1
		int sum = numbers.stream().reduce(0, (a,b)-> a+b);
		
		System.out.println(sum);
		
		//Task 2
		
		int product = numbers.stream().reduce(1, (a,b)-> a*b);
		System.out.println(product);
		
		/*
		 * 3. Indentity value in the reduce represent the initial accumulation.
		 * It is similar like
		 * int sum = 0;
		 * sum = a+b;
		 * 
		 * 
		 * 3. What is the identity value?
The identity value is the starting value that does not change the result when combined with another value using the relevant operation.

For addition:
numbers.stream().reduce(0, (a, b) -> a + b);


The identity is 0, because:
- 0 + 2 = 2
- 0 + 3 = 3
For multiplication:
numbers.stream().reduce(1, (a, b) -> a * b);


The identity is 1, because:
- 1 * 2 = 2
- 1 * 3 = 3
Your analogy with int sum = 0 is helpful. More precisely, 
the reduction begins with the identity and combines it with the stream elements to produce the final result.
		 * 
		 * 
		 * 4. reduce is used to calculate the values and return a value
		 * whereas collect is used convert the stream values in a list or set.
		 * 
		 * 4. Difference between reduce() and collect()
		 * 
reduce()														collect()
Combines elements into a single result							Accumulates elements into a result container or another collected result
Commonly used for sum, product, minimum, or maximum				Commonly used to create a List, Set, Map, or grouped result
Example: reduce(0, Integer::sum)								Example: collect(Collectors.toList())

Examples:
// One result: sum
int sum = numbers.stream()
    .reduce(0, Integer::sum);

// A collection containing selected elements
List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());


The key distinction is combining values into a result versus accumulating elements into a result structure. 
Technically, collect() can also produce a single value, such as a count, so it is not limited to lists and sets.
		 * 
		 * 5. 
		 * It can produce an incorrect answer without throwing any exception.

For example:
int sum = numbers.stream()
    .reduce(10, (a, b) -> a + b);

System.out.println(sum); // 24


The actual sum is 14, but the result is 24 because the initial value 10 is added to all the elements.

Similarly:
int product = numbers.stream()
    .reduce(0, (a, b) -> a * b);

System.out.println(product); // 0


The result is 0, because multiplying by zero always produces zero.

Important: An identity must satisfy the identity property for the operation. For parallel reductions, 
the accumulator must also be associative, and the identity must be compatible with it. 
Violating these requirements can cause incorrect results, especially with parallel streams.
		 * 
		 * 
		 * 
		 */
	}
	
	
	
	//Section 7: Selenium Automation Scenarios Using Streams and Lambdas
	
	
	/*
	 * Q19. Validate Dropdown Options — Difficult
Suppose a dropdown contains these options:
List<WebElement> options =
        driver.findElements(By.cssSelector("#country option"));

Tasks:
1. Use streams and map() to extract all option texts into a List<String>.
2. Use anyMatch() to verify whether "India" exists.
3. Use filter() to find all options whose visible text contains "United".
4. Explain why it is useful to extract text before performing multiple validations.
	 */
	
	public void ques_19()
	{
		List<WebElement> options =
		        driver.findElements(By.cssSelector("#country option"));
		
		//Task 1
		List<String> country = options.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Task 2
		
		boolean country2 = options.stream().map(s->s.getText()).anyMatch(s->s.equalsIgnoreCase("India"));
		
		//Task 3
		List<String> country3 = options.stream().map(s->s.getText()).filter(s->s.contains("United")).collect(Collectors.toList());
		
		//task4
		/*
		 * It is useful to extract text first because options contains list of webelements.
		 * and if we don't extract text first, then in each verification we will first have  to extract text first and then 
		 * perform validation.
		 */
	}
	
	/*
	 * Q20. Validate a Web Table — Difficult
Suppose a table contains employee names in the first column:
List<WebElement> rows =
        driver.findElements(By.cssSelector("#employeeTable tbody tr"));

Tasks:
1. Use streams to determine whether an employee named "Karan" exists in the table.
2. Make the comparison case-insensitive.
3. Find all employee names beginning with "A".
4. Handle rows that have no cells or no usable employee name.
5. Explain why calling getText() repeatedly on live WebElements can be less robust than first extracting the required text.
	 */
	
	public void ques_20()
	{
		List<WebElement> rows =
		        driver.findElements(By.cssSelector("#employeeTable tbody tr"));
		
		//task1 and task 2
		
		rows.stream().map(row->row.findElement(By.cssSelector("td")).getText().trim()).filter(row->!row.isEmpty()).anyMatch(row->row.equalsIgnoreCase("Karan"));
		
		
		//task 3
		
		rows.stream().map(row->row.findElement(By.cssSelector("td")).getText().trim()).filter(row->row.startsWith("A"));
		
		Predicate<String> result = s->{
			if(s==null || s.isEmpty())
			{
				return false;
			}
			else
			{
				return true;
			}
		};
		
		//Task 4
		rows.stream().map(s->s.findElement(By.cssSelector("td")).getText()).filter(result).collect(Collectors.toList());
		
		/*
		 * If we first extract text in a list, then it can reusable and user will not have to again extract text 
		 * if he wants to use text in multiple streams.
		 */
		
		
		
	}
	
	
	/*
	 * Q21. Validate Buttons — Difficult
Suppose a page has multiple buttons:
List<WebElement> buttons = driver.findElements(By.tagName("button"));

Tasks:
1. Use streams to determine whether at least one displayed button is enabled.
2. Find the text of all displayed buttons that are enabled.
3. Filter buttons whose text contains "Save", ignoring case.
4. Explain the difference between isDisplayed() and isEnabled().
5. What Selenium exception might occur if a button becomes stale while the stream is processing it?
Important: Selenium WebDriver interactions should generally remain sequential. 
Avoid using parallelStream() for browser-element interactions.
	 */
	
	public void ques_21()
	{
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		
		//task1
		buttons.stream().anyMatch(s->s.isDisplayed() && s.isEnabled());
		
		//Task 2
		buttons.stream().filter(s->s.isEnabled() && s.isDisplayed()).forEach(s->System.out.println(s.getText()));
		
		//task3
		
		List<String> saveButtons = buttons.stream().map(s->s.getText()).filter(s->s.contains("save")).collect(Collectors.toList());
		
		//task 4
		/*
		 * isDisplayed() checks whether element is displayed on page or not
		 * isEnabled() checks whether webElement is enabled or not. and can generally accept user interaction.
		 */
		
		/*
		 * 5. StaleElementReferenceException
		 */
		
	}
	
	
	/*
	 * Section 8: Combined Lambda + Stream Challenges
	 * 
	 * 
	 * 
These are the most challenging questions in this set because they combine multiple concepts.
Q22. Combined Predicate and Stream Pipeline
Given:
List<String> usernames = Arrays.asList(
    "karan", "admin", "test_user", "", "manager", null, "QA"
);

Tasks:
1. Create a reusable Predicate<String> that checks whether a username:
   - Is not null.
   - Is not empty.
   - Contains at least five characters.
2. Use the predicate in a stream pipeline.
3. Convert valid usernames to uppercase.
4. Sort them alphabetically.
5. Collect the result into a list.
6. Use noneMatch() to determine whether any valid username is shorter than five characters.
	 */
	
	public void ques_22()
	{
		List<String> usernames = Arrays.asList(
			    "karan", "admin", "test_user", "", "manager", null, "QA"
			);
		Predicate<String> result = s-> {
			if(s== null || s.isEmpty())
			{
				return false;
			}
			else if(s.length() >=5)
			{
				return true;
			}
			else
			{
				return false;
			}
		};
		
		
		//task 1 to 5
		usernames.stream().filter(result).map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
		
		//task6
		
		usernames.stream().filter(s->{
			if(s== null || s.isEmpty())
			{
				return false;
			}
			else
			{
				return true;
			}
		}).noneMatch(s->s.length()<5);
		
	}
}

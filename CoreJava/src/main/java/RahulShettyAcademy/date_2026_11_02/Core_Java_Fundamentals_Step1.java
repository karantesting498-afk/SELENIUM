/*
 * THis class contains knowledge regarding the Java fundamentals
 */
package RahulShettyAcademy.date_2026_11_02;

public class Core_Java_Fundamentals_Step1 {
	
	/*
	 * 1. Java fundamentals
1.1 JDK, JRE and JVM
These three components are important for understanding Java execution.


Component			Purpose
JVM	Executes 		Java bytecode
JRE	Provides 		JVM and libraries required to run Java applications
JDK					Provides development tools, including compiler and runtime components

Example:
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}


Commands:
javac Main.java
java Main


Interview concepts:
- Why is Java platform-independent?
- Is JVM platform-independent?
- What is bytecode?
- What is JIT?
- Difference between JDK, JRE and JVM?


1.2 Java features

Understand these features and their practical meaning:

Feature								Meaning

Platform independent				Bytecode can run on compatible JVMs across platforms

Object-oriented						Supports classes and objects

Robust								Strong type checking and exception handling

Secure								Runtime checks and security-related features

Multithreaded						Supports concurrent execution

Portable							Consistent primitive data types and bytecode

Automatic memory management			Garbage collector manages object memory

High performance					JIT optimizes frequently executed code
	 */
	
	
	/*
	 * 1.3 Data types
	 * 
	 * 
Java has two main categories of data types.

Primitive 					data types

Type					Size							Example
byte					8 bits							byte a = 10;
short					16 bits							short a = 100;
int						32 bits							int a = 1000;
long					64 bits							long a = 10000L;
float					32 bits							float a = 10.5f;
double					64 bits							double a = 10.5;
char					16 bits							char a = 'A';

boolean					JVM-dependent representation	boolean a = true;
	 */
	
	/*
	 * Non-primitive/reference types
- String
- Arrays
- Classes
- Interfaces
- Enums
Important: Reference variables hold references to objects, not the objects themselves
	 */
	
	/*
	 * 1.4 Variables and scope
	 * 
Three important variable types:

public class Example {

    int instanceVariable = 10;

    static int staticVariable = 20;

    public void display() {

        int localVariable = 30;

        System.out.println(instanceVariable);
        System.out.println(staticVariable);
        System.out.println(localVariable);
    }
}


Variable					Belongs to					Lifetime

Local						Method/block				During execution of its scope

Instance					Object						While referenced object remains reachable

Static						Class						Associated with class initialization and class lifecycle

Remember:
- Local variables must be initialized before use.
- Instance and static variables receive default values.
- Static variables are shared among instances of the class.
	 */
	
	/*
	 * 1.5 Type casting
Type casting converts a value from one data type to another.

Widening – automatic conversion
int a = 100;
double b = a;

System.out.println(b); // 100.0


Narrowing – explicit conversion
double a = 100.75;
int b = (int) a;

System.out.println(b); // 100


Important: Narrowing can result in data loss.
	 */
	
	
	/*
	 * 1.6 Operators
| Category | Operators |
|---|---|
| Arithmetic | + - * / % |
| Relational | == != > < >= <= |
| Logical | && || ! |
| Assignment | = += -= *= /= |
| Unary | ++ -- |
| Ternary | condition ? value1 : value2 |
| Bitwise | & | ^ ~ |
| Shift | << >> >>> |

Pay particular attention to:
- == vs equals()
- && vs &
- ++i vs i++
- Integer division vs decimal division
- Short-circuit evaluation
	 */

	/*
	 * 1.7 Wrapper classes
Wrapper classes represent primitive values as objects.
Primitive	Wrapper
byte	Byte
short	Short
int	Integer
long	Long
float	Float
double	Double
char	Character
boolean	Boolean

Autoboxing:
int a = 10;
Integer b = a;


Unboxing:
Integer a = 20;
int b = a;


Why are wrapper classes useful?
- Collections such as ArrayList require reference types.
- They provide utility methods such as Integer.parseInt().
- They can represent null values, unlike primitive types.
Important distinction:
String value = "100";
int number = Integer.parseInt(value);


parseInt() converts String to primitive int, whereas valueOf() returns an Integer object.
	 */
}

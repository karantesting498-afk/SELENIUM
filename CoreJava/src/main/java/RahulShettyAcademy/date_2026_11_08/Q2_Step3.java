/*
 * Q2. Checked vs Unchecked Exceptions
(Medium) Exception Classification, Compilation

Consider the following code:
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static void readFile() throws IOException {

        FileReader reader = new FileReader("data.txt");

        System.out.println("File opened");
    }

    static void calculate() {

        int result = 10 / 0;

        System.out.println(result);
    }

    public static void main(String[] args) {

        readFile();

        calculate();

        System.out.println("Program completed");
    }
}

Tasks:
1. Identify all exceptions that can occur.
2. Classify them as checked or unchecked.
3. Explain why the given program produces a compilation error.
4. Modify the program so that checked exceptions are handled correctly.
5. Explain what happens when calculate() executes.
6. Explain why the compiler does not force you to handle ArithmeticException.
7. Predict which statements will execute after the exception occurs.
Do not simply add catch(Exception e) everywhere. Handle the exceptions appropriately.
 */
package RahulShettyAcademy.date_2026_11_08;

import java.io.FileReader;
import java.io.IOException;

public class Q2_Step3 {
	
	/*1.
	 * IOException
	 * AirthmeticException
	 * FileNotFoundException
	 * 
	 * 2. FIle reader exception in checked and   int result = 10 / 0; is unchecked.
	 * 
	 * 3. 10/0 gives compilation error.
	 * 
	 * No. 10 / 0 does not cause a compile error. It compiles fine and fails at runtime.
	 *  The compile error is in main: it calls readFile(), which throws IOException (checked), without handling or declaring it.
	 * 
	 * 4. try
	 * {
	 *  int result = 10 / 0;
	 * }catch(Exception e)
	 * {
	 * 	e.printStackTrace();
	 * }
	 * 
	 * 5. Compilation errro due to  int result = 10 / 0;
	 * 
	 * No. Not a compilation error. 10 / 0 throws ArithmeticException: / by zero at runtime, and println(result) is skipped.
	 *  In the original program, with no handler, it would terminate the program.
	 * 
	 * 6. Because it is an runtime unchecked exception.
	 * Partial. “Runtime unchecked exception” is correct but is just the label. Add the reason: 
	 * it extends RuntimeException, so it is unchecked, and it comes from programming errors (a zero divisor) 
	 * that should be fixed or validated rather than caught everywhere.
	 * 
	 * 7. compilation error wil be occured on  int result = 10 / 0;
	 * after this no statement will be executed
	 * 
	 * No. There is no compilation error to stop things. Answer for the original (fixed to compile) program:
	 *  System.out.println(result) is skipped, and since nothing catches it, "Program completed" never prints.
	 *   In your modified code: the exception is caught in calculate(), so "Program completed" does print.
	 */

	   static void readFile() throws IOException {

	       try( FileReader reader = new FileReader("data.txt"))
	       {
	    	   System.out.println("File opened");
	       }
	    }
	   
	   static void calculate() {

	        try {
	        	int result = 10 / 0;

		        System.out.println(result);
			} catch (ArithmeticException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	   
	   public static void main(String[] args) throws IOException {

	        try {
	        	readFile();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

	        calculate();

	        System.out.println("Program completed");
	    }
}

/*
 * Q8. Expression Evaluation Challenge
Predict the output before executing the program.
public class ExpressionChallenge {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        double c = a / b;

        double d = (double) a / b;

        int x = 5;

        int y = x++ + ++x;

        int z = 10;

        boolean result = (z++ > 10) && (++z > 10);

        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        System.out.println("result = " + result);
    }
}


Requirements:
1. Predict every output.
2. Explain the evaluation order.
3. Explain why c and d differ.
4. Explain why z changes or does not change.
5. Verify your prediction by executing the program.
Expected learning: Type promotion, integer division, increment operators and short-circuit evaluation.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q13_Step14 {
	
	/*1. output
	 * c = 3
	 * d = 3.3
	 * y = 12
	 * z = 12 -> incorrect z =11 because   boolean result = (z++ > 10) && (++z > 10); uses short circuit. (z++ > 10) this condition 10>10= false so (++z > 10) this condition will not be executed 
	 * result = false
	 * 2. ^^ same as 1
	 * 
	 * 3. c & d differe because c = int/int value which return int value too
	 * but d = (double) a/(double) b which return decimal value.
	 * 
	 * 4. z changes because we are using z++ and ++z;
	 * 5. 
	 * 
	 * 
	 */
	
	 public static void main(String[] args) {

	        int a = 10;
	        int b = 3;

	        double c = a / b;

	        double d = (double) a / b;

	        int x = 5;

	        int y = x++ + ++x;

	        int z = 10;

	        boolean result = (z++ > 10) && (++z > 10);

	        System.out.println("c = " + c);
	        System.out.println("d = " + d);
	        System.out.println("y = " + y);
	        System.out.println("z = " + z);
	        System.out.println("result = " + result);
	    }
	}



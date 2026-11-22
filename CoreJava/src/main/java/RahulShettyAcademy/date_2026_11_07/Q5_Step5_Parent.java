/*
 * Q5. Final Keyword – Coding and Output Prediction
(Hard) final Variables, Methods, Classes, References

Consider the following code:
class Parent {

    final int value = 100;

    final void display() {
        System.out.println("Parent Display");
    }
}

class Child extends Parent {

    // Add your code here
}

public class Main {

    public static void main(String[] args) {

        final StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");

        System.out.println(sb);

        // Add your code here
    }
}

Tasks:
1. Print the final variable value using the child object.
2. Demonstrate that the final method cannot be overridden.
3. Try modifying the final variable and explain the compilation result.
4. Try assigning a new StringBuilder object to sb and explain the compilation result.
5. Explain why sb.append() works even though sb is final.
6. What happens if the Child class itself is declared final? Can another class extend it?
For points 2 and 3, demonstrate the compilation restrictions separately. Do not leave invalid code in the final runnable version.
 */
package RahulShettyAcademy.date_2026_11_07;

public class Q5_Step5_Parent {

	 final int value = 100;

	    final void display() {
	        System.out.println("Parent Display");
	    }
}



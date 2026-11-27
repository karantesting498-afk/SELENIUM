/*
 * Q2. Array Output Prediction
Predict the exact output of the following program. Explain why each output occurs.
public class ArrayTest {

    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40};

        int[] b = a;

        b[1] = 100;

        int[] c = a.clone();

        c[2] = 200;

        System.out.println(a[1]);
        System.out.println(b[1]);
        System.out.println(c[2]);

        System.out.println(a == b);
        System.out.println(a == c);

        System.out.println(a.length);
    }
}


Also explain:
- Why does changing b affect a?
- Why does changing c not affect a?
- What is the difference between == and comparing array contents?
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q2_Step3 {
	
	/*
	 * Output:
	 * 100
	 * 100
	 * 200
	 * true
	 * false
	 * 4
	 * 
	 * 1. Changing b affects a because both a & b have same refrence of array.
	 * 
	 * 2. Changing c does nto afffect a because c is cloning array A. CLoning feature creates a new array with same content
	 * in the memory.
	 * 
	 * 3. (==) operator checks if both arrays reference are same or not.
	 * It does not check content of the array.
	 * 
	 * 
	 */

}

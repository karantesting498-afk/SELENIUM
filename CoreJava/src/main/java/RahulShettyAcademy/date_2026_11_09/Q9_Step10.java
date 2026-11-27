/*
 * Q9. Array Reference and Copy Behaviour – Debugging
Study the following program:
import java.util.Arrays;

public class ArrayDebug {

    public static void main(String[] args) {

        int[] original = {10, 20, 30, 40};

        int[] reference = original;

        int[] copied = Arrays.copyOf(original, original.length);

        reference[0] = 100;

        copied[1] = 200;

        original = new int[]{1, 2, 3};

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(reference));
        System.out.println(Arrays.toString(copied));
    }
}


Tasks:
1. Predict the exact output.
2. Explain why reference still points to the old array.
3. Explain why copied is independent.
4. Explain what happens when original is assigned a new array.
5. Draw or describe the reference relationship before and after reassignment.
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q9_Step10 {
	
	public static void main(String[] args) {
		/*
		 * 1. Output
		 * 
		 * [1,2,3]
		 * [100,20,30,40]
		 * [10,200,30,40]
		 * 
		 * 2.
		 *  First original array is initialized.
		 * refrence variable holds reference to original array.
		 * copied array holds reference to a new array copied from original
		 * reference[0] is updated means both original variable and reference variable which points to address of same array object will be updated at 0th position
		 * copied array is updated
		 * 	now original variable holds reference to new original array.
		 * 
		 * but reference variable still holds previous assigned reference.
		 * 
		 * 3. copied varibale holds reference to a new array which is created using copy method. Copy methods generates new array in the memory.
		 * 
		 * 4. When new array is assigned to original array, then it releases old array reference and holds new array reference.
		 * 
		 * 5. 
		 * 
		 */
	}

}

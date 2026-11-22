package RahulShettyAcademy.date_2026_11_07;

public class Step5_Main {

	public static void main(String[] args) {

		Step5_Child obj = new Step5_Child();
		
//		obj.value = 200; => error The final field Q5_Step5_Parent.value cannot be assigned
		//Print the final variable value using the child object.
		System.out.println(obj.value);
        final StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");

        System.out.println(sb);

        // Add your code here
        
//        sb = sb.append("4"); error ->The final local variable sb cannot be assigned. It must be blank and not using a compound assignment
        
        /*
         *  sb.append(" Programming"); works because sb is final not immutable.
         *  Sb cannot point to another reference but we can update the value of the object.
         *  
         *  
         *  If class is declared as final, then child class cannot inherit it.
         *  
         *  
         */
    }
}

package RahulShettyAcademy.date_2026_11_06;

public class Step3_Child extends Q3_Step3_parent{

	 String department = "Development";

	    void display() {
	        System.out.println("Developer display");
	    }

	    void showDetails() {

	        // Complete your implementation here
	    	System.out.println(this.department);
	    	System.out.println(super.department);
	    	super.display();
	    	this.display();
	    	
	    	//This refers to the current class instance and super refers to parent class instance.
	    	// If child and parent have same name variable, then by default child objet will refer to child variable, but if we want to access parent class variable we can do it using parent class object or using super in child method.
	    }
	    
	    
	    public static void main(String[] args) {
			
	    	Step3_Child obj = new Step3_Child();
	    	obj.showDetails();
	    	
	
		}
}

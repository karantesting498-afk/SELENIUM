/*
 * Q3. Static vs Instance Variables – Output Prediction
(Hard)

Study the following code and complete the tasks.
public class Employee {

    int employeeId;
    String employeeName;
    static String companyName = "ABC";

    Employee(int id, String name) {
        employeeId = id;
        employeeName = name;
    }

    void display() {
        System.out.println(employeeId + " " + employeeName + " " + companyName);
    }

    static void changeCompany() {
        companyName = "XYZ";
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Karan");
        Employee e2 = new Employee(102, "Rahul");

        e1.display();
        e2.display();

        e1.companyName = "PQR";

        e1.display();
        e2.display();

        changeCompany();

        e1.display();
        e2.display();
    }
}

Requirements:
1. Predict the complete output before executing the code.
2. Explain why both objects share companyName.
3. Explain what happens when e1.companyName is modified.
4. Explain why accessing a static variable using an object reference is allowed but not recommended.
5. Modify the program to access the static variable using the class name.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q3_Step4 {
	
	/*
	 * 1. Output
	 * 
	 * 101 Karan ABC
	 * 102 Rahul ABC
	 * 101 Karan PQR
	 * 102 Rahul PQR
	 * 101 Karan XYZ
	 * 102 Rahul XYZ
	 * 
	 * 2. companyName is a static variable. It will be shared commonly with all the class objects.
	 * Make changes in it will reflect for all class objects.
	 * 
	 * 2. Why both objects share companyName: correct, add the reason. A static variable belongs to the class, not to any object. There is exactly one copy, stored once when the class is loaded, so e1 and e2 both read the same variable.
	 * Instance variables (employeeId, employeeName) get a separate copy per object.
	 * 
	 * 3. e1.companyName will modify the static companyName. changes in it will reflect for all class objects.
	 * 
	 * 3. What happens on e1.companyName = "PQR": correct, but make it more precise.
	 *  The compiler translates e1.companyName into Q3_Step4.companyName.
	 *   It does not create a copy for e1, and the object e1 is not even consulted. So it changes the one shared variable, and e2 sees PQR too.
	 * 
	 * 4. We can simply access static varibale using className.variableName.
	 * 

	 */
	
    int employeeId;
    String employeeName;
    static String companyName = "ABC";

    Q3_Step4(int id, String name) {
        employeeId = id;
        employeeName = name;
    }

    void display() {
        System.out.println(employeeId + " " + employeeName + " " + Q3_Step4.companyName);
    }

    static void changeCompany() {
    	Q3_Step4.companyName = "XYZ";
    }

    public static void main(String[] args) {

    	Q3_Step4 e1 = new Q3_Step4(101, "Karan");
    	Q3_Step4 e2 = new Q3_Step4(102, "Rahul");

        e1.display();
        e2.display();

        Q3_Step4.companyName = "PQR";

        e1.display();
        e2.display();

        changeCompany();

        e1.display();
        e2.display();
    }
}


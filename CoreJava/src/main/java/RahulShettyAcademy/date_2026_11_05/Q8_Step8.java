/*
 * Q7. Object References and Memory Behaviour
Hard
Predict the output of this program before executing it.
public class Employee {

    int employeeId;
    String employeeName;

    Employee(int id, String name) {
        employeeId = id;
        employeeName = name;
    }

    void display() {
        System.out.println(employeeId + " " + employeeName);
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Karan");

        Employee e2 = e1;

        e2.employeeName = "Rahul";

        e1.display();
        e2.display();

        e2 = new Employee(102, "Aman");

        e1.display();
        e2.display();
    }
}


Requirements:
1. Predict the complete output.
2. Explain what happens when e2 = e1.
3. Explain why changing e2.employeeName affects the output of e1.
4. Explain what happens after e2 = new Employee(102, "Aman").
5. Draw a simple reference diagram showing the objects and references at each stage.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q8_Step8 {

	int employeeId;
    String employeeName;

    Q8_Step8(int id, String name) {
        employeeId = id;
        employeeName = name;
    }

    void display() {
        System.out.println(employeeId + " " + employeeName);
    }

    public static void main(String[] args) {

    	Q8_Step8 e1 = new Q8_Step8(101, "Karan");

    	Q8_Step8 e2 = e1;

        e2.employeeName = "Rahul";

        e1.display();
        e2.display();

        e2 = new Q8_Step8(102, "Aman");

        e1.display();
        e2.display();
    }

    /*
     * 1. Output
     * 101 Rahul
     * 101 Rahul
     * 101 Rahul
     * 102 Aman
     * 
     * 
     * 2. e2=e1 , means e2 variable is not pointing towards refernece of e1. it receives a copy of refernce value stored in e1. Any changes using e2. will reflect for e1 also.
     * 
     * 3.Because e2 is pointing towards reference of e1.
     * 
     * 4. e2 will point towards new object.
     * 
     * 5. Stage 1: Q8_Step8 e1 = new Q8_Step8(101, "Karan");

  e1 ───────► [ Object A: 101, "Karan" ]


Stage 2: Q8_Step8 e2 = e1;

  e1 ───┐
        ├───► [ Object A: 101, "Karan" ]
  e2 ───┘


Stage 3: e2.employeeName = "Rahul";

  e1 ───┐
        ├───► [ Object A: 101, "Rahul" ]   (shared object changed)
  e2 ───┘


Stage 4: e2 = new Q8_Step8(102, "Aman");

  e1 ───────► [ Object A: 101, "Rahul" ]

  e2 ───────► [ Object B: 102, "Aman" ]
     * 
     */
}

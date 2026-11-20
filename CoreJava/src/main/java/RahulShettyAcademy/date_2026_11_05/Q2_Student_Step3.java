/*
 * Q2. Constructor Overloading and this Keyword
(Medium)

Create a Student class with:
- studentId
- studentName
- course
- fees
Requirements:
1. Create a no-argument constructor that initializes default values.
2. Create a constructor accepting studentId and studentName.
3. Create another constructor accepting all four variables.
4. Use this to differentiate instance variables from constructor parameters.
5. Use this() to call another constructor.
6. Create three objects using the three different constructors.
7. Create a method to display student details.
Important: Demonstrate constructor chaining correctly. Remember that this() must be the first statement in a constructor.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q2_Student_Step3 {
	
	int studentId;
	String  studentName;
	String course;
	int fees;
	
	public Q2_Student_Step3() {
		// TODO Auto-generated constructor stub
		this.studentId =1;
		this.studentName ="A";
		this.course ="Java";
		this.fees= 2001;
	}
	
	public Q2_Student_Step3(int studentId ,String  studentName ) {
		// TODO Auto-generated constructor stub
		this();
		this.studentId =studentId;
		this.studentName =studentName;
		

	}
	
	public Q2_Student_Step3(int studentId ,String  studentName , String course , int fees) {
		// TODO Auto-generated constructor stub
		this(studentId, studentName);
		this.course = course;
		this.fees = fees;

	}
	
	
	@Override
	public String toString() {
		return "Q2_Student_Step3 [studentId=" + studentId + ", studentName=" + studentName + ", course=" + course
				+ ", fees=" + fees + "]";
	}

	public static void main(String[] args) {
		Q2_Student_Step3 obj1 = new Q2_Student_Step3();
		
		Q2_Student_Step3 obj2 = new Q2_Student_Step3(2, "B");
		
		Q2_Student_Step3 obj3 = new Q2_Student_Step3(3, "C", "Python", 3001);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
	}
	
	

}

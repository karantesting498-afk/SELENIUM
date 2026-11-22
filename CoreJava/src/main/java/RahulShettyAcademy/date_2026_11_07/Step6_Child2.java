package RahulShettyAcademy.date_2026_11_07;

public class Step6_Child2 extends Q6_Step6_Parent{

	
	public void meow()
	{
		System.out.println("Cat meows");
	}


	public static void main(String[] args) {

		Q6_Step6_Parent parent = new Step6_Child1();
		
		parent.eat();
		
//		parent.bark();  Parent variable reference type is Q6_Step6_Parent but it holds the reference to the object of Step6_Child1. So variable can only access methods and variables of the  reference type  class. parent does not bark method so cannot access it.
		
		if(parent instanceof Step6_Child1)
		{
			Step6_Child1 dog = (Step6_Child1) parent;
			dog.bark();
		}
		
		
		
		
		Q6_Step6_Parent parent2 = new Step6_Child2();
		
		if(parent2 instanceof Step6_Child1)
		{
			Step6_Child1 dog2 = (Step6_Child1) parent2;
			System.out.println("Cat object has been  cast into dog");
		}
		
		else
		{
			System.out.println("Cat object cannot be cast into dog");
		}
		
	}










}


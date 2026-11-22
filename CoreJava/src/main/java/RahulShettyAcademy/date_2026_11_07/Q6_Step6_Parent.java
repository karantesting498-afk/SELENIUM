/*
 * Q6. Upcasting and Downcasting
(Hard) Runtime Polymorphism, Casting, instanceof

Create the following classes:
- Parent class: Animal
- Child classes: Dog and Cat
Methods:

Animal

- eat()

Dog

- bark()

Cat

- meow()

Requirements:
1. Create a Dog object and assign it to an Animal reference.
2. Call eat() using the parent reference.
3. Explain why bark() cannot be called directly using the parent reference.
4. Downcast the parent reference to Dog and call bark().
5. Create a Cat object and assign it to an Animal reference.
6. Try downcasting the Cat object to Dog.
7. Explain the runtime result.
8. Use instanceof to ensure that downcasting is safe.
Also explain the difference between upcasting and downcasting.
 */
package RahulShettyAcademy.date_2026_11_07;

public class Q6_Step6_Parent {
	
	public void eat()
	{
		System.out.println("Animal is eating.");
	}

}



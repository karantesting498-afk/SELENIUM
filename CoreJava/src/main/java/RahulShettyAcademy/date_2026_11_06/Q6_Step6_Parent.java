/*
 * Q6. Runtime Polymorphism and Dynamic Method Dispatch
Hard
Study the following program:
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void eat() {
        System.out.println("Dog eats");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal obj;

        obj = new Dog();
        obj.sound();

        obj = new Cat();
        obj.sound();

        obj = new Animal();
        obj.sound();
    }
}


Requirements:
1. Predict the complete output.
2. Explain the reference type and actual object type in each assignment.
3. Explain why the executed method changes.
4. Try calling obj.eat() and identify the result.
5. Explain dynamic method dispatch.
6. Explain whether runtime polymorphism is possible without method overriding.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q6_Step6_Parent {
	
	/*
	 * 1. Output
	 * Dog barks
	 * Cat meows
	 * Animal makes sound
	 * 
	 * 
	 * 2.  compile error in all three cases,
	 * 
	 *  First, obj = new Dog();
        obj.sound();
        
        Refrence obj is of Animal but it  is holding refernece to the dog object. It will call the methods of dog class.
        
        second,
        Refrence obj is of Animal but it  is holding refernece to the cat object. It will call the methods of cat class.
        
        third,
        Refrence obj is of Animal but it  is holding refernece to the animal object. It will call the methods of animal class.
        
        
        3. Execution method changes because reference the obj is holding is updating with new Cat(), new Dog();
        
        Your reason is “the reference is updating”, which is close. More precisely: sound() is overridden, 
        and Java chooses the version at runtime from the actual object’s class, not the reference type.
        
        4. if obj.eat() is called after         obj = new Animal();
        it will show error because parent class obj cannot access the child class methods.
        
        
        if obj.eat() is called after    obj = new Cat();
        it will display error because eat is the method of sibling class dog not of class cat.
        
        
         if obj.eat() is called after  obj = new Dog();
         it will displayed  Dog eats = wrong will not work.
         
         we need ((Dog) obj).eat();
         
         
         5. Dynamic dispatch method means, We are using parent class variable which holds the reference of child class object
         
         Your sentence only describes the setup (parent reference holding a child object). The definition is: 
         
         the JVM decides at runtime which overridden method to run, based on the actual object the reference points to, 
         
         not on the reference type.
         
         6. Not possible. 
         with no overriding, every class would inherit the same method body, so a parent reference always
         
          gives the same behaviour and there is nothing to choose at runtime.
          
          (Overloading is resolved at compile time, and variables and static methods are never dispatched dynamically.)
	 */

}

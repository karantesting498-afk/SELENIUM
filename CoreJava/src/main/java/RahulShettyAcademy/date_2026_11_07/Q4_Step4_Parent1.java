/*
 * Q4. Multiple Inheritance Through Interfaces
(Hard) Interfaces, Multiple Inheritance, Default Methods

Create two interfaces:

Camera
- Abstract method: takePhoto().
- Default method: deviceInfo() which prints "Camera Device".
MusicPlayer
- Abstract method: playMusic().
- Default method: deviceInfo() which prints "Music Player Device".
Create a class Smartphone that implements both interfaces.

Requirements:
1. Implement both abstract methods.
2. Resolve the conflict between the two deviceInfo() default methods.
3. Inside the overridden deviceInfo() method, call both interface implementations using Camera.super.deviceInfo() and MusicPlayer.super.deviceInfo().
4. Add your own message: "Smartphone supports multiple features".
5. Create a Smartphone object and call all three methods.
Also explain why Java allows this through interfaces but does not allow a class to extend two classes.
 */
package RahulShettyAcademy.date_2026_11_07;

public interface Q4_Step4_Parent1 {
	
	public abstract void takePhoto();
	
	default public void deviceInfo()
	{
		System.out.println("Camera Device");
	}

}



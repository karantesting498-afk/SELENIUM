package RahulShettyAcademy.date_2026_11_07;

public class Step4_Child1 implements Q4_Step4_Parent1 , Step4_Parent2{

	
	@Override
	public void takePhoto() {
		// TODO Auto-generated method stub
		System.out.println("Take photo");
	}
	
	@Override
	public void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("Play music");
	}
	
	public void deviceInfo()
	{
		Q4_Step4_Parent1.super.deviceInfo();
		Step4_Parent2.super.deviceInfo();
		
		System.out.println("Smartphone supports multiple features");
		
	}
	
	public static void main(String[] args) {
		
		Step4_Child1 o = new Step4_Child1();
		
		o.takePhoto();
		o.playMusic();
		o.deviceInfo();
	}
}

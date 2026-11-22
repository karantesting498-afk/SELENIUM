package RahulShettyAcademy.date_2026_11_07;

public interface Step4_Parent2 {
	
	public abstract void playMusic();
	
	default public void deviceInfo()
	{
		System.out.println("Music Player Device");
	}

}

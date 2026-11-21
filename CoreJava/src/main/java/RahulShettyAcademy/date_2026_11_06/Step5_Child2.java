package RahulShettyAcademy.date_2026_11_06;

public class Step5_Child2 extends Q5_Step5_Parent{

	//HDFC
	
	int interentRate = 7;
	int principle = 5000;
	int time = 5;
	
	@Override
	public int calculateInterest() {
		// TODO Auto-generated method stub
		return interentRate*principle*time;
	}
}


package test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day6 {
	
	@Parameters({"password", "AdminAccount"})
	@Test
	public void login(String name,@Optional("Hello password is optional") String account)
	{
		System.out.println(name);
		System.out.println(account);
	}

}

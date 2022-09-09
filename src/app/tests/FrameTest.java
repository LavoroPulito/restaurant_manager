package app.tests;

import app.frontend.windows.*;

public class FrameTest {
	public static boolean test()
{		System.out.println("Open window test");
		try{
			ChefFrame frame = new ChefFrame();
			frame.setVisible(true);
			frame.dispose();

			CookFrame frame1 = new CookFrame();
			frame1.setVisible(true);
			frame1.dispose();

			WaiterFrame frame2 = new WaiterFrame();
			frame2.setVisible(true);
			frame2.dispose();

			CashFrame frame3 = new CashFrame();
			frame3.setVisible(true);
			frame3.dispose();

			System.out.println("Test passed\n");
			return true;
		}catch(Exception e){
			System.out.println("Test failed\n");
			return false;
		}
		
	}
}

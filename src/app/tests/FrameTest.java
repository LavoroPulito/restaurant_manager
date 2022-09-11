package app.tests;

import app.frontend.windows.*;
/**
 * it tries to open all the frames and returns false in case there are errors
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class FrameTest {
	public static boolean test()
{		System.out.println("Open window test");
		try{
			ChefFrame frame = new ChefFrame();
			frame.dispose();

			CookFrame frame1 = new CookFrame();
			frame1.dispose();

			WaiterFrame frame2 = new WaiterFrame();
			frame2.dispose();

			CashFrame frame3 = new CashFrame();
			frame3.dispose();

			System.out.println("Test passed\n");
			return true;
		}catch(Exception e){
			System.out.println("Test failed\n");
			return false;
		}
		
	}
}

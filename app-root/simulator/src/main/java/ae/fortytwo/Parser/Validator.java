package ae.fortytwo.Parser;


public class Validator
{
	public int validateSimulations(String simulations) {
		int simulationsInt = -1;
		try {
			simulationsInt = Integer.parseInt(simulations);
			if (simulationsInt < 1) {
				// ! throw an exception here
				System.out.println("Error ! The simulations string should be positive number");
			}
		}
		catch (Exception e) {
			System.out.println("Error ! The simulations string is not int" + e.getMessage());
			e.printStackTrace();
		}
		return simulationsInt;
	}


}
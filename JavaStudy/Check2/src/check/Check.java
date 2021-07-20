package check;
import constants.Constants;



public class Check {
	

	private static String firstname = "佐藤";
	private static String lastname = "徳政";
	
	private static String printName(String firstname, String lastname) {
		return firstname + lastname;
	}

	public static void main(String[] args) {
	System.out.println("printNameメソッド → " + printName(firstname,lastname));


		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,  Constants.CHECK_CLASS_HOGE);
		pet.introduce();

		RobotPet robotPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		robotPet.introduce();
	}
		
		
		
}
	
	
		
		





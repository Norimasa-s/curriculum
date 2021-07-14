package check;
import constants.Constants;



public class Check {
	
	//メソッドや変数に付けることによって、
	//staticはインスタンス化しなくても、クラスから直接メソッドや変数にアクセスすることができるようになる。
	//↓フィールド変数を定義して、他のところでも使えるようになるため。
	private static String firstname = "佐藤";
	private static String lastname = "徳政";
	//課題②
	//【Check.java】にてfirstNameとlastNameを引数で受け取って、
	//連結して表示させるメソッド「printName」を作成しなさい。
	///作成した関数のアクセス修飾子は「private」とする。
	private static String printName(String firstname, String lastname) {
		return firstname + lastname;
	}

	public static void main(String[] args) {
	System.out.println("printNameメソッド → " + printName(firstname,lastname));

		//課題③
		//【Check.java】にてPetクラスとRobotPetクラスをインスタンス化して、下記の完成イメージを出力させなさい。
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,  Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		
		RobotPet robotPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		robotPet.introduce();
	}
		
		
		
}
	
	
		
		





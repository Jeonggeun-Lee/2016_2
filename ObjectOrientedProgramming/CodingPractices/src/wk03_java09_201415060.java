/**
wk03_java09_201415060 클래스는 컴퓨터와 사용자가 가위바위보를 하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
/**무작위 수를 위한 랜덤 클래스 수입*/
import java.util.Random;

public class wk03_java09_201415060 {

	/**
	main 함수는 사용자에게 가위, 바위, 보 중 하나를 입력받고 컴퓨터의 가위, 바위, 보를 랜덤으로 결정한 후 승, 패, 비김을 결정합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**무작위 수를 뽑기 위한 랜덤 객체 생성*/
		Random generator = new Random();
		/**무작위 수를 저장하는 변수*/
		int temp;
		/**컴퓨터와 사용자의 가위, 바위, 보 문자열에 대한 참조*/
		String com = "", user;
		
		/**사용자에 가위, 바위, 보 입력 지시*/
		System.out.print("Select word(\"scissors\", \"rock\", \"paper\"): ");
		/**사용자 가위, 바위, 보 입력*/
		user = scan.next();
		
		/**0,1,2 중 무작위로 수 뽑기*/
		temp = generator.nextInt(3);
		/**뽑은 수가 0이면 컴퓨터는 가위를 냄*/
		if(temp == 0) {com = "scissors";}
		/**뽑은 수가 1이면 컴퓨터는 바위를 냄*/
		else if(temp == 1) {com = "rock";}
		/**뽑은 수가 2이면 컴퓨터는 보를 냄*/
		else if(temp == 2) {com = "paper";}
		
		/**컴퓨터와 사용자의 가위, 바위, 보 값을 출력*/
		System.out.println("com(" + com + ") & player(" + user + ")" );
		
		/**컴퓨터와 사용자의 값이 같으면 비김*/
		if(user.equals(com)){ System.out.println("draw."); }
		/**사용자가 이기는 경우 you win. 출력*/
		else if( (user.equals("scissors") && com.equals("paper"))
				|| (user.equals("rock") && com.equals("scissors"))
				|| (user.equals("paper") && com.equals("rock") ) )
		{ System.out.println("you win."); }
		/**사용자가 지는 경우 you lose. 출력*/
		else { System.out.println("you lose."); }		 

	}

}

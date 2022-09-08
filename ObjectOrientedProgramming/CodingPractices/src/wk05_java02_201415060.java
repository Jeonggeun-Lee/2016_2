
/**
Account 클래스는
계좌를 정보를 표현
하는 클래스 입니다.
속성으로 이름, 계좌번호, 잔고,
메소드로 모든 속성을 초기화하는 생성자, 입금, 출급, 이자 증가, 잔고조회, 형식을 준 계좌 정보 문자열 반환
이 있습니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**통화 표시를 위한 숫자 형식 클래스 도입*/
import java.text.NumberFormat;



class Account
{
	/**전용 고 정밀 소수 이자율 상수 선언과 초기화*/
	private final double RATE = 0.035;
	
	/**전용 이름 문자열 참조 선언*/
	private String name;
	/**전용 긴 정수 계좌번호 변수 선언*/
	private long acctNumber;
	/**전용 고 정밀 소수 잔액 변수 선언*/
	private double balance;
	
	/**공용 계좌 클래스 생성자. 매개변수로 소유자 이름 문자열, 긴 정수 계좌번호, 고 정밀 잔고 초기값*/
	public Account(String owner, long account, double initial)
	{
		/**이름 변수가 소유자 참조*/
		name = owner;
		/**계좌 변수에 계좌 번호 저장*/
		acctNumber = account;
		/**잔고 변수에 초기값 저장*/
		balance = initial;
	}
	
	/**공용 입금 메소드. 매개변수로 고 정밀 입금액. 반환값으로 고 정밀 입금 후 잔고*/
	public double deposit(double amount)
	{
		/**입금액이 양수일 때*/
		if(amount > 0)
			/**잔고에 입금액을 더 함*/
			balance = balance + amount;
		/**잔고 반환*/
		return balance;
	}
	
	/**공용 인출 메소드. 매개변수로 고 정밀 출금액, 고 정밀 수수료. 반환갑으로 고정밀 인출 후 잔고*/
	public double withdraw(double amount, double fee)
	{
		/**출금액과 수수료 합이 양수이고 잔고보다 작을 때*/
		if(amount + fee > 0 && amount + fee < balance)
			/**잔고에서 인출액과 수수료를 뺌*/
			balance = balance - amount - fee;
		/**인출 후 잔고 반환*/
		return balance;
	}
	
	/**이자 증가 공용 메소드. 이자 증가 후 잔고값 반환*/
	public double addInterest()
	{
		/**잔고에 이자 더함*/
		balance += (balance * RATE);
		/**잔고 반환*/
		return balance;
	}
	
	/**잔고 조회 공용 메소드. 잔고값 반환*/
	public double getBalance()
	{
		/**잔고값 반환*/
		return balance;
	}
	
	/**형식을 준 계좌 정보 문자열 반환 공요 메소드*/
	public String toString()
	{
		/**통화 숫자 형식 객체 생성*/
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		/**계좌번호, 예금주이름, 통화형식의 잔고 문자열 반환*/
		return (acctNumber + "\t"+ name + "\t" +fmt.format(balance) );

	}
}

/**
wk05_java02_201415060 클래스는 
계좌 객체 3개를 생성하고 초기화하고
입금, 출금 뒤 각각 잔액을 조회하고
다시 이자를 지급하고 각 사람의 계좌 정보를 형식을 갖춰 출력
하기 위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java02_201415060 {
	/**
	main 함수는
	계좌 객체 3개를 생성하고 초기화한 뒤
	입금, 출금 뒤 각각 잔액을 조회하고
	다시 이자를 지급하고 각 사람의 계좌 정보를 형식을 갖춰 출력
	합니다.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main(String[] args) {
		/**제 1 계좌 생성과 초기화*/
		Account acct1 = new Account("Ted Murphy", 72354, 25.59);
		/**제 2 계좌 생성과 초기화*/
		Account acct2 = new Account("Angelica Adams", 69713, 500.00);
		/**제 3 계좌 생성과 초기화*/
		Account acct3 = new Account("Edward Demsey", 93757, 769.32);
		
		/**제 1 계좌 입금*/
		acct1.deposit(44.10);
		/**제 2 계좌 입금 후 잔고 저장*/
		double adamsBalance = acct2.deposit(75.25);
		/**제 2 계좌 입금 후 잔고 출력*/
		System.out.println("Adams balance after deposit = " + adamsBalance);
		/**제 2 계좌 출금 후 잔고 출력*/
		System.out.println("Adams balance after withdrawal = " + acct2.withdraw(480, 1.50));
		
		/**제 3 계좌 출금. 매개변수가 범위를 벗어나므로 잔고 변화 없음*/
		acct3.withdraw(-100.00, 1.50);
		
		/**제 1 계좌 이자 증가*/
		acct1.addInterest();
		/**제 2 계좌 이자 증가*/
		acct2.addInterest();
		/**제 3 계좌 이자 증가*/
		acct3.addInterest();
		
		/**한 줄 간격*/
		System.out.println();
		/**제 1 계좌 정보 출력*/
		System.out.println(acct1);
		/**제 2 계좌 정보 출력*/
		System.out.println(acct2);
		/**제 3 계좌 정보 출력*/
		System.out.println(acct3);
	}
}
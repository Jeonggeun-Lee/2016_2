
/**
Account Ŭ������
���¸� ������ ǥ��
�ϴ� Ŭ���� �Դϴ�.
�Ӽ����� �̸�, ���¹�ȣ, �ܰ�,
�޼ҵ�� ��� �Ӽ��� �ʱ�ȭ�ϴ� ������, �Ա�, ���, ���� ����, �ܰ���ȸ, ������ �� ���� ���� ���ڿ� ��ȯ
�� �ֽ��ϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**��ȭ ǥ�ø� ���� ���� ���� Ŭ���� ����*/
import java.text.NumberFormat;



class Account
{
	/**���� �� ���� �Ҽ� ������ ��� ����� �ʱ�ȭ*/
	private final double RATE = 0.035;
	
	/**���� �̸� ���ڿ� ���� ����*/
	private String name;
	/**���� �� ���� ���¹�ȣ ���� ����*/
	private long acctNumber;
	/**���� �� ���� �Ҽ� �ܾ� ���� ����*/
	private double balance;
	
	/**���� ���� Ŭ���� ������. �Ű������� ������ �̸� ���ڿ�, �� ���� ���¹�ȣ, �� ���� �ܰ� �ʱⰪ*/
	public Account(String owner, long account, double initial)
	{
		/**�̸� ������ ������ ����*/
		name = owner;
		/**���� ������ ���� ��ȣ ����*/
		acctNumber = account;
		/**�ܰ� ������ �ʱⰪ ����*/
		balance = initial;
	}
	
	/**���� �Ա� �޼ҵ�. �Ű������� �� ���� �Աݾ�. ��ȯ������ �� ���� �Ա� �� �ܰ�*/
	public double deposit(double amount)
	{
		/**�Աݾ��� ����� ��*/
		if(amount > 0)
			/**�ܰ� �Աݾ��� �� ��*/
			balance = balance + amount;
		/**�ܰ� ��ȯ*/
		return balance;
	}
	
	/**���� ���� �޼ҵ�. �Ű������� �� ���� ��ݾ�, �� ���� ������. ��ȯ������ ������ ���� �� �ܰ�*/
	public double withdraw(double amount, double fee)
	{
		/**��ݾװ� ������ ���� ����̰� �ܰ��� ���� ��*/
		if(amount + fee > 0 && amount + fee < balance)
			/**�ܰ��� ����װ� �����Ḧ ��*/
			balance = balance - amount - fee;
		/**���� �� �ܰ� ��ȯ*/
		return balance;
	}
	
	/**���� ���� ���� �޼ҵ�. ���� ���� �� �ܰ� ��ȯ*/
	public double addInterest()
	{
		/**�ܰ� ���� ����*/
		balance += (balance * RATE);
		/**�ܰ� ��ȯ*/
		return balance;
	}
	
	/**�ܰ� ��ȸ ���� �޼ҵ�. �ܰ� ��ȯ*/
	public double getBalance()
	{
		/**�ܰ� ��ȯ*/
		return balance;
	}
	
	/**������ �� ���� ���� ���ڿ� ��ȯ ���� �޼ҵ�*/
	public String toString()
	{
		/**��ȭ ���� ���� ��ü ����*/
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		/**���¹�ȣ, �������̸�, ��ȭ������ �ܰ� ���ڿ� ��ȯ*/
		return (acctNumber + "\t"+ name + "\t" +fmt.format(balance) );

	}
}

/**
wk05_java02_201415060 Ŭ������ 
���� ��ü 3���� �����ϰ� �ʱ�ȭ�ϰ�
�Ա�, ��� �� ���� �ܾ��� ��ȸ�ϰ�
�ٽ� ���ڸ� �����ϰ� �� ����� ���� ������ ������ ���� ���
�ϱ� ���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java02_201415060 {
	/**
	main �Լ���
	���� ��ü 3���� �����ϰ� �ʱ�ȭ�� ��
	�Ա�, ��� �� ���� �ܾ��� ��ȸ�ϰ�
	�ٽ� ���ڸ� �����ϰ� �� ����� ���� ������ ������ ���� ���
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main(String[] args) {
		/**�� 1 ���� ������ �ʱ�ȭ*/
		Account acct1 = new Account("Ted Murphy", 72354, 25.59);
		/**�� 2 ���� ������ �ʱ�ȭ*/
		Account acct2 = new Account("Angelica Adams", 69713, 500.00);
		/**�� 3 ���� ������ �ʱ�ȭ*/
		Account acct3 = new Account("Edward Demsey", 93757, 769.32);
		
		/**�� 1 ���� �Ա�*/
		acct1.deposit(44.10);
		/**�� 2 ���� �Ա� �� �ܰ� ����*/
		double adamsBalance = acct2.deposit(75.25);
		/**�� 2 ���� �Ա� �� �ܰ� ���*/
		System.out.println("Adams balance after deposit = " + adamsBalance);
		/**�� 2 ���� ��� �� �ܰ� ���*/
		System.out.println("Adams balance after withdrawal = " + acct2.withdraw(480, 1.50));
		
		/**�� 3 ���� ���. �Ű������� ������ ����Ƿ� �ܰ� ��ȭ ����*/
		acct3.withdraw(-100.00, 1.50);
		
		/**�� 1 ���� ���� ����*/
		acct1.addInterest();
		/**�� 2 ���� ���� ����*/
		acct2.addInterest();
		/**�� 3 ���� ���� ����*/
		acct3.addInterest();
		
		/**�� �� ����*/
		System.out.println();
		/**�� 1 ���� ���� ���*/
		System.out.println(acct1);
		/**�� 2 ���� ���� ���*/
		System.out.println(acct2);
		/**�� 3 ���� ���� ���*/
		System.out.println(acct3);
	}
}
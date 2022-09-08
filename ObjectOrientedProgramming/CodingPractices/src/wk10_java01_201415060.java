/**
wk10_java01_201415060 Ŭ������  
������� �������� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**Staff Ŭ������ � ����� �λ��� �� ������ ǥ���մϴ�.*/
class Staff
{
   private StaffMember[] staffList;
   
   /**������ �迭�� ����� ������*/
   public Staff ()
   {
      staffList = new StaffMember[6];

      staffList[0] = new Executive ("Tony", "123 Main Line", "555-0469", "123-45-6789", 2423.07);

      staffList[1] = new Employee ("Paulie", "456 Off Line", "555-0101", "987-65-4321", 1246.15);
      staffList[2] = new Employee ("Vito", "789 Off Rocker", "555-0000", "010-20-3040", 1169.23);

      staffList[3] = new Hourly ("Michael", "678 Fifth Ave.", "555-0690", "958-47-3625", 10.55);

      staffList[4] = new Volunteer ("Adrianna", "987 Babe Blvd.", "555-8374");
      staffList[5] = new Volunteer ("Benny", "321 Dud Lane", "555-7282");

      ((Executive)staffList[0]).awardBonus (500.00);

      ((Hourly)staffList[3]).addHours (40);
   }
   
   /**��� �������� �ӱ� ����*/
   public void payday ()
   {
      double amount;

      for (int count=0; count < staffList.length; count++)
      {
         System.out.println (staffList[count]);
         
         /**�������� �޼ҵ�*/
         amount = staffList[count].pay();

         if (amount == 0.0)
            System.out.println ("Thanks!");
         else
            System.out.println ("Paid = " + amount);

         System.out.println ("-----------------------------------");
      }
   }
}

/**StaffMember Ŭ������ �Ϲ��� ������ ǥ���մϴ�.*/
abstract class StaffMember
{
	protected String name;
	protected String address;
	protected String phone;
	
	/**Ư�� ������ ����� ������ ����� ������*/
	public StaffMember (String eName, String eAddress, String ePhone)
	{
		name = eName;
		address = eAddress;
		phone = ePhone;
	}
	
	/**�⺻���� ��� ������ ������ ���ڿ��� ��ȯ*/
	public String toString()
	{
		String result = "Name = " + name + "\n";

		result += "Address = " + address + "\n";
		result += "Phone = " + phone;

		return result;
	}
	
	/**����� �� ���¿� ���� �Ļ� Ŭ������ pay �޼ҵ带 �����ؾ� ��*/
	public abstract double pay();
}

/**EmployeeŬ������ �Ϲ����� �ӱ� ����ڸ� ǥ���մϴ�.*/
class Employee extends StaffMember
{
	protected String socialSecurityNumber;
	protected double payRate;
	
	/**�ӱ� ����ڸ� Ư�� ������ ������ �����ϴ� ������*/
	public Employee (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone);

		socialSecurityNumber = socSecNumber;
		payRate = rate;
	}
	
	/**�ӱ� ������� ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�*/
	public String toString()
	{
		String result = super.toString();

		result += "\nSocial Security Number = " + socialSecurityNumber;

		return result;
	}

	/**�ӱ� ������� �ӱݾ�*/
	public double pay()
	{
		return payRate;
	}
}

/**Executive Ŭ������ �ӿ��� ǥ���ϰ� �ӿ��� ���ʽ��� �޽��ϴ�.*/
class Executive extends Employee
{
	private double bonus;
	
/**�ӿ��� Ư�� ������ ����� ������*/
	public Executive (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);
		/**���ʽ��� ���� ������� ����*/
		bonus = 0;
	}

	/**�� �ӿ����� ��ü���� ���ʽ��� �����ϴ� �޼ҵ�*/
	public void awardBonus (double execBonus)
	{
		bonus = execBonus;
	}

	/**�ӿ��� �ӱ��� ����ϰ� ��ȯ�ϴ� �޼ҵ�. �ӱ��� ��Ģ�� ����ӱݿ� 1ȸ�� ���ʽ��� ����*/
	public double pay()
	{
		double payment = super.pay() + bonus;

		bonus = 0;

		return payment;
	}
}

/**Hourly�� �ñ��� �޴� ������ ǥ���մϴ�.*/
class Hourly extends Employee
{
	private int hoursWorked;
	
	/**Ư�� ������ �ñ��� �޴� ������ ����� ������*/
	public Hourly (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);

		hoursWorked = 0;
	}
	
	/**�ñ� �޴� ������ ���� �ð���  �ʰ� �ٹ� �ð��� ����*/
	public void addHours (int moreHours)
	{
		hoursWorked += moreHours;
	}
	
	/**�� �ñ� �޴� ������ �ӱ��� ����ϰ� ��ȯ�ϴ� �޼ҵ�*/
	public double pay()
	{
		double payment = payRate * hoursWorked;

		hoursWorked = 0;

		return payment;
	}
	
	/**�ñ� �޴� ������ ���� ������ ��ȯ*/
	public String toString()
	{
		String result = super.toString();

		result += "\nCurrent hours = " + hoursWorked;

		return result;
	}
}

/**VolunteerŬ������ �ڿ������ ���ϴ� ������ ǥ��*/
class Volunteer extends StaffMember
{
	/**�ڿ������ڸ� Ư�������� ����� ������*/
	public Volunteer (String eName, String eAddress, String ePhone)
	{
		super (eName, eAddress, ePhone);
	}
	
	/**�ڿ������ڿ��� 0���� ����*/
	public double pay()
	{
		return 0.0;
	}
}

public class wk10_java01_201415060
{
	/**
	main �Լ���
	ȸ���� ��� ������ �����ϰ� �׵鿡�� �ӱ��� ��
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
   
   public static void main (String[] args)
   {
      Staff personnel = new Staff();

      personnel.payday();
   }
}

/**
wk10_java01_201415060 클래스는  
상속으로 다형성을 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**Staff 클래스는 어떤 사업의 인사기록 상 직원을 표현합니다.*/
class Staff
{
   private StaffMember[] staffList;
   
   /**직원의 배열을 만드는 생성자*/
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
   
   /**모든 직원에게 임금 지급*/
   public void payday ()
   {
      double amount;

      for (int count=0; count < staffList.length; count++)
      {
         System.out.println (staffList[count]);
         
         /**다형적인 메소드*/
         amount = staffList[count].pay();

         if (amount == 0.0)
            System.out.println ("Thanks!");
         else
            System.out.println ("Paid = " + amount);

         System.out.println ("-----------------------------------");
      }
   }
}

/**StaffMember 클래스는 일반적 직원을 표현합니다.*/
abstract class StaffMember
{
	protected String name;
	protected String address;
	protected String phone;
	
	/**특정 정보를 사용해 직원을 만드는 생성자*/
	public StaffMember (String eName, String eAddress, String ePhone)
	{
		name = eName;
		address = eAddress;
		phone = ePhone;
	}
	
	/**기본적인 고용 정보를 포함한 문자열을 반환*/
	public String toString()
	{
		String result = "Name = " + name + "\n";

		result += "Address = " + address + "\n";
		result += "Phone = " + phone;

		return result;
	}
	
	/**고용의 각 형태에 따라 파생 클래스는 pay 메소드를 정의해야 함*/
	public abstract double pay();
}

/**Employee클래스는 일반적인 임금 고용자를 표현합니다.*/
class Employee extends StaffMember
{
	protected String socialSecurityNumber;
	protected double payRate;
	
	/**임금 고용자를 특정 정보를 가지고 설정하는 생성자*/
	public Employee (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone);

		socialSecurityNumber = socSecNumber;
		payRate = rate;
	}
	
	/**임금 고용자의 정보를 문자열로 반환하는 메소드*/
	public String toString()
	{
		String result = super.toString();

		result += "\nSocial Security Number = " + socialSecurityNumber;

		return result;
	}

	/**임금 고용자의 임금액*/
	public double pay()
	{
		return payRate;
	}
}

/**Executive 클래스는 임원을 표현하고 임원은 보너스를 받습니다.*/
class Executive extends Employee
{
	private double bonus;
	
/**임원을 특정 정보로 만드는 생성자*/
	public Executive (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);
		/**보너스가 아직 보상되지 않음*/
		bonus = 0;
	}

	/**이 임원에게 구체적인 보너스를 보상하는 메소드*/
	public void awardBonus (double execBonus)
	{
		bonus = execBonus;
	}

	/**임원의 임금을 계산하고 반환하는 메소드. 임금은 규칙적 고용임금에 1회의 보너스를 더함*/
	public double pay()
	{
		double payment = super.pay() + bonus;

		bonus = 0;

		return payment;
	}
}

/**Hourly는 시급을 받는 직원을 표현합니다.*/
class Hourly extends Employee
{
	private int hoursWorked;
	
	/**특정 정도로 시급을 받는 직원을 만드는 생성자*/
	public Hourly (String eName, String eAddress, String ePhone, String socSecNumber, double rate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);

		hoursWorked = 0;
	}
	
	/**시급 받는 직원의 누적 시간에  초과 근무 시간을 더함*/
	public void addHours (int moreHours)
	{
		hoursWorked += moreHours;
	}
	
	/**이 시급 받는 직원의 임금을 계산하고 반환하는 메소드*/
	public double pay()
	{
		double payment = payRate * hoursWorked;

		hoursWorked = 0;

		return payment;
	}
	
	/**시급 받는 직원에 대한 정보를 반환*/
	public String toString()
	{
		String result = super.toString();

		result += "\nCurrent hours = " + hoursWorked;

		return result;
	}
}

/**Volunteer클래스는 자원봉사로 일하는 직원을 표현*/
class Volunteer extends StaffMember
{
	/**자원봉사자를 특정정보로 만드는 생성자*/
	public Volunteer (String eName, String eAddress, String ePhone)
	{
		super (eName, eAddress, ePhone);
	}
	
	/**자원봉사자에게 0원을 지불*/
	public double pay()
	{
		return 0.0;
	}
}

public class wk10_java01_201415060
{
	/**
	main 함수는
	회사의 고용 직원을 생성하고 그들에게 임금을 줍
	니다.
	@param args: the command line arguments
	@return void
	*/
   
   public static void main (String[] args)
   {
      Staff personnel = new Staff();

      personnel.payday();
   }
}

/**
RationalNumber Ŭ������
�������� ǥ��
�ϴ� Ŭ�����Դϴ�.
�������� ���ڿ� �и� �Ӽ����� ����,
�� �������� �ٸ� �������� ���ϰ� ���� ���ϰ� ������,
�� �������� ������ ���ϴ� �޼ҵ带 �����ϴ�.
�����ڿ� �ٸ� ���������� �� �޼ҵ嵵 ������
�������� ����� ���� �ּҰ������ ���ϴ� �޼ҵ嵵 �����ϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

class RationalNumber
{
	/**���ڿ� �и� ���� ���� ����*/
	private int numerator, denominator;
	
	/**������ ��ü ������ ���� �޼ҵ�. �Ű������� ����, �и� ����*/
	public RationalNumber(int numer, int denom)
	{
		/**�и� 0�̸�*/
		if(denom == 0)
			/**�и� 1�� ����*/
			denom = 1;
		
		/**�и� ������*/
		if(denom < 0)
		{
			/**������ ��ȣ�� �ٲٰ�*/
			numer = numer * -1;
			/**�и��� ��ȣ�� ����� �ٲ�*/
			denom = denom * -1;
		}
		
		/**���� ����*/
		numerator = numer;
		/**�и� ����*/
		denominator = denom;
		
		/**�и� ���� ���*/
		reduce();
	}
	
	/**���ڰ� ��ȯ ���� �޼ҵ�*/
	public int getNumerator()
	{
		/***/
		return numerator;
	}
	
	/**�и� ��ȯ ���� �޼ҵ�*/
	public int getDenominator()
	{
		/***/
		return denominator;
	}
	
	/**���� ��ȯ ���� �޼ҵ�*/
	public RationalNumber reciprocal()
	{
		/**�и�� ���ڸ� ���� �ٲ� �� ������ ��ü�� ������ ��ȯ*/
		return new RationalNumber( denominator, numerator);
	}
	
	/**������ ���ϱ� ���� �޼ҵ�. �Ű������� ���� ������. ���� ��� ������ ��ȯ*/
	public RationalNumber add(RationalNumber op2)
	{
		/**�� �������� �и� ���*/
		int commonDenominator = denominator * op2.getDenominator();
		/**�� 1 ���ڿ� �� 2 �и� ��*/
		int numerator1 = numerator * op2.getDenominator();
		/**�� 1 �и� �� 2 ���ڸ� ��*/
		int numerator2 = op2.getNumerator() * denominator;
		/**������ ��*/
		int sum = numerator1 + numerator2;
		
		/**���� ���ڷ� ��а��� �и�� �� ������ ������ ��ȯ*/
		return new RationalNumber(sum, commonDenominator);
	}
	
	/**������ ���� ���� �޼ҵ�. �Ű������� �� ������. �� ��� ������ ��ȯ*/
	public RationalNumber subtract(RationalNumber op2)
	{
		/**�� �������� �и� ���*/
		int commonDenominator = denominator * op2.getDenominator();
		/**�� 1 ���ڿ� �� 2 �и� ��*/
		int numerator1 = numerator * op2.getDenominator();
		/**�� 1 �и� �� 2 ���ڸ� ��*/
		int numerator2 = op2.getNumerator() * denominator;
		/**������ ��*/
		int difference = numerator1 - numerator2;
		
		/**������ ���� ���ڷ� ��� ���� �и��*/
		return new RationalNumber(difference, commonDenominator);
	}
	
	/**������ �� ���� �޼ҵ�. �Ű������� ���� ������. ��ȯ������ ���� ��� ������*/
	public RationalNumber multiply(RationalNumber op2)
	{
		/**���ڳ��� ��*/
		int numer = numerator * op2.getNumerator();
		/**�и𳢸� ��*/
		int denom = denominator * op2.getDenominator();
		/**�� ���� �ٽ� ���ڿ� �и�� �ؼ� ������ ���� �� ��ȯ*/
		return new RationalNumber(numer, denom);
	}
	
	/**������ ������ ���� �޼ҵ�. �Ű������� ���� ������. ��ȯ������ ���� ��� ������*/
	public RationalNumber divide(RationalNumber op2)
	{
		/**���� �������� ������ ����*/
		return multiply(op2.reciprocal());
	}
	
	/**�ٸ� �������� ���ϴ� ���� �޼ҵ� ������ �� ��ȯ*/
	public boolean isLike(RationalNumber op2)
	{
		/**���ڰ� ���� �и� ������ �� ��ȯ*/
		return ( numerator == op2.getNumerator() &&
				denominator == op2.getDenominator() );
	}
	
	/**������ ������ ������ ���� ���ڿ��� ��ȯ�ϴ� ���� �޼ҵ�*/
	public String toString()
	{
		/**��ȯ�� ���ڿ��� ������ ���� ����*/
		String result;
		
		/**���ڰ� 0 �̸� "0" ��ȯ*/
		if(numerator == 0)
			/***/
			result = "0";
		/**���ڰ� 0�� �ƴϸ�*/
		else
			/**�и� 1�̸�*/
			if(denominator == 1)
				/**���ڸ� ���ڿ��� ��ȯ*/
				result = numerator + "";
			/**�и� 1�� �ƴϸ�*/
			else
				/**���� "/" �и� �������� ���ڿ� ��ȯ*/
				result = numerator + "/" + denominator;
		
		/**�� ��쿡 ����� ���ڿ� ���� ��ȯ*/
		return result;
	}
	
	/**���ڿ� �и� ��� ���� �޼ҵ�*/
	private void reduce()
	{
		/**���ڰ� 0�� �ƴϸ�*/
		if(numerator !=0)
		{
			/**������ ���񰪰� �и��� �ִ������� ���Ͽ� ����*/
			int common = gcd( Math.abs(numerator),denominator );
			
			/**�ִ������� ���� ����*/
			numerator = numerator / common;
			/**�ִ������� �и� ����*/
			denominator = denominator / common;
		}
	}
	
	/**������ Ŭ���� �ȿ����� �ִ� ������� ���ϴ� ���� �޼ҵ�. �Ű������� �� ����. ��ȯ������ �� ������ �ִ�����*/
	private int gcd( int num1, int num2 )
	{
		/**�� ������ �ٸ� ����*/
		while( num1 != num2)
			/**�� 1 ������ �� 2 �������� ũ��*/
			if( num1 > num2 )
				/**�� 1 �������� �� 2 ���� ��*/
				num1 = num1 - num2;
			/**�� 1 ������ �� 2 �������� ������*/
			else
				/**�� 2 �������� �� 1 ���� ��*/
				num2 = num2 - num1;
		
		/**�ִ� ����� ��ȯ*/
		return num1;
	}
}

/**
wk05_java03_201415060 Ŭ������
�������� ����� �ϱ�
���� Ŭ�����Դϴ�.

�� �������� �����ϰ� �ʱ�ȭ�մϴ�.
�� �������� ������ �Ǵ��ϰ�
ù �������� ���� �������� �����Ͽ� ����ϰ�,
�� �������� ��, ��, ��, �������� ��� �������� ����մϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java03_201415060 {


/**
main �Լ���
�������� �����
�մϴ�.

�� �������� �����ϰ� �ʱ�ȭ�մϴ�.
�� �������� ������ �Ǵ��ϰ�
ù �������� ���� �������� �����Ͽ� ����ϰ�,
�� �������� ��, ��, ��, �������� ��� �������� ����մϴ�.
@param args: the command line arguments
@return void
*/
	public static void main(String[] args) {
		/**������ 6/8 ����*/
		RationalNumber r1 = new RationalNumber(6,8);
		/**������ 1/3 ����*/
		RationalNumber r2 = new RationalNumber(1,3);
		/**����, ��, ��, ��, ������ ����� ������ ������ ���� ����*/
		RationalNumber r3, r4, r5, r6, r7;
		
		/**�� 1 ������ ���*/
		System.out.println("First rational number = " + r1);
		/**�� 2 ������ ���*/
		System.out.println("Second rational number = " + r2);
		
		/**�� 1,2 �������� ������*/
		if(r1.isLike(r2))
			/**������ ���*/
			System.out.println("r1 and r2 are equal.");
		/**�ٸ���*/
		else
			/**�ٸ��� ���*/
			System.out.println("r1 and r2 are NOT equal.");
		
		/**�� 3 �������� �� 1 �������� ������*/
		r3 = r1.reciprocal();
		/**�� 1 �������� ���� ���*/
		System.out.println("The reciprocal of r1 is = " + r3);
		
		/**�� 1 �������� �� 2 �������� ���� �� 4 ��������*/
		r4 = r1.add(r2);
		/**�� 1 �������� �� 2 �������� ���� �� 5 ��������*/
		r5 = r1.subtract(r2);
		/**�� 1 �������� �� 2 �������� ���� �� 6 ��������*/
		r6 = r1.multiply(r2);
		/**�� 1 �������� �� 2 �������� �������� �� 7 ��������*/
		r7 = r1.divide(r2);
		
		/**��, ��, ��, ������ ��� ���*/
		System.out.println("r1 + r2 = " + r4);
		/***/
		System.out.println("r1 - r2 = " + r5);
		/***/
		System.out.println("r1 * r2 = " + r6);
		/***/
		System.out.println("r1 / r2 = " + r7);
	}
}
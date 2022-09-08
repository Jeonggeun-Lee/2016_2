/**
wk07_java02_201415060 Ŭ������  
CD������ ��ü�� �����ϰ� CD�� �߰��ϰ� �������� ���빰�� ����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**�Ҽ��� �ڸ��� ǥ���� ���� DecimalFormat Ŭ���� ����*/
import java.text.DecimalFormat;

/**CD�� ǥ���ϴ� Ŭ����*/
class CD
{
	/**����, ����, ����, CD������ ����*/
   private String title, artist;
   private double cost;
   private int tracks;
   
   /**Ư�� ������ ������ CD�� ����*/
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }
   
   /**CD������ ���ڿ��� ǥ���ϴ� �޼ҵ�*/
   
   public String toString()
   {
	   /**�Ҽ��� ���� ���ڸ������� ���, ������ 0�� ��¾���*/
      DecimalFormat fmt = new DecimalFormat("#.##");
      
      String description;
      /**-����	Ʈ��	����	����*/
      description ="- " + fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }
}

/**CD���� ��ü*/

class CDCollection
{
	/**CD �迭*/
	private CD[] collection;
	/**CD����*/
	private int count;
	/**�� ����*/
	private double totalCost;
	
/**ó�� �ֺ� CD ������ ����*/
	public CDCollection ()
	{
		collection = new CD[100];
		count = 0;
		totalCost = 0.0;
	}

/**CD�� �߰��ϰ� �ʿ��ϸ� CD�������� ũ�⸦ �ø��� �Լ�*/

	public void addCD (String title, String artist, double cost, int tracks)
	{
		/**����ִ� CD ������ CD������ ���̿� ������ CD������ ũ�⸦ �ø�*/
		if (count == collection.length)
			increaseSize();
		/**CD������ ÷���� �迭�� CD �߰�, �Ѱ��� ����, CD���� ����*/
		collection[count] = new CD (title, artist, cost, tracks);
		totalCost += cost;
		count++;
	}

	/**CD�������� ���빰�� ���ڿ��� ��ȯ*/

	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("#.##");

		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "My CD Collection\n";

		report += "- Number of CDs = " + count + "\n";
		report += "- Total cost = " + fmt.format(totalCost) + "\n";
		report += "- Average cost = " + fmt.format(totalCost/count);

		report += "\nCD List:\n";

		for (int cd = 0; cd < count; cd++)
			report += collection[cd].toString() + "\n";

		return report;
	}

/**CD�������� �뷮�� �ø���. ��ū �迭�� �����ϰ� �� �迭�� �ű⿡ ����*/	
	private void increaseSize ()
	{
		CD[] temp = new CD[collection.length * 2];

		for (int cd = 0; cd < collection.length; cd++)
		temp[cd] = collection[cd];

		collection = temp;
	}
}

public class wk07_java02_201415060 {
	/**
	main �Լ���
	CD������ ��ü�� �����ϰ� CD�� �߰��ϰ� �������� ���빰�� �����
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	   public static void main (String[] args)
	   {
	      CDCollection music = new CDCollection ();

	      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
	      music.addCD ("Come On Over", "Shania Twain", 14.95, 16);
	      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
	      music.addCD ("Graceland", "Paul Simon", 13.90, 11);

	      System.out.print (music);

	      music.addCD ("Double Live", "Garth Brooks", 19.99, 26);
	      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);

	      System.out.print (music);
	   }
}

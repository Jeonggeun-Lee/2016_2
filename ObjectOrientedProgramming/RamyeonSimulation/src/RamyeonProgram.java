import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * ��� ���α׷�.
 * GUI ���� ����Ѵ�.
 * @author ���߱�, ������
 * @version 1.0
 */
public class RamyeonProgram extends JPanel
{

	/**
	 * �̹������� ������ ����.
	 * �غ�� ������ �׻� ���� �տ� ��ġ���Ѿ���.
	 * @author ���߱�, ������
	 */

	protected enum E_IMAGE_SORT
	{
		E_1_SOUP,
		E_2_WELSHONION,
		E_3_CHEESE,
		E_4_NOODLE,
		E_5_WATER,
		E_UNWRAPPED_SOUP,
		E_CUT_WELSHONION,
		E_BOILED_WATER,
		E_PLATE,	//��Ḧ �÷��δ� ����.
		E_TRIM_PLATE,	//��Ḧ �����ϴ� ����.
		E_GARBAGE_BOX,
		E_MAX
	}

	/**
	 * int ���� E_IMAGE_SORT�� �ٲٴ� �Լ�.
	 * E_IMAGE_SORT�� ���ŵǸ� ���� ���ŵǾ����.
	 * @param num	�ٲٴ� int ��.
	 * @return	�ٲ� E_IMAGE_SORT ��.
	 */

	public static E_IMAGE_SORT intToEIS(int num)
	{
		switch(num)
		{
		case 0:
			return E_IMAGE_SORT.E_1_SOUP;
		case 1:
			return E_IMAGE_SORT.E_2_WELSHONION;
		case 2:
			return E_IMAGE_SORT.E_3_CHEESE;
		case 3:
			return E_IMAGE_SORT.E_4_NOODLE;
		case 4:
			return E_IMAGE_SORT.E_5_WATER;
		case 5:
			return E_IMAGE_SORT.E_UNWRAPPED_SOUP;
		case 6:
			return E_IMAGE_SORT.E_CUT_WELSHONION;
		case 7:
			return E_IMAGE_SORT.E_BOILED_WATER;
		case 8:
			return E_IMAGE_SORT.E_PLATE;
		case 9:
			return E_IMAGE_SORT.E_TRIM_PLATE;
		case 10:
			return E_IMAGE_SORT.E_GARBAGE_BOX;
		default:
			return E_IMAGE_SORT.E_MAX;
		}
	}
	
	/**
	 * ��Ḧ ǥ���ϴ� JLabel (�׸��� ����Ѵ�)
	 * @author ���߱�, ������
	 * @version 1.0
	 */
	protected class IngredLabel extends JLabel
	{
		private Ingredient ingred;	//�� ��ü�� �ǹ��ϴ� ���.
		
		private E_IMAGE_SORT eImage;	//�� ��ü�� �̹���.
		
		/**
		 * ��� ������ �̹����� ��ü ����
		 * @param mat	�� ��ü�� �ǹ��ϴ� ���
		 * @param img	�� ��ü�� �̹���
		 * @param eSort	�� ��ü�� �̹��� - enum ��.
		 */
		public IngredLabel(Ingredient mat, ImageIcon img, E_IMAGE_SORT eSort)
		{
			super(img);
			ingred = mat;
			eImage = eSort;
		}
		
		public Ingredient getIngredient() { return ingred; }	//�ڽ��� ���� ��Ḧ �ǹ��ϴ��� �˷��ش�.
		public E_IMAGE_SORT getImageSort()	{ return eImage; }	//���� �̹����� ������ �ִ��� ��ȯ�Ѵ�.
		
		/**
		 * �̹����� �ٸ� �ɷ� ��ü�Ѵ�.
		 * @param eis	��ü�ϴ� �̹����� ������
		 * @param img	��ü�ϴ� �̹��� ������.
		 */
		public void changeImage(E_IMAGE_SORT eis, ImageIcon img)
		{
			eImage = eis;
			this.setIcon(img);
		}
	}
	
	private Ramyeon cook;	//��� ���α׷� Ŭ����
	
	private IngredLabel[] matImages;	//��� �̹�����.
	private IngredLabel[] addedImages;	//�߰��� ��� �̹�����.
	private IngredLabel dragImage;	//�巡���ϰ��ִ� ��� �̹���.
	private IngredLabel trimImage;	//������ ����� �̹���.
	private JLabel plateImage;	//���� �̹���.
	private JLabel trimPlateImage;	//�����ϴ� ���� �̹��� (�÷��θ� �����Ǵ� ����)
	
	/**
	 * �������� �̹��� ����
	 * @author ������
	 * */
	private JLabel garbageBoxImage;
	
	Image[] imgs = new Image[E_IMAGE_SORT.E_MAX.ordinal()];	//���α׷� ������ ����ϴ� �̹�����.
	
	private JButton completeBtn;	//�ϼ������� Ȯ���ϴ� ��ư.
	
	/**���̴� ��ư�� ����
	 * @author ������
	 * */
	private JButton boilBtn;
	

	/**
	 * �̹������� �ҷ��´�.
	 * ��� ���� ������ �������̵����� ó���� ��.
	 */
	protected void loadImages()
	{
		try 
		{
			//�̹������� �о�´�.
			imgs[E_IMAGE_SORT.E_1_SOUP.ordinal()] = ImageIO.read(new File("soup.png"));
			imgs[E_IMAGE_SORT.E_2_WELSHONION.ordinal()] = ImageIO.read(new File("welshonion.png"));
			imgs[E_IMAGE_SORT.E_3_CHEESE.ordinal()] = ImageIO.read(new File("cheese.png"));
			imgs[E_IMAGE_SORT.E_4_NOODLE.ordinal()] = ImageIO.read(new File("noodle.png"));
			imgs[E_IMAGE_SORT.E_5_WATER.ordinal()] = ImageIO.read(new File("water.png"));
			imgs[E_IMAGE_SORT.E_UNWRAPPED_SOUP.ordinal()] = ImageIO.read(new File("unwrappedsoup.png"));
			imgs[E_IMAGE_SORT.E_CUT_WELSHONION.ordinal()] = ImageIO.read(new File("cutwelshonion.png"));
			imgs[E_IMAGE_SORT.E_BOILED_WATER.ordinal()] = ImageIO.read(new File("boiledwater.png"));
			imgs[E_IMAGE_SORT.E_PLATE.ordinal()] = ImageIO.read(new File("range.png"));
			imgs[E_IMAGE_SORT.E_TRIM_PLATE.ordinal()] = ImageIO.read(new File("doma.png"));
			imgs[E_IMAGE_SORT.E_GARBAGE_BOX.ordinal()] = ImageIO.read(new File("garbageBox.png"));
		} 
		catch (IOException e) //���� �Է¿� ������ �߻��ϴ� ���.
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * GUI�� ù �����ϴ� RamyeonProgram�� ������.
	 */
	public RamyeonProgram()
	{
		setPanel();
	}
	
	/**
	 * �г��� ������Ʈ�� �г� ��ü���� ����.
	 * ����� �������̵� �� ��.
	 */
	protected void setPanel()
	{
		//	>>	�г��� �⺻ ����	>>	//
		GUIMouseListener gl = new GUIMouseListener();
		this.addMouseListener(gl);	//���콺 �����ʸ� �гο� �߰��Ѵ�.
		this.addMouseMotionListener(gl);
		
		//�г��� Ư¡�� �����Ѵ�.
		this.setLayout(null);
		this.setBackground (Color.cyan);	//�г� ����� �þ����� ����.
		this.setPreferredSize (new Dimension(1024, 768));	//1024 X 768�� ũ��� ����.
		//	<<	�г��� �⺻ ����	<<	//

		//	>>	�丮 ���α׷��� ���� ����	>>	//
		//�غ�Ǿ��ִ� �丮 ������ ����.
		Ingredient[] prepared = {new Ingredient("����"), new Ingredient("��"), new Ingredient("ġ��"),new Ingredient("��"),new Ingredient("��")};
		//�ϼ��� �丮�� �� ��� ����� ����.
		Ingredient[] goal = {new Ingredient("����","����"), new Ingredient("��","����"), new Ingredient("ġ��"),new Ingredient("��"),new Ingredient("��","����")};
		//�丮 ���α׷� ���θ� �����Ѵ�. �غ� ���� �ٸ� ���� �ΰ��� ���� �׻� ���̰� ��ų� �����Ƿ� �ش� ���̸� �������� ���� ����.
		cook = new Ramyeon(prepared.length, prepared, goal);
		//	<<	�丮 ���α׷��� ���� ����	<<	//
		
		//	>>	�̹��� ����	>>	//
		
		loadImages();
		
		//>>��� �̹����� ����>>//
		matImages = new IngredLabel[prepared.length];	//������Ʈ �ν��� ���ؼ� Label�� ����Ѵ�.
		addedImages = new IngredLabel[prepared.length];	//�߰��� ��� �̹����� �迭��ŭ�� �Ҵ��Ѵ�.
		for (int n=0; n<matImages.length; n++)
		{
			//�غ�� ��� ������ gui�� ���α׷��� ���� ����.
			matImages[n] = new IngredLabel(prepared[n], new ImageIcon(imgs[n]), intToEIS(n));	
			matImages[n].setSize(matImages[n].getPreferredSize());
			this.add(matImages[n]);	//��� �̹����� �гο� �߰�.
		}
		//<<��� �̹����� ����<<//
		
		//>>���� �̹��� ����>>//
		//��� �÷��δ� ���� �̹��� ����
		plateImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_PLATE.ordinal()]));	//�ٷ� �̹����� �ο�.
		plateImage.setSize(plateImage.getPreferredSize());
		this.add(plateImage);	//���� �̹����� �гο� �߰�.
		//������ ���� �̹��� ����
		trimPlateImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_TRIM_PLATE.ordinal()]));
		trimPlateImage.setSize(trimPlateImage.getPreferredSize());
		this.add(trimPlateImage);
		//���õ��� ���� �ڿ� ��ġ.
		this.setComponentZOrder(plateImage, this.getComponentCount() - 2);
		this.setComponentZOrder(trimPlateImage, this.getComponentCount() -1);
		//<<���� �̹��� ����<<//
		
		/**�������� �̹��� ����
		 * @author ������
		 * */
		//>>�������� �̹��� ����>>//
		garbageBoxImage = new JLabel(new ImageIcon(imgs[E_IMAGE_SORT.E_GARBAGE_BOX.ordinal()]));	//�ٷ� �̹����� �ο�.
		garbageBoxImage.setSize(garbageBoxImage.getPreferredSize());
		this.add(garbageBoxImage);	//���� �̹����� �гο� �߰�.
		//<<�������� �̹��� ����<<//
		
		//	<<	�̹��� ����	<<	//
		
		//��ư �߰�.
		completeBtn = new JButton("Complete");
		completeBtn.setSize(100, 50);
		completeBtn.addActionListener(new ButtonListener());
		this.add(completeBtn);
		
		/**���̱� ��ư �߰�*/
		/**
		 * @author ������
		 * */
		boilBtn = new JButton("Boil");
		boilBtn.setSize(100, 50);
		boilBtn.addActionListener(new ButtonListener());
		this.add(boilBtn);
	}
	
	/**
	 * ������Ʈ���� �⺻ ��ġ�� �����ϴ� �Լ�.
	 */
	protected void setDefaultLocation()
	{
		//��� �̹������� ��ġ����.
		for(int n=0; n<matImages.length; n++)
			matImages[n].setLocation(n * 150, this.getSize().height - (matImages[n].getSize().height));
		//���� �̹����� ��ġ ����.
		plateImage.setLocation((this.getSize().width / 2) - (plateImage.getSize().width),	//������� �������� ����.
				(this.getSize().height / 2) - (plateImage.getSize().height / 2)-85);	//���δ� ����� ����.
		//������ ���� �̹����� ��ġ ����.
		trimPlateImage.setLocation((this.getSize().width / 2) + (50),	//������� �����ʿ� ��ġ
				(this.getSize().height / 2) - (trimPlateImage.getSize().height / 2));	//���δ� ����� ��ġ.
		
		//�������� �̹����� ��ġ ����.
		garbageBoxImage.setLocation((this.getSize().width ) - (garbageBoxImage.getSize().width + 100), 100);	//������ �� -200.����+100
		
		//��ư�� ��ġ ����.
		completeBtn.setLocation((this.getSize().width / 2) - (completeBtn.getSize().width / 2),	//����� ��ġ
				100);	//������ 100
		
		/**
		 * ���̱� ��ư�� ��ġ ����.
		 * @author ������
		 * */
		boilBtn.setLocation( (this.getSize().width / 2) - (boilBtn.getSize().width / 2) - 200,	//����:������� - 200�� ��ġ
				100 );//����: ������� ���� �Ʒ� ��ġ
		bSet = true;
	}
	
	/**
	 * ��Ḧ �߰��Ѵ�.
	 * ���α׷� ������ �߰��ϸ�, gui�ε� �߰��ؼ� ���ÿ� �÷��д�.
	 * @param ingred	�߰��ϴ� ���
	 * @return	�߰� ���� ����.
	 */
	public boolean addIngredient(IngredLabel ingred)
	{
		int index = cook.addIngredient(ingred.getIngredient());	//��Ḧ �߰��Ѵ�.
		
		if(index >= 0)	//��� �߰��� ������ ���,
		{
			/**��ᰡ ������ ��� ���簡 ���� ���� ������� ���Ѵ�
			 * @author ������
			 * */
			if( ingred.getImageSort() == E_IMAGE_SORT.E_1_SOUP )
			{
				ingred.changeImage(E_IMAGE_SORT.E_UNWRAPPED_SOUP,
						new ImageIcon(imgs[E_IMAGE_SORT.E_UNWRAPPED_SOUP.ordinal()]) );
				ingred.getIngredient().setState("����");
				ingred.setSize(getPreferredSize());
			}
			
			addedImages[index] = ingred;	//�ش��ϴ� ��ȣ�� ��Ḧ �߰��صд�. (�״�� �Űܵд�)
			Point pos = plateImage.getLocation();
            
			/**
			 * ������ ����� ��� ��Ḧ ���´�
			 * @author ������
			 */
			pos.x += plateImage.getWidth()/2-ingred.getWidth()/2;
			pos.y += plateImage.getHeight()/2-ingred.getHeight()/2;
			addedImages[index].setLocation(pos);	//��ġ�� �����Ų��.
			
				
			return true;
		}
		
		//������ ���.
		return false;
	}
	/**
	 * ��Ḧ �����Ѵ�.
	 * ���α׷� �������� �����ϸ�, gui������ �����Ѵ�.
	 * @param ingred	�����ϴ� ���
	 * @return	���� ���� ����.
	 */
	public boolean removeIngredient(IngredLabel ingred)
	{
		boolean check = false;	//�ش� ��ᰡ ����ִ��� �Ǻ��Ѵ�.
		for(IngredLabel lab : addedImages)
			if(lab == ingred)	//��ᰡ ����ִ� �� Ȯ�εǸ�
				check = true;	//���.
		
		if( check == false)	//��ᰡ ���ٸ�
			return false;	//��� ���� ����.
		//��� Ŭ���� ��ü���� ��Ḧ ����
		int index = cook.removeIngredient(ingred.getIngredient());
		//�켱 �ش� �̹����� ������Ų��.
		this.remove(addedImages[index]);
		this.repaint();
		addedImages[index] = null;
		//�ڿ� �ִ� ������ ��� �� ĭ�� �����. (ȥ���� ���� ����)
		int k;
		for(k = index; k < addedImages.length - 1; k++)
		{
			addedImages[k] = addedImages[k+1];	//�ٷ� ���� ��Ḧ ���� ĭ���� ���ܿ´�.	
			if(addedImages[k] != null)	//null�� �ƴ� ���� ��Ḧ ���ܿ� ���
			{
				//����� ��ġ�� �����.
				Point pos = addedImages[k].getLocation();
				pos.x -= 100;	//X���� 100 �����.
				addedImages[k].setLocation(pos);	//����� ��ġ ��ȯ Ȯ��.
			}
			if( addedImages[k+1] == null)	//���� ��ġ�� ����ִ� ���� ���� �� �ű� �ʿ� ����.
				break;
			//�� if���� �ڿ� ��ġ�� ������ ������ ���� null�� ä���� �ʿ䰡 �ֱ� �����̴�.
		}
		//������: ���� ���ǹ��� ���ʿ��ϴٴ� ����
		if( k == addedImages.length)	//���� ������ ������ ���ܿ� ���,
			addedImages[k] = null;	//������ ���� ������ ���ܿ����Ƿ� ������ ��ġ�� ������Ų��.
		
		return true;	//���������� ����
	}
	/**
	 * ��Ḧ �����Ѵ�.
	 * @param ingred	�����ϴ� ���
	 * @return	���� ���� ����.
	 */
	public boolean trimIngredient(IngredLabel ingred)
	{
		if(trimImage != null)	//�̹� ������ ��ᰡ �÷���������,
			return false;	//���� �Ұ���.
		
		cook.removeIngredient(ingred.getIngredient());	//�����ϱ����� �÷������� �߰��� ��� ��Ͽ����� �����Ѵ�.
		String stat = cook.trimIngredient(ingred.getIngredient());
		
		ingred.getIngredient().setState(stat);	//�ش� ���·� �����Ѵ�.
		trimImage = ingred;	//�����ϴ� �̹����� ����.
		switch(trimImage.getImageSort())
		{
		/**
		 * �� �̹����� �� �ķ� ��ȯ.
		 * @author ������
		 */
		case E_2_WELSHONION:
			trimImage.changeImage(E_IMAGE_SORT.E_CUT_WELSHONION, 
					new ImageIcon(imgs[E_IMAGE_SORT.E_CUT_WELSHONION.ordinal()]));
			break;
		default:
			//�ַ� �̹� ������ ���, Ȥ�� ������ ���� �ش��ϴ� �̹����� ���� ���, case�� ���� ��쿡 �߻�.
			System.out.println("It isn't trimmed");
			break;
		}
		trimImage.setSize(trimImage.getPreferredSize());	//������ ����
		//��ġ ���� -> ���� ���� ���� ��ġ�Ѵ�.
		trimImage.setLocation(trimPlateImage.getLocation().x + (trimPlateImage.getWidth() / 2) - (trimImage.getSize().width / 2),
				trimPlateImage.getLocation().y + (trimPlateImage.getHeight() / 2) - (trimImage.getSize().height / 2));
		return true;
	}

	
	/**
	 * �Ϸ� ��ư�� ���� ��ư ������
	 * �� ���̱� ��ư ������
	 * �� ���� ��ư�鵵 ����� �����ϵ��� �صξ���.
	 * @author ���߱�, ������
	 *
	 */
	protected class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			if( event.getSource() == completeBtn)
			{
				if(cook.succeedCook())	//�丮�� ������ ���.
				{
					JOptionPane.showMessageDialog(null, "�丮�� �����ϼ̽��ϴ�!");
				}
				else	//�丮�� ������ ���.
				{
					JOptionPane.showMessageDialog(null, "�丮�� �����ϼ̽��ϴ�.");
				}
				
				
			}
			
			/**���̱� ��ư�� ������ ���� �۵�
			 * @author ������
			 * */
			if( event.getSource() == boilBtn)
			{
				if(cook.boil() == true)//���� ���� ���
				{
					for(IngredLabel i: addedImages)
					{
						if( i.getImageSort().equals(E_IMAGE_SORT.E_5_WATER) )
						{
							i.changeImage(E_IMAGE_SORT.E_BOILED_WATER, new ImageIcon( imgs[E_IMAGE_SORT.E_BOILED_WATER.ordinal()] ) );
							i.getIngredient().setState("����");
							i.setSize(getPreferredSize());
							Point pos = plateImage.getLocation();
							
							/**
							 * ������������ ����� ���� ���� ���´�
							 */
							pos.x += plateImage.getWidth()/2-i.getWidth()/2;
							pos.y += plateImage.getHeight()/2-i.getHeight()/2;
							i.setLocation(pos);
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "���� �����ϴ�. �ٸ� ��Ḧ ��������.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� ���� ���̸� �� �˴ϴ�. ����!");
				}
			}
		}
	}
	
	public static boolean bSet = false;	//ó�� ��ġ ������ �ߴ��� ����.
	
	/**
	 * ���α׷����� ���콺�� �Է¹ް� ó���ϱ� ���� ������ Ŭ����.
	 * @author ���߱�
	 * @version 1.5
	 */
	protected class GUIMouseListener extends MouseMotionAdapter implements MouseListener
	{
		private Point offset;	//�巡���� �� ���. �巡�� ���۽� ���� ��ġ�� �ǹ��Ѵ�.
		private Point startPos;	//�巡���� ��, ������Ʈ�� ó�� ��ġ�� �����Ѵ�.
		private RamyeonProgram cpanel = null;
		
		public void mousePressed(MouseEvent event)
		{
			JLabel label;
			try	//���� �̹����� ã�� �� �߻��� ���ܸ� ����� ó��.
			{
				label = (JLabel) cpanel.getComponentAt(event.getPoint());	//���� �̹����� ã�´�.
				if( label == null)	//���� �̹����� ���� ���.
					return;
			}
			catch(ClassCastException e)	//�ַ� ������Ʈ�� �ƴ� ����� �������� �� �г��� ������Ʈ�� ��ȯ�Ǹ� �߻�.
			{	return;	}	//�׳� �Լ��� ���������Ѵ�.
			
			for(int n=0; n<matImages.length; n++)
			{
				if(matImages[n] == label)	//���� ��� �̹����� ���� ���. (�ַ� ��Ḧ �߰�/�����ϴ� �뵵�� ���ȴ�)
				{
					//�� �̹����� ������ �巡���� �̹����� �����.
					dragImage = new IngredLabel(matImages[n].getIngredient(), new ImageIcon(imgs[n]), cpanel.intToEIS(n));
					dragImage.setBounds(matImages[n].getBounds());
					cpanel.add(dragImage);
					cpanel.setComponentZOrder(dragImage, 0);	//�̹����� ���� ���ʿ� ���´�.
					startPos = new Point(-100, -100);	//�� ���� ���� ������ ���̹Ƿ� ������ġ�� ����.
				}
				
				if(addedImages[n] != null)	//�߰��� ��ᰡ �ִ� ���.
					if(addedImages[n] == label)	//�߰��� ��Ḧ ���� �Ŷ��,
					{
						dragImage = addedImages[n];	//������ �ƴ϶� �� �̹����� �״�� �ű��.
						startPos = dragImage.getLocation();	//�巡�� ������ġ ����.
					}
			}
			
			if(trimImage != null && trimImage == label)	//������ �̹������,
			{
				dragImage = trimImage;	//���������� �� �̹����� �״�� �̵���Ų��.
				trimImage = null;	//������ �̹����μ��� ������.
				startPos = dragImage.getLocation();	//�巡�� ���� ��ġ ����.
			}
			
			offset = event.getPoint();	//�巡�׸� ���� offset ����.
		}
		
		/**
		 * contains �Լ��� �� �ȵż� ���� ���� �Լ�
		 * @param bounds	�����ϴ� �� Ȯ���ϴ� ����
		 * @param pos		���ԵǴ� �� Ȯ���ϴ� ��ġ.
		 * @return bounds ���� ���� pos�� ���� �� ����.
		 */
		public boolean checkContain(Rectangle bounds, Point pos)
		{
			if(pos.x >= bounds.x && pos.x <= (bounds.x + bounds.width) &&	//���� �𼭸��� ������ �𼭸� �������� Ȯ��.
					pos.y >= bounds.y && pos.y <= (bounds.y + bounds.height))	//���� �𼭸��� �Ʒ��� �𼭸� �������� Ȯ��.
				return true;
			else
				return false;
		}
		
		public void mouseReleased(MouseEvent event)
		{
			if( dragImage != null )	//�巡���ϴ� ��ᰡ �ִ� ���,
			{
				if(checkContain(plateImage.getBounds(), event.getPoint()))	//�巡���ϴ� ��ᰡ ���� ���� �ö�Դ��� Ȯ��.
				{
					if(addIngredient(dragImage) == false)	//��� �߰��� �غ��� ������ ���,
					{
						if( startPos.x >= 0 )	//�ǵ��ư� ��ġ�� �ִ� ���,
							dragImage.setLocation(startPos);	//ó�� ��ġ�� ����������.
						else	//���ư� ��ġ�� ���� ���.
						{
							//�巡�� �ϴ� �̹����� ����.
							cpanel.remove(dragImage);
							cpanel.repaint();
						}
					}
				}
				else if(checkContain(trimPlateImage.getBounds(), event.getPoint()))	//��ᰡ ���� ���� ���� �ö�Դ��� Ȯ��.
				{
					if(trimIngredient(dragImage) == false)	//�̹� ������ ��ᰡ �־��ų� �ϴ� ���� ������ ������ ������ ���.
					{
						if( startPos.x >= 0 )	//�ǵ��ư� ��ġ�� �ִ� ���,
							dragImage.setLocation(startPos);	//ó�� ��ġ�� ����������.
						else	//���ư� ��ġ�� ���� ���.
						{
							//�巡�� �ϴ� �̹����� ����.
							cpanel.remove(dragImage);
							cpanel.repaint();
						}
					}
				}
				else	//�ƹ����� �ö��� ���� ���.
				{
					//�巡���ϴ� ���� �߰��� ��ῴ�ٸ� �����Ѵ�.
					//�ƴ϶�� false�� ��ȯ�� ���� ���̴� ������ ����.
					if(cpanel.removeIngredient(dragImage) == false)	//��ᰡ �������� ���� ���,
					{
						//�巡�� �ϴ� �̹����� ���� ����.
						cpanel.remove(dragImage);
						cpanel.repaint();
					}
				}
				dragImage = null;
			}
			
		}
		
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
		public void mouseDragged(MouseEvent event)
		{
			if(dragImage != null)	//�̹����� �巡���ϴ� ������ ���.
			{
				int mx = event.getPoint().x - offset.x;	//X������ �̵��� �Ÿ�
				int my = event.getPoint().y - offset.y;	//Y������ �̵��� �Ÿ�
				offset = event.getPoint();	//����� �������� ������ �ʱ�ȭ.
				Point loc = dragImage.getLocation();
				loc.x += mx;	loc.y += my;	//��ġ�� �巡���Ѹ�ŭ �̵���Ŵ.
				dragImage.setLocation(loc);
			}
		}
		
		public void mouseMoved(MouseEvent event)	//��� ���翡�� ��� �뵵�θ� �����.
		{
			if(cpanel == null)
				cpanel = ((RamyeonProgram)plateImage.getParent());
			//������ ������� ������Ʈ���� ù �⺻ ��ġ�� �����Ѵ�.
			if(!bSet)
			{
				cpanel.setDefaultLocation();
			}
		}
	}

	/**
	 * �������� ����� �г��� ���̰� �����ִ� ���� �޼ҵ�
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Ramyeon Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RamyeonProgram panel = new RamyeonProgram();
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

}

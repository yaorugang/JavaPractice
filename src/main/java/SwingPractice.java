
import javax.swing.*;


public class SwingPractice
{

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run()
			{
				// ȷ��һ��Ư������۷��
				JFrame.setDefaultLookAndFeelDecorated(true);
				
				// ���������ô���
				JFrame frame = new JFrame("Hello World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// ��� "Hello World" ��ǩ
				JLabel label = new JLabel("Hello World Label");
				frame.getContentPane().add(label);
				
				 // ��ʾ����
				frame.pack();
				frame.setVisible(true);
			}
		});

	}

}

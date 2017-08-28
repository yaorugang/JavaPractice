
import javax.swing.*;


public class SwingPractice
{

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run()
			{
				// 确保一个漂亮的外观风格
				JFrame.setDefaultLookAndFeelDecorated(true);
				
				// 创建及设置窗口
				JFrame frame = new JFrame("Hello World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// 添加 "Hello World" 标签
				JLabel label = new JLabel("Hello World Label");
				frame.getContentPane().add(label);
				
				 // 显示窗口
				frame.pack();
				frame.setVisible(true);
			}
		});

	}

}

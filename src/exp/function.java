package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dialog.EnsureDialog;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class function extends JFrame {

	private JPanel contentPane;

	private static final int WIDTH = 300;
	 
	private static final int HEIGHT = 200;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new function();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public function() {
		final JFrame frame = new JFrame("function");
		frame.setVisible(true);
		frame.setSize(428, 332);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u9AD8\u7EA7\u529F\u80FD\u533A");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(160, 28, 93, 28);
		contentPane.add(label);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u770B\u8D26\u5355");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new view_bill();
			}
		});
		btnNewButton_4.setBounds(138, 157, 127, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnUsersetting = new JButton("\u7528\u6237\u7BA1\u7406");
		btnUsersetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new User_function();
			}
		});
		btnUsersetting.setBounds(138, 66, 127, 23);
		contentPane.add(btnUsersetting);
		
		JButton btnBookfunction = new JButton("\u4E66\u7C4D\u7BA1\u7406");
		btnBookfunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Book_function();
			}
		});
		btnBookfunction.setBounds(138, 110, 127, 23);
		contentPane.add(btnBookfunction);
		
		JButton btnExit = new JButton("注销");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnsureDialog flag = new EnsureDialog();
				if(flag.EnsureDialog("确定要注销吗？")) {
					frame.dispose();
					new login();
				}
			}
		});
		btnExit.setBounds(271, 246, 72, 28);
		contentPane.add(btnExit);
		
		JButton button = new JButton("\u6392\u540D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Rank();
			}
		});
		button.setBounds(139, 204, 126, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u4E66\u7C4D\u63A8\u8350\u680F");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Recommend();
			}
		});
//		Image img=new ImageIcon(ClassLoader.getSystemResource("./images/1.png")).getImage();
//		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(285, 129, 108, 23);
		contentPane.add(btnNewButton);
	}
}

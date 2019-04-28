package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_function extends JFrame {

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
					new User_function();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_function() {
		final JFrame frame = new JFrame("User_function");
		frame.setVisible(true);
		frame.setSize(428, 332);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsersetting = new JLabel("User_Setting");
		lblUsersetting.setFont(new Font("»ªÎÄ¿¬Ìå", Font.PLAIN, 18));
		lblUsersetting.setBounds(160, 25, 93, 28);
		contentPane.add(lblUsersetting);
		
		JButton button = new JButton("\u6DFB\u52A0\u65B0\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new insert_user();
			}
		});
		button.setBounds(151, 64, 114, 23);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("\u89E3\u96C7\u5458\u5DE5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new delete_user();
			}
		});
		btnNewButton_1.setBounds(151, 111, 114, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u770B\u7528\u6237");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new view_user();
			}
		});
		btnNewButton_2.setBounds(151, 201, 114, 23);
		contentPane.add(btnNewButton_2);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Modify_user();
			}
		});
		button_1.setBounds(151, 155, 114, 23);
		contentPane.add(button_1);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new function();
			}
		});
		btnExit.setBounds(275, 249, 70, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new function();
			}
		});
		btnNewButton.setBounds(82, 249, 97, 23);
		contentPane.add(btnNewButton);
	}
}

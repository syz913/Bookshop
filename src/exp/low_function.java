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

public class low_function extends JFrame {

	private JPanel contentPane;
	private login frame1;
	
	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new low_function();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public low_function() {
		final JFrame frame = new JFrame("low_function");
		frame.setVisible(true);
		frame.setSize(445, 294);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F4E\u6743\u9650\u529F\u80FD\u533A");
		label.setFont(new Font("»ªÎÄ¿¬Ìå", Font.PLAIN, 18));
		label.setBounds(158, 33, 110, 24);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u81EA\u5DF1\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new low_Modify();
			}
		});
		btnNewButton.setBounds(145, 147, 139, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new login();
			}
		});
		btnExit.setBounds(264, 205, 68, 23);
		contentPane.add(btnExit);
		
		JButton btnBookfunction = new JButton("\u4E66\u7C4D\u7BA1\u7406");
		btnBookfunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Book_function_2();
			}
		});
		btnBookfunction.setBounds(145, 93, 139, 23);
		contentPane.add(btnBookfunction);
	}
}

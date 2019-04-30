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

public class Book_function_2 extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Book_function_2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Book_function_2() {
		final JFrame frame = new JFrame("Book_function_2");
		frame.setVisible(true);
		frame.setSize(428, 348);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBook = new JLabel("\u4E66\u7C4D\u7BA1\u7406");
		lblBook.setFont(new Font("»ªÎÄ¿¬Ìå", Font.PLAIN, 18));
		lblBook.setBounds(182, 52, 94, 15);
		contentPane.add(lblBook);
		
		JButton button = new JButton("\u8FDB\u8D27");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new import_book();
			}
		});
		button.setBounds(166, 77, 110, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u8D27");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new return_book();
			}
		});
		button_1.setBounds(166, 176, 110, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5356\u4E66");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Sale_book();
			}
		});
		button_2.setBounds(166, 211, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u67E5\u770B\u53CA\u4FEE\u6539");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new view_book();
			}
		});
		button_3.setBounds(166, 244, 110, 23);
		contentPane.add(button_3);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new low_function();
			}
		});
		btnExit.setBounds(298, 276, 58, 23);
		contentPane.add(btnExit);
		
		JButton button_4 = new JButton("\u4ED8\u6B3E");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Pay_money();
			}
		});
		button_4.setBounds(166, 110, 110, 23);
		contentPane.add(button_4);
		
		JButton btnNewButton = new JButton("\u5165\u5E93");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new load_in();
			}
		});
		btnNewButton.setBounds(166, 143, 110, 23);
		contentPane.add(btnNewButton);
	}
}

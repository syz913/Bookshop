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

public class Rank extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Rank();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rank() {
		final JFrame frame = new JFrame("Hot_rank");
		frame.setVisible(true);
		frame.setSize(338, 278);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRank = new JLabel("\u6392\u540D");
		lblRank.setFont(new Font("»ªÎÄ¿¬Ìå", Font.PLAIN, 18));
		lblRank.setBounds(124, 30, 67, 24);
		contentPane.add(lblRank);
		
		JButton button = new JButton("\u70ED\u5EA6\u6392\u540D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Hot_rank();
			}
		});
		button.setBounds(105, 64, 97, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u5229\u6DA6\u6392\u540D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Benifit_rank();
			}
		});
		btnNewButton.setBounds(105, 113, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new function();
			}
		});
		btnExit.setBounds(191, 201, 67, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton_1 = new JButton("\u7EE9\u6548\u6392\u540D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Grade();
			}
		});
		btnNewButton_1.setBounds(105, 160, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}

package exp;

import java.awt.BorderLayout;
import java.io.File;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class insert_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new insert_user();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public insert_user() {
		final JFrame frame = new JFrame("insert_user");
		frame.setVisible(true);
		frame.setSize(465, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u4E00\u540D\u65B0\u7528\u6237");
		label.setBounds(159, 38, 112, 23);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(99, 91, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("name");
		lblAge.setBounds(199, 91, 38, 15);
		contentPane.add(lblAge);
		
		JLabel lblId = new JLabel("password");
		lblId.setBounds(298, 91, 58, 15);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("gender");
		lblPassword.setBounds(68, 164, 58, 15);
		contentPane.add(lblPassword);
	
		JTextPane textPane = new JTextPane();
		textPane.setBounds(89, 116, 58, 21);
		contentPane.add(textPane);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(288, 116, 68, 21);
		contentPane.add(textPane_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(184, 116, 73, 21);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("salary");
		lblNewLabel_1.setBounds(278, 164, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(326, 161, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"m", "f"}));
		comboBox.setBounds(114, 160, 48, 23);
		contentPane.add(comboBox);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t1=""+textPane.getText();//ID
				String t2=""+textPane_1.getText();//name
				String t=""+textPane_2.getText();//password
				String t4=""+comboBox.getSelectedItem();//gender
				String t5=""+textField.getText();//salary
				String t6=textField_1.getText();//age
				if(t6=="") t6=null;
				String t3 = "";
				try {
					t3 = HashUtils.encrypt(t.getBytes("UTF-8"), "MD5");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {  
			          Class.forName("com.mysql.cj.jdbc.Driver");  //加载MYSQL JDBC驱动程序  
			          //Class.forName("org.gjt.mm.mysql.Driver");  
			          System.out.println("Success loading Mysql Driver!");  
			         }catch (Exception e) {  
			          System.out.print("Error loading Mysql Driver!");  
			          e.printStackTrace();  
			     }  
			     try{  
			          Connection connect = DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/bookshop?user=root&password=123456&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8");  
			           //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码  
			          System.out.println("Success connect Mysql server!");  
			          Statement stmt = connect.createStatement();  
			          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
			          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
			          String sql_1;
				      if(t5.equals("")) t5=null; 	 
			          if(t6.equals("")) t6=null;
			          sql_1="insert into person (ID,name,password,gender,age) values('"+t1+"','"+t2+"','"+t3+"','"+t4+"',"+t6+")";
			          String sql_2="insert into salesmen(ID,salary) values('"+t1+"',"+t5+")";
			          stmt.executeUpdate(sql_1);
			          stmt.executeUpdate(sql_2);
			                        //user 为你表的名称 
			         }catch(Exception e) {  
			          System.out.print("get data error!");  
			          e.printStackTrace();  
			         }  


			}
		});
		btnInsert.setBounds(174, 216, 97, 23);
		contentPane.add(btnInsert);
		
		 
		JButton btnNewButton = new JButton("exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new User_function();
			}
		});
		btnNewButton.setBounds(288, 249, 58, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAge_1 = new JLabel("age");
		lblAge_1.setBounds(172, 164, 58, 15);
		contentPane.add(lblAge_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 161, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new function();
			}
		});
		btnNewButton_1.setBounds(89, 249, 78, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}

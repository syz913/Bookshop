package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Modify_book extends JFrame {

	private JPanel contentPane;
	private JTextField data1;
	private JTextField data3;
	
	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Modify_book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modify_book() {
		final JFrame frame = new JFrame("Modify_book");
		frame.setVisible(true);
		frame.setSize(401, 351);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539\u4FE1\u606F");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(128, 25, 91, 34);
		contentPane.add(label);
		
		JLabel lblid = new JLabel("\u8F93\u5165ISBN");
		lblid.setBounds(79, 78, 91, 34);
		contentPane.add(lblid);
		
		data1 = new JTextField();
		data1.setBounds(188, 91, 91, 21);
		contentPane.add(data1);
		data1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u4FEE\u6539\u7684\u503C");
		lblNewLabel.setBounds(79, 138, 78, 15);
		contentPane.add(lblNewLabel);
		
		JComboBox data2 = new JComboBox();
		data2.setModel(new DefaultComboBoxModel(new String[] {"book_name", "publisher", "author", "price", "stock"}));
		data2.setBounds(188, 134, 91, 23);
		contentPane.add(data2);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u65B0\u503C");
		lblNewLabel_1.setBounds(79, 177, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		data3 = new JTextField();
		data3.setBounds(188, 174, 91, 21);
		contentPane.add(data3);
		data3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t1=""+data1.getText();//ISBN
				String t2=""+data2.getSelectedItem();
				String t3=""+data3.getText();
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
			          String sql="update books set "+t2+" = '"+t3+"' where ISBN = '"+t1+"'";//SQL语句
			          stmt.executeUpdate(sql);
			                        //user 为你表的名称 
			         }catch(Exception e) {  
			          System.out.print("get data error!");  
			          e.printStackTrace();  
			         }  
			}
		});
		btnNewButton.setBounds(144, 225, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new view_book();
			}
		});
		btnNewButton_1.setBounds(277, 258, 58, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new function();
			}
		});
		btnNewButton_2.setBounds(63, 258, 74, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}

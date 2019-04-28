package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Add_Book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add_Book() {
		final JFrame frame = new JFrame("Add_Book");
		frame.setVisible(true);
		frame.setSize(439, 382);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u4E66\u7C4D");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(181, 31, 86, 33);
		contentPane.add(label);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(84, 92, 58, 15);
		contentPane.add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(133, 89, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E66\u540D");
		label_1.setBounds(234, 92, 58, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(278, 89, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setBounds(84, 148, 58, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 145, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F5C\u8005");
		label_3.setBounds(234, 148, 58, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(278, 145, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCost = new JLabel("cost");
		lblCost.setBounds(84, 194, 58, 15);
		contentPane.add(lblCost);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 191, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1=""+textField.getText();//ISBN
				String t2=""+textField_1.getText();//book_name
				String t3=""+textField_2.getText();//publisher
				String t4=""+textField_3.getText();//author
				float t5=Float.parseFloat(textField_4.getText());//cost
				int t6=0;//stock
				String t7=""+textField_5.getText();//工号
				String t8=order_bill.random_bill();//order_ID
				String number=""+textField_6.getText();//number
				try {  
			          Class.forName("com.mysql.cj.jdbc.Driver");  //加载MYSQL JDBC驱动程序  
			          //Class.forName("org.gjt.mm.mysql.Driver");  
			          System.out.println("Success loading Mysql Driver!");  
			         }catch (Exception e1) {  
			          System.out.print("Error loading Mysql Driver!");  
			          e1.printStackTrace();  
			     }  
			     try{  
			          Connection connect = DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/bookshop?user=root&password=123456&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8");  
			           //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码  
			           
			          System.out.println("Success connect Mysql server!");  
			          Statement stmt = connect.createStatement(); 
			          String sql_1="insert into books values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+0+"','"+0+"')";
			          String sql_2="insert into order_list values('"+t8+"','"+t1+"','"+number+"')";
			          String sql_3="insert into import_order values('"+t8+"','"+t5+"',0)";
			          stmt.executeUpdate(sql_1);
			          stmt.executeUpdate(sql_2);
			          stmt.executeUpdate(sql_3);
			                        //user 为你表的名称 
			         }catch(Exception e1) {  
			          System.out.print("get data error!");  
			          e1.printStackTrace();  
			         }  
			}
		});
		btnAdd.setBounds(170, 276, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Book_function();
			}
		});
		btnExit.setBounds(303, 312, 66, 23);
		contentPane.add(btnExit);
		
		JLabel label_5 = new JLabel("\u5DE5\u53F7");
		label_5.setBounds(234, 194, 58, 15);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(278, 191, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new function();
			}
		});
		btnHome.setBounds(84, 312, 78, 23);
		contentPane.add(btnHome);
		
		JLabel label_4 = new JLabel("\u6570\u91CF");
		label_4.setBounds(84, 235, 58, 15);
		contentPane.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(133, 232, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}

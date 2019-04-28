package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dialog.WarningDialog;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class import_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new import_book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public import_book() {
		final JFrame frame = new JFrame("import_book");
		frame.setVisible(true);
		frame.setSize(406, 477);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalebook = new JLabel("Import_book");
		lblSalebook.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblSalebook.setBounds(147, 31, 99, 24);
		contentPane.add(lblSalebook);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(70, 77, 58, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 74, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumber = new JLabel("\u6570\u91CF");
		lblNumber.setBounds(70, 122, 58, 15);
		contentPane.add(lblNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 119, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice = new JLabel("\u8FDB\u8D27\u5355\u4EF7");
		lblPrice.setBounds(201, 77, 58, 15);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 74, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSale = new JButton("import");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size=1000;
				String[] a1=new String[size];
				int a11=0;
				int flag = 0;//用于判断书库中是否有这本书
				String t1=""+textField.getText();//ISBN 
				int t2=Integer.parseInt(textField_1.getText());//number
				float t3=Float.parseFloat(textField_2.getText());//price
				float price = t2*t3;
			//	String t4=""+textField_3.getText();//order_ID
				String t4=order_bill.random_bill();//order_ID
				String t5=""+textField_3.getText();//工号
				String t6=""+textField_4.getText();//书名
				String t7=""+textField_5.getText();//出版社
				String t8=""+textField_6.getText();//作者
				String t9=""+textField_7.getText();//零售价
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
		          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
		          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
		          ResultSet rs = stmt.executeQuery("select * from books");
		          while (rs.next()) {  
		                  a1[a11]=rs.getString("ISBN");  
		                  a11+=1;
			          }

		          for(int i = 0; i < size; i ++) {
		        	  if(t1.equals(a1[i])){
		        		  flag = 1;
		        	  }
		          }
		          String a="";
		          if(flag == 0 && t7.equals(a)) {
		        	  WarningDialog warning = new WarningDialog();
			      	  warning.WarningDialog("没有该书信息，请在下面完善"); 
		          }
		          else if(!t7.equals(a)) {
		        	  String sql_1="insert into books values('"+t1+"','"+t6+"','"+t7+"','"+t8+"','"+t9+"','"+0+"')";
			          String sql_2="insert into order_list values('"+t4+"','"+t1+"','"+t2+"')";
			          String sql_3="insert into import_order values('"+t4+"','"+t3+"',0)";
			          stmt.executeUpdate(sql_1);
			          stmt.executeUpdate(sql_2);
			          stmt.executeUpdate(sql_3);
		          }
		          else {
		        	  String sql_1="insert into order_list values('"+t4+"','"+t1+"','"+t2+"')";
			          String sql_2="insert into import_order values('"+t4+"','"+t3+"',0)";
			          //String sql_3="update books set stock = stock + "+t2+" where ISBN = '"+t1+"'";//SQL语句
			          //String sql_4="insert into import_bill values('"+t4+"')";
			          //String sql_5="insert into bill values('"+t4+"',(select now()),'"+price+"')";
			          stmt.executeUpdate(sql_1);
			          stmt.executeUpdate(sql_2);
			          //stmt.executeUpdate(sql_3);
			          //stmt.executeUpdate(sql_5);
			          //stmt.executeUpdate(sql_4);  
		          }
		         }catch(Exception e1) {  
		          System.out.print("get data error!");  
		          e1.printStackTrace();  
		         }  
		}
	});
		btnSale.setBounds(163, 163, 97, 23);
		contentPane.add(btnSale);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Book_function();
			}
		});
		btnExit.setBounds(285, 386, 66, 23);
		contentPane.add(btnExit);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new function();
			}
		});
		btnHome.setBounds(74, 386, 80, 23);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("\u5DE5\u53F7");
		label.setBounds(201, 122, 58, 15);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setBounds(254, 119, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u540D");
		lblNewLabel_1.setBounds(70, 248, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 245, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u7248\u793E");
		label_1.setBounds(212, 248, 58, 15);
		contentPane.add(label_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(254, 245, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005");
		label_2.setBounds(70, 297, 58, 15);
		contentPane.add(label_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(113, 294, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_3 = new JLabel("\u96F6\u552E\u4EF7");
		label_3.setBounds(212, 297, 58, 15);
		contentPane.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(254, 294, 66, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 205, 316, 140);
		contentPane.add(panel);
		
		JLabel label_4 = new JLabel("\u65B0\u4E66\u4E13\u5C5E");
		panel.add(label_4);
	}
}

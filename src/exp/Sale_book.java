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

public class Sale_book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Sale_book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sale_book() {
		final JFrame frame = new JFrame("Sale_book");
		frame.setVisible(true);
		frame.setSize(404, 288);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalebook = new JLabel("\u5356\u4E66");
		lblSalebook.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblSalebook.setBounds(174, 37, 99, 24);
		contentPane.add(lblSalebook);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(204, 77, 58, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(243, 74, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumber = new JLabel("\u6570\u91CF");
		lblNumber.setBounds(63, 133, 58, 15);
		contentPane.add(lblNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 130, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSale = new JButton("\u786E\u8BA4");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String t1=""+textField.getText();//ISBN
			int t2=Integer.parseInt(textField_1.getText());//number
			//float t3=Float.parseFloat(textField_2.getText());//price
			float t3=0;
			float price = 0;
			//String t4=""+textField_3.getText();//order_ID
			String t4=order_bill.random_bill();//order_ID
			String t_4=order_bill.trans(t4);
			String t5=""+textField_2.getText();//工号person_ID
			int size=100;
			String[] a1=new String[size];//售价
			String[] a2=new String[size];//库存
			int a11=0;
			int a12=0;
		//	String t5=""+textField_4.getText();//time
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
		          ResultSet rs = stmt.executeQuery("select * from books where ISBN='"+t1+"'");
		  	        while (rs.next()) {  
	  	        	  	a1[a11]=rs.getString("price");  
	  	        	  	a2[a12]=rs.getString("stock");
	                    a11+=10;
	                    a12+=10;
	  	          }
		  	      int stock=Integer.parseInt(a2[0]);
		  	      if(stock < t2) {
		  	    	  WarningDialog warning = new WarningDialog();
			      	  warning.WarningDialog("库存不足");
			      	  return;
		  	      }
		  	      t3=Float.parseFloat(a1[0]);
		  	      price=t2*t3;
		          //String sql="insert into test1 values('2','张伟','110')";   //SQL语句
		          //stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
		          String sql_1="insert into order_list values('"+t4+"','"+t1+"','"+t2+"')";
		          String sql_2="insert into sales_order values('"+t4+"','"+t3+"')";
		          String sql="insert into bill_order values('"+t_4+"','"+t4+"')";
		          String sql_3="update books set stock = stock - "+t2+" where ISBN = '"+t1+"'";//SQL语句
		          String sql_5="insert into bill values('"+t_4+"',(select now()),'"+price+"')";
		          String sql_4="insert into sales_bill values('"+t_4+"')";
		          String sql_6="insert into operation values('"+t5+"','"+t4+"')";
		          stmt.executeUpdate(sql_1);
		          stmt.executeUpdate(sql_2);
		          stmt.executeUpdate(sql_3);
		          stmt.executeUpdate(sql_5);
		          stmt.executeUpdate(sql_4);
		          stmt.executeUpdate(sql_6);
		          stmt.executeUpdate(sql);
		                        //user 为你表的名称 
		         }catch(Exception e1) {  
		          System.out.print("get data error!");  
		          e1.printStackTrace();  
		         }  
		}
	});
		btnSale.setBounds(151, 175, 97, 23);
		contentPane.add(btnSale);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Book_function();
			}
		});
		btnExit.setBounds(255, 218, 66, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("\u5DE5\u53F7");
		lblNewLabel_1.setBounds(76, 77, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 77, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new function();
			}
		});
		btnHome.setBounds(63, 218, 86, 23);
		contentPane.add(btnHome);
	}

}

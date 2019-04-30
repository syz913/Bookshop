package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class return_book extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new return_book();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public return_book() {
		final JFrame frame = new JFrame("return_book");
		frame.setVisible(true);
		frame.setSize(501, 366);
		int size=200;
	      String[] a1=new String[size];
	      String[] a2=new String[size];
	      String[] a3=new String[size];
	      String[] a4=new String[size];
	      String[] a5=new String[size];
	      String[] a6=new String[size];
	      String[] a7=new String[size];
	      int a11=0;
	      int a12=0;
	      int a13=0;
	      int a14=0;
	      int a15=0;
	      int a16=0;
	      int a17=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 45, 398, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
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
	           
	          ResultSet rs = stmt.executeQuery("select * from import_order natural join order_list natural join books where state = 0");
	          while (rs.next()) {  
                  a1[a11]=rs.getString("order_ID");  
                  a2[a12]=rs.getString("ISBN");  
                  a3[a13]=rs.getString("book_name");  
                  a4[a14]=rs.getString("cost");
                  a5[a15]=rs.getString("number");
                  a6[a16]=Float.toString((Integer.parseInt(a5[a15])*Float.parseFloat(a4[a14])));
                  a7[a17]=rs.getString("state");
                  a11+=10;
                  a12+=20;
                  a13+=10;
                  a14+=10;
                  a15+=10;
                  a16+=10;
                  a17+=10;
	          }
	          table.setModel(new DefaultTableModel(
	          	new Object[][] {
	          		{a1[0], a2[0], a3[0],a4[0],a5[0],a6[0],a7[0]},
      				{a1[10], a2[20], a3[10],a4[10],a5[10],a6[10],a7[10]},
      				{a1[20], a2[40], a3[20],a4[20],a5[20],a6[20],a7[20]},
      				{a1[30], a2[60], a3[30],a4[30],a5[30],a6[30],a7[30]},
      				{a1[40], a2[80], a3[40],a4[40],a5[40],a6[40],a7[40]},
      				{a1[50], a2[100], a3[50],a4[50],a5[50],a6[50],a7[50]},
      				{a1[60], a2[120], a3[60],a4[60],a5[60],a6[60],a7[60]},
      				{a1[70], a2[140], a3[70],a4[70],a5[70],a6[70],a7[70]},
	          	},
	          	new String[] {
	          		"\u5355\u53F7", "ISBN", "\u4E66\u540D", "\u5355\u4EF7", "\u6570\u91CF", "\u603B\u4EF7", "State"
	          	}
	          ));
	          table.getColumnModel().getColumn(2).setPreferredWidth(88);
	          table.getColumnModel().getColumn(6).setMinWidth(20);
	          
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new Book_function();
	          	}
	          });
	          btnNewButton_1.setBounds(354, 296, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JLabel lblUnpaid = new JLabel("\u672A\u4ED8\u6B3E\u5217\u8868");
	          lblUnpaid.setFont(new Font("华文楷体", Font.PLAIN, 18));
	          lblUnpaid.setBounds(200, 10, 97, 25);
	          contentPane.add(lblUnpaid);
	          
	          textField = new JTextField();
	          textField.setBounds(183, 217, 66, 21);
	          contentPane.add(textField);
	          textField.setColumns(10);
	          
	          JComboBox comboBox = new JComboBox();
	          comboBox.setModel(new DefaultComboBoxModel(new String[] {"order_ID", "ISBN", "book_name"}));
	          comboBox.setBounds(64, 216, 84, 23);
	          contentPane.add(comboBox);
	          
	          JButton btnPay = new JButton("\u9000\u8D27");
	          btnPay.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          	int size=1000;
				String[] a1=new String[size];
				String[] a2=new String[size];
				String[] a3=new String[size];
				String[] a4=new String[size];
				int a11=0;
				int a12=0;
				int a13=0;
				int a14=0;
				int flag = 0;//用于判断书库中是否有这本书
				String t1=""+textField.getText();//order_ID
				//String t5=""+textField_4.getText();//time
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
			          ResultSet rs = stmt.executeQuery("select * from import_order natural join order_list natural join books where order_ID = '"+t1+"' and state = 0");
			          while (rs.next()) {  
			                  a1[a11]=rs.getString("ISBN");  
			                  a2[a12]=rs.getString("number");  
			                  a4[a14]=rs.getString("cost");
			                  a11+=1;
			                  a12+=1;
			                  a14+=1;
				          }
				          String sql_2="update import_order set state = -1 where order_ID = '"+t1+"'";
				         //String sql_3="update books set stock = stock + "+a2[0]+" where ISBN = '"+a1[0]+"'";//SQL语句
				         //String sql_4="insert into import_bill values('"+t1+"')";
				          //String sql_5="insert into bill values('"+t1+"',(select now()),'"+a4[0]+"',1)";
				         // stmt.executeUpdate(sql_1);
				          stmt.executeUpdate(sql_2);
				          //stmt.executeUpdate(sql_3);
				         // stmt.executeUpdate(sql_5);
				         // stmt.executeUpdate(sql_4);  
			          
			         }catch(Exception e1) {  
			          System.out.print("get data error!");  
			          e1.printStackTrace();  
			         }  
			}
		});
	          btnPay.setBounds(183, 262, 97, 23);
	          contentPane.add(btnPay);
	          
	          JButton order_2 = new JButton("\u641C\u7D22");
	          order_2.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		String choice =""+comboBox.getSelectedItem();
	          		String a = ""+textField.getText();
	          		  int size=200;
	          		  String[] a1=new String[size];
		      	      String[] a2=new String[size];
		      	      String[] a3=new String[size];
		      	      String[] a4=new String[size];
		      	      String[] a5=new String[size];
		      	      String[] a6=new String[size];
		      	      String[] a7=new String[size];
		      	      int a11=0;
		      	      int a12=0;
		      	      int a13=0;
		      	      int a14=0;
		      	      int a15=0;
		      	      int a16=0;
		      	      int a17=0;
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
		  	           
		  	          ResultSet rs = stmt.executeQuery("select * from import_order natural join order_list natural join books where "+choice+" = '"+a+"'");
		  	          while (rs.next()) {  
		  	        	 a1[a11]=rs.getString("order_ID");  
		                  a2[a12]=rs.getString("ISBN");  
		                  a3[a13]=rs.getString("book_name");  
		                  a4[a14]=rs.getString("cost");
		                  a5[a15]=rs.getString("number");
		                  a6[a16]=Float.toString((Integer.parseInt(a5[a15])*Float.parseFloat(a4[a14])));
		                  a7[a17]=rs.getString("state");
		                  a11+=10;
		                  a12+=20;
		                  a13+=10;
		                  a14+=10;
		                  a15+=10;
		                  a16+=10;
		                  a17+=10;
		  	          }
		  	          table.setModel(new DefaultTableModel(
		  	          	new Object[][] {
		  	          	{a1[0], a2[0], a3[0],a4[0],a5[0],a6[0],a7[0]},
	      				{a1[10], a2[20], a3[10],a4[10],a5[10],a6[10],a7[10]},
	      				{a1[20], a2[40], a3[20],a4[20],a5[20],a6[20],a7[20]},
	      				{a1[30], a2[60], a3[30],a4[30],a5[30],a6[30],a7[30]},
	      				{a1[40], a2[80], a3[40],a4[40],a5[40],a6[40],a7[40]},
	      				{a1[50], a2[100], a3[50],a4[50],a5[50],a6[50],a7[50]},
	      				{a1[60], a2[120], a3[60],a4[60],a5[60],a6[60],a7[60]},
	      				{a1[70], a2[140], a3[70],a4[70],a5[70],a6[70],a7[70]},
		  	          	},
		  	          	new String[] {
		  	          		"\u5355\u53F7", "ISBN", "\u4E66\u540D", "\u5355\u4EF7", "\u6570\u91CF", "\u603B\u4EF7", "State"
		  	          	
		  	          }
		 			          ));
					         }catch(Exception e1) {  
					          System.out.print("get data error!");  
					          e1.printStackTrace();  
					         }  

		          	}
		          });
	          order_2.setBounds(271, 216, 84, 23);
	          contentPane.add(order_2);
	          
	          JButton btnHome = new JButton("Home");
	          btnHome.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {
	          		frame.dispose();
	          		new function();
	          	}
	          });
	          btnHome.setBounds(51, 296, 84, 23);
	          contentPane.add(btnHome);
	          
	         
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}

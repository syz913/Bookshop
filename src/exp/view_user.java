package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_user extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new view_user();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_user() {
		final JFrame frame = new JFrame("view_user");
		frame.setVisible(true);
		frame.setSize(512, 320);
		int size=200;
		String[] sales_men=new String[size];

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
		scrollPane.setBounds(28, 21, 415, 156);
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
	           
	          ResultSet rs = stmt.executeQuery("(select * from person natural join salesmen natural join (select count(ID) as sales_num from salesmen) as p) union (select * from person natural join manager natural join (select count(ID) as sales_num from salesmen) as q)");
	          while (rs.next()) {  
	        	  	a1[a11]=rs.getString("ID");
	        	  	a2[a12]=rs.getString("name");  
	        	  	a3[a13]=rs.getString("password");  
	        	  	a4[a14]=rs.getString("gender");
	        	  	a6[a16]=rs.getString("age");
	        	  	a5[a15]=rs.getString("salary");
	        	  	a7[a17]=rs.getString("sales_num");
	        	  	a11+=10;
	        	  	a12+=20;
	        	  	a13+=10;
	        	  	a14+=10;
	        	  	a15+=10;
	        	  	a16+=10;
	          }
	          int num=Integer.parseInt(a7[0]);
	          for(int i = 0; i < num; i ++) {
	        	  sales_men[i] = a1[i*10];
	          }
	          String a="salesmen";
	          String b="manager";
	          for(int j = 0; j < 10; j ++) {
	        	  if(j < num) a7[j*10]=a;
	        	  else if(a1[j*10] != null) a7[j*10]=b;
	          }
	          table.setModel(new DefaultTableModel(
	          	new Object[][] {
	          		{a1[0], a2[0], a3[0],a4[0],a6[0],a5[0],a7[0]},
	      				{a1[10], a2[20], a3[10],a4[10],a6[10],a5[10],a7[10]},
	      				{a1[20], a2[40], a3[20],a4[20],a6[20],a5[20],a7[20]},
	      				{a1[30], a2[60], a3[30],a4[30],a6[30],a5[30],a7[30]},
	      				{a1[40], a2[80], a3[40],a4[40],a6[40],a5[40],a7[40]},
	      				{a1[50], a2[100], a3[50],a4[50],a6[50],a5[50],a7[50]},
	      				{a1[60], a2[120], a3[60],a4[60],a6[60],a5[60],a7[60]},
	      				{a1[70], a2[140], a3[70],a4[70],a6[70],a5[70],a7[70]},
	          	},
	          	new String[] {
	          		"ID", "name", "password", "gender","age","salary","级别"
	          	
	          }
	          ));
	          
	          JButton order_1 = new JButton("\u6309ID\u6392\u5E8F");
	          order_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
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
	  	           
	  	          ResultSet rs = stmt.executeQuery("(select * from person natural join salesmen natural join (select count(ID) as sales_num from salesmen) as p) union (select * from person natural join manager natural join (select count(ID) as sales_num from salesmen) as q) order by id asc");
	  	          while (rs.next()) {  
	  	        	  	a1[a11]=rs.getString("ID");  
	  	        	  	a2[a12]=rs.getString("name");  
	  	        	  	a3[a13]=rs.getString("password");  
	  	        	  	a4[a14]=rs.getString("gender");
	  	        	  	a6[a16]=rs.getString("age");
	  	        	  	a5[a15]=rs.getString("salary");
	                    a11+=10;
	                    a12+=20;
	                    a13+=10;
	                    a14+=10;
	                    a15+=10;
	                    a16+=10;
	  	          }
	  	          String a="salesmen";
		          String b="manager";
	  	          for(int j = 0; j < 10; j ++) {
		        	  if(a1[j*10] != null && Arrays.asList(sales_men).contains(a1[j*10])) a7[j*10]=a;
		        	  else if(a1[j*10] != null) a7[j*10]=b;
		          }
	  	          table.setModel(new DefaultTableModel(
	  	          	new Object[][] {
	  	          	{a1[0], a2[0], a3[0],a4[0],a6[0],a5[0],a7[0]},
      				{a1[10], a2[20], a3[10],a4[10],a6[10],a5[10],a7[10]},
      				{a1[20], a2[40], a3[20],a4[20],a6[20],a5[20],a7[20]},
      				{a1[30], a2[60], a3[30],a4[30],a6[30],a5[30],a7[30]},
      				{a1[40], a2[80], a3[40],a4[40],a6[40],a5[40],a7[40]},
      				{a1[50], a2[100], a3[50],a4[50],a6[50],a5[50],a7[50]},
      				{a1[60], a2[120], a3[60],a4[60],a6[60],a5[60],a7[60]},
      				{a1[70], a2[140], a3[70],a4[70],a6[70],a5[70],a7[70]},
	  	          	},
	  	          	new String[] {
	  	          		"ID", "name", "password", "gender","age","salary","级别"
	  	          	
	  	          }
	 			          ));
				         }catch(Exception e1) {  
				          System.out.print("get data error!");  
				          e1.printStackTrace();  
				         }  

	          	}
	          });
	          order_1.setBounds(62, 199, 124, 23);
	          contentPane.add(order_1);
	          
	          JButton order_2 = new JButton("\u6309\u5DE5\u8D44\u6392\u5E8F");
	          order_2.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
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
		  	           
		  	          ResultSet rs = stmt.executeQuery("(select * from person natural join salesmen natural join (select count(ID) as sales_num from salesmen) as p) union (select * from person natural join manager natural join (select count(ID) as sales_num from salesmen) as q) order by salary");
		  	        while (rs.next()) {  
	  	        	  	a1[a11]=rs.getString("ID");  
	  	        	  	a2[a12]=rs.getString("name");  
	  	        	  	a3[a13]=rs.getString("password");  
	  	        	  	a4[a14]=rs.getString("gender");
	  	        	  	a6[a16]=rs.getString("age");
	  	        	  	a5[a15]=rs.getString("salary");
	                    a11+=10;
	                    a12+=20;
	                    a13+=10;
	                    a14+=10;
	                    a15+=10;
	                    a16+=10;
	  	          }
		  	      String a="salesmen";
		          String b="manager";
	  	          for(int j = 0; j < 10; j ++) {
		        	  if(a1[j*10] != null && Arrays.asList(sales_men).contains(a1[j*10])) a7[j*10]=a;
		        	  else if(a1[j*10] != null) a7[j*10]=b;
		          }
	  	          table.setModel(new DefaultTableModel(
	  	          	new Object[][] {
	  	          	{a1[0], a2[0], a3[0],a4[0],a6[0],a5[0],a7[0]},
      				{a1[10], a2[20], a3[10],a4[10],a6[10],a5[10],a7[10]},
      				{a1[20], a2[40], a3[20],a4[20],a6[20],a5[20],a7[20]},
      				{a1[30], a2[60], a3[30],a4[30],a6[30],a5[30],a7[30]},
      				{a1[40], a2[80], a3[40],a4[40],a6[40],a5[40],a7[40]},
      				{a1[50], a2[100], a3[50],a4[50],a6[50],a5[50],a7[50]},
      				{a1[60], a2[120], a3[60],a4[60],a6[60],a5[60],a7[60]},
      				{a1[70], a2[140], a3[70],a4[70],a6[70],a5[70],a7[70]},
	  	          	},
	  	          	new String[] {
	  	          		"ID", "name", "password", "gender","age","salary","级别"
	  	          	
	  	          }
		 			          ));
					         }catch(Exception e1) {  
					          System.out.print("get data error!");  
					          e1.printStackTrace();  
					         }  

		          	}
		          });
	          order_2.setBounds(292, 199, 132, 23);
	          contentPane.add(order_2);
	          
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new User_function();
	          	}
	          });
	          btnNewButton_1.setBounds(354, 250, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JButton btnHome = new JButton("Home");
	          btnHome.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new function();
	          	}
	          });
	          btnHome.setBounds(62, 250, 70, 23);
	          contentPane.add(btnHome);
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}

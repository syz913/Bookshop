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

public class All_Bill extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new All_Bill();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public All_Bill() {
		final JFrame frame = new JFrame("All_Bill");
		frame.setVisible(true);
		frame.setSize(640, 427);
		int size=20000;
		  String[] a1=new String[size];
	      String[] a2=new String[size];
	      String[] a3=new String[size];
	      String[] a4=new String[size];	 
	      String[] a5=new String[size];	
	      int a11=0;
	      int a12=0;
	      int a13=0;
	      int a14=0;
	      int a15=0;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 45, 398, 155);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		
		scrollPane.setViewportView(table_1);
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
	           
	          //ResultSet rs = stmt.executeQuery("(select * from bill natural join sales_bill) union (select * from bill natural join import_bill) order by time");
	          ResultSet rs = stmt.executeQuery("(select * from (select * from bill natural join sales_bill natural join bill_order) as a left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on a.order_ID = opera.order_ID)\r\n" + 
	          		"union\r\n" + 
	          		"(select * from (select * from bill natural join import_bill natural join bill_order) as b left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on b.order_ID = opera.order_ID)\r\n" + 
	          		" order by time\r\n"
	          		);
	          while (rs.next()) {  
	        	  a1[a11]=rs.getString("person_ID");
	        	  a2[a12]=rs.getString("bill_ID");  
	              a3[a13]=rs.getString("time");  
	              a4[a14]=rs.getString("money");
	              a5[a15]=rs.getString("name");
	              
	              a11+=10;
	              a12+=20;
	              a13+=10;
	              a14+=10;	   
	              a15+=10;
	          }
	          table_1.setModel(new DefaultTableModel(
	          	new Object[][] {
	          		{a1[0],a5[0],a2[0], a3[0],a4[0]},
    				{a1[10],a5[10],a2[20], a3[10],a4[10]},
    				{a1[20],a5[20],a2[40], a3[20],a4[20]},
    				{a1[30],a5[30],a2[60], a3[30],a4[30]},
    				{a1[40],a5[40],a2[80], a3[40],a4[40]},
    				{a1[50],a5[50],a2[100], a3[50],a4[50]},
    				{a1[60],a5[60],a2[120], a3[60],a4[60]},
    				{a1[70],a5[70],a2[140], a3[70],a4[70]},
    				{a1[80],a5[80],a2[160], a3[80],a4[80]},
    				{a1[90],a5[90],a2[180], a3[90],a4[90]},
    				{a1[100],a5[100],a2[200], a3[100],a4[100]},
	          	},
	          	new String[] {
	          		"工号","姓名","\u8D26\u5355\u53F7", "\u65E5\u671F", "\u6536\u652F"
	          	}
	          ));
	          table_1.getColumnModel().getColumn(0).setPreferredWidth(8);
	         // table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	          DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	          for(int i = 0; i < 15; i ++)
        	  model.addRow(new Object[]{a1[110+10*i],a5[110+10*i],a2[220 + 20*i], a3[110 + 10*i], a4[110 + 10*i]});
        	  
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new view_bill();
	          	}
	          });
	          btnNewButton_1.setBounds(510, 357, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JLabel lblUnpaid = new JLabel("\u603B\u8D26\u5355");
	          lblUnpaid.setFont(new Font("华文楷体", Font.PLAIN, 18));
	          lblUnpaid.setBounds(200, 10, 97, 25);
	          contentPane.add(lblUnpaid);
	          
	          JButton btnNewButton = new JButton("\u76C8\u4F59");
	          btnNewButton.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		float [] a = new float[size];
	          		float sum = 0;
	          		int count = 0;
	          		for(int i = 0; i < size; i ++) {
	          			try {
	          				String s = table_1.getValueAt(i, 4).toString();
	          				count ++;
	          			}catch(Exception e1) {  
	          	          System.out.print("get data error!");  
	        	          e1.printStackTrace(); 
	        	          break;
	        	         }  
	          		
	          		}
	          		
	          		for(int i = 0; i < count; i ++) {
	          			sum +=  Float.parseFloat (table_1.getValueAt(i, 4).toString());	
	          		}
	          		textField.setText(sum+"");
	          	}
	          });
	          btnNewButton.setBounds(47, 225, 97, 23);
	          contentPane.add(btnNewButton);
	          
	          textField = new JTextField();
	          textField.setBounds(175, 227, 167, 21);
	          contentPane.add(textField);
	          textField.setColumns(10);
	          
	          JButton btnNewButton_2 = new JButton("\u5DE5\u53F7");
	          btnNewButton_2.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {
	          		String[] a1=new String[size];
		      	    String[] a2=new String[size];
		      	    String[] a3=new String[size];
		      	    String[] a4=new String[size];	
		      	    String[] a5=new String[size];
		      	    int a11=0;
		      	    int a12=0;
		      	    int a13=0;
		      	    int a14=0;
		      	    int a15=0;
		      	    
		      	    String id = textField_1.getText().toString();
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
	      	           
	      	          //ResultSet rs = stmt.executeQuery("(select * from bill natural join sales_bill) union (select * from bill natural join import_bill) order by time");
	      	          ResultSet rs = stmt.executeQuery("(select * from (select * from bill natural join sales_bill natural join bill_order) as a left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on a.order_ID = opera.order_ID where person_ID ='"+id+"' )\r\n" + 
	      	          		"union\r\n" + 
	      	          		"(select * from (select * from bill natural join import_bill natural join bill_order) as b left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on b.order_ID = opera.order_ID where person_ID = '"+id+"' )\r\n" + 
	      	          		"order by time"
	      	          		);
	      	          while (rs.next()) {  
	      	        	  a1[a11]=rs.getString("person_ID");
	      	        	  a2[a12]=rs.getString("bill_ID");  
	      	              a3[a13]=rs.getString("time");  
	      	              a4[a14]=rs.getString("money");
	      	              a5[a15]=rs.getString("name");
	      	              a11+=10;
	      	              a12+=20;
	      	              a13+=10;
	      	              a14+=10;	              
	      	              a15+=10;
	      	          }
	      	          table_1.setModel(new DefaultTableModel(
	      	          	new Object[][] {
	      	          	{a1[0],a5[0],a2[0], a3[0],a4[0]},
	    				{a1[10],a5[10],a2[20], a3[10],a4[10]},
	    				{a1[20],a5[20],a2[40], a3[20],a4[20]},
	    				{a1[30],a5[30],a2[60], a3[30],a4[30]},
	    				{a1[40],a5[40],a2[80], a3[40],a4[40]},
	    				{a1[50],a5[50],a2[100], a3[50],a4[50]},
	    				{a1[60],a5[60],a2[120], a3[60],a4[60]},
	    				{a1[70],a5[70],a2[140], a3[70],a4[70]},
	    				{a1[80],a5[80],a2[160], a3[80],a4[80]},
	    				{a1[90],a5[90],a2[180], a3[90],a4[90]},
	    				{a1[100],a5[100],a2[200], a3[100],a4[100]},
	      	          	},
	      	          	new String[] {
	      	          		"工号","姓名","\u8D26\u5355\u53F7", "\u65E5\u671F", "\u6536\u652F"
	      	          	}
	      	  	          ));
	      	        table_1.getColumnModel().getColumn(0).setPreferredWidth(8);
	      	      DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		          for(int i = 0; i < 15; i ++)
	        	  model.addRow(new Object[]{a1[110+10*i],a5[110+10*i],a2[220 + 20*i], a3[110 + 10*i], a4[110 + 10*i]});
	        	  
	      	   }catch(Exception e1) {  
			          System.out.print("get data error!");  
			          e1.printStackTrace();  
			         }  
	          	}
	          });
	          btnNewButton_2.setBounds(47, 263, 97, 23);
	          contentPane.add(btnNewButton_2);
	          
	          textField_1 = new JTextField();
	          textField_1.setBounds(175, 258, 66, 21);
	          contentPane.add(textField_1);
	          textField_1.setColumns(10);
	          
	          JButton btnImportbill = new JButton("\u8FDB\u8D27\u8D26\u5355");
	          btnImportbill.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		String[] a1=new String[size];
		      	    String[] a2=new String[size];
		      	    String[] a3=new String[size];
		      	    String[] a4=new String[size];	
		      	    String[] a5=new String[size];
		      	    int a11=0;
		      	    int a12=0;
		      	    int a13=0;
		      	    int a14=0;
		      	    int a15=0;
	      	    
	      	    String id = textField_1.getText().toString();
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
      	           
      	          //ResultSet rs = stmt.executeQuery("(select * from bill natural join sales_bill) union (select * from bill natural join import_bill) order by time");
      	          ResultSet rs = stmt.executeQuery("(select * from (select * from bill natural join import_bill natural join bill_order) as a left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on a.order_ID = opera.order_ID)\r\n" + 
      	   
      	          		"order by time"
      	          		);
      	          while (rs.next()) {  
      	        	a1[a11]=rs.getString("person_ID");
    	        	  a2[a12]=rs.getString("bill_ID");  
    	              a3[a13]=rs.getString("time");  
    	              a4[a14]=rs.getString("money");
    	              a5[a15]=rs.getString("name");
    	              a11+=10;
    	              a12+=20;
    	              a13+=10;
    	              a14+=10;	              
    	              a15+=10;
    	          }
    	          table_1.setModel(new DefaultTableModel(
    	          	new Object[][] {
    	          	{a1[0],a5[0],a2[0], a3[0],a4[0]},
	  				{a1[10],a5[10],a2[20], a3[10],a4[10]},
	  				{a1[20],a5[20],a2[40], a3[20],a4[20]},
	  				{a1[30],a5[30],a2[60], a3[30],a4[30]},
	  				{a1[40],a5[40],a2[80], a3[40],a4[40]},
	  				{a1[50],a5[50],a2[100], a3[50],a4[50]},
	  				{a1[60],a5[60],a2[120], a3[60],a4[60]},
	  				{a1[70],a5[70],a2[140], a3[70],a4[70]},
	  				{a1[80],a5[80],a2[160], a3[80],a4[80]},
	  				{a1[90],a5[90],a2[180], a3[90],a4[90]},
	  				{a1[100],a5[100],a2[200], a3[100],a4[100]},
    	          	},
    	          	new String[] {
    	          		"工号","姓名","\u8D26\u5355\u53F7", "\u65E5\u671F", "\u6536\u652F"
    	          	}
    	  	          ));
    	        table_1.getColumnModel().getColumn(0).setPreferredWidth(8);
    	      DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	          for(int i = 0; i < 15; i ++)
      	  model.addRow(new Object[]{a1[110+10*i],a5[110+10*i],a2[220 + 20*i], a3[110 + 10*i], a4[110 + 10*i]});
        	  
      	   }catch(Exception e1) {  
		          System.out.print("get data error!");  
		          e1.printStackTrace();  
		         }  
          	}
          });
	          btnImportbill.setBounds(457, 67, 114, 23);
	          contentPane.add(btnImportbill);
	          
	          JButton btnNewButton_3 = new JButton("\u9500\u552E\u8D26\u5355");
	          btnNewButton_3.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		String[] a1=new String[size];
		      	    String[] a2=new String[size];
		      	    String[] a3=new String[size];
		      	    String[] a4=new String[size];	
		      	    String[] a5=new String[size];
		      	    int a11=0;
		      	    int a12=0;
		      	    int a13=0;
		      	    int a14=0;
		      	    int a15=0;
	      	    
	      	    String id = textField_1.getText().toString();
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
      	           
      	          //ResultSet rs = stmt.executeQuery("(select * from bill natural join sales_bill) union (select * from bill natural join import_bill) order by time");
      	          ResultSet rs = stmt.executeQuery(
      	          		"(select * from (select * from bill natural join sales_bill natural join bill_order) as b left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on b.order_ID = opera.order_ID)\r\n" + 
      	          		"order by time"
      	          		);
      	          while (rs.next()) {  
      	        	  a1[a11]=rs.getString("person_ID");
	  	        	  a2[a12]=rs.getString("bill_ID");  
	  	              a3[a13]=rs.getString("time");  
	  	              a4[a14]=rs.getString("money");
	  	              a5[a15]=rs.getString("name");
	  	              a11+=10;
	  	              a12+=20;
	  	              a13+=10;
	  	              a14+=10;	              
	  	              a15+=10;
	  	          }
      	          table_1.setModel(new DefaultTableModel(
      	        		  new Object[][] {
      	        			  	{a1[0],a5[0],a2[0], a3[0],a4[0]},
				  				{a1[10],a5[10],a2[20], a3[10],a4[10]},
				  				{a1[20],a5[20],a2[40], a3[20],a4[20]},
				  				{a1[30],a5[30],a2[60], a3[30],a4[30]},
				  				{a1[40],a5[40],a2[80], a3[40],a4[40]},
				  				{a1[50],a5[50],a2[100], a3[50],a4[50]},
				  				{a1[60],a5[60],a2[120], a3[60],a4[60]},
				  				{a1[70],a5[70],a2[140], a3[70],a4[70]},
				  				{a1[80],a5[80],a2[160], a3[80],a4[80]},
				  				{a1[90],a5[90],a2[180], a3[90],a4[90]},
				  				{a1[100],a5[100],a2[200], a3[100],a4[100]},
			  	          	},
			  	          	new String[] {
			  	          		"工号","姓名","\u8D26\u5355\u53F7", "\u65E5\u671F", "\u6536\u652F"
			  	          	}
  	  	          ));
      	          table_1.getColumnModel().getColumn(0).setPreferredWidth(8);
      	          DefaultTableModel model = (DefaultTableModel) table_1.getModel();
      	          for(int i = 0; i < 15; i ++)
      	        	  model.addRow(new Object[]{a1[110+10*i],a5[110+10*i],a2[220 + 20*i], a3[110 + 10*i], a4[110 + 10*i]});
      	     	}catch(Exception e1) {  
		          System.out.print("get data error!");  
		          e1.printStackTrace();  
		         }  
          	}
          });
	          btnNewButton_3.setBounds(455, 163, 114, 23);
	          contentPane.add(btnNewButton_3);
	          
	          JComboBox comboBox = new JComboBox();
	          comboBox.setModel(new DefaultComboBoxModel(new String[] {"2019-4-22", "2019-4-23", "2019-4-24", "2019-4-25", "2019-4-26", "2019-4-27"}));
	          comboBox.setBounds(175, 312, 102, 23);
	          contentPane.add(comboBox);
	          
	          JComboBox comboBox_1 = new JComboBox();
	          comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2019-4-23", "2019-4-24", "2019-4-25", "2019-4-26", "2019-4-27", "2019-4-28"}));
	          comboBox_1.setBounds(311, 312, 97, 23);
	          contentPane.add(comboBox_1);
	          
	          JButton button = new JButton("\u65F6\u95F4\u8303\u56F4");
	          button.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {  
	          	String tmin=comboBox.getSelectedItem().toString();
	          	String tmax=comboBox_1.getSelectedItem().toString();
	          	String[] a1=new String[size];
	      	    String[] a2=new String[size];
	      	    String[] a3=new String[size];
	      	    String[] a4=new String[size];	
	      	    String[] a5=new String[size];
	      	    int a11=0;
	      	    int a12=0;
	      	    int a13=0;
	      	    int a14=0;
	      	    int a15=0;
	      	    
	      	    String id = textField_1.getText().toString();
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
      	           
      	          //ResultSet rs = stmt.executeQuery("(select * from bill natural join sales_bill) union (select * from bill natural join import_bill) order by time");
      	          ResultSet rs = stmt.executeQuery("(select * from (select * from bill natural join sales_bill natural join bill_order) as a left join (select *  from operation left join person on operation.person_ID = person.ID) as opera on a.order_ID = opera.order_ID where time >= '"+tmin+"' && time <= '"+tmax+"')\r\n" + 
      	          		"union\r\n" + 
      	          		"(select * from (select * from bill natural join import_bill natural join bill_order) as b left join (select *  from operation left join person on operation.person_ID = person.ID)as opera on b.order_ID = opera.order_ID  where time >= '"+tmin+"' && time <= '"+tmax+"')\r\n" + 
      	          		"order by time"
      	          		);
      	          while (rs.next()) {  
      	        	 a1[a11]=rs.getString("person_ID");
	  	        	  a2[a12]=rs.getString("bill_ID");  
	  	              a3[a13]=rs.getString("time");  
	  	              a4[a14]=rs.getString("money");
	  	              a5[a15]=rs.getString("name");
	  	              a11+=10;
	  	              a12+=20;
	  	              a13+=10;
	  	              a14+=10;	              
	  	              a15+=10;
	  	          }
     	          table_1.setModel(new DefaultTableModel(
     	        		  new Object[][] {
     	        			  	{a1[0],a5[0],a2[0], a3[0],a4[0]},
				  				{a1[10],a5[10],a2[20], a3[10],a4[10]},
				  				{a1[20],a5[20],a2[40], a3[20],a4[20]},
				  				{a1[30],a5[30],a2[60], a3[30],a4[30]},
				  				{a1[40],a5[40],a2[80], a3[40],a4[40]},
				  				{a1[50],a5[50],a2[100], a3[50],a4[50]},
				  				{a1[60],a5[60],a2[120], a3[60],a4[60]},
				  				{a1[70],a5[70],a2[140], a3[70],a4[70]},
				  				{a1[80],a5[80],a2[160], a3[80],a4[80]},
				  				{a1[90],a5[90],a2[180], a3[90],a4[90]},
				  				{a1[100],a5[100],a2[200], a3[100],a4[100]},
			  	          	},
			  	          	new String[] {
			  	          		"工号","姓名","\u8D26\u5355\u53F7", "\u65E5\u671F", "\u6536\u652F"
			  	          	}
 	  	          ));
     	          table_1.getColumnModel().getColumn(0).setPreferredWidth(8);
     	          DefaultTableModel model = (DefaultTableModel) table_1.getModel();
     	          for(int i = 0; i < 15; i ++)
     	        	  model.addRow(new Object[]{a1[110+10*i],a5[110+10*i],a2[220 + 20*i], a3[110 + 10*i], a4[110 + 10*i]});
        	  
      	   }catch(Exception e1) {  
		          System.out.print("get data error!");  
		          e1.printStackTrace();  
		         }  
          	}
          });
	          button.setBounds(47, 312, 97, 23);
	          contentPane.add(button);
	         
	          
	          JLabel label = new JLabel("\u5230");
	          label.setBounds(287, 316, 58, 15);
	          contentPane.add(label);
	          
	          JButton btnNewButton_4 = new JButton("Home");
	          btnNewButton_4.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {
	          		frame.dispose();
					new function();
	          	}
	          });
	          btnNewButton_4.setBounds(372, 357, 73, 23);
	          contentPane.add(btnNewButton_4);
	          
	         
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}

   
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

public class Grade extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Grade();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grade() {
		final JFrame frame = new JFrame("Grade");
		frame.setVisible(true);
		frame.setSize(501, 346);
		int size=200;
		String[] a1=new String[size];
	      String[] a2=new String[size];
	      String[] a3=new String[size];
	      String[] a5=new String[size];
	      
	      int a11=0;
	      int a12=0;
	      int a13=0;
	      int a15=0;
	      
	      a1[a11] = 0+"";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 45, 398, 157);
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
	          
	          int i = 0;
	          ResultSet rs = stmt.executeQuery("select person_ID, name, number*(price-cost)as sales from(\r\n" + 
	          		"select * from(\r\n" + 
	          		"select ISBN as I, person_ID,sum(number) as number from  operation natural join order_list \r\n" + 
	          		"natural join sales_order group by person_ID) as a\r\n" + 
	          		"left join\r\n" + 
	          		"(select * from\r\n" + 
	          		"(select distinct ISBN as IB,cost from import_order natural join order_list where state = 1) as p\r\n" + 
	          		"left join books on p.IB = books.ISBN) as b\r\n" + 
	          		"on a.I = b.IB)as pe left join person on pe.person_ID = person.ID\r\n" + 
	          		"order by sales desc;");
	          while (rs.next()) { 
	        	  i ++;
	        	  a1[a11]=i + "";
	        	  a2[a12]=rs.getString("person_ID");  
	        	  a3[a13]=rs.getString("name");
	              a5[a15]=rs.getString("sales");
	              a5[a15]=String.format("%.3f", Float.parseFloat(a5[a15]));
	              
	              a11+=10;
	              a12+=20;
	              a13+=10;
	              a15+=10;
	              
	          }
	          int count = 0;
	          for(i = 0; i < size; i ++) {
	        	  if(a1[i] == 0 + "") a1[i] = null;
	        	  else count ++;
	          }
	          table_1.setModel(new DefaultTableModel(
	          	new Object[][] {
	          		{a1[0],a2[0],a3[0], a5[0]},
    				{a1[10],a2[20], a3[10],a5[10]},
    				{a1[20],a2[40],a3[20], a5[20]},
    				{a1[30],a2[60],a3[30], a5[30]},
    				{a1[40],a2[80], a3[40],a5[40]},
    				{a1[50],a2[100],a3[50], a5[50]},
    				{a1[60],a2[120], a3[60],a5[60]},
    				{a1[70],a2[140], a3[70],a5[70]},
	          	},
	          	new String[] {
	          		"rank", "\u5DE5\u53F7", "\u59D3\u540D", "\u9500\u552E\u989D"
	          	}
	          ));
	          
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new Rank();
	          	}
	          });
	          btnNewButton_1.setBounds(364, 276, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JLabel lblUnpaid = new JLabel("\u7EE9\u6548\u6392\u540D");
	          lblUnpaid.setFont(new Font("华文楷体", Font.PLAIN, 18));
	          lblUnpaid.setBounds(200, 10, 97, 25);
	          contentPane.add(lblUnpaid);
	          
	          JButton btnNewButton = new JButton("\u5347\u804C");
	          btnNewButton.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
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
	  		          for(int i = 0; i < size; i ++) {
	          			try {
	          				String s1 = table_1.getValueAt(i, 3).toString();//sales
	          				String s2 = table_1.getValueAt(i, 1).toString();//ID
	          				 if(Float.parseFloat(s1) >= 300) {
	   		            	  String sql_1="insert into manager values('"+s2+"','"+0.05+"')";
	   		            	  String sql_2="delete from salesmen where ID = '"+s2+"'";
	   		            	  stmt.executeUpdate(sql_1);
	   		            	  stmt.executeUpdate(sql_2);
	   		              }
	          			}catch(Exception e1) {  
	          	          System.out.print("get data error!");  
	        	          e1.printStackTrace(); 
	        	          break;
	        	         }  
	          		
	          		}
	  		         }catch(Exception e1) {  
	  		          System.out.print("get data error!");  
	  		          e1.printStackTrace();  
	  		         }  
	  		}
	  	});
	          btnNewButton.setBounds(189, 236, 97, 23);
	          contentPane.add(btnNewButton);
	          
	          JButton btnHome = new JButton("Home");
	          btnHome.setBounds(47, 276, 78, 23);
	          contentPane.add(btnHome);
	          
	         
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}

   
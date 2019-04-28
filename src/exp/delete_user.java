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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dialog.EnsureDialog;

public class delete_user extends JFrame {

	private JPanel contentPane;
	private JTextField data1;
	
	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new delete_user();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public delete_user() {
		final JFrame frame = new JFrame("delete_user");
		frame.setVisible(true);
		frame.setSize(387, 368);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u89E3\u96C7\u5458\u5DE5");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(128, 25, 91, 34);
		contentPane.add(label);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u7528\u6237id");
		lblid.setBounds(69, 88, 91, 34);
		contentPane.add(lblid);
		
		data1 = new JTextField();
		data1.setBounds(159, 92, 79, 27);
		contentPane.add(data1);
		data1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 191, 282, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
      			new Object[][] {
      				{null,null,null,null,null},
      			},
      			new String[] {
      				"ID", "name", "password", "gender", "salary"
      			}
      		));
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t1=""+data1.getText();
				
				int size=200;
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
			          
			          ResultSet rs = stmt.executeQuery("select * from person natural join salesmen where ID = '"+t1+"'");
			          while (rs.next()) {  
		                  a1[a11]=rs.getString("ID");  
		                  a2[a12]=rs.getString("name");  
		                  a3[a13]=rs.getString("password");  
		                  a4[a14]=rs.getString("gender");
		                  a5[a15]=rs.getString("salary");
		                  a11+=10;
		                  a12+=20;
		                  a13+=10;
		                  a14+=10;
		                  a15+=10;
			          }
			          table.setModel(new DefaultTableModel(
			      			new Object[][] {
			      				{a1[0], a2[0], a3[0],a4[0],a5[0]},
			      			},
			      			new String[] {
			      				"ID", "name", "password", "gender", "salary"
			      			}
			      		));
			         }catch(Exception e) {  
			          System.out.print("get data error!");  
			          e.printStackTrace();  
			         }  
			}
		});
		btnNewButton.setBounds(122, 146, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new User_function();
			}
		});
		btnNewButton_1.setBounds(258, 298, 58, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnsureDialog flag = new EnsureDialog();
				if(!flag.EnsureDialog("确定要解雇该员工吗？")){
					return;
				}
				String t1=""+data1.getText();
				
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
			          String sql_1="delete from salesmen where ID = '"+t1+"'"; 
			          String sql_2="delete from operation where person_ID = '"+t1+"'";  
			          String sql="delete from person where ID = '"+t1+"'";  
			          stmt.executeUpdate(sql_1); 
			          stmt.executeUpdate(sql_2); 
			          stmt.executeUpdate(sql);         //将sql语句上传至数据库执行
			        
			         }catch(Exception e1) {  
			          System.out.print("get data error!");  
			          e1.printStackTrace();  
			         }  
			}
		});
		btnVerify.setBounds(122, 258, 97, 23);
		contentPane.add(btnVerify);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new function();
			}
		});
		btnNewButton_2.setBounds(31, 298, 71, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		
	}
}

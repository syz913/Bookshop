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
import java.awt.Color;

public class view_bill extends JFrame {

	private JPanel contentPane;

	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new view_bill();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_bill() {
		final JFrame frame = new JFrame("view_bill");
		frame.setVisible(true);
		frame.setSize(361, 326);
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
	      
	      a1[a11] = 0+"";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
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
	           
	          int i = 0,count = 0;
	          ResultSet rs = stmt.executeQuery("select * from (select ISBN, sum(number) as number "
	          		+ "from sales_order natural join order_list group by ISBN) as s left join books"
	          		+ " on s.ISBN = books.ISBN order by number desc");
	          while (rs.next()) { 
	        	  i ++;count++;
	        	  a1[a11]=i + "";
	        	  a2[a12]=rs.getString("book_name");  
	              a3[a13]=rs.getString("number");  
	              a5[a15]=rs.getString("price");
	              
	              a11+=10;
	              a12+=20;
	              a13+=10;
	              a15+=10;
	          }
	          int sum = 0;
	       
	          for(i = 0; i <count*10; i +=10) {
	        		  sum += Integer.parseInt(a3[i]);
	          } 
	          for(i = 0; i < count*10; i += 10)
	        	  a4[i] = Integer.parseInt(a3[i])*100/sum + "%";
	          
	          JButton btnNewButton_1 = new JButton("exit");
	          btnNewButton_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new function();
	          	}
	          });
	          btnNewButton_1.setBounds(200, 212, 70, 23);
	          contentPane.add(btnNewButton_1);
	          
	          JLabel lblUnpaid = new JLabel("Bill");
	          lblUnpaid.setForeground(Color.BLACK);
	          lblUnpaid.setBackground(Color.BLACK);
	          lblUnpaid.setFont(new Font("华文楷体", Font.BOLD, 25));
	          lblUnpaid.setBounds(153, 53, 155, 25);
	          contentPane.add(lblUnpaid);
	          
	          JButton btnHome = new JButton("Home");
	          btnHome.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new function();
	          	}
	          });
	          btnHome.setBounds(71, 212, 81, 23);
	          contentPane.add(btnHome);
	          
	          JButton button = new JButton("\u5168\u90E8\u8D26\u5355");
	          button.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent arg0) {
	          		frame.dispose();
	          		new All_Bill();
	          	}
	          });
	          button.setBounds(126, 101, 97, 23);
	          contentPane.add(button);
	          
	          JButton button_1 = new JButton("\u6708\u5EA6\u8D26\u5355");
	          button_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		frame.dispose();
	          		new Month_bill();
	          	}
	          });
	          button_1.setBounds(126, 161, 97, 23);
	          contentPane.add(button_1);
	          
	         
	         }catch(Exception e) {  
	          System.out.print("get data error!");  
	          e.printStackTrace();  
	         }  
	}
}

   
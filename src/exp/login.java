package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dialog.EnsureDialog;
import Dialog.WarningDialog;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private static final int WIDTH = 500;
	 
	private static final int HEIGHT = 350;
	private JTextField textField_1;
	String code;//验证码

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		final JFrame frame = new JFrame("login");
		frame.setVisible(true);
		frame.setSize(436, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("华文楷体", Font.PLAIN, 18));
		label.setBounds(139, 34, 154, 34);
		contentPane.add(label);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		lblLogin.setBounds(189, 78, 58, 15);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("\u5E10\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 109, 58, 25);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(99, 150, 58, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(161, 111, 111, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 152, 111, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnsureDialog flag = new EnsureDialog();
				if(!flag.EnsureDialog("确定要登录吗？")) {
					return;
				}
				int size = 1000;
				String t1=""+textField.getText();
				char[] password=passwordField.getPassword();
				String t=String.valueOf(password); //将char数组转化为string类型
				String t2 = "";
				try {
					t2 = HashUtils.encrypt(t.getBytes("UTF-8"), "MD5");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String t3=textField_1.getText();//验证码
				String[] a1=new String[size];
	      	    String[] a2=new String[size];
	      	    String[] a3=new String[size];
		      	int a11=0;
	      	    int a12=0;
	      	    int a13=0;
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
			           
			          ResultSet rs = stmt.executeQuery("(select * from manager natural join person)\r\n" + 
			          		"union\r\n" + 
			          		"(select * from salesmen natural join person)");
			          while (rs.next()) {  
 		                  a1[a11]=rs.getString("ID");  
 		                  a2[a12]=rs.getString("password");  
 		                  a3[a13]=rs.getString("stocks");
 		                  a11+=1;
 		                  a12+=1;
 		                  a13+=1;
 			          }
			          int f = 0;
			          if(t1.equals("syz") && t.equals("123") && t3.equals(code)) {
			        	  f = 1;
			        	  frame.dispose();
		                  new function(); 
			          }
			          else {
			        	  for(int i = 0; i < size; i ++) {
				        	  if(t1.equals(a1[i]) && t2.equals(a2[i]) && t3.equals(code)){
				        		  f = 1;
				        		  if(Float.parseFloat(a3[i]) > 1) {
				        			  frame.dispose();
					                  new low_function();
				        		  }
				        		  else {
				        			  frame.dispose();
					                  new function(); 
				        		  }
				        	  }
				          }
			          }   
			          if(f == 0) {
			        	  WarningDialog warning = new WarningDialog();
				      	  warning.WarningDialog("信息错误");  
			          }
			    }catch(Exception e1) {  
			          System.out.print("get data error!");  
			          e1.printStackTrace();  
			         }  
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(161, 263, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel Click = new JLabel("\u70B9\u51FB");
		Click.setFont(new Font("宋体", Font.BOLD, 15));
		Click.setBounds(60, 186, 97, 45);
		contentPane.add(Click);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 198, 111, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 1){	
					//重新获取验证码
					getPicture(Click,contentPane);
				}
			}
		});
	}
	//添加图片，获取验证码
		public void getPicture(JLabel label,JPanel panel){
			Object[] obj = CodePicture.createImage();
			code = obj[0].toString();
			System.out.println("1:"+code);
			ImageIcon img = new ImageIcon((BufferedImage)obj[1]);//创建图片对象
			label.setIcon((Icon)img);
			panel.add(label);
		}
	
}

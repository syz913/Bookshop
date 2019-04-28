package exp;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class CheckCode extends JFrame {
	private static Random random = new Random();
	private int width = 53;//验证码宽度
	private int height =25;//验证码高度
	private int font_size = 20;//验证码颜色
	private int x = 100;//验证码所在窗体X坐标
	private int y = 100;//验证码所在窗体Y坐标
	private int jam = 5;//干扰元素 建议使用 4~7 之间的数字
	private String code = "";//保存验证码
	private JTextField textField;
	 
	public CheckCode(){//初始化窗体信息
		super("请输入验证码");
		setVisible(true);
		setBounds((Toolkit.getDefaultToolkit().getScreenSize().width-300)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-300)/2, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(165, 67, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				repaint();
			}
		});
	}
 
	public Color getRandomColor(){//获得随机颜色
		int R=random.nextInt(255),G=random.nextInt(255),B=random.nextInt(255);
		return new Color(R,G,B);
	}
	 
	public String getRandomString(){//获得验证码
		int num = random.nextInt(9);
		code = num+"";
		return num+"";
	}
	 
	public void checkCode(Graphics g){// 绘画验证码
		drawBorder(g); 
		drawCode(g);
		drawJam(g);
	}
	 
	public void drawBorder(Graphics g){//绘画边框和背景
		Color gc = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setColor(gc);
	}
	 
	public void drawCode(Graphics g){//绘画验证码内容
		Color gc = g.getColor();
		for(int i=0;i<4;i++){
			g.setColor(getRandomColor());
			g.setFont(new Font("宋体",Font.BOLD,font_size));
			g.drawString(getRandomString(), x+5+(i*12), y+font_size);
		}
		g.setColor(gc);
	}
	 
	public void drawJam(Graphics g){//绘画干扰元素
		Color gc = g.getColor();
		for(int i=0;i<jam;i++){
		g.setColor(getRandomColor());
		g.drawLine(x+random.nextInt(width), y+random.nextInt(height), x+random.nextInt(width), y+random.nextInt(height));
		}
		g.setColor(gc);
	}
	 
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.drawString("单击可刷新验证码", 30, 50);
		checkCode(g);
		g.setColor(c);
	}
	 
	public static void main(String[] args) {
		new CheckCode();
	}
}
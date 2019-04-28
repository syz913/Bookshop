package exp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class CodePicture {
	// ��֤���ַ���
	private static final char[] chars = ("0123456789abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	// �ַ�����
	private static final int SIZE = 4;
	// ����������
	private static final int LINES = 10;
	// ���
	private static final int WIDTH = 80;
	// �߶�
	private static final int HEIGHT = 40;
	// �����С
	private static final int FONT_SIZE = 30;//30
 
	/**
	 * ���������֤�뼰ͼƬ
	 */
	public static Object[] createImage() {
		StringBuffer sb = new StringBuffer();
		// 1.�����հ�ͼƬ
		BufferedImage image = new BufferedImage(
			WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.��ȡͼƬ����
		Graphics graphic = image.getGraphics();
		// 3.���û�����ɫ
		graphic.setColor(Color.LIGHT_GRAY);
		// 4.���ƾ��α���
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.������ַ�
		Random ran = new Random();
		for (int i = 0; i <SIZE; i++) {
			// ȡ����ַ�����
			int n = ran.nextInt(chars.length);
			// ���������ɫ
			graphic.setColor(getRandomColor());
			// ���������С
			graphic.setFont(new Font(
				null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			// ���ַ�
			graphic.drawString(
				chars[n] + "", i * WIDTH / SIZE, HEIGHT/2+10);
			// ��¼�ַ�
			sb.append(chars[n]);
		}
		// 6.��������
		for (int i = 0; i < LINES; i++) {
			// ���������ɫ
			graphic.setColor(getRandomColor());
			// �������
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7.������֤���ͼƬ
		return new Object[]{sb.toString(), image};
	}
	
	/**
	 * ���ȡɫ
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), 
				ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
	//�������
	public static void main(String[] args) throws IOException {
		Object[] objs = createImage();
		BufferedImage image = 
			(BufferedImage) objs[1];
		// UNIXϵͳ /home/soft01/1.png
		OutputStream os = 
			new FileOutputStream("d:/3.png");
		ImageIO.write(image, "png", os);
		os.close();
	}
}
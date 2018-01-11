package com.hospital.pulbic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class CreatImage {
	static Random m = new Random();
	static CreatImage c = new CreatImage();
	static String code = null;
	public static void main(String[] args) {
		BufferedImage image = getImage();
		System.out.println(getChar());
		System.out.println(getString());
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("d:\\a.jpg"));
			ImageIO.write(image, "JPEG", os);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static String getCode() {
		return code;
	}

	//������֤��ͼƬ
	public static BufferedImage getImage(){
		//��ȡ��֤���ַ���
		code = getString();
		//����һ��ͼ�� ����
		BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_BGR);
		//��ȡһ�����Ի��Ƶ�2DͼƬ
		Graphics g = image.getGraphics();
		//������ɫ
		g.setColor(Color.WHITE);
		//���ͼƬ����
		g.fillRect(0, 0, 100, 40);
		
		//д�ַ���
		for(int i=0;i<code.length();i++){
			//���������С
			g.setFont(new Font("Times New Roman", Font.BOLD, 25));
			//������ɫ
			g.setColor(new Color(m.nextInt(255), m.nextInt(255), m.nextInt(255)));
			//д���ַ���
			g.drawString(code.substring(i, i+1), 10+20*i, 20+m.nextInt(15));
		
		}
		
		//������
		for(int i=0;i<100;i++){
			g.setColor(new Color(m.nextInt(255), m.nextInt(255), m.nextInt(255)));
			g.drawOval(m.nextInt(100),m.nextInt(40), 1, 1);
		}
		return image;
	}
	
	
	
	//����4�ַ�����֤��
	public static String getString(){
		String str = "";
		str = str+c.getChar()+c.getChar()+c.getChar()+c.getChar();
		return str;
	}
	
	//�������һ���ַ�
	public static char getChar(){
		
		int i = m.nextInt(62); 
		char c ;
		if(i>=0&&i<=9){
			c = (char)(i+48);
			
		}else if(i>9&&i<=36){
			
			c = (char)(i+55);
		}else{
			c = (char)(i+60);
		}
		return c;
	}
	
}

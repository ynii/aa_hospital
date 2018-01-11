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

	//生成验证码图片
	public static BufferedImage getImage(){
		//获取验证码字符串
		code = getString();
		//创建一个图像 对象
		BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_BGR);
		//获取一个可以绘制的2D图片
		Graphics g = image.getGraphics();
		//设置颜色
		g.setColor(Color.WHITE);
		//填充图片背景
		g.fillRect(0, 0, 100, 40);
		
		//写字符串
		for(int i=0;i<code.length();i++){
			//设置字体大小
			g.setFont(new Font("Times New Roman", Font.BOLD, 25));
			//设置颜色
			g.setColor(new Color(m.nextInt(255), m.nextInt(255), m.nextInt(255)));
			//写入字符串
			g.drawString(code.substring(i, i+1), 10+20*i, 20+m.nextInt(15));
		
		}
		
		//干扰线
		for(int i=0;i<100;i++){
			g.setColor(new Color(m.nextInt(255), m.nextInt(255), m.nextInt(255)));
			g.drawOval(m.nextInt(100),m.nextInt(40), 1, 1);
		}
		return image;
	}
	
	
	
	//产生4字符的验证码
	public static String getString(){
		String str = "";
		str = str+c.getChar()+c.getChar()+c.getChar()+c.getChar();
		return str;
	}
	
	//随机生成一个字符
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

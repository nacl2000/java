package 课设;

import java.awt.*;
import javax.swing.*;

public class enter {
	public void creatgui() {
		JFrame f=new JFrame("中学信息管理系统");
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
		JTextField tf1=new JTextField(20);
		JTextField tf2=new JTextField(20);
		JLabel admin=new JLabel("账号");
		JLabel password=new JLabel("密码");
		JButton denglu=new JButton("登录");
		JButton zhuce=new JButton("注册");
		f.add(tf1);
		f.add(tf2);
		f.add(admin);
		f.add(password);
		f.add(denglu);
		f.add(zhuce);
		tf1.setBounds(180, 100, 140, 20);
		tf2.setBounds(180, 160, 140, 20);
		admin.setBounds(130, 100, 140, 20);
		password.setBounds(130, 160, 140, 20);
		denglu.setBounds(90, 250, 140, 20);
		zhuce.setBounds(280, 250, 140, 20);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enter e=new enter();
		e.creatgui();
	}
}

package ����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class enter {
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/����?"
			+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
	static private String name = "root";
	static private String Password = "jhy,.jht";
	private ResultSet set;
	public void creatgui() {
		JFrame f=new JFrame("��ѧ��Ϣ����ϵͳ");
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
		JTextField tf1=new JTextField(20);
		JPasswordField tf2=new JPasswordField(20);
		JLabel admin=new JLabel("�˺�");
		JLabel password=new JLabel("����");
		JButton denglu=new JButton("��¼");
		JButton zhuce=new JButton("ע��");
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(zhuce)) {
					f.dispose();
					Login tmp=new Login();
					tmp.start();
				}else if(e.getSource().equals(denglu)) {
					char s[]=tf2.getPassword();
					String pass=new String(s);
					String adm=tf1.getText();
					try{//��������
			            Class.forName("com.mysql.cj.jdbc.Driver");//��������
			            Connection coon = DriverManager.getConnection(UTR,name,Password);//�������Ӷ���
			            String sql=" select password from user where username='"+adm+"'"; 
			            Statement stmt = coon.createStatement();
			            set = stmt.executeQuery(sql);
			            if(set.next()&&set.getString(1).equals(pass)) {
			            	choose tmp=new choose();
			            	f.dispose();
			            	tmp.start();
			            }else {
			            	JOptionPane.showMessageDialog(null, "�û������������", "������",
			            										JOptionPane.ERROR_MESSAGE);
			            }
			            coon.close();
			            stmt.close();
			            set.close();
			        }catch (Exception e1){
			            e1.printStackTrace();
			        }
				}
			}
		}
		f.add(tf1);
		f.add(tf2);
		f.add(admin);
		f.add(password);
		f.add(denglu);
		f.add(zhuce);
		denglu.addActionListener(new mylistener());
		zhuce.addActionListener(new mylistener());
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

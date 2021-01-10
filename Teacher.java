package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
public class Teacher implements ActionListener{
	public JFrame f=new JFrame("教师信息管理");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/课设?"
			+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
	static private String NAME = "root";
	static private String PASSWORD = "jhy,.jht";
	private JButton re=new JButton("返回");
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(re)) {
			f.dispose();
			choose tmp=new choose();
			tmp.start();
		}
	}
	int tmp=0;
	public void init() {
		f=new JFrame("教师信息管理");
		tmp++;
		if(tmp==1) {
			re.addActionListener(this);
		}
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
	}
	public void start() {
		init();
		//输入
		JTextField tid=new JTextField(20);
		JTextField name=new JTextField(20);
		JTextField sex=new JTextField(20);
		JTextField phone=new JTextField(20);
		JTextField address=new JTextField(20);
		
		f.add(tid);
		f.add(name);
		f.add(sex);
		f.add(address);
		f.add(phone);
		
		tid.setBounds(180,40,150,20);
		name.setBounds(180,80,150,20);
		sex.setBounds(180,120,150,20);
		phone.setBounds(180,160,150,20);
		address.setBounds(180,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("教师号：");
		JLabel xingming=new JLabel("姓名：");
		JLabel xingbie=new JLabel("性别：");
		JLabel shouji=new JLabel("手机号：");
		JLabel zhuzhi=new JLabel("住址：");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		f.add(zhuzhi);
		f.add(shouji);
		
		xuehao.setBounds(130,40,150,20);
		xingming.setBounds(130,80,150,20);
		xingbie.setBounds(130,120,150,20);
		shouji.setBounds(130,160,150,20);
		zhuzhi.setBounds(130,200,150,20);
		//按钮
		JButton ad=new JButton("添加");
		JButton update=new JButton("修改");
		JButton delete=new JButton("删除");
		JButton query=new JButton("查找");
		f.add(ad);
		f.add(query);
		f.add(update);
		f.add(delete);
		ad.setBounds(30,300,80,30);
		update.setBounds(120,300,80,30);
		delete.setBounds(210,300,80,30);
		query.setBounds(300,300,80,30);
		f.add(re);
		re.setBounds(390,300,80,30);
		//事务
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(ad)) {
					try{//加载驱动
			            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//创建连接对象
			            if(tid.getText()==null||name.getText()==null||sex.getText()==null||
			            				phone.getText()==null||address.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "信息未填写完整", "出错啦",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String []ss=new String [10];
			            ss[0]=tid.getText();
			            ss[1]=name.getText();
			            ss[2]=sex.getText();
			            ss[3]=phone.getText();
			            ss[4]=address.getText();
			            String sql=" INSERT  INTO  teacher   VALUES  ('"+ss[0]+"','"+ss[1]+"','"+ss[2]+"','"+ss[3]+"','"+ss[4]+"')"; 
			            Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            coon.close();
			            stmt.close();
			        }catch (Exception e1){
			            e1.printStackTrace();
			        }
				}else if(e.getSource().equals(query)) {
					
				}else if(e.getSource().equals(update)) {
					try{//加载驱动
			            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//创建连接对象
			            if(tid.getText()==null||name.getText()==null||sex.getText()==null||phone.getText()==null||
			            				address.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "信息未填写完整", "出错啦",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String []ss=new String [10];
			            ss[0]=tid.getText();
			            ss[1]=name.getText();
			            ss[2]=sex.getText();
			            ss[3]=phone.getText();
			            ss[4]=address.getText();
			            String sql=" UPDATE teacher SET name='"+ss[1]+"',sex='"+ss[2]+"',phone='"+ss[3]+"',address='"+ss[4]+"' "
			            		+ "where tid='"+ss[0]+"' ";
			            Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            coon.close();
			            stmt.close();
			        }catch (Exception e1){
			            e1.printStackTrace();
			        }
				}else {
					try{//加载驱动
			            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//创建连接对象
			            if(tid.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "教师号不能为空", "出错啦",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String ss=tid.getText();
			            String sql="delete from teacher where tid='"+ss+"'"; 
			            Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            coon.close();
			            stmt.close();
			        }catch (Exception e1){
			            e1.printStackTrace();
			        }
				}
			}
		}
		ad.addActionListener(new mylistener());
		delete.addActionListener(new mylistener());
		update.addActionListener(new mylistener());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher s=new Teacher();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

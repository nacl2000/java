package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
public class Student implements ActionListener{
	public JFrame f=new JFrame("学生信息管理");
	private JButton re=new JButton("返回");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/课设?"
			+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
	static private String NAME = "root";
	static private String PASSWORD = "jhy,.jht";
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
		f=new JFrame("学生信息管理");
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
		JTextField sid=new JTextField(20);
		JTextField name=new JTextField(20);
		JTextField sex=new JTextField(20);
		JTextField classnumber=new JTextField(20);
		JTextField phone=new JTextField(20);
		JTextField address=new JTextField(20);
		
		f.add(sid);
		f.add(name);
		f.add(sex);
		f.add(classnumber);
		f.add(phone);
		f.add(address);
		
		sid.setBounds(80,40,150,20);
		name.setBounds(80,80,150,20);
		sex.setBounds(80,120,150,20);
		classnumber.setBounds(310,40,150,20);
		phone.setBounds(310,80,150,20);
		address.setBounds(310,120,150,20);
		//提示字
		JLabel xuehao=new JLabel("学号：");
		JLabel xingming=new JLabel("姓名：");
		JLabel xingbie=new JLabel("性别：");
		JLabel banji=new JLabel("班级：");
		JLabel shoujihao=new JLabel("手机号：");
		JLabel zhuzhi=new JLabel("住址：");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		f.add(banji);
		f.add(shoujihao);
		f.add(zhuzhi);
		
		xuehao.setBounds(30,40,150,20);
		xingming.setBounds(30,80,150,20);
		xingbie.setBounds(30,120,150,20);
		banji.setBounds(260,40,150,20);
		shoujihao.setBounds(260,80,150,20);
		zhuzhi.setBounds(260,120,150,20);
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
		//事件
//		f.add(sid);
//		f.add(name);
//		f.add(sex);
//		f.add(classnumber);
//		f.add(phone);
//		f.add(address);
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(ad)) {
					try{//加载驱动
			            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//创建连接对象
			            if(sid.getText()==null||name.getText()==null||sex.getText()==null||classnumber.getText()==null||
			            				phone.getText()==null||address.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "信息未填写完整", "出错啦",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String []ss=new String [10];
			            ss[0]=sid.getText();
			            ss[1]=name.getText();
			            ss[2]=sex.getText();
			            ss[3]=classnumber.getText();
			            ss[4]=phone.getText();
			            ss[5]=address.getText();
			            String sql=" INSERT  INTO  student   VALUES  ('"+ss[0]+"','"+ss[1]+"','"+ss[2]+"','"+ss[3]+"','"+ss[4]+"','"+ss[5]+"')"; 
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
			            if(sid.getText()==null||name.getText()==null||sex.getText()==null||classnumber.getText()==null||
	            				phone.getText()==null||address.getText()==null) {
			            		JOptionPane.showMessageDialog(null, "信息未填写完整", "出错啦",
							JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String []ss=new String [10];
			            ss[0]=sid.getText();
			            ss[1]=name.getText();
			            ss[2]=sex.getText();
			            ss[3]=classnumber.getText();
			            ss[4]=phone.getText();
			            ss[5]=address.getText();
			            String sql=" UPDATE student SET name='"+ss[1]+"',sex='"+ss[2]+"',classnumber='"+ss[3]+"',phone='"+ss[4]+"', "
			            		+ " address='"+ss[5]+"' where sid='"+ss[0]+"' ";
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
			            if(sid.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "学号不能为空", "出错啦",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String ss=sid.getText();
			            String sql="delete from student where sid='"+ss+"'"; 
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
		Student s=new Student();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

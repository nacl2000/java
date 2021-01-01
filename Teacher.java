package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Teacher implements ActionListener{
	public JFrame f=new JFrame("学生信息管理");
	private JButton re=new JButton("返回");
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(re)) {
			f.dispose();
			start();
		}
	}
	int tmp=0;
	public void init() {
		f=new JFrame("成绩管理");
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
		JButton add=new JButton("增加教师信息");
		JButton update=new JButton("修改教师信息");
		JButton delete=new JButton("删除教师信息");
		JButton ret=new JButton("返回");
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(add)) {
					f.dispose();
					ADD();
				}else if(e.getSource().equals(update)) {
					f.dispose();
					UPDATE();
				}else if(e.getSource().equals(delete)){
					f.dispose();
					DELETE();
				}else {
					f.dispose();
					INFORMATION tmp=new INFORMATION();
					tmp.start();
				}
			}
		}
		f.add(add);
		f.add(update);
		f.add(delete);
		f.add(ret);
		ret.addActionListener(new mylistener());
		ret.setBounds(210,300,80,30);
		add.addActionListener(new mylistener());
		delete.addActionListener(new mylistener());
		update.addActionListener(new mylistener());
		add.setBounds(60,120,110,110);
		delete.setBounds(200,120,110,110);
		update.setBounds(340,120,110,110);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void ADD() {
		init();
		//输入
		JTextField sid=new JTextField(20);
		JTextField name=new JTextField(20);
		JTextField sex=new JTextField(20);
		JTextField phone=new JTextField(20);
		JTextField address=new JTextField(20);
		
		f.add(sid);
		f.add(name);
		f.add(sex);
		f.add(phone);
		f.add(address);
		
		sid.setBounds(170,40,150,20);
		name.setBounds(170,80,150,20);
		sex.setBounds(170,120,150,20);
		phone.setBounds(170,160,150,20);
		address.setBounds(170,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("教师号：");
		JLabel xingming=new JLabel("姓名：");
		JLabel xingbie=new JLabel("性别：");
		JLabel shoujihao=new JLabel("手机号：");
		JLabel zhuzhi=new JLabel("住址：");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		f.add(shoujihao);
		f.add(zhuzhi);
		
		xuehao.setBounds(110,40,150,20);
		xingming.setBounds(110,80,150,20);
		xingbie.setBounds(110,120,150,20);
		shoujihao.setBounds(110,160,150,20);
		zhuzhi.setBounds(110,200,150,20);
		//按钮
		JButton accpet=new JButton("添加");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void UPDATE() {
		init();
		//输入
		JTextField sid=new JTextField(20);
		JTextField name=new JTextField(20);
		JTextField sex=new JTextField(20);
		JTextField phone=new JTextField(20);
		JTextField address=new JTextField(20);
		
		f.add(sid);
		f.add(name);
		f.add(sex);
		f.add(phone);
		f.add(address);
		
		sid.setBounds(170,40,150,20);
		name.setBounds(170,80,150,20);
		sex.setBounds(170,120,150,20);
		phone.setBounds(170,160,150,20);
		address.setBounds(170,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("教师号：");
		JLabel xingming=new JLabel("姓名：");
		JLabel xingbie=new JLabel("性别：");
		JLabel shoujihao=new JLabel("手机号：");
		JLabel zhuzhi=new JLabel("住址：");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		f.add(shoujihao);
		f.add(zhuzhi);
		
		xuehao.setBounds(110,40,150,20);
		xingming.setBounds(110,80,150,20);
		xingbie.setBounds(110,120,150,20);
		shoujihao.setBounds(110,160,150,20);
		zhuzhi.setBounds(110,200,150,20);
		//按钮
		JButton accpet=new JButton("确认修改");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void DELETE() {
		init();
		JTextField sid=new JTextField(20);
		
		f.add(sid);
		
		sid.setBounds(170,150,150,20);
		//提示字
		JLabel xuehao=new JLabel("教师号：");

		f.add(xuehao);
		
		xuehao.setBounds(110,150,150,20);
		//按钮
		JButton accpet=new JButton("确认删除");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t=new Teacher();
//		t.init();
		t.start();
//		t.ADD();
//		t.UPDATE();
//		t.DELETE();
	}
}

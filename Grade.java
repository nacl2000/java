package 课设;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Grade implements ActionListener{
	public JFrame f=new JFrame("成绩管理");
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
		tmp++;
		if(tmp==1) {
			re.addActionListener(this);
		}
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
	}
	public void look() {
		f=new JFrame("成绩管理");
		init();
		JComboBox<String>sid=new JComboBox<>();
		sid.setBounds(40,20,80,20);
		sid.addItem("学号");
		
		JComboBox<String>name=new JComboBox<>();
		name.setBounds(120,20,80,20);
		name.addItem("姓名");
		
		JComboBox<String>classnumber=new JComboBox<>();
		classnumber.setBounds(200,20,80,20);
		classnumber.addItem("班级");
		classnumber.addItem("初一(1)班");
		classnumber.addItem("初二(2)班");
		classnumber.addItem("初三(1)班");
		classnumber.addItem("高一(1)班");
		classnumber.addItem("高二(1)班");
		classnumber.addItem("高三(1)班");
		
		JComboBox<String>subject=new JComboBox<>();
		subject.setBounds(280,20,80,20);
		subject.addItem("总分");
		subject.addItem("语文");
		subject.addItem("数学");
		subject.addItem("英语");
		subject.addItem("物理");
		subject.addItem("化学");
		subject.addItem("生物");
		subject.addItem("历史");
		subject.addItem("政治");
		subject.addItem("地理");
		
		JComboBox<String>grade=new JComboBox<>();
		grade.setBounds(360,20,80,20);
		grade.addItem("成绩");
		f.add(sid);
		f.add(grade);
		f.add(subject);
		f.add(classnumber);
		f.add(name);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(re);
		re.setBounds(200,300,100,30);
		f.setVisible(true);
	}
	public void ADD() {
		f=new JFrame("成绩管理");
		init();
		//输入
		JTextField sid=new JTextField(20);
		JTextField subject=new JTextField(20);
		JTextField grade=new JTextField(20);
		
		f.add(sid);
		f.add(subject);
		f.add(grade);
		
		sid.setBounds(170,40,150,20);
		subject.setBounds(170,80,150,20);
		grade.setBounds(170,120,150,20);
		//提示字
		JLabel xuehao=new JLabel("学号：");
		JLabel kemu=new JLabel("科目：");
		JLabel fenshu=new JLabel("分数：");
		
		f.add(kemu);
		f.add(xuehao);
		f.add(fenshu);
		
		xuehao.setBounds(110,40,150,20);
		kemu.setBounds(110,80,150,20);
		fenshu.setBounds(110,120,150,20);
		//按钮
		JButton accpet=new JButton("添加");
		f.add(accpet);
		f.add(re);
		re.setBounds(300,300,100,30);
		accpet.setBounds(100,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void UPDATE() {
		f=new JFrame("成绩管理");
		init();
		//输入
		JTextField sid=new JTextField(20);
		JTextField subject=new JTextField(20);
		JTextField grade=new JTextField(20);
		
		f.add(sid);
		f.add(subject);
		f.add(grade);
		
		sid.setBounds(170,40,150,20);
		subject.setBounds(170,80,150,20);
		grade.setBounds(170,120,150,20);
		//提示字
		JLabel xuehao=new JLabel("学号：");
		JLabel kemu=new JLabel("科目：");
		JLabel fenshu=new JLabel("分数：");
		
		f.add(xuehao);
		f.add(kemu);
		f.add(fenshu);
		
		xuehao.setBounds(110,40,150,20);
		kemu.setBounds(110,80,150,20);
		fenshu.setBounds(110,120,150,20);
		//按钮
		JButton accpet=new JButton("确认修改");
		f.add(accpet);
		f.add(re);
		re.setBounds(300,300,100,30);
		accpet.setBounds(100,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void start() {
		f=new JFrame("成绩管理");
		init();
		JButton re=new JButton("返回");
		JButton add=new JButton("添加成绩");
		JButton update=new JButton("更新成绩");
		JButton look=new JButton("查看成绩");
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(add)) {
					f.dispose();
					ADD();
				}else if(e.getSource().equals(look)) {
					f.dispose();
					look();
				}else if(e.getSource().equals(update)){
					f.dispose();
					UPDATE();
				}else {
					f.dispose();
					choose tmp=new choose();
					tmp.start();
				}
			}
		}
		add.addActionListener(new mylistener());
		update.addActionListener(new mylistener());
		look.addActionListener(new mylistener());
		f.add(add);
		f.add(update);
		f.add(look);
		f.add(re);
		re.setBounds(210,300,80,30);
		re.addActionListener(new mylistener());
		add.setBounds(55,120,110,110);
		look.setBounds(195,120,110,110);
		update.setBounds(335,120,110,110);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grade tmp=new Grade();
//		tmp.init();
		tmp.start();
//		tmp.look();
//		tmp.ADD();
//		tmp.UPDATE();
	}
}

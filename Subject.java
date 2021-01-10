package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Subject implements ActionListener{
	public JFrame f=new JFrame("课程信息管理");
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
		f=new JFrame("课程信息管理");
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
		
		sid.setBounds(180,40,150,20);
		name.setBounds(180,80,150,20);
		sex.setBounds(180,120,150,20);
		classnumber.setBounds(180,160,150,20);
		phone.setBounds(180,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("课程名：");
		JLabel xingming=new JLabel("班级：");
		JLabel xingbie=new JLabel("教师：");
		JLabel banji=new JLabel("第几周：");
		JLabel shoujihao=new JLabel("第几节：");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		f.add(banji);
		f.add(shoujihao);
		
		xuehao.setBounds(130,40,150,20);
		xingming.setBounds(130,80,150,20);
		xingbie.setBounds(130,120,150,20);
		banji.setBounds(130,160,150,20);
		shoujihao.setBounds(130,200,150,20);
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
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject s=new Subject();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

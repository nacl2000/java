package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class choose {
	JFrame f=new JFrame("中学信息管理系统");
	public void init() {
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
	}
	public void start() {
		init();
		JButton information=new JButton("信息管理");
		JButton subject=new JButton("课程管理");
		JButton grade=new JButton("成绩管理");
		
		f.add(grade);
		f.add(subject);
		f.add(information);
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(grade)) {
					f.dispose();
					Grade tmp=new Grade();
					tmp.start();
				}else if(e.getSource().equals(subject)) {
					f.dispose();
					Subject tmp=new Subject();
					tmp.start();
				}else {
					f.dispose();
					INFORMATION tmp=new INFORMATION();
					tmp.start();
				}
			}
		}
		information.addActionListener(new mylistener());
		subject.addActionListener(new mylistener());
		grade.addActionListener(new mylistener());
		information.setBounds(60,120,110,110);
		subject.setBounds(200,120,110,110);
		grade.setBounds(340,120,110,110);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		choose e=new choose();
		e.start();
	}
}

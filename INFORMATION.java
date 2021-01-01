package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class INFORMATION {
	JFrame f=new JFrame("信息管理");
	public void init() {
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
	}
	public void start() {
		init();
		JButton student=new JButton("学生信息管理");
		JButton teacher=new JButton("教师信息管理");
		JButton re=new JButton("返回");
		
		f.add(student);
		f.add(teacher);
		f.add(re);
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(student)) {
					f.dispose();
					Student tmp=new Student();
					tmp.start();
				}else if(e.getSource().equals(teacher)){
					f.dispose();
					Teacher tmp=new Teacher();
					tmp.start();
				}else {
					f.dispose();
					choose tmp=new choose();
					tmp.start();
				}
			}
		}
		student.addActionListener(new mylistener());
		teacher.addActionListener(new mylistener());
		student.setBounds(80,120,110,110);
		teacher.setBounds(310,120,110,110);
		re.setBounds(210,300,80,30);
		re.addActionListener(new mylistener());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		INFORMATION e=new INFORMATION();
		e.start();
	}
}

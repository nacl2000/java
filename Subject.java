package ����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Subject implements ActionListener{
	public JFrame f=new JFrame("ѧ����Ϣ����");
	private JButton re=new JButton("����");
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(re)) {
			f.dispose();
			start();
		}
	}
	int tmp=0;
	public void init() {
		f=new JFrame("�γ̹���");
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
		JButton add=new JButton("���ӿγ���Ϣ");
		JButton update=new JButton("�޸Ŀγ���Ϣ");
		JButton delete=new JButton("ɾ���γ���Ϣ");
		JButton ret=new JButton("����");
		f.add(ret);
		f.add(add);
		f.add(update);
		f.add(delete);
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
		//����
		JTextField name=new JTextField(20);
		JTextField classnumber=new JTextField(20);
		JTextField teacher=new JTextField(20);
		
		f.add(name);
		f.add(classnumber);
		f.add(teacher);
		
		name.setBounds(170,40,150,20);
		classnumber.setBounds(170,120,150,20);
		teacher.setBounds(170,200,150,20);
		//��ʾ��
		JLabel kecheng=new JLabel("�γ�����");
		JLabel banji=new JLabel("�༶��");
		JLabel jiaoshi=new JLabel("��ʦ��");
		
		f.add(kecheng);
		f.add(banji);
		f.add(jiaoshi);
		
		kecheng.setBounds(110,40,150,20);
		banji.setBounds(110,120,150,20);
		jiaoshi.setBounds(110,200,150,20);
		//��ť
		JButton accpet=new JButton("���");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void UPDATE() {
		init();
		//����
		JTextField name=new JTextField(20);
		JTextField classnumber=new JTextField(20);
		JTextField teacher=new JTextField(20);
		
		f.add(name);
		f.add(classnumber);
		f.add(teacher);
		
		name.setBounds(170,40,150,20);
		classnumber.setBounds(170,120,150,20);
		teacher.setBounds(170,200,150,20);
		//��ʾ��
		JLabel kecheng=new JLabel("�γ�����");
		JLabel banji=new JLabel("�༶��");
		JLabel jiaoshi=new JLabel("��ʦ��");
		
		f.add(kecheng);
		f.add(banji);
		f.add(jiaoshi);
		
		kecheng.setBounds(110,40,150,20);
		banji.setBounds(110,120,150,20);
		jiaoshi.setBounds(110,200,150,20);
		//��ť
		JButton accpet=new JButton("ȷ���޸�");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void DELETE() {
		init();
		JTextField classnumber=new JTextField(20);
		JTextField name=new JTextField(20);
		f.add(name);
		f.add(classnumber);
		name.setBounds(170,200,150,20);
		classnumber.setBounds(170,100,150,20);
		//��ʾ��
		JLabel banji=new JLabel("�༶��");
		JLabel kecheng=new JLabel("�γ̣�");
		f.add(banji);
		f.add(kecheng);
		banji.setBounds(110,100,150,20);
		kecheng.setBounds(110,200,150,20);
		//��ť
		JButton accpet=new JButton("ȷ��ɾ��");
		f.add(accpet);
		accpet.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
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

package ����;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Grade implements ActionListener{
	public JFrame f=new JFrame("�ɼ�����");
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
		tmp++;
		if(tmp==1) {
			re.addActionListener(this);
		}
		f.setLayout(null);
		f.setSize(500,400);
		f.setLocation(300,200);
	}
	public void look() {
		f=new JFrame("�ɼ�����");
		init();
		JComboBox<String>sid=new JComboBox<>();
		sid.setBounds(40,20,80,20);
		sid.addItem("ѧ��");
		
		JComboBox<String>name=new JComboBox<>();
		name.setBounds(120,20,80,20);
		name.addItem("����");
		
		JComboBox<String>classnumber=new JComboBox<>();
		classnumber.setBounds(200,20,80,20);
		classnumber.addItem("�༶");
		classnumber.addItem("��һ(1)��");
		classnumber.addItem("����(2)��");
		classnumber.addItem("����(1)��");
		classnumber.addItem("��һ(1)��");
		classnumber.addItem("�߶�(1)��");
		classnumber.addItem("����(1)��");
		
		JComboBox<String>subject=new JComboBox<>();
		subject.setBounds(280,20,80,20);
		subject.addItem("�ܷ�");
		subject.addItem("����");
		subject.addItem("��ѧ");
		subject.addItem("Ӣ��");
		subject.addItem("����");
		subject.addItem("��ѧ");
		subject.addItem("����");
		subject.addItem("��ʷ");
		subject.addItem("����");
		subject.addItem("����");
		
		JComboBox<String>grade=new JComboBox<>();
		grade.setBounds(360,20,80,20);
		grade.addItem("�ɼ�");
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
		f=new JFrame("�ɼ�����");
		init();
		//����
		JTextField sid=new JTextField(20);
		JTextField subject=new JTextField(20);
		JTextField grade=new JTextField(20);
		
		f.add(sid);
		f.add(subject);
		f.add(grade);
		
		sid.setBounds(170,40,150,20);
		subject.setBounds(170,80,150,20);
		grade.setBounds(170,120,150,20);
		//��ʾ��
		JLabel xuehao=new JLabel("ѧ�ţ�");
		JLabel kemu=new JLabel("��Ŀ��");
		JLabel fenshu=new JLabel("������");
		
		f.add(kemu);
		f.add(xuehao);
		f.add(fenshu);
		
		xuehao.setBounds(110,40,150,20);
		kemu.setBounds(110,80,150,20);
		fenshu.setBounds(110,120,150,20);
		//��ť
		JButton accpet=new JButton("���");
		f.add(accpet);
		f.add(re);
		re.setBounds(300,300,100,30);
		accpet.setBounds(100,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void UPDATE() {
		f=new JFrame("�ɼ�����");
		init();
		//����
		JTextField sid=new JTextField(20);
		JTextField subject=new JTextField(20);
		JTextField grade=new JTextField(20);
		
		f.add(sid);
		f.add(subject);
		f.add(grade);
		
		sid.setBounds(170,40,150,20);
		subject.setBounds(170,80,150,20);
		grade.setBounds(170,120,150,20);
		//��ʾ��
		JLabel xuehao=new JLabel("ѧ�ţ�");
		JLabel kemu=new JLabel("��Ŀ��");
		JLabel fenshu=new JLabel("������");
		
		f.add(xuehao);
		f.add(kemu);
		f.add(fenshu);
		
		xuehao.setBounds(110,40,150,20);
		kemu.setBounds(110,80,150,20);
		fenshu.setBounds(110,120,150,20);
		//��ť
		JButton accpet=new JButton("ȷ���޸�");
		f.add(accpet);
		f.add(re);
		re.setBounds(300,300,100,30);
		accpet.setBounds(100,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void start() {
		f=new JFrame("�ɼ�����");
		init();
		JButton re=new JButton("����");
		JButton add=new JButton("��ӳɼ�");
		JButton update=new JButton("���³ɼ�");
		JButton look=new JButton("�鿴�ɼ�");
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

package ����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Grade implements ActionListener{
	public JFrame f=new JFrame("��ʦ��Ϣ����");
	private JButton re=new JButton("����");
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
		f=new JFrame("��ʦ��Ϣ����");
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
		//����
		JTextField sid=new JTextField(20);
		JTextField name=new JTextField(20);
		JTextField sex=new JTextField(20);
		JTextField classnumber=new JTextField(20);
		JTextField phone=new JTextField(20);
		JTextField address=new JTextField(20);
		
		f.add(sid);
		f.add(name);
		f.add(sex);
		
		sid.setBounds(180,40,150,20);
		name.setBounds(180,80,150,20);
		sex.setBounds(180,120,150,20);
		
		//��ʾ��
		JLabel xuehao=new JLabel("ѧ�ţ�");
		
		JLabel xingming=new JLabel("ѧ�ƣ�");
		
		JLabel xingbie=new JLabel("������");
		
		f.add(xingbie);
		f.add(xuehao);
		f.add(xingming);
		
		xuehao.setBounds(130,40,150,20);
		xingming.setBounds(130,80,150,20);
		xingbie.setBounds(130,120,150,20);
		//��ť
		JButton ad=new JButton("���");
		JButton update=new JButton("�޸�");
		JButton delete=new JButton("ɾ��");
		JButton query=new JButton("����");
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
		Grade s=new Grade();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

package ����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Student implements ActionListener{
	public static boolean judge(String sid, String name, String sex, String classnumber, String phone, String address) {
        if (sid == "" || name == "" || sex == "" || classnumber == "" || phone == "" || address == "") return false;

        if (!isDig(sid)) return false;
        if (!isDig(phone)) return  false;
        if (sex.charAt(0) != '��' && sex.charAt(0) != 'Ů') return  false;
        if (sex.length() > 1) return  false;
        if (classnumber.charAt(0) != '��' && classnumber.charAt(0) != '��') return  false;
        if (phone.length() != 11) return false;
        if (!Character.isDigit(classnumber.charAt(2))) return  false;
        if (classnumber.charAt(classnumber.length() - 1) != '��') return false;
        return true;
    }
    public static boolean isDig(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }
	public JFrame f=new JFrame("ѧ����Ϣ����");
	private JButton re=new JButton("����");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/����?"
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
		f=new JFrame("ѧ����Ϣ����");
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
		f.add(classnumber);
		f.add(phone);
		f.add(address);
		
		sid.setBounds(80,40,150,20);
		name.setBounds(80,80,150,20);
		sex.setBounds(80,120,150,20);
		classnumber.setBounds(310,40,150,20);
		phone.setBounds(310,80,150,20);
		address.setBounds(310,120,150,20);
		//��ʾ��
		JLabel xuehao=new JLabel("ѧ�ţ�");
		JLabel xingming=new JLabel("������");
		JLabel xingbie=new JLabel("�Ա�");
		JLabel banji=new JLabel("�༶��");
		JLabel shoujihao=new JLabel("�ֻ��ţ�");
		JLabel zhuzhi=new JLabel("סַ��");
		
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
		//�¼�
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
				String []ss=new String [10];
	            ss[0]=sid.getText();
	            ss[1]=name.getText();
	            ss[2]=sex.getText();
	            ss[3]=classnumber.getText();
	            ss[4]=phone.getText();
	            ss[5]=address.getText();
	            if(!judge(ss[0],ss[1],ss[2],ss[3],ss[4],ss[5])) {
	            	JOptionPane.showMessageDialog(null, "��Ϣδ��д��ȷ", "������",
							JOptionPane.ERROR_MESSAGE);
	            	return;
	            }
				if(e.getSource().equals(ad)) {
					try{//��������
			            Class.forName("com.mysql.cj.jdbc.Driver");//��������
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//�������Ӷ���
			            if(sid.getText()==null||name.getText()==null||sex.getText()==null||classnumber.getText()==null||
			            				phone.getText()==null||address.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "��Ϣδ��д����", "������",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            
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
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//�������Ӷ���
						String sql=" select * from student "
		            			+ " where sid='"+ss[0]+"' ";
		            	Statement stmt = coon.createStatement();
		            	ResultSet rs = stmt.executeQuery(sql);
	            		JFrame tmp = new JFrame("��ѯ");
	            		tmp.setSize(800,600);
	            		tmp.setLocation(600,00);
		            	int count = 0;
		            	while(rs.next()){
		            		count++;
		            	}
		            	Object[][] info = new Object[count][6];
		            	count = 0;
		            	rs = stmt.executeQuery(sql);
		            	while(rs.next()){
		            		info[count][0] = rs.getString("sid");
		            		info[count][1] = rs.getString("name");
		            		info[count][2] = rs.getString("sex");
		            		info[count][3] = rs.getString("classnumber");
		            		info[count][4] = rs.getString("phone");
		            		info[count][5] = rs.getString("address");
		            		count++;
		            	}
		            	String[] title = {"ѧ��","����","�Ա�","�༶", "�绰", "��ַ"};
		            	JScrollPane scroll=new JScrollPane();//������������
		            	JTable jtable=null;//�������	
		            	DefaultTableModel model = new DefaultTableModel(info, title);
		            	jtable = new JTable(model);
		            	jtable.setBackground(Color.cyan);
		            	jtable.setPreferredScrollableViewportSize(new Dimension(100, 80));
		            	jtable.setFillsViewportHeight(true);
		            	
		            	JScrollPane jScrollPane = new JScrollPane();
		                jScrollPane.setViewportView(jtable);
		                Font font = new Font("����", Font.BOLD, 13);

		                //���label
		                JLabel label =new JLabel("��ѯ���ݿ��е�����");
		                label.setFont(font);
		                label.setBounds(1,10,240,30);

		                //ͨ��panel���button��label
		                JPanel panel =new JPanel();
		                panel.setBackground(Color.GRAY);
		                panel.setSize(200,100);
		                panel.add(label);
//		                panel.add(button);

		                //6����ӱ�񡢹�������������
		                tmp.add(panel, BorderLayout.NORTH);
		                tmp.setVisible(true);
		                tmp.add(jScrollPane,BorderLayout.CENTER);
	                    tmp.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//��������
		            
				}else if(e.getSource().equals(update)) {
					try{//��������
			            Class.forName("com.mysql.cj.jdbc.Driver");//��������
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//�������Ӷ���
			            if(sid.getText()==null||name.getText()==null||sex.getText()==null||classnumber.getText()==null||
	            				phone.getText()==null||address.getText()==null) {
			            		JOptionPane.showMessageDialog(null, "��Ϣδ��д����", "������",
							JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            
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
					try{//��������
			            Class.forName("com.mysql.cj.jdbc.Driver");//��������
			            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//�������Ӷ���
			            if(sid.getText()==null) {
			            	JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "������",
									JOptionPane.ERROR_MESSAGE);
			            	coon.close();
			            	return;
			            }
			            String sss=sid.getText();
			            String sql="delete from student where sid='"+sss+"'"; 
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
		query.addActionListener(new mylistener());
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

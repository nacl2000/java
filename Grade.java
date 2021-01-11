package ����;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
public class Grade implements ActionListener{
	public JFrame f=new JFrame("��ʦ��Ϣ����");
	private JButton re=new JButton("����");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/����?"
			+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
	static private String NAME = "root";
	static private String PASSWORD = "jhy,.jht";
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	  public static boolean judgeGrade(String sid, String sub, String grade) {
	        if (sid == "" || sub == "" || grade == "") return false;
	        if (!isDig(sid)) return false;
	        if (!isDig(grade)) return  false;
	        int k = Integer.valueOf(grade).intValue();
	        if (k > 100 || k < 0) return false;
	        return true;
	    }
	    public static boolean isDig(String s) {
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	        return pattern.matcher(s).matches();
	    }
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
		JTextField sub=new JTextField(20);
		JTextField core=new JTextField(20);
		
		f.add(sid);
		f.add(sub);
		f.add(core);
		
		sid.setBounds(180,40,150,20);
		sub.setBounds(180,80,150,20);
		core.setBounds(180,120,150,20);
		
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
		//����
		class mylistener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{//��������
		            Class.forName("com.mysql.cj.jdbc.Driver");//��������
		            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//�������Ӷ���
		            String ss[]=new String[10];
	            	ss[0]=sid.getText();
	            	ss[1]=sub.getText();
	            	ss[2]=core.getText();
	            	if(!judgeGrade(ss[0],ss[1],ss[2])) {
	            		coon.close();
	            		JOptionPane.showMessageDialog(null, "��Ϣδ��д��ȷ", "������",
								JOptionPane.ERROR_MESSAGE);
		            	return;
	            	}
		            if(e.getSource().equals(ad)) {
		            	String sql="insert into grade values ('"+ss[0]+"','"+ss[1]+"','"+ss[2]+"') ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else if(e.getSource().equals(delete)) {
		            	String sql="delete from grade where sid='"+ss[0]+"' and sub='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else if (e.getSource().equals(update)) {
		            	String sql="update grade set  core='"+ss[2]+"' "
		            			+ " where sid='"+ss[0]+"' and sub='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else {
		            	String sql=" select * from grade "
		            			+ " where sid='"+ss[0]+"' and sub='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
		            	ResultSet rs = stmt.executeQuery(sql);
	            		JFrame tmp = new JFrame("��ѯ");
	            		tmp.setSize(800,600);
	            		tmp.setLocation(600,00);
		            	int count = 0;
		            	while(rs.next()){
		            		count++;
		            	}
		            	Object[][] info = new Object[count][4];
		            	count = 0;
		            	rs = stmt.executeQuery(sql);
		            	while(rs.next()){
		            		info[count][0] = rs.getString("sid");
		            		info[count][1] = rs.getString("sub");
		            		info[count][2] = rs.getString("core");
		            		count++;
		            	}
		            	String[] title = {"ѧ��","��Ŀ","�ɼ�"};
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
		            }
		            coon.close();
		        }catch (Exception e1){
		            e1.printStackTrace();
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
		Grade s=new Grade();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

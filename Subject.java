package 课设;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
public class Subject implements ActionListener{
	public JFrame f=new JFrame("课程信息管理");
	private JButton re=new JButton("返回");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/课设?"
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
		JTextField sname=new JTextField(20);
		JTextField classnumber=new JTextField(20);
		JTextField tea=new JTextField(20);
		JTextField week=new JTextField(20);
		JTextField jie=new JTextField(20);
		
		f.add(sname);
		f.add(classnumber);
		f.add(tea);
		f.add(week);
		f.add(jie);
		
		sname.setBounds(180,40,150,20);
		classnumber.setBounds(180,80,150,20);
		tea.setBounds(180,120,150,20);
		week.setBounds(180,160,150,20);
		jie.setBounds(180,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("课程名：");
		JLabel xingming=new JLabel("班级：");
		JLabel xingbie=new JLabel("教师：");
		JLabel banji=new JLabel("周几：");
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
		//事务
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{//加载驱动
		            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
		            Connection coon = DriverManager.getConnection(UTR,NAME,PASSWORD);//创建连接对象
		            String ss[]=new String[10];
	            	ss[0]=sname.getText();
	            	ss[1]=classnumber.getText();
	            	ss[2]=tea.getText();
	            	ss[3]=week.getText();
	            	ss[4]=jie.getText();
		            if(e.getSource().equals(ad)) {
		            	String sql="insert into subject values ('"+ss[0]+"','"+ss[1]+"','"+ss[2]+"','"+ss[3]+"',"
		            			+ " '"+ss[4]+"') ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else if(e.getSource().equals(delete)) {
		            	String sql="delete from subject where sname='"+ss[0]+"' and classnumber='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else if (e.getSource().equals(update)) {
		            	String sql="update subject set  tea='"+ss[2]+"',week='"+ss[3]+"',jie='"+ss[4]+"' "
		            			+ " where sname='"+ss[0]+"' and classnumber='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
			            int  result = stmt.executeUpdate(sql);
			            System.out.print(result);
			            stmt.close();
		            }else {
		            	String sql=" select * from subject "
		            			+ " where sname='"+ss[0]+"' and classnumber='"+ss[1]+"' ";
		            	Statement stmt = coon.createStatement();
		            	ResultSet rs = stmt.executeQuery(sql);
	            		JFrame tmp = new JFrame("查询");
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
		            		info[count][0] = rs.getString("sname");
		            		info[count][1] = rs.getString("classnumber");
		            		info[count][2] = rs.getString("tea");
		            		info[count][3] = rs.getString("week");
		            		info[count][4] = rs.getString("jie");
		            		count++;
		            	}
		            	String[] title = {"姓名","班级","教师", "周几", "第几节课"};
		            	JScrollPane scroll=new JScrollPane();//创建滚动容器
		            	JTable jtable=null;//创建表格	
		            	DefaultTableModel model = new DefaultTableModel(info, title);
		            	jtable = new JTable(model);
		            	jtable.setBackground(Color.cyan);
		            	jtable.setPreferredScrollableViewportSize(new Dimension(100, 80));
		            	jtable.setFillsViewportHeight(true);
		            	
		            	JScrollPane jScrollPane = new JScrollPane();
		                jScrollPane.setViewportView(jtable);
		                Font font = new Font("宋体", Font.BOLD, 13);

		                //添加label
		                JLabel label =new JLabel("查询数据库中的数据");
		                label.setFont(font);
		                label.setBounds(1,10,240,30);

		                //通过panel组合button，label
		                JPanel panel =new JPanel();
		                panel.setBackground(Color.GRAY);
		                panel.setSize(200,100);
		                panel.add(label);
//		                panel.add(button);

		                //6，添加表格、滚动条到容器中
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
		Subject s=new Subject();
//		s.init();
		s.start();
//		s.ADD();
//		s.UPDATE();
//		s.DELETE();
	}
}

package 课设;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	public JFrame f=new JFrame("学生信息管理");
	private JButton re=new JButton("返回");
	static private String UTR = "jdbc:mysql://127.0.0.1:3306/课设?"
			+ "useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
	static private String name = "root";
	static private String Password = "jhy,.jht";
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(re)) {
			f.dispose();
			enter ee=new enter();
			ee.creatgui();
		}
	}
	int tmp=0;
	public void init() {
		f=new JFrame("注册");
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
		JTextField sid=new JTextField(20);
		JPasswordField pwd=new JPasswordField(20);
		f.add(sid);
		f.add(pwd);
		sid.setBounds(170,100,150,20);
		pwd.setBounds(170,200,150,20);
		//提示字
		JLabel xuehao=new JLabel("用户名：");
		JLabel mima=new JLabel("密码：");
		f.add(xuehao);
		f.add(mima);
		xuehao.setBounds(110,100,150,20);
		mima.setBounds(110,200,150,20);
		//按钮
		JButton accept=new JButton("确认");
		class mylistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				char s[]=pwd.getPassword();
				String pass=new String(s);
				String adm=sid.getText();
				try{//加载驱动
		            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
		            Connection coon = DriverManager.getConnection(UTR,name,Password);//创建连接对象
		            String sql=" INSERT  INTO  user   VALUES  ('"+adm+"','"+pass+"')"; 
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
		f.add(accept);
		accept.addActionListener(new mylistener());
		accept.setBounds(100,300,100,30);
		f.add(re);
		re.setBounds(300,300,100,30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login l=new Login();
		l.start();
	}
}

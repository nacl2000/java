package ����;

import java.sql.*;

public class database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String UTR = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF8";
        String name = "root";
        String Password = "jhy,.jht";
        try{//��������
            Class.forName("com.mysql.cj.jdbc.Driver");//��������
            Connection coon = DriverManager.getConnection(UTR,name,Password);//�������Ӷ���
            System.out.println("asdasdas");
            coon.close();
        }catch (Exception e){
            e.printStackTrace();
        }
	}

}


package com.bank.model.package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	private String name;
	private String cid;
	private int acc_num;
	private String pwd;
	private int bal;
	private String mail;
	private int racc_num;
	String url="jdbc:mysql://localhost:3306/bank";
	String user ="root";
	String pwds="root";
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet res;
	private PreparedStatement pstmt;

	public ArrayList al = new ArrayList();
	public ArrayList sal = new ArrayList();
	public ArrayList ral = new ArrayList();


	public String getMail()

	{
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRaccno() {
		return racc_num;
	}
	public void setRaccno(int racc_num) {
		this.racc_num = racc_num;
	}

	public Model() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, user, pwds);

		System.out.println("Connection Established");
	}
	public boolean register() throws Exception {
		String s="insert into rbibank values(?,?,?,?,?,?)";
		pstm=con.prepareStatement(s);
		pstm.setString(1,name);
		pstm.setString(2,cid);
		pstm.setInt(3, acc_num);
		pstm.setString(4,pwd);
		pstm.setInt(5, bal);
		pstm.setString(6,mail);

		int x = pstm.executeUpdate();
		if(x>0) {
			return true;
		}
		else {
			return false;
		}

	}
	public boolean Login() throws Exception {
		String s = "select * from rbibank where cid= ? and pwd = ?";

		pstm = con.prepareStatement(s);

		pstm.setString(1,cid);		
		pstm.setString(2,pwd);

		res = pstm.executeQuery();

		while(res.next()==true) {
			acc_num = res.getInt("acc_num");
			return true;

		}

		return false;
	}
	public boolean checkbalance() throws Exception {
		String s="select bal from rbibank where acc_num= ? ";
		pstm=con.prepareStatement(s);
		pstm.setInt(1, acc_num);
		res = pstm.executeQuery();
		while(res.next()==true) {
			bal=res.getInt("bal");
			return true;
		}

		return false;
	}
	public boolean ChangePwd() throws Exception {
		String s = "update rbibank set pwd = ? where acc_num= ? ";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1, pwd);
		pstmt.setInt(2, acc_num);

		int x = pstmt.executeUpdate();

		if(x>0) {
			return true;
		}
		return false;
	}
	public boolean transfer() throws SQLException {
		System.out.println("1");
		String s1="select * from rbibank where acc_num= ?";
		pstmt= con.prepareStatement(s1);
		pstmt.setInt(1,acc_num);
		res= pstmt.executeQuery();
		while(res.next()==true) {
			System.out.println("2");
			String s2= "Update rbibank set bal = bal - ? where acc_num = ? ";
			pstmt= con.prepareStatement(s2);
			pstmt.setInt(1,bal);
			pstmt.setInt(2, acc_num);
			int y1 = pstmt.executeUpdate();
			if(y1>0){
				System.out.println("3");
				int x=  res.getInt("bal");
				if(x>0) {
					System.out.println("4");
					String s3= "Update rbibank set bal = bal + ? where acc_num = ? ";
					pstmt= con.prepareStatement(s3);
					pstmt.setInt(1,bal);
					pstmt.setInt(2,racc_num);
					int y2 = pstmt.executeUpdate();
					if(y2>0) {
						System.out.println("5");
						String s4=" insert into getstatement values (?,?,?)";
						pstmt = con.prepareStatement(s4);
						pstmt.setInt(1, acc_num);
						pstmt.setInt(2, racc_num);
						pstmt.setInt(3, bal);
						int y= pstmt.executeUpdate();
						if(y>0) {
							return true;
						}
						else {
							return false;
						}
					}
				}
				else {
					return false;
				}
			}

		}
		return false;
	}
	public ArrayList getStatement() throws SQLException {
		String s= "select * from getstatement where acc_num= ?";
		pstmt = con.prepareStatement(s);
		pstmt.setInt(1, acc_num);
		res= pstmt.executeQuery();
		while(res.next()==true)	{
			sal.add(res.getInt("acc_num"));
			ral.add(res.getInt("racc_num"));
			al.add(res.getInt("bal"));

		}
		return al;
	}
	public boolean applyLoan() throws SQLException {
		String s= "select * from rbibank where acc_num= ?";
		pstmt = con.prepareStatement(s);
		pstmt.setInt(1, acc_num);
		res= pstmt.executeQuery();
		while(res.next()==true) {
			name = res.getString("name");
			mail = res.getString("mail");
			return true;
		}
		return false;
	}
}
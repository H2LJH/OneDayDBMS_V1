package com.biz.dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.biz.config.DBConnection;
import com.biz.config.DBContract;

public class jdbcEx_04 
{
	public static void main(String[] args) 
	{
			Connection dbConn = DBConnection.getDBConnection();
			String delete_sql = DBContract.ORDER_INSERT;
			Scanner sc = new Scanner(System.in);
			
			System.out.print("삭제할 SEQ : ");
			String str_seq = sc.nextLine();
			
			long long_seq = Long.valueOf(str_seq);
			
			PreparedStatement pSt;
			
			try
			{
				pSt = dbConn.prepareStatement(delete_sql);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			System.out.println(DBContract.ORDER_INSERT);
			System.out.println("INSERT INTO tbl_order(o_seq, o_date, o_num, o_cnum, o_pcode) VALUES (seq_order.NEXTVAL, '2020-07-22', 'O00001', 'C0032', 'P00001');");
	}
}

package com.biz.dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.config.DBConnection;
import com.biz.config.DBContract;
import com.biz.dbms.domain.OrderVO;

public class jdbcEx_02 
{
	public static void main(String[] args) 
	{
		Connection dbConn = DBConnection.getDBConnection();
		String order_select = DBContract.ORDER_SELECT;
		
		// 인터페이스를 이용해서 객체 선언
		PreparedStatement pSt = null;
		
		
		List<OrderVO> orderList = new ArrayList<>();
		
		
		// dbconn 객체의 prepareStatement() method에게 SQL 명령문 코드를 전달하면
		// PreparedStatment type의 객체를 생성하여 return
		try {
			pSt = dbConn.prepareStatement(order_select);
			ResultSet result = pSt.executeQuery();
			while(result.next())
			{
				OrderVO orderVO = new OrderVO();
				
				String o_num = result.getNString(DBContract.ORDER.POS_O_NUM_STR);
				orderVO.setO_num(o_num);
				
				String o_date = result.getNString(DBContract.ORDER.POS_O_DATE_STR);
				orderVO.setO_date(o_date);
				
				String o_cnum = result.getNString(DBContract.ORDER.POS_O_CNUM_STR);
				orderVO.setO_cnum(o_cnum);
				
				String o_pcode = result.getNString(DBContract.ORDER.POS_O_PCODE_STR);
				orderVO.setO_pcode(o_pcode);
				
				String o_pname = result.getNString(DBContract.ORDER.POS_O_PNAME_STR);
				orderVO.setO_pname(o_pname);
				
				int o_price = result.getInt(DBContract.ORDER.POS_O_PRICE_INT);
				orderVO.setO_price(o_price);
				
				int o_qty = result.getInt(DBContract.ORDER.POS_O_QTY_INT);
				orderVO.setO_qty(o_qty);
				
				orderList.add(orderVO);
			}
			pSt.close();
			dbConn.close();
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		

		for(OrderVO vo : orderList)
		{
			System.out.println(vo.toString());
		}
		
		
	}
}

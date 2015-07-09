package com.acme.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.acme.order.pizza.PizzaOrder;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Primary
public class JdbcOrderRepository implements OrderRepository {

	private final String url = "jdbc:mysql://localhost:3306/pizza-tutorial";

	private final String user = "dbuser";

	private final String password = "dbpass";
	
	@Autowired
	private DataSource dataSource;
	

	@Override
	public String save(PizzaOrder order) {		
				
		return null;
	}

	@Override
	public void rollback() {
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public PizzaOrder get(String pizzaOrderId) {
		try(Connection conn = dataSource.getConnection()){
			try(Statement stmt = conn.createStatement();
				ResultSet rs= stmt.executeQuery("Select * from order_t where id = 1"))
				{
				System.out.println(rs.toString());
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<PizzaOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PizzaOrder> findByOrderStatus(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}

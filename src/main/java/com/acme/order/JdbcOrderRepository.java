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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acme.order.delivery.strategy.PizzaTypeDeliveryTimeStrategy;
import com.acme.order.pizza.PizzaOrder;
import com.acme.order.pizza.PizzaType;
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
	
	  private JdbcTemplate jdbcTemplate;

	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

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
		return this.jdbcTemplate.queryForObject("select * from order_t where id=?", new Object[]{pizzaOrderId}, PizzaOrder.class);
	}

	@Override
	public List<PizzaOrder> findAll() {
		return this.jdbcTemplate.queryForList("select * from order_t",PizzaOrder.class);
	}

	@Override
	public List<PizzaOrder> findByOrderStatus(OrderStatus orderStatus) {
		return this.jdbcTemplate.query("select * from order_t where status= ?",new Object[]{orderStatus},new RowMapper<PizzaOrder>(){

			@Override
			public PizzaOrder mapRow(ResultSet rs, int arg1) throws SQLException {
				rs.getString("type");
				Customer customer = new Customer("1", "PPP", "pppd@sjdas", "Lodz");
				PizzaType pizzatype = PizzaType.BIG;
				PizzaOrder po = new PizzaOrder(customer, pizzatype);
				return po;
			}
			
		});
	}

}

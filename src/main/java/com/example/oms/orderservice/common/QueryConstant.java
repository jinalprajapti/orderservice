package com.example.oms.orderservice.common;

public interface QueryConstant {

	/** get all branch */
	String GET_ORDER_BY_ORDER = " SELECT o.customer_name as customer_name, o.order_date as order_date, o.shipping_address as shipping_address,  o.total as total  FROM orders o where o.order_id = ? ";

	String INSERT_NEW_ORDER  = "INSERT INTO orders( "
			+ "  CUSTOMER_NAME, ORDER_DATE, SHIPPING_ADDRESS,TOTAL) "
			+ " VALUES( ?,?,?,?)";
}

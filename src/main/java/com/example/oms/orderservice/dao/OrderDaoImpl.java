package com.example.oms.orderservice.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.example.oms.orderservice.common.OrderServiceUtil;
import com.example.oms.orderservice.common.QueryConstant;
import com.example.oms.orderservice.dto.OrderDTO;
import com.example.oms.orderservice.dto.ProductItemDTO;


@Repository
public class OrderDaoImpl implements IOrderDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);




	@Override
	public Integer createOrder(OrderDTO orderDto) {
		String[] primarKey = { "ORDER_ID" };
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(QueryConstant.INSERT_NEW_ORDER, primarKey);
			ps.setString(1, orderDto.getCustomerName());
			ps.setDate(2, Date.valueOf(OrderServiceUtil.convertyyyyMMdd_toyyyy_MM_dd(orderDto.getOrderDate())));
			ps.setString(3, orderDto.getShippingAddress());
			ps.setInt(4, orderDto.getProductItemList().size());
			return ps;
		}, keyHolder);

		return (Integer) keyHolder.getKey();
	
	}

	
	  public OrderDTO getOrderById(Integer orderId, List<ProductItemDTO> productItemDTOList) {

		  OrderDTO orderDTO = null;
			try {
				orderDTO = jdbcTemplate.queryForObject(QueryConstant.GET_ORDER_BY_ORDER,
						new BeanPropertyRowMapper<OrderDTO>(OrderDTO.class), new Object[] { orderId });
				if (!CollectionUtils.isEmpty(productItemDTOList)) {
					orderDTO.setProductItemList(productItemDTOList);
				}

			} catch (EmptyResultDataAccessException e) {
				LOGGER.debug("Error while getOrderById , " + e.getMessage());
			}
			return orderDTO;
	 }

}

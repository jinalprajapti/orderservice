package com.example.oms.orderservice.dao;

import java.util.List;

import com.example.oms.orderservice.dto.OrderDTO;
import com.example.oms.orderservice.dto.ProductItemDTO;

public interface IOrderDao {

	 /**
	  * create Order
	  * 
	  * @param OrderDTO
	  * @return Integer
	  */
	 public Integer createOrder(OrderDTO OrderDTO);
	 /**
	  * get all order
	  * @return
	  */
	  public OrderDTO getOrderById(Integer orderId, List<ProductItemDTO> productItemDTOList);

	 
}

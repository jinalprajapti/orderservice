package com.example.oms.orderservice.service;

import com.example.oms.orderservice.dto.OrderDTO;

public interface IOrderService {
	
 /**
  * create Order
  * 
  * @param OrderDTO
  * @return boolean
  */
 public boolean createOrder(OrderDTO OrderDTO);
 /**
  * get all order list
  * @return
  */
 public OrderDTO getOrderById(Integer orderId);


}

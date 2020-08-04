package com.example.oms.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.oms.orderservice.common.OrderServiceUtil;
import com.example.oms.orderservice.dao.IOrderDao;
import com.example.oms.orderservice.dto.OrderDTO;
import com.example.oms.orderservice.dto.ProductItemDTO;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderDao iOrderDao;

	@Autowired
	FeignService feignService;
	/**
	 * {@inheritDoc}
	 */
	public boolean createOrder(OrderDTO OrderDTO) {
		Integer orderId = iOrderDao.createOrder(OrderDTO);
		feignService.createOrderItem(OrderDTO.getProductItemList(), orderId);
		if (OrderServiceUtil.checkorderId(orderId)) {
			return true;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	 public OrderDTO getOrderById(Integer orderId){
			List<ProductItemDTO> productCodeList = feignService.getOrderItemByOrderId(orderId);
			return  iOrderDao.getOrderById(orderId, productCodeList);
	 }

}

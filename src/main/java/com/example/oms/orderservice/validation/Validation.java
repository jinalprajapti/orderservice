package com.example.oms.orderservice.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.oms.orderservice.dto.OrderDTO;

public  class Validation {
	public static List<String> validate(OrderDTO orderDTO) {
		List<String> errorList = new ArrayList<String>();
		if (StringUtils.isEmpty(orderDTO.getCustomerName())) {
			errorList.add("Customer name should not be empty");
		}
		if (StringUtils.isEmpty(orderDTO.getOrderDate())) {
			errorList.add("Order date should not be empty");
		}
		if (StringUtils.isEmpty(orderDTO.getShippingAddress())) {
			errorList.add("Shipping Address should not be empty");
		}
		if (CollectionUtils.isEmpty(orderDTO.getProductItemList())) {
			errorList.add("Product Item should not be empty");
		}
		return errorList;

	}
}

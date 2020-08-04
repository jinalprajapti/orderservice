package com.example.oms.orderservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oms.orderservice.common.OrderServiceUtil;
import com.example.oms.orderservice.domain.ServiceResponse;
import com.example.oms.orderservice.dto.OrderDTO;
import com.example.oms.orderservice.service.IOrderService;
import com.example.oms.orderservice.validation.Validation;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/orderservice")
public class OrderServiceController {
	
	private static final Logger LOGGER = Logger.getLogger(OrderServiceController.class);
	
	@Autowired
	IOrderService iOrderService;
	
	
	@ApiOperation(value = "Create New Order", notes = "Create New Order.")
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ServiceResponse createOrder(@RequestBody OrderDTO orderDTO) {
		LOGGER.debug("...in .createOrder controller start.");
		List<String> errorList = Validation.validate(orderDTO);
		if (CollectionUtils.isEmpty(errorList)) {
			boolean f = iOrderService.createOrder(orderDTO);
			return OrderServiceUtil.getServiceResponse(f);
		} else {
			return OrderServiceUtil.getServiceResponse(errorList);
		}
		
	}
	
	@ApiOperation(value = "get Order by OrderId", notes = "get Order by OrderId.")
	@RequestMapping(value = "/getOrderById/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ServiceResponse getOrderById(@PathVariable Integer orderId) {
		LOGGER.debug("...in .getAllOrder controller start.");
		 OrderDTO orderDto = iOrderService.getOrderById(orderId);
		return OrderServiceUtil.getServiceResponse(orderDto);
	}
	
}

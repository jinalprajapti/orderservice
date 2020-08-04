package com.example.oms.orderservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.oms.orderservice.domain.ServiceResponse;
import com.example.oms.orderservice.dto.ProductItemDTO;

@FeignClient(name = "orderitemservice", url = "localhost:8013/api/orderitemservice")
public interface FeignService {

	

	@PostMapping("/createOrderItem/{orderId}")
	public @ResponseBody ServiceResponse createOrderItem(@RequestBody List<ProductItemDTO> productItemDTO,
			@PathVariable Integer orderId);
	
	@GetMapping("/getOrderItemByOrderId/{orderId}")
	public List<ProductItemDTO> getOrderItemByOrderId(@PathVariable Integer orderId);
								
}

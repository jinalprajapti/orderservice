package com.example.oms.orderservice.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	private String customerName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private String orderDate;
	
	private String shippingAddress;	
	
	private Long total;
	
	private List<ProductItemDTO> productItemList;
}

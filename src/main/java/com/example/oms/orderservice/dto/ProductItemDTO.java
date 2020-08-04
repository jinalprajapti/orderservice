package com.example.oms.orderservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductItemDTO {
	
	private String productCode;
	
	private String productName;
	
	private Integer quantity;

}

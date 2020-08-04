package com.example.oms.orderservice.domain;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 2175476829866293178L;
	
	private String status;
	private String responseMessage;
	private int searchCount;
	private Object resObject;

}
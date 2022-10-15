package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Dc_Cases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer case_Id;
	
	//private Integer case_no;
	
	private Integer app_id;
	
	private Integer plan_id;
}

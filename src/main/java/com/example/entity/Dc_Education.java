package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Education-dts")
public class Dc_Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edu_id;
	
	private Integer case_Id;
	
	private String highest_qualifcation;
	
	private LocalDate yearof_completion;

}

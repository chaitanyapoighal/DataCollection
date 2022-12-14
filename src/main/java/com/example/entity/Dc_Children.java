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
@Table(name="ChildrenDetails")
public class Dc_Children {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer child_id;
	
	private Integer case_Id;
	
	private LocalDate child_dob;
	
	private Integer ssn;
}

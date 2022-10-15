package com.example.service;

import java.util.Map;

import com.example.entity.Dc_Children;
import com.example.entity.Dc_Education;
import com.example.entity.Dc_Income;

public interface ServiceRepo {

	public Integer search(Integer Appid);
	public Map<Integer, String> getplans();
	public Integer selectplan(Integer cno,Integer number,String planname);
	public String saveIncome(Dc_Income dcinc,Integer num);
	public String saveEducation(Dc_Education dcedu,Integer num);
	public void saveChildren(Dc_Children dcchild,Integer num);
	
}

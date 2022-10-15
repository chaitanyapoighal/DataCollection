package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Dc_Cases;
import com.example.entity.Dc_Children;
import com.example.entity.Dc_Education;
import com.example.entity.Dc_Income;
import com.example.entity.Plan;
import com.example.repo.Dc_CasesRepo;
import com.example.repo.Dc_EducationRepo;
import com.example.repo.Dc_childrenRepo;
import com.example.repo.Dc_incomeRepo;
import com.example.repo.PlanRepository;
@Service
public class ServiceImplDc implements ServiceRepo {
	@Autowired
	private PlanRepository prepo;
	
	@Autowired
	private Dc_CasesRepo drepo;
    
    @Autowired
	private Dc_childrenRepo crepo;
    
    @Autowired
	private Dc_EducationRepo erepo;
    
    @Autowired
	private Dc_incomeRepo irepo;
    
	public Integer search(Integer Appid) {
		Boolean value=prepo.existsById(Appid);
		if(value)
		{
			Dc_Cases dc=new Dc_Cases();
		    drepo.save(dc);
		    return dc.getCase_Id();
		}
		else
		  return 0;
	}

	public Map<Integer, String> getplans() {
		Map<Integer, String> map = new HashMap<>();
		List<Plan> plans = prepo.findAll();
		plans.forEach(plan -> {
			map.put(plan.getPlanid(), plan.getPlanname());
		});
		return map;
	}
	
	public Integer selectplan(Integer caseno,Integer appid,String planname) {
		Dc_Cases dc=new Dc_Cases();
		dc.setCase_Id(caseno);
		Integer id=prepo.getPlanId(planname);
		dc.setPlan_id(id);
		dc.setApp_id(appid);
		drepo.save(dc);
		return dc.getCase_Id();
	}

	public String saveIncome(Dc_Income dcinc,Integer casenum) {
		dcinc.setCase_Id(casenum);
		irepo.save(dcinc);
		return "Income details stored successfully";
	}

	public String saveEducation(Dc_Education dcedu,Integer casenum) {
		dcedu.setCase_Id(casenum);
		erepo.save(dcedu);
		return "Education details stored successfully";
	}

	public void saveChildren(Dc_Children dcchild,Integer casenum) {
		dcchild.setCase_Id(casenum);
		crepo.save(dcchild);
		
	}

	

	

	

}

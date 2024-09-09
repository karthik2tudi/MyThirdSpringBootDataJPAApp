package com.rt.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rt.domain.Employee;
import com.rt.exception.EmployeeNotFoundException;
import com.rt.repository.EmpRepository;

@Service
@Transactional
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	public int saveEmp(Employee employee) {
		com.rt.entity.Employee entity = new com.rt.entity.Employee();
		if (employee != null && Objects.nonNull(employee)) {
			entity.setEadd(employee.getEadd() != null ? employee.getEadd().concat("city") : "Delhi City");
			entity.setEname(employee.getEname());
			entity.setNetSalery(employee.getNetSalery());
			entity.setGrossSalery(employee.getNetSalery() + 10000);
			entity.setPfContribution((employee.getNetSalery() + 1000) - 30000);
			com.rt.entity.Employee save = empRepository.save(entity);
			return save.getEid();
		}
		return 30;
	}

	/**
	 * method is used to fetch all employee details from the DB by calling the
	 * findAll which is there in repository
	 * 
	 * @return List of Employee
	 */
	public List<com.rt.entity.Employee> getAllEmpDetails() {
		return empRepository.findAll();
	}

	/**
	 * method is used to fetch the details of an employee by submitting the Id.
	 * 
	 * @param id
	 * @return employee or Exception
	 */
	public com.rt.entity.Employee getEmpDetailsById(int id) {
		System.out.println(empRepository.getClass().getName());
		System.out.println(empRepository.count());
		return empRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee details not found"));
	}

	/**
	 * first u need check id is present or not if id is present to update it with
	 * the data or throw exception saying no id found
	 */
	public String updateEmp(com.rt.entity.Employee e) {
		Optional<com.rt.entity.Employee> empdataById = empRepository.findById(e.getEid());
		if (empdataById.isPresent()) {
			com.rt.entity.Employee save = empRepository.save(e);
			return save.getEname();
		} else {
			return "employee data not found";
		}
	}

	/**
	 * method is used to delete the employee id based on id
	 * 
	 * @param id
	 */
	public void deleteEmpId(int id) {
		boolean empdataById = empRepository.existsById(id);
		if (empdataById) {
			empRepository.deleteById(id);
			
		}
		else {
			throw new EmployeeNotFoundException("Employee Not found");
		}
	}
	
	
	/**
	 * findBy methods
	 * @param address
	 * @return
	 */
	public List<com.rt.entity.Employee> findEmpDetailsByAddress(String address) {
		return empRepository.findByEadd(address);
	}
	
	public List<com.rt.entity.Employee> getEmpdDetailswhoseSalMore(int grossSal,int netSal){
		return empRepository.findByGrossSaleryGreaterThanEqualAndNetSaleryGreaterThanEqual(grossSal,netSal);
	}

	
	public List<com.rt.entity.Employee> getAllEmp(String city) {
		return empRepository.getAllEmpDetails(city);
	}
	
	
	public List<com.rt.entity.Employee> getEmpSalery(int salery){
		return empRepository.getEmpDetailsSalGreaterNative(salery);
	}
	
	
	public void updateEmpDetails(int incsalery,String location) {
		empRepository.UpdateEmp(incsalery, location);
	}

	
	
	public void DeleteEmp(String location) {
		empRepository.DeleteEmpByNativeQuery(location);
	}

}

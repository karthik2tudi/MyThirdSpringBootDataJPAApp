package com.rt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rt.domain.Employee;
import com.rt.service.EmpService;

@SpringBootApplication
public class MyThirdSpringBootDataJpaAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MyThirdSpringBootDataJpaAppApplication.class, args);
		EmpService empService = ctx.getBean(EmpService.class);
		Employee emp = new Employee();
		emp.setEname("Mustafa");
		emp.setEadd("Vizag");
		emp.setNetSalery(100000);
		// int id = empService.saveEmp(emp);
		// System.out.println("employee saved with id "+id);

		/**
		 * Retrieve alll employees details which are there in DB
		 */
		// List<com.rt.entity.Employee> allEmpDetails = empService.getAllEmpDetails();
//		allEmpDetails.stream().forEach(e ->{
//			System.out.println(e);
//		});
		// allEmpDetails.stream().forEach(System.out::println);
		// com.rt.entity.Employee empDetailsById = empService.getEmpDetailsById(2);
		// System.out.println(empDetailsById);
		// empService.deleteEmpId(1);

		//List<com.rt.entity.Employee> empDetailsByAddress = empService.getEmpdDetailswhoseSalMore(100000);
		//empDetailsByAddress.stream().forEach(System.out::println);

		// List<com.rt.entity.Employee> empdetailsWhoseSalMore =
		// empService.getEmpdDetailswhoseSalMore(150000,100000);
		// empdetailsWhoseSalMore.stream().forEach(System.out::println);
		
//		List<com.rt.entity.Employee> allEmp = empService.getAllEmp("Mumbai");
//		allEmp.stream().forEach(e->{
//			System.out.println(e);
//		});

		//empService.getEmpSalery(150000).stream().forEach(System.out::println);
		
		//empService.updateEmpDetails(15000, "Hyd");
		empService.DeleteEmp("Mumbai");
		
		
	}

}

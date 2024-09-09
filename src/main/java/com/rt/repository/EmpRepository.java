package com.rt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.domain.Employee;


@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	// select * from emp_details_india where eadd =?;
	//List<Employee> findByEadd(String eadd);
	
	
	List<Employee> findByGrossSaleryGreaterThan(int grossSalery);
	List<Employee> findByGrossSaleryGreaterThanEqual(int gross);
	
	List<Employee> findByNetSaleryLessThanEqual(int netSalery);

	//print emp details whose gSal>=100000 and nSal>=90000;
	//select * from emp_details_india where g_salery>=:? and n_salery>=?;
	List<Employee> findByGrossSaleryGreaterThanEqualAndNetSaleryGreaterThanEqual(int grossSal, int netSal);
	
	
	/***
	 * no supports the non select queries like insert, update, delete
	 * methods name are bit lengthy which can confuse the dev
	 * it is returning the entire entity object i.e not supporting to return only specific properties like ename/ eid/eadd
	 * 
	 * @param grossSalery
	 * @return
	 */
	
	
	/**
	 * @Query methods
	 * @param grossSalery
	 * @return
	 */
	
//	@Query("FROM Employee emp WHERE emp.grossSalery=:gSalery")
//	List<Employee> getEmpDetailsBySalery(@Param("gSalery") int grossSalery);
//	
	
	
	@Query("FROM Employee emp WHERE emp.eadd=:add")
	List<Employee> getAllEmpDetails(@Param("add") String address);

	//select * from emp where grossSalery >10000;
	@Query("FROM Employee e WHERE e.grossSalery>:sal")
	List<Employee> getEmpDetailsSalGreater(@Param("sal") int salery);

	/**
	 * Native queries
	 * 
	 * @param salery
	 * @return
	 */
	@Query(value = "SELECT * FROM emp_details_india e WHERE e.g_salery>:sal", nativeQuery = true)
	List<Employee> getEmpDetailsSalGreaterNative(@Param("sal") int salery);
	
	
	/**
	 * 
	 * Non Select Queries
	 * 
	 */

	@Modifying
	@Query(value = "UPDATE Employee SET grossSalery=:incsalery WHERE eadd=:city")
	void UpdateEmp(@Param("incsalery") int incsalery,@Param("city") String location);
	
	
	@Modifying
	@Query(value = "DELETE FROM Employee WHERE eadd=:city")
	void DeleteEmp(@Param("city") String location);
	
	
	@Modifying
	@Query(value = "DELETE FROM EMP_DETAILS_INDIA WHERE ADDRESS=:city", nativeQuery = true)
	void DeleteEmpByNativeQuery(@Param("city") String location);
	

}

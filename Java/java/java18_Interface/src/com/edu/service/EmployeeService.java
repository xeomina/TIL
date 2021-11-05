package com.edu.service;

import com.edu.parent.Employee;

//프로젝트시 PM역할이 이 부분을 작성해서 팀원들에게 나눠준다
public interface EmployeeService {
	void manageEmployee(Employee e);
	void printAllEmployee(Employee[] emps);

}

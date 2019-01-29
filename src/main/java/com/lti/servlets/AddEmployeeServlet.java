package com.lti.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lti.DatabaseEntry.EmployeeDao;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String empno=request.getParameter("empno");
		String empname=request.getParameter("empname");
		String salary=request.getParameter("salary");
		
	
		
		System.out.println(empno + empname + salary);
		EmployeeDao d=new EmployeeDao();
		d.insert(empno, empname, salary);
		response.sendRedirect("addEmployee.jsp");
		
		
	}

}

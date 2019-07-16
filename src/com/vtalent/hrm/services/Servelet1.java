package com.vtalent.hrm.services;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vtalent.hrm.beans.Employee;
import com.vtalent.hrm.dao.DBOperations;

/**
 * Servlet implementation class Servelet1
 */
@WebServlet("/Servelet1")
public class Servelet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
		
		String ID = request.getParameter("employeeID");
		int empID = Integer.parseInt(ID);
		String empName = request.getParameter("employeeName");
		String salary = request.getParameter("employeeSalary");
		double empSalary = Integer.parseInt(salary);
		String empMobile = request.getParameter("employeeMobile");
		String empAddress = request.getParameter("employeeAddress");
		
		Employee emp = new Employee();
		emp.setEmployeeID(empID);
		emp.setEmployeeName(empName);
		emp.setEmployeeSalary(empSalary);
		emp.setEmpolyeeMobile(empMobile);
		emp.setEmployeeAddress(empAddress);
		
		DBOperations db = new DBOperations();
		
		int status = db.InsertDataWithStatement(emp);
		
		HttpSession session = request.getSession();
		session.setAttribute("EmployeeID", emp.getEmployeeID());
		
		out.println("<html><body>");
		out.println("<form action ='SuccessServlet' method='post'>");
		out.println("<input type='submit' value='getSession'/>");
		out.println("</form></body><html>");
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

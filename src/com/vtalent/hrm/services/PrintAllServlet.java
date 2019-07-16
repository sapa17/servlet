package com.vtalent.hrm.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtalent.hrm.beans.Employee;
import com.vtalent.hrm.dao.DBOperations;

/**
 * Servlet implementation class PrintAllServlet
 */
@WebServlet("/PrintAllServlet")
public class PrintAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DBOperations db = new DBOperations();
		List <Employee> listofemployees = db.Print();
		out.print("<table border='1' width='100%'");  
		
		if (listofemployees != null) {
			out.println("<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Salary</th><th>Employee Mobile</th><th>Employee Address</th> </tr>");
			for (Employee emp:listofemployees) {
				
				out.println("<tr><td>" + emp.getEmployeeID() + "</td><td>" + emp.getEmployeeName() + "</td><td>" + emp.getEmployeeSalary() +
						"</td><td>" + emp.getEmpolyeeMobile() + "</td><td>" + emp.getEmployeeAddress() + "</td></tr>");
					

				
				
			}
			out.print("</table>");  	

			
		} else {

		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

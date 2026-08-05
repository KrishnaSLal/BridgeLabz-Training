package com.healthclinic.main;

import com.healthclinic.dao.PatientDAO;
import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.dao.BillingDAO;
import com.healthclinic.dao.DepartmentDAO;

public class HealthclinicMain {
	public static void main(String[] args) {
		
//		PatientDAO patientDAO = new PatientDAO();
//		
//		patientDAO.addPatient();
//		
//		 AppointmentDAO appointmentDAO = new AppointmentDAO();
//
//	        appointmentDAO.getScheduledAppointmentsByDoctor();
		
//		 BillingDAO billingDAO = new BillingDAO();
//
//	        billingDAO.deleteBill();
		
		 DepartmentDAO departmentDAO = new DepartmentDAO();

	        departmentDAO.addDepartment();
		
		
	}

}

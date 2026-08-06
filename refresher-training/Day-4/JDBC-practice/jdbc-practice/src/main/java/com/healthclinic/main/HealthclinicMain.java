package com.healthclinic.main;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.healthclinic.dao.*;
import com.healthclinic.model.*;
import com.healthclinic.service.TransactionService;

public class HealthclinicMain {

    static Scanner sc = new Scanner(System.in);

    static DepartmentDAO departmentDAO = new DepartmentDAO();
    static DoctorDAO doctorDAO = new DoctorDAO();
    static PatientDAO patientDAO = new PatientDAO();
    static AppointmentDAO appointmentDAO = new AppointmentDAO();
    static VisitDAO visitDAO = new VisitDAO();
    static BillingDAO billingDAO = new BillingDAO();
    static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\nHEALTH CLINIC ");
            System.out.println("\n1. Department");
            System.out.println("2. Doctor");
            System.out.println("3. Patient");
            System.out.println("4. Appointment");
            System.out.println("5. Visit");
            System.out.println("6. Billing");
            System.out.println("7. Exit");
            System.out.print("Enter your Choice : ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 : departmentMenu();
                case 2 : doctorMenu();
                case 3 : patientMenu();
                case 4 : appointmentMenu();
                case 5 : visitMenu();
                case 6 : billingMenu();
                case 7 : System.out.println("Thank You!");
                break;
                default : System.out.println("Invalid Choice");
            }

        } while (choice != 7);
    }

    static void departmentMenu() {
        int c;
        do {
            System.out.println("\n Department Menu ");
            System.out.println(" ");
            System.out.println("1.Add 2.View 3.Search 4.Update 5.Delete 6.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 :{
                    System.out.print("Department Name: ");
                    departmentDAO.addDepartment(new Department(sc.nextLine()));
                }
                
                case 2 : departmentDAO.viewDepartments();
                
                case 3 : {
                    System.out.print("Department ID: ");
                    departmentDAO.searchDepartment(Integer.parseInt(sc.nextLine()));
                }
                
                case 4 : {
                    System.out.print("Department ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New Name: ");
                    departmentDAO.updateDepartment(id, sc.nextLine());
                }
                
                case 5 : {
                    System.out.print("Department ID: ");
                    departmentDAO.deleteDepartment(Integer.parseInt(sc.nextLine()));
                    break;
                }
                
                default : System.out.println("Invalid Choice");
            }
        } while (c != 6);
    }

    static void doctorMenu() {
        int c;
        do {
            System.out.println("\n Doctor Menu ");
            System.out.println(" ");
            System.out.println("1.Add 2.View 3.Search 4.Update Info 5.Delete 6.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 : {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Specialty: ");
                    String sp = sc.nextLine();
                    System.out.print("Department ID: ");
                    int dep = Integer.parseInt(sc.nextLine());
                    doctorDAO.addDoctor(new Doctor(name, sp, dep));
                }
                
                case 2 : doctorDAO.viewDoctors();
                
                case 3 : {
                    System.out.print("Doctor ID: ");
                    doctorDAO.searchDoctor(Integer.parseInt(sc.nextLine()));
                }
                
                case 4 : {
                    System.out.print("Doctor ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Specialty: ");
                    String specialty = sc.nextLine();
                    System.out.print("New Department ID: ");
                    int departmentId = Integer.parseInt(sc.nextLine());
                    doctorDAO.updateDoctor(id, name, specialty, departmentId);
                    
                }
                case 5 : {
                    System.out.print("Doctor ID: ");
                    doctorDAO.deleteDoctor(Integer.parseInt(sc.nextLine()));
                    
                    break;
                }
                
                default : System.out.println("Invalid Choice");
            }
        } while (c != 6);
    }

    static void patientMenu() {
        int c;
        do {
            System.out.println("\n Patient Menu ");
            System.out.println(" ");
            System.out.println("1.Add 2.View 3.Search 4.Update Info 5.Delete 6.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 : {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("DOB (yyyy-mm-dd): ");
                    Date dob = Date.valueOf(sc.nextLine());
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    patientDAO.addPatient(new Patient(name, phone, dob, gender));
                }
                
                case 2 : patientDAO.viewPatients();
                
                case 3 : {
                    System.out.print("Patient ID: ");
                    patientDAO.searchPatient(Integer.parseInt(sc.nextLine()));
                }
                
                case 4 : {
                    System.out.print("Patient ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("New DOB (yyyy-mm-dd): ");
                    Date dob = Date.valueOf(sc.nextLine());
                    System.out.print("New Gender: ");
                    String gender = sc.nextLine();
                    patientDAO.updatePatient(id, name, phone, dob, gender);
                }
                
                case 5 : {
                    System.out.print("Patient ID: ");
                    patientDAO.deletePatient(Integer.parseInt(sc.nextLine()));
                    
                    break;
                }
                
                default : System.out.println("Invalid Choice");
            }
        } while (c != 6);
    }

    static void appointmentMenu() {
        int c;
        do {
            System.out.println("\n Appointment Menu ");
            System.out.println(" ");
            System.out.println("1.Schedule 2.View 3.Search 4.Update Appointment info 5.Delete 6.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 : {
                    System.out.print("Patient ID: ");
                    int pid = Integer.parseInt(sc.nextLine());
                    System.out.print("Doctor ID: ");
                    int did = Integer.parseInt(sc.nextLine());
                    System.out.print("Date Time (yyyy-mm-dd hh:mm:ss): ");
                    Timestamp ts = Timestamp.valueOf(sc.nextLine());
                    System.out.print("Status: ");
                    String st = sc.nextLine();
                    appointmentDAO.addAppointment(new Appointment(pid, did, ts, st));
                }
                
                case 2 : appointmentDAO.viewAppointments();
                
                case 3 : {
                    System.out.print("Appointment ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    appointmentDAO.searchAppointment(id);
                }
                
                case 4 : {
                    System.out.print("Appointment ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Patient ID: ");
                    int patientId = Integer.parseInt(sc.nextLine());
                    System.out.print("Doctor ID: ");
                    int doctorId = Integer.parseInt(sc.nextLine());
                    System.out.print("Appointment Date (yyyy-mm-dd hh:mm:ss): ");
                    Timestamp ts = Timestamp.valueOf(sc.nextLine());
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    appointmentDAO.updateAppointment(id,patientId,doctorId,ts,status);
                    
                }
                case 5 : {
                    System.out.print("Appointment ID: ");
                    appointmentDAO.deleteAppointment(Integer.parseInt(sc.nextLine()));
                    
                    break;
                }
                
                default : System.out.println("Invalid Choice");
            }
        } while (c != 6);
    }

    static void visitMenu() {
        int c;
        do {
            System.out.println("\n Visit Menu ");
            System.out.println(" ");
            System.out.println("1.Add 2.View 3.Search 4.Update visit info 5.Delete 6.Complete Visit + Generate Bill 7.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 : {
                    System.out.print("Appointment ID: ");
                    int aid = Integer.parseInt(sc.nextLine());
                    System.out.print("Visit DateTime (yyyy-mm-dd hh:mm:ss): ");
                    Timestamp ts = Timestamp.valueOf(sc.nextLine());
                    System.out.print("Diagnosis: ");
                    String d = sc.nextLine();
                    visitDAO.addVisit(new Visit(aid, ts, d));
                }
                
                case 2 : visitDAO.viewVisits();
                
                case 3 : {
                    System.out.print("Visit ID: ");
                    visitDAO.searchVisit(Integer.parseInt(sc.nextLine()));
                }
                
                case 4 : {
                    System.out.print("Visit ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Appointment ID: ");
                    int appointmentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Visit Date (yyyy-mm-dd hh:mm:ss): ");
                    Timestamp ts = Timestamp.valueOf(sc.nextLine());
                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.nextLine();
                    visitDAO.updateVisit(id,appointmentId,ts,diagnosis);
                }
                
                case 5 : {
                    System.out.print("Visit ID: ");
                    visitDAO.deleteVisit(Integer.parseInt(sc.nextLine()));
                }
                
                case 6 : {
                    System.out.print("Appointment ID: ");
                    int appointmentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Visit Date (yyyy-MM-dd HH:mm:ss): ");
                    Timestamp visitDate = Timestamp.valueOf(sc.nextLine());
                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.nextLine();
                    Visit visit = new Visit(appointmentId,visitDate,diagnosis);

                    System.out.print("Visit ID for Billing: ");
                    int visitId = Integer.parseInt(sc.nextLine());
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Payment Status: ");
                    String paymentStatus = sc.nextLine();
                    Billing bill = new Billing(visitId,amount,paymentStatus);
                    transactionService.completeVisit(visit, bill);
                    
                    break;
                }
                
                default : System.out.println("Invalid Choice");
            }
        } while (c != 7);
    }

    static void billingMenu() {
        int c;
        do {
            System.out.println("\n Billing Menu ");
            System.out.println(" ");
            System.out.println("1.Generate 2.View 3.Search 4.Update Payment 5.Delete 6.Back");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 : {
                    System.out.print("Visit ID: ");
                    int vid = Integer.parseInt(sc.nextLine());
                    System.out.print("Amount: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    System.out.print("Payment Status: ");
                    String st = sc.nextLine();
                    billingDAO.generateBill(new Billing(vid, amt, st));
                }
                
                case 2 : billingDAO.viewBills();
                
                case 3 : {
                    System.out.print("Bill ID: ");
                    billingDAO.searchBill(Integer.parseInt(sc.nextLine()));
                }
                
                case 4 : {

                    System.out.print("Bill ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Visit ID: ");
                    int visitId = Integer.parseInt(sc.nextLine());
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Payment Status: ");
                    String paymentStatus = sc.nextLine();
                    billingDAO.updateBill(id,visitId,amount,paymentStatus);
                }
                
                case 5 : {
                    System.out.print("Bill ID: ");
                    billingDAO.deleteBill(Integer.parseInt(sc.nextLine()));
                    
                    break;
                }
                
                default :  System.out.println("Invalid Choice");
            }
        } while (c != 6);
    }
}
package com.healthclinic.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.healthclinic.dao.BillingDAO;
import com.healthclinic.dao.VisitDAO;
import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Billing;
import com.healthclinic.model.Visit;

public class TransactionService {

	private VisitDAO visitDAO = new VisitDAO();
    private BillingDAO billingDAO = new BillingDAO();

    public void completeVisit(Visit visit, Billing bill) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            visitDAO.addVisit(con, visit);

            billingDAO.generateBill(con, bill);

            con.commit();

            System.out.println(" Transaction Successfull");

        } catch (Exception e) {

            try {

                if (con != null) {

                    con.rollback();

                    System.out.println("\nTransaction Rolled Back.");

                }

            } catch (SQLException ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        } 
        
        finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);

                    con.close();

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

}
package Bean;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import Dto.Customer;

import com.mysql.jdbc.PreparedStatement;

public class CustomerBean
{   
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/insurance_management";
	static final String DB_USER = "root";
	static final String DB_PASS = "root";
	private Connection cn;
	private JdbcRowSet rowSet=null;
	private PreparedStatement pst;
	public CustomerBean()
	{
		try 
		{
		Class.forName(JDBC_DRIVER);
		rowSet.setUrl(DB_URL);
		rowSet.setUsername(DB_USER);
		rowSet.setPassword(DB_PASS);
		rowSet.setCommand("SELECT * FROM Person");
		rowSet.execute();
			}
		catch (Exception e) 
		{
		e.printStackTrace();
		}      
			}		

	
	public  Customer create(Customer cust)
	{  
		try{
			
		 rowSet.moveToInsertRow();	
		 rowSet.updateString("customerName", cust.getCustomerName());
		 rowSet.updateString("customerDob", cust.getCustomerDob());
		 rowSet.updateString("address", cust.getAddress());
		 rowSet.updateString("phone", cust.getPhone());
		 rowSet.insertRow();
		 rowSet.moveToCurrentRow();
	}
	catch (SQLException ex) {
         try {
            rowSet.rollback();
            cust = null;
         } catch (SQLException e) {

         }
         ex.printStackTrace();
      }
      return cust;}
	
	public Customer update(Customer cust)
	{ 
		try
		{
			 rowSet.updateString("customerName", cust.getCustomerName());
			 rowSet.updateString("customerDob", cust.getCustomerDob());
			 rowSet.updateString("address", cust.getAddress());
			 rowSet.updateString("phone", cust.getPhone());
			 rowSet.insertRow();
			 rowSet.moveToCurrentRow();				
		}
		catch(SQLException ex)
		{
			try{
				rowSet.rollback();
				cust=null;
				
			} catch (SQLException e) {

	         }
	         ex.printStackTrace();
	      }
	      return cust;}
	    public  void delete() {
	      try {
	         rowSet.moveToCurrentRow();
	         rowSet.deleteRow();
	      } catch (SQLException ex) {
	         try {
	            rowSet.rollback();
	         } catch (SQLException e)
	         { }
	         ex.printStackTrace();
	      }}

	   public Customer moveFirst()
	      {
	    	 Customer cust= new Customer();
	    	 try {
	             rowSet.first();
	             cust.setCustomerName (rowSet.getString("customerName"));
	             cust.setCustomerDob(rowSet.getString("customerDob"));
	             cust.setAddress(rowSet.getString("address"));
	             cust.setPhone(rowSet.getString("phone"));

	          } catch (SQLException ex) {
	             ex.printStackTrace();
	          }
	          return cust;
	       }
       
	   public Customer moveLast()
	   {
		   Customer cust = new Customer();
		      try {
		         rowSet.last();
		   	     cust.setCustomerName(rowSet.getString("customerName"));
		         cust.setCustomerDob(rowSet.getString("customerDob"));
		         cust.setAddress(rowSet.getString("address"));
		         cust.setPhone(rowSet.getString("phone"));
		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return cust;
		   }
		   
	   public Customer moveNext() {
		      Customer cust = new Customer();
		      try {
		         if (rowSet.next() == false)
		            rowSet.previous();
		         cust.setCustomerName(rowSet.getString("customerName"));
		         cust.setCustomerDob(rowSet.getString("customerDob"));
		         cust.setAddress(rowSet.getString("address"));
		         cust.setPhone(rowSet.getString("phone"));

		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return cust;
		   }
	   public Customer movePrevious() {
		      Customer cust = new Customer();
		      try {
		         if (rowSet.previous() == false)
		            rowSet.next();
		         cust.setCustomerName(rowSet.getString("customerName"));
		         cust.setCustomerDob(rowSet.getString("customerDob"));
		         cust.setAddress(rowSet.getString("address"));
		         cust.setPhone(rowSet.getString("phone"));

		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return cust;
		   }
	   
	   public Customer getCurrent() {
		      Customer cust = new Customer();
		      try {
		         rowSet.moveToCurrentRow();
		         cust.setCustomerName(rowSet.getString("customerName"));
		         cust.setCustomerDob(rowSet.getString("customerDob"));
		         cust.setAddress(rowSet.getString("address"));
		         cust.setPhone(rowSet.getString("phone"));
		      } catch (SQLException ex) {
		         ex.printStackTrace();
		      }
		      return cust;
	   }
	   
	   public void cleanUp() throws Exception
	   {
		   if(pst!=null)
			   pst.close();
		   if(cn!=null)
			   cn.close();
	   }


	}


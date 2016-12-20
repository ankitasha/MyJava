package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Bean.CustomerBean;
import Dto.Customer;
import net.miginfocom.swing.*;

public class CustomerUI extends JPanel 
{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NameField = new JTextField(30);
	   private JTextField DOBField = new JTextField(30);
	   private JTextField AddressField = new JTextField(30);
	   private JTextField PhoneField = new JTextField(30);	   

	   private JButton createButton = new JButton("New...");
	   private JButton updateButton = new JButton("Update..");
	   private JButton deleteButton = new JButton("Delete...");
	   private JButton firstButton = new JButton("First...");
	   private JButton prevButton = new JButton("Previous...");
	   private JButton nextButton = new JButton("Next...");
	   private JButton lastButton = new JButton("Last...");
	   
	   private CustomerBean bean = new CustomerBean();

	   
	   public CustomerUI() {
		      setBorder(new TitledBorder
		      (new EtchedBorder(),"Person Details"));
		      setLayout(new BorderLayout(5, 5));
		      add(initFields(), BorderLayout.NORTH);
		      add(initButtons(), BorderLayout.CENTER);
		      setFieldData(bean.moveFirst());
		   }

	  

	private JPanel initButtons() {
		      JPanel panel = new JPanel();
		      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		      panel.add(createButton);
		      createButton.addActionListener(new ButtonHandler());
		      panel.add(updateButton);
		      updateButton.addActionListener(new ButtonHandler());
		      panel.add(deleteButton);
		      deleteButton.addActionListener(new ButtonHandler());
		      panel.add(firstButton);
		      firstButton.addActionListener(new ButtonHandler());
		      panel.add(prevButton);
		      prevButton.addActionListener(new ButtonHandler());
		      panel.add(nextButton);
		      nextButton.addActionListener(new ButtonHandler());
		      panel.add(lastButton);
		      lastButton.addActionListener(new ButtonHandler());
		      return panel;
		   }
	   private JPanel initFields() {
		      JPanel panel = new JPanel();
		      panel.setLayout(new MigLayout());
		      panel.add(new JLabel("Name"), "align label");
		      panel.add(NameField, "wrap");
		      panel.setLayout(new MigLayout());
		      panel.add(new JLabel("DOB"), "align label");
		      panel.add(DOBField, "wrap");
		      panel.setLayout(new MigLayout());
		      panel.add(new JLabel("Address"), "align label");
		      panel.add(AddressField, "wrap");
		      panel.setLayout(new MigLayout());
		      panel.add(new JLabel("Phone"), "align label");
		      panel.add(PhoneField, "wrap");
		      return panel;
	   }
	        private Customer getFieldData() {
		      Customer cust = new Customer();
		      /*cust.setPersonId(Integer.parseInt(idField.getText()));*/
		      cust.setCustomerName(NameField.getText());
		      cust.setCustomerDob(DOBField.getText());
		      cust.setAddress(AddressField.getText());
		      cust.setPhone(PhoneField.getText());
		      return cust;

	   }
		      
	  	        private void setFieldData(Customer c) {
		          /*idField.setText(String.valueOf(p.getPersonId()));*/
		          NameField.setText(c.getCustomerName());
		          DOBField.setText(c.getCustomerDob());
		          AddressField.setText(c.getAddress());
		          PhoneField.setText(c.getPhone());
		          
		       }  
	  	        
	  	      private boolean isEmptyFieldData() {
	  	        return (NameField.getText().trim().isEmpty()
	  	           &&  DOBField.getText().trim().isEmpty()
	  	           && AddressField.getText().trim().isEmpty()
	  	           && PhoneField.getText().trim().isEmpty());
	  	     }
	  	        
	  	    private class ButtonHandler implements ActionListener {
	  	      @SuppressWarnings("unused")
			public void actionPerformed1(ActionEvent e) {
	  	         Customer c = getFieldData();
	  	         switch (e.getActionCommand()) 
	  	         {
	  	         case "Save":
	  	            if (isEmptyFieldData()) {
	  	               JOptionPane.showMessageDialog(null,
	  	               "Cannot create an empty record");
	  	               return;
	  	            }
	  	            
	  	            if (bean.create(c) != null)
	  	               JOptionPane.showMessageDialog(null,
	  	               "New person created successfully.");
	  	               createButton.setText("New...");
	  	               break;
	  	       case "New...":
	  	            /*c.setPersonId(new Random()
	  	            .nextInt(Integer.MAX_VALUE) + 1);
	  	            */
	  	    	    c.setCustomerName("");
	  	            c.setCustomerDob("");
	  	            c.setAddress("");
	  	            c.setPhone("");
	  	            setFieldData(c);
	  	            createButton.setText("Save");
	  	            break;
	  	     case "Update":
	             if (isEmptyFieldData()) {
	                JOptionPane.showMessageDialog(null,
	                "Cannot update an empty record");
	                return;
	             }
	             if (bean.update(c) != null)
	                JOptionPane.showMessageDialog(
	                null,"Person with Name:" + c.getCustomerName()
	                + " is updated successfully");
	             /*String.valueOf(p.getPersonId()*/
	                break;

	  	   case "Delete":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot delete an empty record");
	               return;
	            }
	            c = bean.getCurrent();
	            bean.delete();
	            JOptionPane.showMessageDialog(
	               null,"Person with Name:"
	               +c.getCustomerName()
	               + " is deleted successfully");
	               break;
	               /*String.valueOf(p.getPersonId()*/
	  	         
	  	    case "First":
	            setFieldData(bean.moveFirst()); break;
	         case "Previous":
	            setFieldData(bean.movePrevious()); break;
	         case "Next":
	            setFieldData(bean.moveNext()); break;
	         case "Last":
	            setFieldData(bean.moveLast()); break;
	         default:
	            JOptionPane.showMessageDialog(null,
	            "invalid command");
	  	         }
	  	      }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
	  	    }
}


/*}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
*/				
			
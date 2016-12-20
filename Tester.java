package test;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import UI.CustomerUI;

public class Tester
{
	 public static void main(String[] args) {
	      JFrame f=new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
	      f.getContentPane().add(new CustomerUI());
	      f.setSize(600, 280);
	      f.setVisible(true);
	   }

}

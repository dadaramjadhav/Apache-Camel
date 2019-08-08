package com.capgemini;

public class EmpBean {

   private int counter=5000;

   public Employee generateEmp() {
       counter++;

       Employee emp = new Employee();
       emp.setId(counter);
       emp.setName("dm"+counter);
       return emp;
   }

   public String processEmp(Employee emp) {
       return "Processed Employee id " + emp.getId() + " Name " + emp.getName();
   }
}
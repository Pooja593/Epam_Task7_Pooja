package StructuralDesign_Patterns;
import java.util.ArrayList;
import java.util.List;
public class Composite{
	   public static void main(String[] args) {
	   
	      Employe CEO = new Employe("John","CEO", 30000);

	      Employe headSales = new Employe("Robert","Head Sales", 20000);

	      Employe headMarketing = new Employe("Michel","Head Marketing", 20000);

	      Employe clerk1 = new Employe("Laura","Marketing", 10000);
	      Employe clerk2 = new Employe("Bob","Marketing", 10000);

	      Employe salesExecutive1 = new Employe("Richard","Sales", 10000);
	      Employe salesExecutive2 = new Employe("Rob","Sales", 10000);

	      CEO.add(headSales);
	      CEO.add(headMarketing);

	      headSales.add(salesExecutive1);
	      headSales.add(salesExecutive2);

	      headMarketing.add(clerk1);
	      headMarketing.add(clerk2);

	      //print all employees of the organization
	      System.out.println(CEO); 
	      
	      for (Employe headEmployee : CEO.getSubordinates()) {
	         System.out.println(headEmployee);
	         
	         for (Employe employee : headEmployee.getSubordinates()) {
	            System.out.println(employee);
	         }
	      }		
	   }
	}
class Employe {
	   private String name;
	   private String dept;
	   private int salary;
	   private List<Employe> subordinates;

	   // constructor
	   public Employe(String name,String dept, int sal) {
	      this.name = name;
	      this.dept = dept;
	      this.salary = sal;
	      subordinates = new ArrayList<Employe>();
	   }

	   public void add(Employe e) {
	      subordinates.add(e);
	   }

	   public void remove(Employe e) {
	      subordinates.remove(e);
	   }

	   public List<Employe> getSubordinates(){
	     return subordinates;
	   }

	   public String toString(){
	      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
	   }   
	}
package it.betacom.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;
import static javax.persistence.AccessType.PROPERTY;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String ename;
	private double salary;
	private String deg;
	
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}

	
	
	/**
	 * @param eid
	 * @param ename
	 * @param salary
	 * @param deg
	 */
	public Employee(int eid, String ename, double salary, String deg) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}



	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
	}
   
	
	
}

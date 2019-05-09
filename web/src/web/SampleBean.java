package web;

import java.io.Serializable;

public class SampleBean implements Serializable{

	private int salary =0;

	public int getSalary() {
		System.out.println(salary);
		return salary;

	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

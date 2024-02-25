package employeManagement.model.dto;

public class Employee {
	public Employee()
	{
		
	}
	private int id;
	private String name;
	private double salary;
	private long number;
	private String password;
	private String roll;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", number=" + number + ", password="
				+ password + ", roll=" + roll + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public Employee(int id, String name, double salary, long number, String password, String roll) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.number = number;
		this.password = password;
		this.roll = roll;
	}

}

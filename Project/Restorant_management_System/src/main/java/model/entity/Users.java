package model.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
public class Users {
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", menu=" + menu + ", branch=" + branch + ", foodorder=" + foodorder + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "user_seq_gen")
	@SequenceGenerator(name="user_seq_gen",initialValue = 101,sequenceName = "user_seq")
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
	
	@OneToOne(mappedBy = "user")
	private Menu menu;
	
	@ManyToOne
	private Branch branch;
	
	@OneToMany(mappedBy = "user")
	private List<FoodOrder> foodorder;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<FoodOrder> getFoodorder() {
		return foodorder;
	}

	public void setFoodorder(List<FoodOrder> foodorder) {
		this.foodorder = foodorder;
	}
 	

}

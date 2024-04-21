package model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "food_order_seq_gen")
	@SequenceGenerator(name="food_order_seq_gen",initialValue = 1001,sequenceName = "food_seq")
	private int id;
	private String status;
	private double total_price;
	private String name;
	private Long contactnumber;
	
	private LocalDate orederCreated;
	private LocalDate orederDelever;
	
	@ManyToOne
	@JoinColumn
	private Users user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(Long contactnumber) {
		this.contactnumber = contactnumber;
	}

	public LocalDate getOrederCreated() {
		return orederCreated;
	}

	public void setOrederCreated(LocalDate orederCreated) {
		this.orederCreated = orederCreated;
	}

	public LocalDate getOrederDelever() {
		return orederDelever;
	}

	public void setOrederDelever(LocalDate orederDelever) {
		this.orederDelever = orederDelever;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
	
	
	
	

}

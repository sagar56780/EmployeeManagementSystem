package model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value="prototype")
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "branch_seq_gen")
	@SequenceGenerator(name="branch_seq_gen",initialValue = 2001,sequenceName = "branch_seq")
	private  int id;
	private String name;
	private String adress;
	private Long phoneNumber;
	private String email;

	@OneToMany
	private List<Users> user;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Users> getUser() {
		return user;
	}
	public void setUser(List<Users> user) {
		this.user = user;
	}
	
}

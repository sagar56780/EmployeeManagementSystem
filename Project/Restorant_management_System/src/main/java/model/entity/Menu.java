package model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "menu_seq_gen")
	@SequenceGenerator(name="menu_seq_gen",initialValue = 201,sequenceName = "menu_seq")
	private int id;
	
	@OneToMany(mappedBy = "menu")
	private List<FoodProduct> foodProducts;
	
	@OneToOne
	@JoinColumn
	private Users user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FoodProduct> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProducts = foodProducts;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
	

}

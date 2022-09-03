package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-users")
public class User {
	
	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String email;
	@Field(type = FieldType.Text)
	private String fullname;
	@Field(type = FieldType.Text)
	private String password;
	@Field(type = FieldType.Date)
	private Date dayOfBirth;
	
	private List<Purchase> purchases = new ArrayList<Purchase>();

	// constructor vacio pedido por hibernate
	public User() {
	
	}
	
	public User(String anEmail, String aFullname, String aPassword, Date aDayOfBirth) {
		this.email = anEmail;
		this.fullname = aFullname;
		this.password = aPassword;
		this.dayOfBirth = aDayOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

}

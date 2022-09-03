package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-credit-card-payment")
public class CreditCardPayment extends PaymentMethod {

	@Field(type = FieldType.Text)
	private String brand; // marca de la tarjeta
	@Field(type = FieldType.Long)
	private Long number;
	@Field(type = FieldType.Date)
	private Date expiry;
	@Field(type = FieldType.Integer)
	private Integer cvv;
	@Field(type = FieldType.Text)
	private String owner;

	// constructor vacio pedido por hibernate
	public CreditCardPayment() {
		super();
	}
	public CreditCardPayment(String aName, String aBrand, Long aNumber, Date anExpiry, Integer aCvv, String AnOwner) {
		super(aName);
		this.brand = aBrand;
		this.number = aNumber;
		this.expiry = anExpiry;
		this.cvv = aCvv;
		this.owner = AnOwner;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}

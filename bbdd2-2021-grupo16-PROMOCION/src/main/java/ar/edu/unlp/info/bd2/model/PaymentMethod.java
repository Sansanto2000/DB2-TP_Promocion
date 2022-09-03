package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-payment-methods")
public abstract class PaymentMethod {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Text)
	private String name;
	
	// constructor vacio pedido por hibernate
	public PaymentMethod() {

	}
	
	public PaymentMethod(String aName) {
		this.name = aName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

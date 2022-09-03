package ar.edu.unlp.info.bd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-delivery-method")
public class DeliveryMethod {

	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Float)
	private Float cost;
	@Field(type = FieldType.Float)
	private Float startWeight; // peso minimo
	@Field(type = FieldType.Float)
	private Float endWeight; // peso maximo

	// constructor vacio pedido por hibernate
	public DeliveryMethod() {

	}
	
	public DeliveryMethod(String aName, Float aCost, Float aStartWeight, Float anEndWeight) {
		this.name = aName;
		this.cost = aCost;
		this.startWeight = aStartWeight;
		this.endWeight = anEndWeight;
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

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(Float startWeight) {
		this.startWeight = startWeight;
	}

	public Float getEndWeight() {
		return endWeight;
	}

	public void setEndWeight(Float endWeight) {
		this.endWeight = endWeight;
	}
}

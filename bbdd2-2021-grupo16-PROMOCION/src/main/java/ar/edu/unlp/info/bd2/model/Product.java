package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-products")
public class Product {

	@Id
	private String id;
	
	@Field(type = FieldType.Keyword)
	private String name;
	@Field(type = FieldType.Float)
	private Float weight;

	@Field(type = FieldType.Object)
	private Category category;

	private List<String> productOnSales = new ArrayList<String>();

	// constructor vacio pedido por hibernate
	public Product() {

	}

	public Product(String aName, Float aWeigth, Category aCategory) {
		this.name = aName;
		this.weight = aWeigth;
		this.category = aCategory;
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

	public Float getWeigth() {
		return weight;
	}

	public void setWeigth(Float weight) {
		this.weight = weight;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getProductsOnSale() {
		return productOnSales;
	}

	public void setProductsOnSale(List<String> list) {
		this.productOnSales = list;
	}
}

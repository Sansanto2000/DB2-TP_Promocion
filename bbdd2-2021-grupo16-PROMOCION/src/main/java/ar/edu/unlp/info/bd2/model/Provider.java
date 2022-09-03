package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-providers")
public class Provider {

	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Long)
	private Long cuit;
	
	private List<ProductOnSale> productOnSales = new ArrayList<ProductOnSale>();
	
	// constructor vacio pedido por hibernate
	public Provider() {

	}
	
	public Provider(String aName, Long aCuit) {
		this.name = aName;
		this.cuit = aCuit;
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

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public List<ProductOnSale> getProductOnSales() {
		return productOnSales;
	}

	public void setProductOnSales(List<ProductOnSale> productOnSales) {
		this.productOnSales = productOnSales;
	}
}

package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-product-on-sales")
public class ProductOnSale {
	
	@Id
	private String id;
	
	@Field(type = FieldType.Text)
	private String productId;
	
	@Field(type = FieldType.Text)
	private String providerId;
	
	@Field(type = FieldType.Object)
	private Product product;
	@Field(type = FieldType.Object)
	private Provider provider;
	
	@Field(type = FieldType.Float)
	private Float price;
	@Field(type = FieldType.Date)
	private Date initialDate;
	@Field(type = FieldType.Date)
	private Date finalDate = null;
	@Field(type = FieldType.Boolean)
	private Boolean actual = true;

	public ProductOnSale() {

	}
	
	public ProductOnSale(String aProductId, String aProviderId, Float aPrice, Date anInitialDate) {
		this.product = null;
		this.provider = null;
		this.productId = aProductId;
		this.providerId = aProviderId;
		this.price = aPrice;
		this.initialDate = anInitialDate;
		this.finalDate = null;
	}
	
	public ProductOnSale(Product aProduct, Provider aProvider, Float aPrice, Date anInitialDate) {
		this.product = aProduct;
		this.provider = aProvider;
		this.productId = aProduct.getId();
		this.providerId = aProvider.getId();
		this.price = aPrice;
		this.initialDate = anInitialDate;
		this.finalDate = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return this.finalDate;
	}
	
	public void setFinalDate(Date anDate) {
		this.finalDate = anDate;
	}

	public Boolean getActual() {
		return actual;
	}

	public void setActual(Boolean actual) {
		this.actual = actual;
	}
}

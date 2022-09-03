package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-purchases")
public class Purchase {

	@Id
	private String id;
	
	@Field(type = FieldType.Object)
	private ProductOnSale productOnSale;
	
	@Field(type = FieldType.Integer)
	private Integer quantity;
	
	@Field(type = FieldType.Object)
	private User client;
	
	@Field(type = FieldType.Object)
	private DeliveryMethod deliveryMethod;
	
	@Field(type = FieldType.Object)
	private PaymentMethod paymentMethod;

	@Field(type = FieldType.Text)
	private String address;
	@Field(type = FieldType.Float)
	private Float coordX;
	@Field(type = FieldType.Float)
	private Float coordY;
	@Field(type = FieldType.Date)
	private Date dateOfPurchase;
	@Field(type = FieldType.Float)
	private Float total; // costo sin delivery
	
	public Purchase() {
		
	}
	
	public Purchase(ProductOnSale aProductOnSale, Integer aQuantity, User aClient, DeliveryMethod aDeliveryMethod,
			PaymentMethod aPaymentMethod, String anAddress, Float aCoordX, Float aCoordY, Date aDateOfPurchase) {
		this.productOnSale = aProductOnSale;
		this.quantity = aQuantity;
		this.client = aClient;
		this.deliveryMethod = aDeliveryMethod;
		this.paymentMethod = aPaymentMethod;
		this.address = anAddress;
		this.coordX = aCoordX;
		this.coordY = aCoordY;
		this.dateOfPurchase = aDateOfPurchase;
		this.total = productOnSale.getPrice() * aQuantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductOnSale getProductOnSale() {
		return productOnSale;
	}

	public void setProductOnSale(ProductOnSale productOnSale) {
		this.productOnSale = productOnSale;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getCoordX() {
		return coordX;
	}

	public void setCoordX(Float coordX) {
		this.coordX = coordX;
	}

	public Float getCoordY() {
		return coordY;
	}

	public void setCoordY(Float coordY) {
		this.coordY = coordY;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	// precio del producto en venta por la cantidad mas el costo del delivery
	public Float getAmount() {
		return ((this.productOnSale.getPrice() * this.quantity) + this.deliveryMethod.getCost());
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
}

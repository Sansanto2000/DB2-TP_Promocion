package ar.edu.unlp.info.bd2.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ml-on-delivery-payments")
public class OnDeliveryPayment extends PaymentMethod{

	@Field(type = FieldType.Float)
	private Float promisedAmount;

	// constructor vacio pedido por hibernate
	public OnDeliveryPayment() {
		super();
	}

	public OnDeliveryPayment(String aName, Float aPromisedAmount) {
		super(aName);
		this.promisedAmount = aPromisedAmount;
	}

	public Float getPromisedAmount() {
		return promisedAmount;
	}

	public void setPromisedAmount(Float promisedAmount) {
		this.promisedAmount = promisedAmount;
	}
}

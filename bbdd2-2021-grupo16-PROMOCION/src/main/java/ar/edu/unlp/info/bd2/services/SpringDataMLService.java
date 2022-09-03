package ar.edu.unlp.info.bd2.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.bd2.model.Category;
import ar.edu.unlp.info.bd2.model.CreditCardPayment;
import ar.edu.unlp.info.bd2.model.DeliveryMethod;
import ar.edu.unlp.info.bd2.model.OnDeliveryPayment;
import ar.edu.unlp.info.bd2.model.PaymentMethod;
import ar.edu.unlp.info.bd2.model.Product;
import ar.edu.unlp.info.bd2.model.ProductOnSale;
import ar.edu.unlp.info.bd2.model.Provider;
import ar.edu.unlp.info.bd2.model.Purchase;
import ar.edu.unlp.info.bd2.model.User;
import ar.edu.unlp.info.bd2.repositories.CategoryRepository;
import ar.edu.unlp.info.bd2.repositories.CreditCardPaymentRepository;
import ar.edu.unlp.info.bd2.repositories.DeliveryMethodRepository;
import ar.edu.unlp.info.bd2.repositories.MLException;
import ar.edu.unlp.info.bd2.repositories.OnDeliveryPaymentRepository;
import ar.edu.unlp.info.bd2.repositories.ProductOnSaleRepository;
import ar.edu.unlp.info.bd2.repositories.ProductRepository;
import ar.edu.unlp.info.bd2.repositories.ProviderRepository;
import ar.edu.unlp.info.bd2.repositories.PurchaseRepository;
import ar.edu.unlp.info.bd2.repositories.UserRepository;

@Service
public class SpringDataMLService implements MLService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CreditCardPaymentRepository ccpRepository;

	@Autowired
	private DeliveryMethodRepository dmRepository;

	@Autowired
	private OnDeliveryPaymentRepository odpRepository;

	@Autowired
	private ProductOnSaleRepository posRepository;

	@Autowired
	private ProviderRepository providerRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ElasticsearchOperations client;

	@Override
	public List<Purchase> getAllPurchasesMadeByUser(String username) {
		Optional<User> opuser = this.userRepository.findUserByEmail(username);
		return this.purchaseRepository.findAllByClientId(opuser.get().getId());
	}

	@Override
	public List<User> getUsersSpendingMoreThanInPurchase(Float amount) {
		List<Purchase> list = this.purchaseRepository.findByTotalGreaterThan(amount);
		List<User> userList = new ArrayList<>();
		for (Purchase purchase : list) {
			userList.add(purchase.getClient());
		}
		return userList;
	}

	@Override
	public List<User> getUsersSpendingMoreThan(Float amount) {
		return null;
		// return this.purchaseRepository.findUsersSpendingMoreThan(amount);
	}

	@Override
	public List<Provider> getTopNProvidersInPurchases(int n) {
		return null;
		// Page<Provider> providers = this.posRepository.findTopNProvidersInPurchases(n,
		// PageRequest.of(0, n));
		// return providers.getContent();
	}

	@Override
	public List<Product> getTop3MoreExpensiveProducts() {
		/// Page<Product> products =
		/// this.posRepository.findTop3MoreExpensiveProducts(PageRequest.of(0, 3));
		return null; // products.getContent();
	}

	@Override
	public List<User> getTopNUsersMorePurchase(int n) {
		return null;
		// Page<User> users = this.userRepository.findTopNUsersMorePurchase(n,
		// PageRequest.of(0, n));
		// return users.getContent();
	}

	@Override
	public List<Purchase> getPurchasesInPeriod(Date startDate, Date endDate) {
		return this.purchaseRepository.findByDateOfPurchaseBetween(startDate, endDate);
	}

	@Override
	public List<Product> getProductForCategory(Category category) {
		return this.productRepository.findAllByCategoryId(category.getId());
	}

	@Override
	public List<Purchase> getPurchasesForProvider(Long cuit) {
		return this.purchaseRepository.findByProductOnSaleProviderCuit(cuit);
	}

	@Override
	public Product getBestSellingProduct() {
		Query query;
		/*
		 * TermsAggregationBuilder aggregation =
		 * AggregationBuilders.terms("top_products") .field("tags")
		 * .order(Terms.Bucket.count(false)); SearchSourceBuilder builder = new
		 * SearchSourceBuilder().aggregation(aggregation);
		 * 
		 * SearchRequest searchRequest = new
		 * SearchRequest().indices("blog").types("article").source(builder);
		 * SearchResponse response = client.search(searchRequest,
		 * RequestOptions.DEFAULT);
		 * 
		 * Map<String, Aggregation> results = response.getAggregations().asMap();
		 * StringTerms topTags = (StringTerms) results.get("top_products");
		 * 
		 * List<String> keys = topTags.getBuckets() .stream() .map(b ->
		 * b.getKeyAsString()) .collect(toList()); this.client.search(null, null);
		 */
		//this.client.search(query, Purchase.class);
		Page<Purchase> purPage = this.purchaseRepository.findBestSellingProduct(PageRequest.of(0, 1));
		return purPage.getContent().get(0).getProductOnSale().getProduct();
		//return null;
	}

	@Override
	public List<Product> getProductsOnePrice() {
		return null;
		// return this.productRepository.findProductsOnePrice();
	}

	@Override
	public List<Product> getProductWithMoreThan20percentDiferenceInPrice() {
		return null;
		// return
		// this.productRepository.findProductWithMoreThan20percentDiferenceInPrice();
	}

	@Override
	public Provider getProviderLessExpensiveProduct() {
		Page<ProductOnSale> pos = this.posRepository.findByActualFalseOrderByPrice(PageRequest.of(0, 1));
		return pos.getContent().get(0).getProvider();
	}

	@Override
	public List<Provider> getProvidersDoNotSellOn(Date day) {
		return null;
		// return this.providerRepository.findProvidersDoNotSellOn(day);
	}

	@Override
	public List<ProductOnSale> getSoldProductsOn(Date day) {
		List<Purchase> listPurchases = this.purchaseRepository.findByDateOfPurchase(day);
		Map<String, ProductOnSale> map = new HashMap<String, ProductOnSale>();// new ArrayList<ProductOnSale>();
		for (Purchase pur : listPurchases) {
			map.putIfAbsent(pur.getProductOnSale().getId(), pur.getProductOnSale());
		}
		List<ProductOnSale> list = new ArrayList<ProductOnSale>(map.values());
		return list;
	}

	@Override
	public List<Product> getProductsNotSold() {
		return null;
		// return this.productRepository.findProductsNotSold();
	}

	@Override
	public DeliveryMethod getMostUsedDeliveryMethod() {
		return null;
		// Page<DeliveryMethod> deliveryMethod =
		// this.purchaseRepository.findMostUsedDeliveryMethod(PageRequest.of(0, 1));
		// return deliveryMethod.getContent().get(0);
	}

	@Override
	public OnDeliveryPayment getMoreChangeOnDeliveryMethod() {
		return null;
		/*
		 * Page<OnDeliveryPayment> onDeliveryPayment = this.purchaseRepository
		 * .findMoreChangeOnDeliveryMethod(PageRequest.of(0, 1)); return
		 * onDeliveryPayment.getContent().get(0);
		 */
	}

	@Override
	public Product getHeaviestProduct() {
		Page<Product> product = this.productRepository.findFirstByOrderByWeightDesc(PageRequest.of(0, 1));
		return product.getContent().get(0);

	}

	@Override
	public Category getCategoryWithLessProducts() {
		return null;
		/*
		 * Page<Category> category =
		 * this.productRepository.findCategoryWithLessProducts(PageRequest.of(0, 1));
		 * return category.getContent().get(0);
		 */
	}

	@Override
	public Category createCategory(String name) throws MLException {
		Category category = new Category(name);
		categoryRepository.save(category);
		return category;
	}

	@Override
	@Transactional
	public Product createProduct(String name, Float weight, Category category) throws MLException {
		Optional<Product> op = this.getProductByName(name);
		if (op.isEmpty()) {
			Product p = new Product(name, weight, category);
			this.productRepository.save(p);
			return p;
		} else {
			throw new MLException("Constraint Violation");
		}
	}

	@Override
	@Transactional
	public User createUser(String email, String fullname, String password, Date dayOfBirth) throws MLException {
		Optional<User> opu = this.getUserByEmail(email);
		// usuario nuevo
		if (opu.isEmpty()) {
			User u = new User(email, fullname, password, dayOfBirth);
			this.userRepository.save(u);
			return u;
		}
		// usuario ya existe, osea ya hay uno con es mismo email
		else {
			throw new MLException("Constraint Violation");
		}
	}

	@Override
	@Transactional
	public Provider createProvider(String name, Long cuit) throws MLException {
		Optional<Provider> op = this.getProviderByCuit(cuit);
		if (op.isEmpty()) {
			Provider p = new Provider(name, cuit);
			this.providerRepository.save(p);
			return p;
		} else {
			throw new MLException("Constraint Violation");
		}
	}

	@Override
	@Transactional
	public DeliveryMethod createDeliveryMethod(String name, Float cost, Float startWeight, Float endWeight)
			throws MLException {
		DeliveryMethod dm = new DeliveryMethod(name, cost, startWeight, endWeight);
		this.dmRepository.save(dm);
		return dm;
		/*
		 * verificando que no haya mas de un delivery method con el mismo nombre
		 * Optional<DeliveryMethod> odm = this.getDeliveryMethodByName(name); if
		 * (odm.isEmpty()) { DeliveryMethod dm = new DeliveryMethod(name, cost,
		 * startWeight, endWeight); this.dmRepository.save(dm); return dm; } return
		 * odm.get();
		 */
	}

	@Override
	@Transactional
	public CreditCardPayment createCreditCardPayment(String name, String brand, Long number, Date expiry, Integer cvv,
			String owner) throws MLException {
		CreditCardPayment ccp = new CreditCardPayment(name, brand, number, expiry, cvv, owner);
		this.ccpRepository.save(ccp);
		return ccp;
	}

	@Override
	@Transactional
	public OnDeliveryPayment createOnDeliveryPayment(String name, Float promisedAmount) throws MLException {
		OnDeliveryPayment odp = new OnDeliveryPayment(name, promisedAmount);
		this.odpRepository.save(odp);
		return odp;
	}

	@Override
	@Transactional
	public ProductOnSale createProductOnSale(Product product, Provider provider, Float price, Date initialDate)
			throws MLException {
		Optional<ProductOnSale> op = this.posRepository.findByProductIdAndProviderIdAndActual(product.getId(),
				provider.getId(), true);
		if (op.isPresent()) {
			// la fecha de inicio del productOnSale actual es posterior a la fecha del nuevo
			// productOnSale
			if (op.get().getInitialDate().after(initialDate)) {
				throw new MLException(
						"Ya existe un precio para el producto con fecha de inicio de vigencia posterior a la fecha de inicio dada");
			}
		}
		ProductOnSale pos = new ProductOnSale(product, provider, price, initialDate);
		// si ya habia por lo menos un productOnSale, actualizo la fecha fin del ultimo
		int posSize = product.getProductsOnSale().size();
		if (posSize > 0) {
			// recupero el id
			String posId = product.getProductsOnSale().get(posSize - 1);
			// lo busco por id
			ProductOnSale lastPos = this.getProductOnSaleById(posId);
			lastPos.setFinalDate(new Date());
			lastPos.setActual(false);
			this.posRepository.save(lastPos);
		}
		// agrego el nuevo ProductOnSale
		product.getProductsOnSale().add(pos.getId());
		this.posRepository.save(pos);
		this.productRepository.save(product);
		return pos;
	}

	@Override
	@Transactional
	public Purchase createPurchase(ProductOnSale productOnSale, Integer quantity, User client,
			DeliveryMethod deliveryMethod, PaymentMethod paymentMethod, String address, Float coordX, Float coordY,
			Date dateOfPurchase) throws MLException {
		// peso del producto por la cantidad
		Float weigth = productOnSale.getProduct().getWeigth() * quantity;
		// lo anterior tiene que estar entre los pesos soportados por el delivery
		if (weigth <= deliveryMethod.getEndWeight() && weigth >= deliveryMethod.getStartWeight()) {
			Purchase pur = new Purchase(productOnSale, quantity, client, deliveryMethod, paymentMethod, address, coordX,
					coordY, dateOfPurchase);
			this.purchaseRepository.save(pur);
			return pur;
		} else {
			throw new MLException("método de delivery no válido");
		}
	}

	@Override
	@Transactional
	public Optional<User> getUserByEmail(String email) {
		return this.userRepository.findUserByEmail(email);
	}

	@Override
	@Transactional
	public Optional<Provider> getProviderByCuit(long cuit) {
		Optional<Provider> op = this.providerRepository.findProviderByCuit(cuit);
		return op;
	}

	@Override
	@Transactional
	public Optional<Category> getCategoryByName(String name) {
		Optional<Category> c = this.categoryRepository.findCategoryByName(name);
		return c;
	}

	@Override
	@Transactional
	public Optional<Product> getProductByName(String name) {
		Optional<Product> opp = this.productRepository.findProductByName(name);
		if (opp.isPresent()) {
			if (name.equals(opp.get().getName())) {
				return opp;
			}
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public ProductOnSale getProductOnSaleById(String id) {
		Optional<ProductOnSale> opos = this.posRepository.findProductOnSalesById(id);
		return opos.get();
	}

	@Override
	@Transactional
	public Optional<DeliveryMethod> getDeliveryMethodByName(String name) {
		return this.dmRepository.findByName(name);
	}

	@Override
	@Transactional
	public Optional<CreditCardPayment> getCreditCardPaymentByName(String name) {
		return this.ccpRepository.findCreditCardPaymentByName(name);
	}

	@Override
	@Transactional
	public Optional<OnDeliveryPayment> getOnDeliveryPaymentByName(String name) {
		return this.odpRepository.findOnDeliveryPaymentByName(name);
	}

	@Override
	@Transactional
	public Optional<Purchase> getPurchaseById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Category category) {
		this.categoryRepository.delete(category);
	}

	@Override
	public void deleteProduct(Product product) {
		this.productRepository.delete(product);
	}

	@Override
	public void deleteUser(User user) {
		this.userRepository.delete(user);
	}

	@Override
	public void deleteProvider(Provider provider) {
		this.providerRepository.delete(provider);
	}

	@Override
	public void deleteDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.dmRepository.delete(deliveryMethod);
	}

	@Override
	public void deleteCreditCardPayment(CreditCardPayment creditCardPayment) {
		this.ccpRepository.delete(creditCardPayment);
	}

	@Override
	public void deleteOnDeliveryPayment(OnDeliveryPayment onDeliveryPayment) {
		this.odpRepository.delete(onDeliveryPayment);
	}

	@Override
	public void deleteProductOnSale(ProductOnSale productOnSale) {
		this.posRepository.delete(productOnSale);
	}

	@Override
	public void deletePurchase(Purchase purchase) {
		this.purchaseRepository.delete(purchase);
	}

	@Override
	public void deleteData() {
		this.categoryRepository.deleteAll();
		this.ccpRepository.deleteAll();
		this.dmRepository.deleteAll();
		this.odpRepository.deleteAll();
		this.posRepository.deleteAll();
		this.productRepository.deleteAll();
		this.providerRepository.deleteAll();
		this.purchaseRepository.deleteAll();
		this.userRepository.deleteAll();

		/*
		 * DeleteIndexRequest request = new DeleteIndexRequest("ml-delivery-method");
		 * DeleteIndexRequest request1 = new
		 * DeleteIndexRequest("ml-credit-card-payment"); DeleteIndexRequest request2 =
		 * new DeleteIndexRequest("ml-users"); DeleteIndexRequest request3 = new
		 * DeleteIndexRequest("ml-providers"); DeleteIndexRequest request4 = new
		 * DeleteIndexRequest("ml-purchanses"); DeleteIndexRequest request5 = new
		 * DeleteIndexRequest("ml-on-delivery-payments"); DeleteIndexRequest request6 =
		 * new DeleteIndexRequest("ml-categories"); DeleteIndexRequest request7 = new
		 * DeleteIndexRequest("ml-products"); DeleteIndexRequest request8 = new
		 * DeleteIndexRequest("ml-delivery-method"); DeleteIndexRequest request9 = new
		 * DeleteIndexRequest("ml-delivery-method"); RestHighLevelClient client = new
		 * RestHighLevelClient( RestClient.builder(new HttpHost("localhost", 9200,
		 * "http"))); client.indices().delete(request, RequestOptions.DEFAULT);
		 * client.indices().delete(request1, RequestOptions.DEFAULT);
		 * client.indices().delete(request2, RequestOptions.DEFAULT);
		 * client.indices().delete(request3, RequestOptions.DEFAULT);
		 * client.indices().delete(request4, RequestOptions.DEFAULT);
		 * client.indices().delete(request5, RequestOptions.DEFAULT);
		 * client.indices().delete(request6, RequestOptions.DEFAULT);
		 * client.indices().delete(request7, RequestOptions.DEFAULT);
		 * client.indices().delete(request8, RequestOptions.DEFAULT);
		 * client.indices().delete(request9, RequestOptions.DEFAULT); client.close();
		 */
	}

	public Boolean existsData() {
		if (this.categoryRepository.count() > 0) {
			return true;
		} else {
			return false;
		}
	}

}

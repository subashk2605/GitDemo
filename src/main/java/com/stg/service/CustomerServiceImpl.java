package com.stg.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stg.entity.Address;
import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Payment;
import com.stg.entity.QuickFoods;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.repository.AddressRepository;
import com.stg.repository.CustomerRepository;
import com.stg.repository.FoodRepository;
import com.stg.repository.OrderRepository;
import com.stg.repository.QuickFoodsRepository;
import com.stg.repository.RestaurentRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private RestaurentRepository restaurentRepository;
	
	@Autowired
	private QuickFoodsRepository quickFoodsRepository;
	
	

	@Override
	public String createCustomer(Customer customer) throws CustomException {
		if (customerRepository.findAll() == customer) {
			throw new CustomException("customer already exist");
		} else {
			QuickFoods quickFoods = quickFoodsRepository.getById(1);
			customer.setQuickfoodRef(quickFoods);
			customerRepository.save(customer);
			return "Created Sucessfully";
		}
	}

	@Override
	public String addCustomer(int customerId, String customerName, String customerPhNo, String email,String password ,String doorNo,
			String street, String city, String area, String state, int zipcode) throws CustomException {

		String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Customer customer = new Customer();
		if (customerId != 0) {
			customer.setCustomerId(customerId);
			customer.setPassword(password);
			if (customerName!=null) {
				customer.setCustomerName(customerName);

				if (customerPhNo.length() == 10) {
					customer.setPhoneNo(customerPhNo);
					if (email.matches(emailRegex)) {
						customer.setEMail(email);
						
					} else {
						throw new CustomException("Invalid email");
					}
				} else {
					throw new CustomException("Please Enter the valid Phone No");
				}
			} else {
				throw new CustomException("Please Enter the Name");
			}
		} else {
			throw new CustomException("Please Enter the Id");
		}
		customerRepository.save(customer);
		List<Address> addresses = new ArrayList<>();

		for (Address address : addresses) {
			address.setCustomerRef(customer);

			address.setDoorNo(doorNo);

			address.setStreet(street);

			address.setCity(city);

			address.setArea(area);

			address.setState(state);
			address.setZipCode(zipcode);
			addressRepository.save(address);

		}

		customer.setAddresses(addresses);

		return "Created Sucessfully";

	}

	@Override
	public String createAddress(int customerId, int addressId, String doorNo, String street, String city, String area,
			String state, int zipcode) throws CustomException {
		Customer customer = customerRepository.findById(customerId).get();
		Address address = new Address();

		address.setCustomerRef(customer);

		address.setDoorNo(doorNo);

		address.setStreet(street);

		address.setCity(city);

		address.setArea(area);

		address.setState(state);
		address.setZipCode(zipcode);

		addressRepository.save(address);

		// addressRepository.save(address1);

		if (address != null) {
			return "Address  added sucessfully";

		} else {
			throw new CustomException("please give a valid data");
		}

	}

	@Override
	public List<Food> readfoodMenu() throws CustomException {

		if (foodRepository.findAll() == null) {
			throw new CustomException("No record found");
		} else {
			return foodRepository.findAll();
		}
	}

//	@Override
//	public Orders placeOrders(String foodname, int quantity, int customerId, String payment) throws CustomException {
//
//		float sum = 0;
//		Orders orders = new Orders();
//		
//		List<Food> foods1 = new ArrayList<>();
//		Customer customer = customerRepository.findById(customerId).get();
//
//		List<Food> foods = foodRepository.findAll();
//		for (Food i : foods) {
//			if (i.getFoodName().equalsIgnoreCase(foodname)) {
//				foods1.add(i);
//			}
//		}
//		
//		Food food = foodRepository.findByFoodName(foodname);
//		if (food != null) {
//			if (food.getFoodName().equalsIgnoreCase(foodname)) {
//
//				orders.setQuantity(quantity);
//				food.setQuantity(quantity - orders.getQuantity());
//				orders.setOrderId(customerId);
//				orders.setCustomerRef(customerRepository.getReferenceById(customerId));
//				sum += food.getFoodPrice() * quantity;
//				orders.setPrice(sum);
//				orders.setFoods(foods1);
//
//				if ("yes".equalsIgnoreCase("yes")) {
//					orders.setPaymentStatus("Payment Sucessfull");
//				} else if ("no".equalsIgnoreCase("no")) {
//					orders.setPaymentStatus("pending payment");
//				}
//				orders.setOrderStatus("order placed sucessfully");
//
//				orderRepository.save(orders);
//			}
//			return orders;
//
//		} else {
//			throw new CustomException("Sorry ! Not available");
//		}
//
//	}

	@Override
	public String cancelOrder(int customerId, int orderId) throws CustomException {

		if (customerRepository.findById(customerId) != null) {
			orderRepository.deleteById(orderId);
			return "Your order cancelled sucessfully";
		} else {
			throw new CustomException("No orders yet");
		}
	}

	@Override
	public List<Orders> readMyOrders(int customerId) throws CustomException {
		if (orderRepository.findAll() != null) {
			return orderRepository.readMyOrders(customerId);
		} else {
			throw new CustomException("You don't have any orders");
		}

	}

	@Override
	public List<Food> readFoodByCatogory(String catogory) throws CustomException {
		if (foodRepository.findByFoodCatogory(catogory) != null) {
			return foodRepository.findByFoodCatogory(catogory);
		} else {
			throw new CustomException("no such a catogory");
		}

	}

	@Override
	public List<Food> readFoodByName(String name) throws CustomException {

		if (foodRepository.findByFoodName(name) != null) {
			return foodRepository.findByFoodName1(name);
		} else {
			throw new CustomException("no such a food");
		}

	}

	@Override
	public List<Food> readByVegOrNonveg(String name) throws CustomException {
		if (foodRepository.findByVegOrNonveg(name) != null) {
			return foodRepository.findByVegOrNonveg(name);
		} else {
			throw new CustomException("no such a food");
		}
	}
	
	@Override
	public List<Restaurent> readall() throws CustomException{
	
		if (restaurentRepository.findAll() == null) {
			throw new CustomException("No record found");
		} else {
			return restaurentRepository.findAll();
		}
	}

	@Override
	public List<Food> readfoodByRestaurent(int restaurentId) throws CustomException {
		Restaurent restaurent = restaurentRepository.findById(restaurentId).get();
		List<Food> foods = restaurent.getFoods();
		return foods;
	}

	@Override
	public Orders placeOrders(int foodId, int quantity, int customerId, String payment) throws CustomException {
		
		
		float totalPrice =0;
		List<Food> foods = new ArrayList<>();
		List<Food>  food = foodRepository.findAll();
		Customer customer = customerRepository.getById(customerId);
		System.out.println(customer.getCustomerName());
		Orders orders = new Orders();
		orders.setQuantity(quantity);
		QuickFoods quickFoods = quickFoodsRepository.getById(1);
		orders.setQuickFoodsRef(quickFoods);
		for (Food food2 : food) {
			if(food2.getFoodId()==foodId) {
				foods.add(food2);
				totalPrice += food2.getFoodPrice();
			}
		}
		totalPrice *= quantity;
		orders.setCustomerRef(customer);
		orders.setFoods(foods);
		orders.setPrice(totalPrice);
		if(payment.equalsIgnoreCase("yes")) {
			orders.setPaymentStatus("Payment Successfull");
		} else if(payment.equalsIgnoreCase("No")){
			orders.setPaymentStatus("Pending Payment");
		}
		orders.setOrderStatus("order placed sucessfully");
		
		orderRepository.save(orders);
		
		return orderRepository.save(orders);
	
		
		
		
	}

}

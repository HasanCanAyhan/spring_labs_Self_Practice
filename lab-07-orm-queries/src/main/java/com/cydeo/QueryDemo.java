package com.cydeo;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public QueryDemo(AddressRepository addressRepository, BalanceRepository balanceRepository, CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------------------ADDRESS------------------------------------------------");

        //System.out.println("findAllByCustomerId : " + addressRepository.findAllByCustomerId(498L));
        //System.out.println("findAllByStreet : " + addressRepository.findAllByStreet("Everett"));
        //System.out.println("findTop3ByCustomer_Email : " + addressRepository.findTop3ByCustomer_Email("theinigdt@sohu.com"));
        //System.out.println("findAllByCustomer_UserName : " + addressRepository.findAllByCustomer_UserName("asturton0"));
        //System.out.println("findAllByStreetStartingWith : " + addressRepository.findAllByStreetStartingWith("A"));
        //System.out.println("fetchAllAddressByCustomerId : " + addressRepository.fetchAllAddressByCustomerId(498L));

        System.out.println("---------------------BALANCE------------------------------------------------");

        //System.out.println("existsBalanceByCustomerId : " + balanceRepository.existsBalanceByCustomerId(498L));
        //System.out.println("fetchMax5Balance : " + balanceRepository.fetchMax5Balance());

    }
}

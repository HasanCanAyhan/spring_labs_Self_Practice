package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CartDto;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.PaymentDTO;
import com.cydeo.lab08rest.entity.Cart;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.entity.Payment;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.CartService;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.OrderService;
import com.cydeo.lab08rest.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;


    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CustomerService customerService, PaymentService paymentService, CartService cartService) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
    }


    @Override
    public List<OrderDTO> getOrderList() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> mapperUtil.convert(order,new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod) {
        List<Order> orderList = orderRepository.findAllByPayment_PaymentMethod(paymentMethod);
        return orderList.stream().map(order -> mapperUtil.convert(order,new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByEmail(String email) throws Exception {
        boolean hasEmail = orderRepository.existsByCustomer_email(email);

        if (hasEmail){
            List<Order> orderList = orderRepository.findAllByCustomer_Email(email);
            return orderList.stream().map(order -> mapperUtil.convert(order,new OrderDTO())).collect(Collectors.toList());
        }

        throw new Exception("Email could not found : " + email);

    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {

        Order order = mapperUtil.convert(orderDTO, new Order());

        orderRepository.save(order);

        return orderDTO;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {

        Order order = orderRepository.findById(orderDTO.getId()).orElseThrow();

        order.setPaidPrice(orderDTO.getPaidPrice());
        order.setTotalPrice(orderDTO.getTotalPrice());

        //
        CustomerDTO customerDTO = customerService.findById(orderDTO.getCustomerId());

        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        order.setCustomer(customer);

        //
        PaymentDTO paymentDTO = paymentService.findById(orderDTO.getPaymentId());

        order.setPayment(mapperUtil.convert(paymentDTO,new Payment()));

        //

        CartDto cartDto = cartService.findById(orderDTO.getCartId());
        Cart cart = mapperUtil.convert(cartDto, new Cart());
        order.setCart(cart);

        orderRepository.save(order);


        return mapperUtil.convert(order,new OrderDTO());
    }
}

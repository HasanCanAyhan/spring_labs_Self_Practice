package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;


    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> getDiscountList() {
        List<Discount> discounts = discountRepository.findAll();
        return discounts.stream().map(discount -> mapperUtil.convert(discount,new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public void save(DiscountDTO discountDTO) {
        discountRepository.save(mapperUtil.convert(discountDTO,new Discount()));
    }

    @Override
    public void update(DiscountDTO discountDTO) {

        Discount discount = discountRepository.findById(discountDTO.getId()).orElseThrow();
        discount.setDiscount(discountDTO.getDiscount());
        discount.setName(discount.getName());
        discount.setDiscountType(discount.getDiscountType());

        discountRepository.save(discount);
    }

    @Override
    public DiscountDTO retrieveDiscountByName(String name) {

        Discount discount = discountRepository.findFirstByName(name);

        return mapperUtil.convert(discount, new DiscountDTO());
    }


}

package com.example.shopListService.shop.service;

import com.example.shopListService.shop.dto.ShopDto;
import com.example.shopListService.shop.repository.ShopListRateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopListServiceImpl implements ShopListService{
    @Autowired
    ShopListRateMapper shopListRateMapper;

    @Override
    public List<ShopDto> getShop() {
        return shopListRateMapper.getShop();
    }

}

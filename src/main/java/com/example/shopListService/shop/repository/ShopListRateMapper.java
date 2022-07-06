package com.example.shopListService.shop.repository;

import com.example.shopListService.shop.dto.ShopDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopListRateMapper {
    List<ShopDto> getShop();

}
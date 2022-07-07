package com.example.shopListService.shop.controller;

import com.example.shopListService.shop.dto.ShopDto;
import com.example.shopListService.shop.dto.ShopRateDto;
import com.example.shopListService.shop.service.RestTemplateService;
import com.example.shopListService.shop.service.ShopListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("shoplist")
public class ShopListController {
    @Autowired
    ShopListServiceImpl shopListService;

    @Autowired
    RestTemplateService restTemplateService;

    @GetMapping("/rate")
    public List<ShopDto> getShopRate(){
        System.out.println("adlkfjlakjd");
        //shopRateRes에 review 테이블의 shopId,rate 들어옴
        ShopRateDto[] shopRateRes =restTemplateService.getReviewResponse();
        List<ShopDto> shopList = shopListService.getShop();
        List<ShopDto> newShopList = new ArrayList<>();
        //shop 테이블의 id와 일치하는 rate 조인하기
        for(ShopDto dto: shopList){
            for(ShopRateDto resDto :shopRateRes){
                if(resDto.getShopId() == dto.getId()) {
                    dto.setRate(resDto.getRate());
                    dto.setName(dto.getName());
                    dto.setLocation(dto.getLocation());
                    newShopList.add(dto);
                }
            }
        }
        return newShopList;
    }


}
package com.example.shopListService.shop.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ShopRateDto {
    private Integer shopId;
    private double rate;
}

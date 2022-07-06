package com.example.shopListService.shop.service;

import com.example.shopListService.shop.dto.ShopRateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {
    public ShopRateDto[] getReviewResponse() {
        System.out.println("rest에 들어옴");
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8000")
                .path("/review/shoprate")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        // status 코드와 , 바디를 같이 담아서 보낸다
        // **반환값을 DTO를 설정해주면 좋지만, LIST객체나 아직 반환값을 정확하게 모름**
        ResponseEntity<ShopRateDto[]> result = restTemplate.getForEntity(uri, ShopRateDto[].class);
        ShopRateDto[] array = result.getBody();

//        for(ShopRateDto dto : array){
//            System.out.println(dto.getShopId());
//            System.out.println(dto.getRate());
//        }

        return array;
    }

}
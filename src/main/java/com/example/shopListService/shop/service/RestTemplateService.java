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
        //다른 포트 번호로 다른 DB에 접근해서 필요한 데이터 가져오기
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8000")
                .path("/review/shoprate")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        // getEntity() 결과값 객체 배열에 담기, getBody()에 필요한 데이터 들어 있음
        ResponseEntity<ShopRateDto[]> result = restTemplate.getForEntity(uri, ShopRateDto[].class);
        ShopRateDto[] array = result.getBody();
//        for(ShopRateDto dto : array){
//            System.out.println(dto.getShopId());
//            System.out.println(dto.getRate());
//        }
        return array;
    }

}
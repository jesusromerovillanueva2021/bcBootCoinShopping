package com.bootCoinShopping.redis;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import com.bootCoinShopping.redis.entity.BootCoinShopping;
import com.bootCoinShopping.redis.respository.BootCoinShoppingDao;

import java.util.List;

@SpringBootApplication
public class SpringDataRedisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}

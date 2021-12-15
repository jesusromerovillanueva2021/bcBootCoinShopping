package com.bootCoinShopping.redis.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bootCoinShopping.redis.entity.BootCoinShopping;

import java.util.List;

@Repository
public class BootCoinShoppingDao {

    public static final String HASH_KEY = "bootcoinshoppingope";

    @Autowired
    private RedisTemplate template;

    public BootCoinShopping save(BootCoinShopping bootCoinShopping){
        template.opsForHash().put(HASH_KEY, bootCoinShopping.getId(), bootCoinShopping);
        return  bootCoinShopping;
    }

    public List<BootCoinShopping> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public BootCoinShopping findById(int id){
        return (BootCoinShopping) template.opsForHash().get(HASH_KEY,id);
    }


    public String delete(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "BootCoin Shopping removed !!";
    }
}

package com.bootCoinShopping.redis.yanquiPaymentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootCoinShopping.redis.entity.BootCoinShopping;
import com.bootCoinShopping.redis.kafkaProducer.Producer;
import com.bootCoinShopping.redis.respository.BootCoinShoppingDao;

@RestController
@RequestMapping("/bootcoinshoppings")
@EnableCaching
public class BootCoinShoppingController {
	@Autowired
    private BootCoinShoppingDao dao;
	
	private final Producer producer;
	
	@Autowired
	public BootCoinShoppingController(Producer producer) {
		this.producer=producer;
	}

    @PostMapping
    public BootCoinShopping save(@RequestBody BootCoinShopping bootCoinShopping) {
    	this.producer.sendMessage(String.valueOf(bootCoinShopping.getIdBootCoinClient()));
    	this.producer.sendMessage(String.valueOf(bootCoinShopping.getBootCoinAmount()));
    	this.producer.sendMessage(String.valueOf(bootCoinShopping.getQuantity()));	
        return dao.save(bootCoinShopping);
    }

    @GetMapping
    public List<BootCoinShopping> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "bootcoinshoppingope")
    public BootCoinShopping getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "bootcoinshoppingope")
    public String remove(@PathVariable int id) {
        return dao.delete(id);
    }
}

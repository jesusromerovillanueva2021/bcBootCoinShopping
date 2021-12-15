package com.bootCoinShopping.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("bootcoinshoppingope")
public class BootCoinShopping implements Serializable {
	@Id
	private int id;
	private Date date;
	private int quantity;
	private ModePay modePay;
	private double bootCoinAmount;
	private int idBootCoinUser;
	private int idBootCoinClient;
	
	public enum ModePay{
		Yanqui, Transference
	}
}

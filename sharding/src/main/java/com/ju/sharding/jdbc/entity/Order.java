package com.ju.sharding.jdbc.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private BigDecimal price;

    private long userId;

    private String status;

}

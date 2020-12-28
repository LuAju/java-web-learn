package com.ju.sharding.jdbc.dao;

import com.ju.sharding.jdbc.ShardingJdbcApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcApplication.class})
public class OrderTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void test(){
        orderDao.insertOrder(new BigDecimal("1"),1L,"true");
        orderDao.insertOrder(new BigDecimal("2"),1L,"true");
    }

    @Test
    public void test2(){
        orderDao.insertOrder(new BigDecimal("11"),3L,"true");
        orderDao.insertOrder(new BigDecimal("12"),4L,"true");
    }
}

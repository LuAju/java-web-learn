package com.ju.sharding.jdbc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ju.sharding.jdbc.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Insert("insert into t_order(price,user_id,status)values(#{price},#{userId},#{status})")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId")Long userId, @Param("status")String status);

}

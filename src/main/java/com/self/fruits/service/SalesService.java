package com.self.fruits.service;

import com.self.fruits.modal.Activity;
import com.self.fruits.modal.Fruits;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: fruits
 * @description:
 * @author: twl
 * @create: 2023-02-15 09:20
 **/
public class SalesService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Fruits> fruitList = new ArrayList<>();

    public  List<Fruits> getFruits() {
        return fruitList;
    }

    public Boolean addFruits(Fruits fruits) {
        return fruitList.add(fruits);
    }

    public Boolean removeFruits(String code) {
        return fruitList.removeIf(d -> code.equals(d.getCode()));
    }

    public Boolean editFruits(Fruits fruits) {
        for (Fruits d : fruitList) {
            if (d.getCode().equals(fruits.getCode())) {
                d.setDiscount(fruits.getDiscount());
                d.setPrice(fruits.getPrice());
                return true;
            }
        }
        logger.warn("水果不存在");
        return false;
    }

    public Double count(Map<Double, String> fruitsMap, Activity activity) {
        BigDecimal allPrice = new BigDecimal(0);
        if (!fruitList.isEmpty()) {
            Map<String, Fruits> collect = fruitList.stream().collect(Collectors.toMap(Fruits::getCode, d -> d, (u1, u2) -> u1));
            for (Map.Entry<Double, String> map : fruitsMap.entrySet()) {
                Double key = map.getKey();
                Fruits value = collect.get(map.getValue());
                if (value != null) {
                    BigDecimal weight = BigDecimal.valueOf(key);
                    BigDecimal price = BigDecimal.valueOf(value.getPrice());
                    BigDecimal discount = BigDecimal.valueOf(value.getDiscount());
                    BigDecimal count1 = weight.multiply(price).multiply(discount);
                    allPrice = allPrice.add(count1);
                }
            }
            if (activity.getSub() != null && activity.getSub()) {
                int v = (int) (allPrice.doubleValue() / activity.getSubHighest());
                BigDecimal count2 = BigDecimal.valueOf(activity.getSubNum()).multiply(BigDecimal.valueOf(v));
                allPrice = allPrice.subtract(count2);
            }
        }
        return allPrice.doubleValue();

    }


}

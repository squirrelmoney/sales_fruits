package com.self.test;

import com.alibaba.fastjson.JSON;
import com.self.fruits.modal.Activity;
import com.self.fruits.modal.Fruits;
import com.self.fruits.service.SalesService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: fruits
 * @description:
 * @author: twl
 * @create: 2023-02-15 09:57
 **/
public class testFruits {

    private final SalesService salesService;

    public testFruits(SalesService salesService) {
        this.salesService = salesService;
    }

    public void getAllFruits() {
        System.out.println((JSON.toJSON(salesService.getFruits())));
    }

    public void init() {
        salesService.addFruits(new Fruits("apple", "ƻ��", 8d, 1d));
        salesService.addFruits(new Fruits("strawberry", "��ݮ", 13d, 1d));
    }

    public void codition1(double appleWeight, double strewWeight) {
        Map<Double, String> map = new HashMap<>(16);
        map.put(appleWeight, "apple");
        map.put(strewWeight, "strawberry");
        getAllFruits();
        Double v = salesService.count(map, new Activity(false, 0d, 0d));
        System.out.printf("���1��ƻ����{���ۣ�8/��{%s}��" +
                "��ݮ��{���ۣ�13/��{%s}};�ܼۣ�{%s}%n", appleWeight, strewWeight, v);
    }

    public void codition2(double appleWeight, double strewWeight, double manfoWeight) {
        salesService.addFruits(new Fruits("mango", "â��", 20d, 1d));
        Map<Double, String> map = new HashMap<>(16);
        map.put(appleWeight, "apple");
        map.put(strewWeight, "strawberry");
        map.put(manfoWeight, "mango");
        getAllFruits();
        Double v = salesService.count(map, new Activity(false, 0d, 0d));
        System.out.printf("���2��ƻ����{���ۣ�8/��{%s}��" +
                        "��ݮ��{���ۣ�13/��{%s}};" +
                        "â����{���ۣ�20/��{%s}};�ܼۣ�{%s}%n"
                , appleWeight, strewWeight, manfoWeight, v);

    }

    public void codition3(double appleWeight, double strewWeight, double manfoWeight) {
        salesService.editFruits(new Fruits("strawberry", "��ݮ", 13d, 0.8d));
        Map<Double, String> map = new HashMap<>(16);
        map.put(appleWeight, "apple");
        map.put(strewWeight, "strawberry");
        map.put(manfoWeight, "mango");
        getAllFruits();
        Double v = salesService.count(map, new Activity(false, 0d, 0d));
        System.out.printf("���3��ƻ����{���ۣ�8/��{%s};" +
                        "��ݮ��{���ۣ�13/��{%s}};" +
                        "â����{���ۣ�20/��{%s}};�ܼۣ�{%s}%n"
                , appleWeight, strewWeight, manfoWeight, v);
    }

    public void codition4(double appleWeight, double strewWeight, double manfoWeight) {
        salesService.editFruits(new Fruits("strawberry", "��ݮ", 13d, 0.8d));
        Map<Double, String> map = new HashMap<>(16);
        map.put(appleWeight, "apple");
        map.put(strewWeight, "strawberry");
        map.put(manfoWeight, "mango");
        getAllFruits();
        Double v = salesService.count(map, new Activity(true, 100d, 10d));
        System.out.printf("���4��ƻ����{���ۣ�8/��{%s};" +
                        "��ݮ��{���ۣ�13/��{%s};" +
                        "â����{���ۣ�20/��{%s}};�ܼۣ�{%s}%n"
                , appleWeight, strewWeight, manfoWeight, v);
    }

    public static void main(String[] args) {
        testFruits testFruits = new testFruits(new SalesService());
        testFruits.init();
        double appleWeight = 13.5d, strewWeight = 14.6d, mangoWeight = 3.5d;
        //���1
        System.out.println("--------------------���1-------------------------");
        testFruits.codition1(appleWeight, strewWeight);
        //���2
        System.out.println("--------------------���2-------------------------");
        testFruits.codition2(appleWeight, strewWeight, mangoWeight);
        
        //���3��
        System.out.println("--------------------���3-------------------------");
        testFruits.codition3(appleWeight, strewWeight, mangoWeight);
        //���4
        System.out.println("--------------------���4-------------------------");
        testFruits.codition4(appleWeight, strewWeight, mangoWeight);
    }
}

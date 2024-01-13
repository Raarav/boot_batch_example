package com.batch.example.boot_batch_example.config;

import org.springframework.batch.item.ItemProcessor;

import com.batch.example.boot_batch_example.model.Person;

public class CustomItemProcessor implements ItemProcessor<Person, Person>{

    @Override
    public Person process(Person item) throws Exception {
        // transform ka logic yaha likha jayega
        // calculate krenge discounted price ko
        // origincal price
        // discount
        // try{
        // System.out.println(item.getDescription());
        // int discountPer = Integer.parseInt(item.getDiscount().trim());
        // double originalPrice = Double.parseDouble(item.getPrice().trim());
        // double discount = (discountPer/100) * originalPrice;
        // double finalPrice = originalPrice - discount;
        // item.setDiscountedPrice(String.valueOf(finalPrice));
        // } catch (
        //     NumberFormatException ex
        // ){
        //     ex.printStackTrace();
        // }
        return item;
    }
}

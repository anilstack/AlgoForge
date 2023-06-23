package com.anilstack.ds.stacks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FlattenNestedListIterator {

    public static void main(String[] args) {
         List<Object> list = new ArrayList<>();
         list.add(Arrays.asList(1,1));
         list.add(2);
         list.add(Arrays.asList(1,1));
         System.out.println("printing input list"+ list);
    }
}

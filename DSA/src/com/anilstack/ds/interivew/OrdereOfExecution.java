package com.anilstack.ds.interivew;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class OrdereOfExecution {

        static {
            System.out.println("Static block");
        }
        {
            System.out.println("Anonymous block");
        }
        public OrdereOfExecution(){
            System.out.println("Constructor");
        }

        public static void main(String[] args) {
            OrdereOfExecution a=new OrdereOfExecution();
            OrdereOfExecution a12=new OrdereOfExecution();
        }




}

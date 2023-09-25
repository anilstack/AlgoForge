package com.anilstack.ds.interivew;

import com.anilstack.ds.interivew.util.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class StreamingApi {


    public static void main(String[] args) {

        Employee record1 = new Employee(1, "John", "Male", 30);
        Employee record2 = new Employee(2, "Jane", "Female", 25);
        Employee record3 = new Employee(1, "Joy", "Male", 35);
        Employee record4 = new Employee(2, "Jull", "Female", 45);

        ArrayList employeList = new ArrayList(Arrays.asList(record1,record2,record3,record4));

       Map<String,Double> averageAgeByGender = (Map<String, Double>) employeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingInt(Employee::getAge)
                ));

        averageAgeByGender.forEach((gender, averageAge) -> {
            System.out.println("Average Age for " + gender + " Employees: " + averageAge);
        });



    }


}

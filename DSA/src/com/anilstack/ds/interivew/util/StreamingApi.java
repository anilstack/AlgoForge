package com.anilstack.ds.interivew.util;

import com.anilstack.ds.interivew.util.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class StreamingApi {


    public static void main(String[] args) {

        Employee record1 = new Employee(1, "John", "Male", 35,"IT");
        Employee record2 = new Employee(2, "Jane", "Female", 25,"HR");
        Employee record3 = new Employee(1, "Joy", "Male", 35,"IT");
        Employee record4 = new Employee(2, "Jull", "Female", 45,"HR");
        Employee record5 = new Employee(2, "Jull", "Female", 45,"CEO");

      //  ArrayList employeList = new ArrayList(Arrays.asList(record1,record2,record3,record4,record5));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(record1);
        employeeList.add(record2);
        employeeList.add(record3);
        employeeList.add(record4);
        employeeList.add(record5);

       Map<String,Double> averageAgeByGender = (Map<String, Double>) employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingInt(Employee::getAge)
                ));

        averageAgeByGender.forEach((gender, averageAge) -> {
            System.out.println("Average Age for " + gender + " Employees: " + averageAge);
        });

        // if two persons name is same then do count by name if two persons name is not equal then by age.

        Map<String, Long> namesCount = (Map<String, Long>) employeeList.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));

        Map<Integer, Long> ageCount =  (Map<Integer, Long>)  employeeList.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));


//        Map<Object,Long> result = employeeList.stream().
//                collect(Collectors.groupingBy(employee->{
//                    if (employeeList.stream().filter(e->e.getName().equals(employee.getName())).count() > 1) {
//                        return employee.getName();
//                    }else {
//                        return employee.getAge();
//                    }
//                },
//                        Collectors.counting()
//                        ));
//
//
//        result.forEach((key,count) -> System.out.println(key+ " : "+ count));

// if two persons name is same then do count by name if two persons name is not equal then by age.
        Map<Object, Long> result = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> {
                            long nameCount = employeeList.stream()
                                    .filter(e -> e.getName().equals(employee.getName()))
                                    .count();
                            return nameCount > 1 ? employee.getName() : employee.getAge();
                        },
                        Collectors.counting()));
            result.forEach((key,count) -> System.out.println(key +" : "+ count));



        // i want to return employees based on department and gender of each department.

        Map<String, Map<String, Long>> countOfEmployeesByDepartmentGender = employeeList.stream().
                    collect(Collectors.groupingBy(Employee::getDepartment,
                    Collectors.groupingBy(Employee::getGender,Collectors.counting())
                ));

        countOfEmployeesByDepartmentGender.forEach((department, genderCountMap) -> {
            System.out.println("Department: " + department);
            genderCountMap.forEach((gender, count) -> {
                System.out.println("Gender: " + gender + ", Count: " + count);
            });
            System.out.println("--------------------");
        });


        Map<String,Map<String,List<String>>> groupEmployeesByDepartmentAndGender = employeeList.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList()))
        ));

        groupEmployeesByDepartmentAndGender.forEach((department,genderNamesMap) -> {
            System.out.println("groupEmployeesByDepartmentAndGender  "+department);
            genderNamesMap.forEach((gender,names) -> {
                System.out.println("gender "+ gender + ", names "+names);
            });
            System.out.println("____________________________");
        });


        //print duplicate employee name any one from duplicates.
        Optional<Employee> optionalEmployee = employeeList.stream().
                 collect(Collectors.toMap(Employee::getName, Function.identity(),(existing, replacement)->existing))
                .values()
                .stream()
                .filter(employee -> employeeList.stream().filter(e -> e.getName().equals(employee.getName())).count()>1)
                .findAny();

       if (optionalEmployee.isPresent()) {
           System.out.println(optionalEmployee.get());
       } else {
           System.out.println("didnt find employee");
       }

     //  Map<Character,Integer> charCountMap = new HashMap<>();
        String input = "google";
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedHashMap::new,
                        (map, c) -> map.put(c, map.getOrDefault(c, 0L) + 1),
                        (m1, m2) -> {
                        });

        // Find the first character with a count of 1
        char firstNonRepeatchar = charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse('\0'); // R
        System.out.println("first Non Repeat Char :: "+firstNonRepeatchar);

//      Map<String,Employee> duplicateEmployeeSimpleApproach = employeeList.stream().
//               collect(Collectors.groupingBy(Employee::getName,Collectors.collectingAndThen(Collectors.toList(),list -> list.get(0))));
//
//       duplicateEmployeeSimpleApproach.values().forEach(student -> System.out.println("student"+student));

    }




}

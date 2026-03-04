package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Yağmur", "Lastname1"));
        employees.add(new Employee(2, "Dogancan", "Lastname2"));
        employees.add(new Employee(3, "Yılmaz", "Lastname3"));
        employees.add(new Employee(4, "Yaren", "Lastname4"));
        employees.add(new Employee(5, "Yaren", "Lastname5"));
        employees.add(new Employee(2, "Dogancan", "Lastname2"));
        employees.add(new Employee(3, "Yılmaz", "Lastname3"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Tekrar eden employeeler:");
        for (Employee e : duplicates) {
            System.out.println(e.getId() + " - " + e.getFirstname() + " " + e.getLastname());
        }
    }

    // Tekrar eden employee'leri (id bazlı) bulup, her id için sadece bir tane olacak şekilde liste döner
    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            Integer current = counts.get(id);
            if (current == null) {
                counts.put(id, 1);
            } else {
                counts.put(id, current + 1);
            }
        }

        List<Employee> duplicates = new LinkedList<>();
        Set<Integer> addedIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            Integer count = counts.get(id);
            if (count != null && count > 1 && !addedIds.contains(id)) {
                duplicates.add(employee);
                addedIds.add(id);
            }
        }

        return duplicates;
    }

    // LinkedList içindeki her id'den sadece bir tane olacak şekilde Map'e ekler
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            if (!uniqueMap.containsKey(id)) {
                uniqueMap.put(id, employee);
            }
        }
        return uniqueMap;
    }

    // Bir id birden fazla kez geçiyorsa hepsini siler, sadece tek geçenleri liste olarak döner
    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            Integer current = counts.get(id);
            if (current == null) {
                counts.put(id, 1);
            } else {
                counts.put(id, current + 1);
            }
        }

        List<Employee> uniqueEmployees = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            int id = employee.getId();
            if (counts.get(id) == 1) {
                uniqueEmployees.add(employee);
            }
        }

        return uniqueEmployees;
    }
}
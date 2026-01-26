package com.javacollectionframework.map.groupobjectbyproperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeGrouper {

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {

        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            departmentMap
                .computeIfAbsent(emp.getDepartment(), d -> new ArrayList<>())
                .add(emp);
        }

        return departmentMap;
    }
}

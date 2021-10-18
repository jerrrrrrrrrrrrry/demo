package com.example.demo.BinarTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-05-14 11:46
 **/
public class LeetCode_690 {
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();


    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map,id);


    }

    public int getImportanceHelper(Map<Integer, Employee> map, int id) {
        if (map.get(id).subordinates==null||map.get(id).subordinates.size()==0){
            return map.get(id).importance;
        }
        List<Integer> subordinates = map.get(id).subordinates;
        int tmp=0;
        for (int j=0;j<subordinates.size();j++) {
            tmp = tmp+getImportanceHelper(map,subordinates.get(j));
        }
        return tmp+map.get(id).importance;


    }
//    public int sum(List<Employee> employees, int id){
//
//    }
}



// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


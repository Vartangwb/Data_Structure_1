package LeetCode;

import java.util.*;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution690 {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        Queue<Employee> employeeQueue = new LinkedList<Employee>();
        employeeQueue.add(map.get(id));
        while(employeeQueue.isEmpty() == false){
            Employee employee = employeeQueue.poll();
            res += employee.importance;
            for(int ii : employee.subordinates){
                employeeQueue.add(map.get(ii));
            }
        }
        return res;
    }

}

// 690. Employee Importance

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;
        
        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        if (!map.containsKey(id)) 
            return 0;
        
        queue.offer(map.get(id));
        
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            sum += curr.importance;
            for (int subId : curr.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        
        return sum;
    }
}
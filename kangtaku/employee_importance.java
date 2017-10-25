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
    Map<Integer, Integer> mp;
    List<Integer>[] gp;
    public int getImportance(List<Employee> employees, int id) {
        gp = new ArrayList[2001];
        mp = new HashMap<>();
        for (Employee emp : employees) {
            mp.put(emp.id, emp.importance);
            if (gp[emp.id] == null) gp[emp.id] = new ArrayList<>();
            for (Integer sub : emp.subordinates) {
                gp[emp.id].add(sub);
            }
        }
        
        return dfs(id);
    }
    
    public int dfs(int id) {
        int res = mp.get(id);
        for (Integer sub : gp[id]) {
            res += dfs(sub);
        }
        return res;
    }
}

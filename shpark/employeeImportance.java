import java.util.*;

class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
};

public class employeeImportance {
	Boolean[] visited;

	public int getImportance(List<Employee> employees, int id) {
		int employeeCnt = employees.size();
		visited = new Boolean[2000];
		int[] idxarr = new int[2000];
		for(int i=0; i<2000;i++){
			idxarr[i]=-1;
			visited[i]=false;
		}
		for (int i = 0; i < employeeCnt; i++) {
			idxarr[employees.get(i).id - 1] = i;
		}
		
		return helper(id, idxarr, employees);
	}

	public int helper(int id, int[] idxarr, List<Employee> employees) {
		Employee emp = employees.get(idxarr[id - 1]);
		int totalImportance = 0;
		if (!visited[idxarr[id - 1]]) {
			visited[idxarr[id - 1]] = true;
			totalImportance += emp.importance;
		}
		for (Integer sId : emp.subordinates) {
			totalImportance += helper(sId, idxarr, employees);
		}
		return totalImportance;
	}
}

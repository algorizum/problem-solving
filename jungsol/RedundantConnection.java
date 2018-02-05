
public class RedundantConnection {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[1001];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int[] result = null;
        for(int[] edge : edges) {
            int parent1 = find(edge[0]);
            int parent2 = find(edge[1]);
            if(parent1 == parent2) result = edge; 
            parents[parent2] = parent1;
        }
        return result;
    }
    
    public int find(int point) {
        if(parents[point] == point) return point;
        return find(parents[point]);
    }
}

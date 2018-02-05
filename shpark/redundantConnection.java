
public class redundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int[] parent = new int[edges.length];
		for (int i = 0; i < edges.length; i++)
			parent[i] = i + 1;

		int[] res = null;
		for (int[] edge : edges) {
			if (!merge(edge[0], edge[1], parent)) {
				res = edge;
			}
		}

		return res;
	}

	public int find(int u, int[] parent) {
		if (u == parent[u - 1])
			return u;
		return parent[u - 1] = find(parent[u - 1], parent);
	}

	public Boolean merge(int u, int v, int[] parent) {
		u = find(u, parent);
		v = find(v, parent);
		if (u == v)
			return false;
		parent[v - 1] = u;
		return true;
	}
}

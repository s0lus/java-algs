package dynamic_coupling.quick_find;

public class UF {
    // Base data structure
    private int[] id;

    // Count of components
    private int count;

    // Init N nodes
    public UF(int N) {
        count = N;

        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    // Returns true, if p and q belong to one component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Finding ID of the component for p
    public int find(int p) {
        return id[p];
    }

    // Adding connection between p and q
    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[p] = qId;
            }
        }

        count--;
    }
}

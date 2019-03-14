package dynamic_coupling.quick_union;

public class UF {
    // Base data structure
    private int[] id;

    // Count of components
    private int count;

    // Init 0 to N - 1 nodes
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

    // Finding name of the component
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    // Find root for p and q
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }
}

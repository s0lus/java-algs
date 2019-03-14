package dynamic_coupling.quick_union_weight;

public class UF {
    // Base data structure
    private int[] id;

    // Count of components
    private int count;

    // Size of component for roots
    private int[] sz;

    // Init 0 to N - 1 nodes
    public UF(int N) {
        count = N;

        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
        }
    }

    public int count() {
        return count;
    }

    // Returns true, if p and q belong to one component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Transitions by links to the root
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    // Find root for p and q
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        // Lesser root should link to bigger root
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }
}

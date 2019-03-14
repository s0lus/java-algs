package dynamic_coupling.quick_union_weight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 10;
        UF uf = new UF(N);

        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNext("done")) {
            String[] input = scanner.nextLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);

            if (uf.connected(p, q)) {
                continue;
            }

            uf.union(p, q);
        }

        System.out.println("Count of the components: " + uf.count());
    }
}

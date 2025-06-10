import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    static class UnionFind {
        private int[] parent;
        private int[] size;
        public UnionFind(int n) {
            parent = new int[2 * n + 1]; 
            size = new int[2 * n + 1];
            for (int i = 1; i <= 2 * n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); 
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }
    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        if (gb.isEmpty()) {
            return Arrays.asList( 0, 0);
        }

        int maxNode = 0;
        for (List<Integer> edge : gb) {
            maxNode = Math.max(maxNode, Math.max(edge.get(0), edge.get(1)));
        }

        UnionFind uf = new UnionFind(maxNode);

        for (List<Integer> edge : gb) {
            int u = edge.get(0);
            int v = edge.get(1);
            uf.union(u, v);
        }

        Map<Integer, Integer> componentSizes = new HashMap<>();
        for (int i = 1; i <= 2 * maxNode; i++) {
            int root = uf.find(i);
            componentSizes.put(root, uf.size[root]);
        }

        int minSize = Integer.MAX_VALUE;
        int maxSize = Integer.MIN_VALUE;
        for (int size : componentSizes.values()) {
            if (size > 1) {
                minSize = Math.min(minSize, size);
                maxSize = Math.max(maxSize, size);
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            minSize = 0;
        }
        if (maxSize == Integer.MIN_VALUE) {
            maxSize = 0;
        }

        return Arrays.asList(minSize, maxSize);
    }
}

public class Solution18 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] gbRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> gbRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int gbItem = Integer.parseInt(gbRowTempItems[j]);
                gbRowItems.add(gbItem);
            }

            gb.add(gbRowItems);
        }

        List<Integer> result = Result.componentsInGraph(gb);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

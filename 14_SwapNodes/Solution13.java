import java.io.*;
import java.util.*;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class Result {
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        if (indexes.isEmpty()) {
            return result;
        }
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (List<Integer> children : indexes) {
            TreeNode current = queue.poll();
            int leftValue = children.get(0);
            int rightValue = children.get(1);

            if (leftValue != -1) {
                current.left = new TreeNode(leftValue);
                queue.add(current.left);
            }
            if (rightValue != -1) {
                current.right = new TreeNode(rightValue);
                queue.add(current.right);
            }
        }
        for (int k : queries) {
            swapNodesAtDepth(root, k);
            List<Integer> traversal = new ArrayList<>();
            inOrderTraversal(root, traversal);
            result.add(traversal);
        }
        return result;
    }

    private static void swapNodesAtDepth(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (depth % k == 0) {
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            depth++;
        }
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, traversal);
        traversal.add(node.value);
        inOrderTraversal(node.right, traversal);
    }
}

public class Solution13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] indexesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> indexesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int indexesItem = Integer.parseInt(indexesRowTempItems[j]);
                indexesRowItems.add(indexesItem);
            }

            indexes.add(indexesRowItems);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                bufferedWriter.write(String.valueOf(result.get(i).get(j)));

                if (j != result.get(i).size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

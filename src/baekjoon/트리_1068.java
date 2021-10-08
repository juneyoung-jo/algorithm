package baekjoon;

import java.io.*;
import java.util.*;

public class 트리_1068 {

    public static void main(String[] args) throws Exception {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            makeTree(i, Integer.parseInt(st.nextToken()));


        int removeNode = Integer.parseInt(br.readLine());
        removeTree(removeNode);
        System.out.println(removeNode == rootNode ? 0 : searchLeafNode(map.get(rootNode)));
    }

    private static int searchLeafNode(Node node) {
        int answer = 0;
        if (node.isLeaf) answer++;

        for (Node childNode : node.childNodes)
            answer += searchLeafNode(childNode);

        return answer;
    }

    private static void removeTree(int idx) {
        map.get(idx).remove();
    }

    private static void makeTree(int idx, int parentNum) {
        if (parentNum == -1) rootNode = idx;
        else map.get(idx).add(map.get(parentNum));
    }

    static void init() {
        for (int i = 0; i < 50; i++)
            map.put(i, new Node());
    }

    static Map<Integer, Node> map = new HashMap<>();
    static int rootNode;

    static class Node { // ddd -> Domain Model pattern
        Boolean isRoot = true;
        Boolean isLeaf = true;
        Node parentNode = null;
        List<Node> childNodes = new ArrayList<>();

        public void changeNotIsLeaf() {
            isLeaf = false;
        }

        public void changeIsLeaf() {
            isLeaf = true;
        }

        public boolean checkRootNode() {
            if (isRoot) return true;
            else return false;
        }

        public void add(Node parent) {
            isRoot = false;
            parentNode = parent;
            this.parentNode.childNodes.add(this);
            this.parentNode.changeNotIsLeaf();
        }

        public void remove() {
            if (!checkRootNode()) {
                this.isLeaf = false;
                parentNode.childNodes.remove(this);
                if (parentNode.childNodes.size() == 0) parentNode.changeIsLeaf();
            }
        }

    }
}


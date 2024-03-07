package com.lgx.test;

import java.util.ArrayList;
import java.util.List;

public class TreeSearch {

    public static void main(String[] args) {
        String searchString = "11"; // 指定你想要查找的systemName

        List<Node> result = new ArrayList<>();
        for (Node node : getTreeData()) {
            searchNode(node, searchString, null, result);
        }

        // 打印结果
        for (Node node : result) {
            System.out.println("treeId: " + node.treeId + ", systemName: " + node.systemName + ", parentId: " + node.parentId);
        }
    }

    public static void searchNode(Node node, String searchString, Node parent, List<Node> result) {
        if (node.systemName.contains(searchString)) {
            result.add(node);
        }
        if (node.childSystems != null && !node.childSystems.isEmpty()) {
            for (Node child : node.childSystems) {
                searchNode(child, searchString, node, result);
            }
        }
    }

    public static List<Node> getTreeData() {
        List<Node> tree = new ArrayList<>();

        // 这里将JSON数据转换为Java对象
        // 为简单起见，这里直接创建了节点，你可以根据需要进行更复杂的转换
        Node node1 = new Node("1", "1", "1111");
        Node node2 = new Node("2", "11", "1");
        Node node3 = new Node("3", "111", "2");
        Node node4 = new Node("4", "12", "1");
        Node node5 = new Node("5", "2", "1111");

        node1.childSystems.add(node2);
        node1.childSystems.add(node4);
        node2.childSystems.add(node3);

        tree.add(node1);
        tree.add(node5);

        return tree;
    }

    static class Node {
        String treeId;
        String systemName;
        String parentId;
        List<Node> childSystems = new ArrayList<>();

        Node(String treeId, String systemName, String parentId) {
            this.treeId = treeId;
            this.systemName = systemName;
            this.parentId = parentId;
        }
    }
}


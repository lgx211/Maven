package com.lgx.test;

import java.util.ArrayList;
import java.util.List;

public class ColumnCombinations {
    public static List<String> generateColumnCombine(List<String> columnList, int combinationSize) {
        List<String> combinations = new ArrayList<>();
        generateCombinationHelper(columnList, combinationSize, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationHelper(List<String> columnList, int combinationSize, int start,
                                                  List<String> currentCombination, List<String> combinations) {
        if (currentCombination.size() == combinationSize) {
            combinations.add(String.join(",", currentCombination));
            return;
        }

        for (int i = start; i < columnList.size(); i++) {
            currentCombination.add(columnList.get(i));
            generateCombinationHelper(columnList, combinationSize, i + 1, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> columnList = new ArrayList<>();
        columnList.add("aaa");
        columnList.add("bbb");
        columnList.add("ccc");
        columnList.add("ddd");

        List<String> columnList1 = generateColumnCombine(columnList, 1);
        List<String> columnList2 = generateColumnCombine(columnList, 2);

        columnList1.addAll(columnList2);
        for (String combination : columnList1) {
            System.out.println(combination);
        }
    }
}


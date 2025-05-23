import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int colSize = relation[0].length;
        
        List<Set<Integer>> candidates = new ArrayList<>();
        
        for (int size = 1; size <= colSize; size++) {
            List<Set<Integer>> combinations = generateCombinations(colSize, size);
            for (Set<Integer> comb : combinations) {
                if (checkUnique(comb, relation) && checkMin(comb, candidates)) {
                    candidates.add(comb);
                }
            }
        }
        return candidates.size();
    }
    
    private boolean checkUnique(Set<Integer> cols, String[][] relation) {
        int rowSize = relation.length;
        Set<String> rowSet = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder rowStr = new StringBuilder();
            for (int col : cols) {
                rowStr.append(row[col]);
            }
            rowSet.add(rowStr.toString());
        }
        if (rowSet.size() == rowSize) {
            return true;
        }
        return false;
    }
    
    private boolean checkMin(Set<Integer> cand, List<Set<Integer>> candKeys) {
        for (Set<Integer> key : candKeys) {
            if (cand.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
    
    private List<Set<Integer>> generateCombinations(int n, int r) {
        List<Set<Integer>> combinations = new ArrayList<>();
        generateCombinationsHelper(new HashSet<>(), 0, n, r, combinations);
        return combinations;
    }
    
    private void generateCombinationsHelper(Set<Integer> current, int start, int n, int r, List<Set<Integer>> result) {
        if (current.size() == r) {
            result.add(new HashSet<>(current));
            return;
        }
        
        for (int i = start; i < n; i++) {
            current.add(i);
            generateCombinationsHelper(current, i+ 1, n, r, result);
            current.remove(i);
        }
    }
}
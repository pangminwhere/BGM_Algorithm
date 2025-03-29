import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = answers;
        int size = answers.length;

        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        
        int[] sameA = {1,2,3,4,5};
        int[] sameB = {2,1,2,3,2,4,2,5};
        int[] sameC = {3,3,1,1,2,2,4,4,5,5};
        
        int countA = 0;
        int countB = 0;
        int countC = 0;
        
        int indexA = 0;
        int i = 0;
        while (indexA <= answers.length - 1) {
            if (i <= sameA.length - 1) {
                a[indexA] = sameA[i];
                indexA++;
                i++;
            } else {
                i = 0;
                a[indexA] = sameA[i];
                indexA++;
                i++;
            }
        }
        
        int indexB = 0;
        int j = 0;
        while (indexB <= answers.length - 1) {
            if (j <= sameB.length - 1) {
                b[indexB] = sameB[j];
                indexB++;
                j++;
            } else {
                j = 0;
                b[indexB] = sameB[j];
                indexB++;
                j++;
            }
        }
        
        int indexC = 0;
        int k = 0;
        while (indexC <= answers.length - 1) {
            if (k <= sameC.length - 1) {
                c[indexC] = sameC[k];
                indexC++;
                k++;
            } else {
                k = 0;
                c[indexC] = sameC[k];
                indexC++;
                k++;
            }
        }
        
        for (int x = 0; x <= answers.length - 1; x++) {
            if (a[x] == answers[x]) {
                countA++;
            }
            if (b[x] == answers[x]) {
                countB++;
            }
            if (c[x] == answers[x]) {
                countC++;
            }
        }
        int max = countA;
        if (max < countB) {
            max = countB;
            if (max < countC) {
                return new int[]{3};
            } else if (max == countC) {
                return new int[]{2,3};
            } else {
                return new int[]{2};
            }
        } else if (max == countB) {
            if (max < countC) {
                return new int[]{3};
            } else if (max == countC) {
                return new int[]{1,2,3};
            } else {
                return new int[]{1,2};
            }
        } else {
            if (max < countC) {
                return new int[]{3};
            } else if (max == countC) {
                return new int[]{1,3};
            } else {
                return new int[]{1};
            }
        }
        
        
        
        
//         for (int i = 0; i <= size - 1; i = i + 5) {
//             for (int j = 0; j <= sameA.length - 1; j++) {
//                 a[i] = sameA[j];
//                 i++;
//             }
//         }
        
//         for (int i = 0; i <= size - 1; i = i + 8) {
//             for (int j = 0; j<= sameB.length - 1; j++) {
//                 b[i] = sameB[j];
//                 i++;
//             }
//         }
    }
}
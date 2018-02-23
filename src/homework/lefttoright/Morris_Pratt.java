/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.lefttoright;

import homework.DataSetIO;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class Morris_Pratt {
    public static void main(String[] args) {
        char[] p = DataSetIO.getPattern();
        char[] t = DataSetIO.getText();
        
//        Arrays.stream(preMP("ABABCABAB".toCharArray())).forEach(e -> {
//            System.out.print(e + " ");
//        });
//        
//        System.out.println();
//        MP("ABABCABAB".toCharArray(), "ABABDABACDABABCABAB".toCharArray());

        Arrays.stream(preMP(p)).forEach(e -> {
            System.out.print(e + " ");
        });
        
        System.out.println();
        MP(p, t);
    }
    
    
    /**
     * Preprocessing for Morris-Pratt algorithm
     * @param p characters array represent pattern 
     * @return  mpNext is input array for MP algorithm
     */
    public static int[] preMP(char[] p) {
        int m = p.length;
        int[] mpNext = new int[m + 1];
        int i = 0, j = mpNext[0] = -1;
        
        while (i < m) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                mpNext[i] = j;
            } else {
                j = mpNext[j];
            }
        }
        
        return mpNext;
    }
    
    /**
     * 
     * @param p
     * @param t 
     */
    public static void MP(char[] p, char[] t) {
        int[] mpNext = preMP(p);
        
        int i = 0, j = 0;
        while (i < t.length) {
            if (t[i] == p[j]) {
                i++;
                j++;
                if (j == p.length) {
                    System.out.print(i - j + " ");
                    j = mpNext[j];
                }
            } else {
                if (mpNext[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = mpNext[j];
                }
            }
        }
    }
}

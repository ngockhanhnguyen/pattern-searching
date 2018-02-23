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
public class Knuth_Morris_Pratt {

    public static void main(String[] args) {
        char[] p = DataSetIO.getPattern();
        char[] t = DataSetIO.getText();
        System.out.println(p.length);
        Arrays.stream(preKMP(p)).forEach(e -> {
            System.out.print(e + " ");
        });
    }

    public static int[] preKMP(char[] p) {
        int m = p.length;
        int[] kmpNext = new int[m + 1];
        kmpNext[0] = -1;

        int i = 0, j = -1;

        while (i < m) {
            if (j == -1 || p[i] != p[j]) {
                i++;
                j++;
                if (p[i] != p[j]) {
                    kmpNext[i] = kmpNext[j];
                } else {
                    kmpNext[i] = j;
                }
            } else {
                j = kmpNext[j];
            }
        }

        return kmpNext;
    }
}

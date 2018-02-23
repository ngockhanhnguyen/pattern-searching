/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author Admin
 */
public class BruteForce {
    public static void main(String[] args) {
//        System.out.println(new String(DataSetIO.getText()).indexOf(
//                new String(DataSetIO.getPattern())));

        System.out.print("Index of pattern in text is: ");
        BF(DataSetIO.getPattern(), DataSetIO.getText());
    }
    
    /**
     * 
     * @param x characters array represent pattern 
     * @param y characters array represent text
     */
    public static void BF(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m && x[j] == y[i + j]; j++);
            
            if (j == m)
                System.out.print(i + " ");
        }
    }
}

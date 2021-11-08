package folydalgorithm;

import java.util.Scanner;

public class FolydAlgorithm {

    public void integrated(int A[][]) {
        int D[][] = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] != 0) {
                    D[i][j] = A[i][j];
                } else {
                    D[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        distance(D);
    }

    public void distance(int D[][]) {
        for (int i = 0; i < D.length; i++) {
            for (int[] D1 : D) {
                for (int k = 0; k < D.length; k++) {
                    if ((D1[i] + D[i][k]) < D1[k]) {
                        D1[k] = D1[i] + D[i][k];
                    }
                }
            }
        }
        print(D);
    }

    public void print(int D[][]) {
        System.out.println("Tepe ciftleri arasinda en kisa yollar:\n\n");
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (i == j) {
                    System.out.println(i + "-" + j + " arası uzaklık : " + 0);
                }
                if (i != j) {
                    System.out.println(i + "-" + j + " arası uzaklık : " + D[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        FolydAlgorithm FA = new FolydAlgorithm();
        Scanner k = new Scanner(System.in);
        System.out.print("Grafınız Kaç Düğümlü : ");
        int vertex = k.nextInt();
        System.out.println("Komşuluk matrisini giriniz...");
        int A[][] = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                A[i][j] = k.nextInt();
            }
        }
        /*
        0---------1--------
        |         |        |
        |         |        |
        2---------3--------4
        Grafı dizisi aşağıdadır.
         */

 /*
        int A[][] = {{0, 1, 1, 0, 0},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 0},
        {0, 1, 1, 0, 1},
        {0, 1, 0, 1, 0}};
         */
        FA.integrated(A);
    }

}

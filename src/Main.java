
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Main {

    public static int DIX = 0;
    public  static int CINQ = 0;
    public  static int DEUX = 0;

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez rentrer un nombre pour calculer le nombre de billets à rendre :");
        int nb = s.nextInt();
        calculNbBillets(nb);
    }

    private static void calculNbBillets(int nb){


        if (nb == 1 || nb == 3) {
            System.out.println("Solution : Impossible");
        } else {
            if (nb == 6 || nb == 8 ) {
                DEUX = nb / 2;
            } else {
                if (((nb % 10) % 5) % 2 == 0 ) {
                    DIX = nb / 10;
                    nb = nb % 10;

                    CINQ = nb / 5;
                    nb = nb % 5;

                    DEUX = nb / 2;
                } else {
                    if (nb % 10 == 1 || nb % 10 == 3) {
                        DIX = nb / 10 - 1;
                    } else {
                        DIX = nb / 10;
                    }
                    nb = nb - DIX * 10;
                    CINQ = nb / 5 - 1;
                    nb = nb - CINQ * 5;
                    DEUX = nb / 2;
                }
            }
        }

        if (DIX > 0)
            System.out.println(DIX + " billet(s) de 10€");

        if (CINQ > 0)
            System.out.println(CINQ + " billet(s) de 5€");

        if (DEUX > 0)
            System.out.println(DEUX + " pièce(s) de 2€");
    }

    @Test
    public void testNombre21() {
        calculNbBillets(21);
        assertEquals(1, DIX);
        assertEquals(1, CINQ);
        assertEquals(3, DEUX);
    }
    @Test
    public void testNombre23() {
        calculNbBillets(23);
        assertEquals(1, DIX);
        assertEquals(1, CINQ);
        assertEquals(4, DEUX);
    }
    @Test
    public void testNombre31() {
        calculNbBillets(31);
        assertEquals(2, DIX);
        assertEquals(1, CINQ);
        assertEquals(3, DEUX);
    }

    @Test
    public void testNombre10() {
        calculNbBillets(10);
        assertEquals(1, DIX);
        assertEquals(0, CINQ);
        assertEquals(0, DEUX);
    }
    @Test
    public void testNombre11() {
        calculNbBillets(11);
        assertEquals(0, DIX);
        assertEquals(1, CINQ);
        assertEquals(3, DEUX);
    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoBlackjack;

/**
 *
 * @author leonardo
 */
public class ManoBlackjack extends Mano{
    /**
     * Computes and returns the value of this hand in the game
     * of Blackjack.
     */
    public int getBlackjackValor()  {

        int val;      // The value computed for the hand.
        boolean as;  // This will be set to true if the
        //   hand contains an ace.
        int cartas;    // Number of cards in the hand.

        val = 0;
        as = false;
        cartas = getCountCarta();  // (method defined in class Hand.)

        for ( int i = 0;  i < cartas;  i++ ) {
            // Add the value of the i-th card in the hand.
            Carta carta;    // The i-th card; 
            int cartaVal;  // The blackjack value of the i-th card.
            carta = getCarta(i);
            cartaVal = carta.getValor();  // The normal value, 1 to 13.
            if (cartaVal > 10) {
                cartaVal = 10;   // For a Jack, Queen, or King.
            }
            if (cartaVal == 1) {
                as = true;     // There is at least one ace.
            }
            val = val + cartaVal;
        }

        // Now, val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to 
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to val. 

        if ( as == true  &&  val + 10 <= 21 )
            val = val + 10;

        return val;

    }  // end getBlackjackValue()

} // end class BlackjackHand
    


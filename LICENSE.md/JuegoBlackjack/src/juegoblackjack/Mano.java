/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoblackjack;

import java.util.ArrayList;

/**
 *
 * @author leonardo
 */
public class Mano {
  private ArrayList<Carta> mano;   // The cards in the hand.

    /**
     * Create a hand that is initially empty.
     */
    public Mano() {
        mano = new ArrayList<Carta>();
    }

    /**
     * Remove all cards from the hand, leaving it empty.
     */
    public void clear() {
        mano.clear();
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param c the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */
    public void añadirCarta(Carta c) {
        if (c == null)
            throw new NullPointerException("No se puede agregar una carta nula a una mano.");
        mano.add(c);
    }

    /**
     * Remove a card from the hand, if present.
     * @param c the card to be removed.  If c is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void eliminarCarta(Carta c) {
        mano.remove(c);
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void eliminarCarta(int posicion) {
        if (posicion < 0 || posicion >= mano.size())
            throw new IllegalArgumentException("La posición no existe en la mano: "
                    + posicion);
        mano.remove(posicion);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int getCountCarta() {
        return mano.size();
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Carta getCarta(int posicion) {
        if (posicion < 0 || posicion >= mano.size())
            throw new IllegalArgumentException("La posición no existe en la mano: "
                    + posicion);
        return mano.get(posicion);
    }

    /**
     * Sorts the cards in the hand so that cards of the same suit are
     * grouped together, and within a suit the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void ordenarPorPalo() {
        ArrayList<Carta> nuevaMano = new ArrayList<Carta>();
        while (mano.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Carta c = mano.get(0);  // Minimal card.
            for (int i = 1; i < mano.size(); i++) {
                Carta c1 = mano.get(i);
                if ( c1.getPalo()< c.getPalo()||
                        (c1.getPalo()== c.getPalo()&& c1.getValor()< c.getValor()) ) {
                    pos = i;
                    c = c1;
                }
            }
            mano.remove(pos);
            nuevaMano.add(c);
        }
        mano = nuevaMano;
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by suit.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void ordenarPorValor() {
        ArrayList<Carta> nuevaMano = new ArrayList<Carta>();
        while (mano.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Carta c = mano.get(0);  // Minimal card.
            for (int i = 1; i < mano.size(); i++) {
                Carta c1 = mano.get(i);
                if ( c1.getValor()< c.getValor()||
                        (c1.getValor()== c.getValor()&& c1.getPalo()< c.getPalo()) ) {
                    pos = i;
                    c = c1;
                }
            }
            mano.remove(pos);
            nuevaMano.add(c);
        }
        mano = nuevaMano;
    }   
}

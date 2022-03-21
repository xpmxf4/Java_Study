package ch7.practice;

public class Exercise7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.printf(deck.cards[i] + ",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}

class SutdaCard {
    int num;
    final boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }

}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 1; i < 21; i++) {
            if (i < 11) {
                cards[i - 1] = new SutdaCard(i, i == 1 || i == 3 || i == 8);
            } else {
                cards[i - 1] = new SutdaCard(i - 10, false);
            }
        }

    }

    void shuffle(){
        int ranIdx = (int) (Math.random() * 20);
        for(int i = 0 ; i < cards.length; i++){
           SutdaCard tmp = cards[i];
           cards[i] = cards[ranIdx];
           cards[ranIdx] = tmp;
        }
    }

    SutdaCard pick(int index){
       return cards[index];
    }

    SutdaCard pick(){
        return  cards[(int)(Math.random()*CARD_NUM)];
    }
}
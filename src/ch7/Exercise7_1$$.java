package ch7;

public class Exercise7_1$$ {
    public static void main(String args[]) {
        SutdaDeck deck = new SutdaDeck();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");

        System.out.println();
        System.out.println(deck.pick(0));
    }
}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for (int i = 0; i < CARD_NUM; i++) {
            if (i == 0 || i == 2 || i == 7) {
                cards[i] = new SutdaCard(i % 10 + 1, true);
                continue;
            }
            cards[i] = new SutdaCard(i % 10 + 1, false);
        }
    }

    void shuffle(){
        for (int i = 0; i < CARD_NUM; i++) {
            SutdaCard tmp = cards[i];
            int ranIdx = (int) (Math.random() * 20);
            cards[i] = cards[ranIdx];
            cards[ranIdx] = tmp;
        }
    }

    SutdaCard pick(int index){
//        이거 잘못함, 무조건 매개변수를 넘겨받으면 유효성 검사를 해야함.
        if(index <0 || 20<=index) return null;
        return cards[index];
    }

    SutdaCard pick(){
        return cards[(int) (Math.random() * 20)];
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}


import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

  public Deck(boolean empty, boolean shuffled) {
		cards = new ArrayList<Card>();

		if(!empty) {
			initialize();
		}
		if(shuffled) {
			shuffle();
		}
	}

	public void initialize() {
		cards.add(new Card(1,Suit.CLUBS));
		cards.add(new Card(2,Suit.CLUBS));
		cards.add(new Card(3,Suit.CLUBS));
		cards.add(new Card(4,Suit.CLUBS));
		cards.add(new Card(5,Suit.CLUBS));
		cards.add(new Card(6,Suit.CLUBS));
		cards.add(new Card(7,Suit.CLUBS));
		cards.add(new Card(8,Suit.CLUBS));
		cards.add(new Card(9,Suit.CLUBS));
		cards.add(new Card(10,Suit.CLUBS));
		cards.add(new Card(11,Suit.CLUBS));
		cards.add(new Card(12,Suit.CLUBS));
		cards.add(new Card(13,Suit.CLUBS));

		cards.add(new Card(1,Suit.SPADES));
		cards.add(new Card(2,Suit.SPADES));
		cards.add(new Card(3,Suit.SPADES));
		cards.add(new Card(4,Suit.SPADES));
		cards.add(new Card(5,Suit.SPADES));
		cards.add(new Card(6,Suit.SPADES));
		cards.add(new Card(7,Suit.SPADES));
		cards.add(new Card(8,Suit.SPADES));
		cards.add(new Card(9,Suit.SPADES));
		cards.add(new Card(10,Suit.SPADES));
		cards.add(new Card(11,Suit.SPADES));
		cards.add(new Card(12,Suit.SPADES));
		cards.add(new Card(13,Suit.SPADES));

		cards.add(new Card(1,Suit.DIAMONDS));
		cards.add(new Card(2,Suit.DIAMONDS));
		cards.add(new Card(3,Suit.DIAMONDS));
		cards.add(new Card(4,Suit.DIAMONDS));
		cards.add(new Card(5,Suit.DIAMONDS));
		cards.add(new Card(6,Suit.DIAMONDS));
		cards.add(new Card(7,Suit.DIAMONDS));
		cards.add(new Card(8,Suit.DIAMONDS));
		cards.add(new Card(9,Suit.DIAMONDS));
		cards.add(new Card(10,Suit.DIAMONDS));
		cards.add(new Card(11,Suit.DIAMONDS));
		cards.add(new Card(12,Suit.DIAMONDS));
		cards.add(new Card(13,Suit.DIAMONDS));

		cards.add(new Card(1,Suit.HEARTS));
		cards.add(new Card(2,Suit.HEARTS));
		cards.add(new Card(3,Suit.HEARTS));
		cards.add(new Card(4,Suit.HEARTS));
		cards.add(new Card(5,Suit.HEARTS));
		cards.add(new Card(6,Suit.HEARTS));
		cards.add(new Card(7,Suit.HEARTS));
		cards.add(new Card(8,Suit.HEARTS));
		cards.add(new Card(9,Suit.HEARTS));
		cards.add(new Card(10,Suit.HEARTS));
		cards.add(new Card(11,Suit.HEARTS));
		cards.add(new Card(12,Suit.HEARTS));
		cards.add(new Card(13,Suit.HEARTS));
	}

	public Card draw(boolean revealed) throws EmptyDeckException {
		Card card = null;
	  try {
			card = this.cards.remove(0);
			if(revealed) card.reveal();
		} catch (Exception e) {
			throw new EmptyDeckException();
		}
		return card;
	}

	public boolean shuffle() {
		ArrayList<Card> new_cards;
		if (size() > 0) {
		  new_cards = new ArrayList<Card>();
			int deck_size = size();
			Random random;
			for (int i = 0; i < deck_size; i++) {
				random = new Random();
				int rand = random.nextInt(size());
				new_cards.add(this.cards.remove(rand));
			}
			this.cards = new_cards;
			return true;
		}
		return false;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public int size() {
		return this.cards.size();
	}

	public void reveal() {
		for(int i = 0; i < size(); i++) {
			this.cards.get(i).reveal();
		}
	}

	public int value() {
		int value = 0;
		int num_aces = 0;
		for(int i = 0; i < size(); i++) {
			Card c = this.cards.get(i);
			if (c.value() == 1) num_aces++;
			value += c.value();
		}
		for(int i = 0; i < num_aces; i++) {
			if (value+10 <= 21) value += 10;
		}

		return value;
	}

	public String toString() {
		String deck_s = "[";
		for(int i=0; i < this.cards.size(); i++) {
			deck_s += this.cards.get(i).toString();
			if(i+1 != this.cards.size()) deck_s+=" ";
		}
		deck_s+="]";
		return deck_s;
	}

	public static void main(String[] args) {
		Deck deck = new Deck(false, true);
		for(int i = 0; i < 53; i++) {
			try {
			  System.out.println(deck.draw(true));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}

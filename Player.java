import java.util.ArrayList;

public class Player {
	private Deck hand;
	private int chips;
	private boolean is_dealer;

	public Player(boolean is_dealer, int chips) {
		this.hand = new Deck(true, false);
		this.chips = chips;
		this.is_dealer = is_dealer;
	}

	public void dealCard(Card card) {
		this.hand.addCard(card);
	}
	
	public int getHandValue() {
		return this.hand.value();
	}

	public void fold() {
		this.hand = new Deck(true, false);
	}

	public void revealHand() {
		this.hand.reveal();
	}

	public boolean isDealer() {
		return is_dealer;
	}

	public String toString() {
		return this.hand.toString();
	}
}

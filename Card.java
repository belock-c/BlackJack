enum Suit {
	DIAMONDS,
	HEARTS,
	SPADES,
	CLUBS
}

public class Card {
	private int true_value;
	private Suit suit;
	private boolean is_revealed=false;

	public Card(int true_value, Suit suit) {
		this.true_value = true_value;
		this.suit = suit;
	}

	public boolean isRevealed() {
		return this.is_revealed;
	}

	public int value() {
		switch(this.true_value) {
			case(11): return 10;
		  case(12): return 10;
			case(13): return 10;
			default: return this.true_value;
		}
	}

	public boolean reveal() {
		if (is_revealed==false) {
			is_revealed=true;
		  return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		String card_s = "?";
		if(is_revealed) {
			card_s = "";
			switch(this.true_value) {
				case(1): card_s+='A'; break;
				case(11): card_s+='J'; break;
				case(12): card_s+='Q'; break;
				case(13): card_s+='K'; break;
				default: card_s+=""+true_value;
			}
		}

		char suit_s = '?';
		if(is_revealed) {
			switch(this.suit) {
				case DIAMONDS: suit_s='♦'; break;
				case HEARTS: suit_s='♥'; break;
				case SPADES: suit_s='♠'; break;
				case CLUBS: suit_s='♣'; break;
			}
		}

		return card_s+suit_s;
	}

	public static void main(String[] args) {
		Card c = new Card(13,Suit.SPADES);
		System.out.println(c);
	}

}

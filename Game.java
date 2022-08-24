import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private Player dealer, player;
	private Deck deck;

	public Game() {
		dealer = new Player(true, 100);
		player = new Player(false, 100);

		//Deal
		this.deck = new Deck(false, true);
		try{
			player.dealCard(deck.draw(true));
			dealer.dealCard(deck.draw(false));
			player.dealCard(deck.draw(true));
			dealer.dealCard(deck.draw(true));
		} catch (Exception e) {}


		//Game
		boolean stayed = false;
		boolean busted = false;
		while(!stayed && !busted) {
			printPlayers();	
			if (player.getHandValue() == 21) {
				System.out.println("Blackjack!");
				return;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("(h)it (s)tay");
			String decision = scanner.nextLine();

			try {
				switch(decision) {
					case "h": player.dealCard(deck.draw(true));break;
					case "s": stayed = true;break;
					default: break;
				}
			} catch (Exception e) {
			}

			//Checks
			if(player.getHandValue() > 21) {
				busted = true;
			}
		}
		
		dealer.revealHand();
		printPlayers();
		if(busted) {
			System.out.println("Bust!");
			return;
		}

		//Dealer
		while (dealer.getHandValue() < player.getHandValue()) {
			try {
				dealer.dealCard(deck.draw(true));
			} catch (Exception e) {}
			printPlayers();
		}

		if (dealer.getHandValue() > 21) {
			System.out.println("Dealer busts!");
			return;
		}

		else if (dealer.getHandValue() < player.getHandValue()) {
			System.out.println("You win!");
		}
		else {
			System.out.println("You lose!");
		}
	}

	private void printPlayers() {
		System.out.println(dealer);
		System.out.println(player);
	}

	public static void main(String[] args) {
		Game g = new Game();
	}
}

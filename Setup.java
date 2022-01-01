import java.util.Random;

public class Setup {

	public static final String[] SUITES = {"hearts", "diamonds", "clubs", "spades"};
	public static final String[] RANKS = {"two", "three", "four", "five", "six", "seven", "eight",
	"nine", "ten", "jack", "queen", "king", "ace"};
	public static final int[] VALUES = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	public static final int HAND_SIZE = 3;

	public static Card[] deckGen(){
		Card[] deck = new Card[52];
		int k = 0;
		for(int i = 0; i < SUITES.length; i++){
			for(int j = 0; j < RANKS.length; j++)
				deck[k++] = new Card(SUITES[i], RANKS[j], VALUES[j]);
		}
		return deck;
	}
	
	public static void deckShuffle(Card[] deck){
		int index;
		Card temp;
		Random random = new Random();
		for (int i = deck.length - 1; i > 0; i--){
			index = random.nextInt(i + 1);
			temp = deck[index];
			deck[index] = deck[i];
			deck[i] = temp;
		}
	}

	public static int dealCards(Player[] players, Card[] deck){
		int deckIndex = 0;
		for (int i = 0; i < HAND_SIZE; i++){
			for (int j = 0; j < players.length; j++)
				players[j].setCard(deck[deckIndex++], i);
		}
		return deckIndex;
	}
	
}
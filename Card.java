public class Card{
	
	private String suit;
	private String rank;
	private int value;
	
	public Card(String newSuit, String newRank, int newValue){
		suit = newSuit;
		rank = newRank;
		value = newValue;	
	}
	
	public String toString(){
		return rank + " of " + suit;
	}
	
	public boolean isSameRank(Card compareCard){
		return rank.equals(compareCard.getRank());
	}
	
	public boolean isSameSuit(Card compareCard){
		return suit.equals(compareCard.getSuit());
	}
	
	public String getSuit(){
		return suit;
	}
	
	public String getRank(){
		return rank;
	}
	
	public int getValue(){
		return value;
	}

}
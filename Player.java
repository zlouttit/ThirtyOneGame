public class Player{
	
	private String name;
	private Card[] hand;
	private double score;
	
	public Player(String newName){
		hand = new Card[3];
		score = 0;
		name = newName;
	}
	
	public String toString(){
		String statement = "Cards: ";
		for(int i = 0; i < hand.length; i++){
			statement += hand[i];
			if(i < hand.length-1)
				statement += ", ";
		}
		statement += "\nScore: " + score;
		return statement;
	}
	
	public void setCard(Card newCard, int index){
		hand[index] = newCard;
		if(hand[0] != null && hand[1] != null && hand[2] != null)
			updateScore();
	}
	
	private void updateScore(){
		
		//Three of a kind
		if(hand[0].isSameRank(hand[1]) && hand[0].isSameRank(hand[2]) && hand[1].isSameRank(hand[2]))
			score = 30.5;
		
		//All three the same suit
		else if(hand[0].isSameSuit(hand[1]) && hand[0].isSameSuit(hand[2]) && hand[1].isSameSuit(hand[2]))
			score = hand[0].getValue() + hand[1].getValue() + hand[2].getValue();
		
		//First and second same suit only
		else if(hand[0].isSameSuit(hand[1]))
			score = Math.max(hand[0].getValue() + hand[1].getValue(), hand[2].getValue());
		
		//Second and third same suit only
		else if(hand[1].isSameSuit(hand[2]))
			score = Math.max(hand[1].getValue() + hand[2].getValue(), hand[0].getValue());
		
		//First and third same suit only
		else if(hand[0].isSameSuit(hand[2]))
			score = Math.max(hand[0].getValue() + hand[2].getValue(), hand[1].getValue());
		
		//All suites different
		else
			score = Math.max(Math.max(hand[0].getValue(), hand[1].getValue()), hand[2].getValue());
	}

	public Card getCard(int cardIndex){ return hand[cardIndex]; }

	public String getName(){
		return name;
	}
	
	public double getScore(){
		return score;
	}
	
	
}
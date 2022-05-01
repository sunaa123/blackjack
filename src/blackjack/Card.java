package blackjack;

//カードクラス
public class Card {
	//トランプのマークの定義
	public enum Suit {
		SPADE,
		HEART,
		DIAMOND,
		CLUB
	}
	//トランプのマーク
	private Suit suit;
	//トランプの数字
	private int number;

	//コンストラクタ
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}
    
	//トランプのマークのgetter
	public Suit getSuit() {
		return suit;
	}
	
	//トランプの数字のgetter
	public int getNumber() {
		return number;
	}
	
	//トランプのマークを文字列として取得するメソッド
	public static String getSuitString(Suit suit) {
		String string = null;
		
		if(suit == Suit.SPADE) {
			string = "スペード";
		}
		else if(suit == Suit.HEART) {
			string = "ハート";
		}
		else if(suit == Suit.DIAMOND) {
			string = "ダイヤ";
		}
		else if(suit == Suit.CLUB) {
			string = "クラブ";
		}
		return string;
	}
    
	//トランプの絵札を文字に変更するメソッド
	public static String getNumberString(int number) {
		String string = null;
		
		if(number == 1) {
			string = "A";
		}
		else if(number == 11) {
			string = "J";
		}
		else if(number == 12) {
			string = "Q";
		}
		else if(number == 13) {
			string = "K";
		}
		//2~10は変更しない
		else if(number >= 2 && number <= 10) {
			string = Integer.toString(number);
		}
		return string;
	}
	
	//トランプのマークと数字を組み合わせるメソッド
	public String toString() {
		String suit = getSuitString(this.suit);
		String number = getNumberString(this.number);
		
		String string = "[]";
		if(suit != null && number != null) {
			string = "[" + suit + number + "]";
		}
		return string;
	}

	//トランプのカードを52種類作成するメソッド
	public static Card[] getAllCards() {
		Card[] cards = new Card[52];
		int index = 0;
		Suit[] suits = {Suit.SPADE, Suit.HEART, Suit.DIAMOND, Suit.CLUB};
		
		for(int i = 0; i < suits.length; i++) {
			Suit suit = suits[i];
			for(int number = 1; number <= 13; number++) {
				Card card = new Card(suit, number);
				cards[index] = card;
				index++;
			}
		}
		return cards;
	}
}

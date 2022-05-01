package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//トランプの山札クラス
public class Stock {
	
	//カード52種類を入れる配列
	private ArrayList<Card> cards;
	
	//コンストラクタ
	public Stock() {
		initialize();
	}
	
	//52種類のカードをシャッフルする
	public void initialize() {
		Card[] array = Card.getAllCards();
		List<Card> list = Arrays.asList(array);
		Collections.shuffle(list);
		this.cards = new ArrayList<Card>(list);
	}
	
	//山札の残りを確認するメソッド
	public int getNumberOfCards() {
		return this.cards.size();
	}
	
	//山札からカードを一枚引くメソッド
	public Card pickCard() {
		Card card = this.cards.get(0);
		this.cards.remove(0);
		return card;
	}
}

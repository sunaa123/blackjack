package blackjack;

import java.io.IOException;
import java.util.ArrayList;

//参加者クラス PlayerクラスとDealerクラスのスーパークラス
public  abstract class Attender {
	//手札
	protected ArrayList<Card> cards;
	//参加者の名前
	protected String name;
	
	//コンストラクタ 名前
	public Attender(String name) {
		this.name = name;
		initialize();
	}
	
	//シャッフルされた状態の山札を作成するメソッド
	public void initialize() {
		this.cards = new ArrayList<Card>();
	}
	
	//山札からカードを２枚引くメソッド
	public void start(Stock stock) {
		this.cards.clear();
		for(int i=0; i<2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
	}
	
	//参加者の名前のgetter
	public String getName() {
		return name;
	}
	
	//山札からカードを一枚引くメソッド
	public void hit(Stock stock) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}
	
	//手札の強さを計算するメソッド
	public int calculateStrength() {
		//手札
		int strength = 0;
		//A
		int aceCnt = 0;  
		//手札の枚数文繰り返し数字を足していく
		for (Card card : this.cards) { 
			int num = card.getNumber(); 
			//絵札は１０として扱う
			if ( num > 10) {       
				num = 10;
			} 
			//Aを持っていたらaceCntに+1する
			if(num == 1) {  
				aceCnt++;
			}
			strength += num;  
		}
		//Aを手札に持っていて手札の合計が21以下ならAを11として扱う
		if(aceCnt > 0) {      
			if(strength + 10 <= 21) { 
				strength += 10;   
			}     
		}   
		//バースト
		if(strength > 21) {        
			strength = 0;
		}	
		return strength;
	}
	
	//参加者のplayer名と手札を文字列で取得するメソッド 
	public String toString() {
		String string = name + ": ";  
		for(int i=0; i<this.cards.size(); i++) { 
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}
	
	//toStringメソッドを表示するメソッド
	public void display() {
		System.out.println(this.toString());
	}
	
	//抽象メソッド
	public abstract void play(Stock stock) throws IOException;
	} 

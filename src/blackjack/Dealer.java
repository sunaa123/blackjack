package blackjack;

//ディーラークラス Attenderクラスのサブクラス
public class Dealer extends Attender {
	
	//trueの場合手札を全部表示する為に用意した変数
	private boolean opened;
	
	//コンストラクタ ディーラーの名前
	public Dealer() {
		super("Computer"); 
	}
	
	//ゲームを開始するメソッド
	@Override
	public void start(Stock stock) {
		super.start(stock);
		this.opened = false;
	}
	
    //手札が17以上かバーストするまでカードを一枚引くメソッド
	@Override
	public void play(Stock stock) {
		int strength = this.calculateStrength();
		while(strength < 17 && strength > 0){
			this.hit(stock);
			strength = this.calculateStrength();
		}
		this.opened = true;
	}

	//最初は手札を一枚伏せた状態でカード表示するメソッド
	@Override
	public String toString() {
		String string = "";
		if(this.opened) {
			string = super.toString();
		}
		else {
			string = this.name + ": ";
			for(int i=0; i<this.cards.size(); i++) {
				Card card = this.cards.get(i);
				if(i == 0) {
					string = string + card.toString();
				}
				else {
					string = string + "[#####}";
				}
			}
		}
		return string;
	}
}

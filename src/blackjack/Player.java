package blackjack;

import java.io.BufferedReader;
import java.io.IOException;

//プレイヤークラス Attenderのサブクラス
public class Player extends Attender {
	
	//Hitする(カードを一枚引く)を選択する為の定数
	public static final int ACTION_HIT = 1;
	//Stand(勝負する)を選択する為の定数
	public static final int ACTION_STAND = 2;
	//入力された文字を読み込む
	private BufferedReader reader;
	
	//コンストラクタ 
	public Player(BufferedReader reader) {
		//Playerの名前 
		super("You");
		//入力された文字を読み込む
		this.reader = reader;
	}
	
	//手札の強さを計算するメソッド
	@Override
	public int calculateStrength() {
		int strength = super.calculateStrength();
		if(strength == 0) {
			strength = -1;
		}
		return strength;
	}
	
	//HitとStandの処理をするメソッド
	@Override
	public void play(Stock stock) throws IOException {
		boolean standing = false;
		while(!standing) {
			this.display();
			int action = selectAction();
			if(action == ACTION_HIT) {
				this.hit(stock);
				int strength = this.calculateStrength();
				if(strength <= 0) {
					standing = true;
				}
			}
			else {
				standing = true;
			}
		}
	}
	
	//HitかStandの選択肢を表示するメソッド
	private int selectAction() throws IOException{
		String selectMessage = "[" +ACTION_HIT+ "] Hit (カードを引く)"
				+"   [" +ACTION_STAND+ "]  Stand (勝負する)";
		System.out.println(selectMessage);
		int action = 0;
		//プレイヤーが1か2を入力するまで繰り返す
		while(action != ACTION_HIT && action != ACTION_STAND) {
			String input = this.reader.readLine();
		try {
			action = Integer.parseInt(input);
		}
		catch(Exception e) {
			System.out.println("正しい数字を入力してください。");	
			}
		}
		return action;		
  }
}

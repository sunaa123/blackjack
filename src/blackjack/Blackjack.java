package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Blackjackのコントロールクラス
public class Blackjack {
	//メインメソッド
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		start(reader);
		
		
		reader.close();
	}
	
	//ゲームを開始するメソッド
	public static void start(BufferedReader reader)throws IOException{
		Player player = new Player(reader);
		Dealer dealer = new Dealer();
		Stock stock = new Stock();
		
		player.start(stock);
		dealer.start(stock);
		
		dealer.display();
		
		player.play(stock);
		dealer.play(stock);
		
		showResult(player, dealer);	
		
		//ゲーム終了後に再プレイするかを選択
        System.out.println("もう一回やりますか？    [1]やる    [2]やらない");

        int yes = 1;
        int no = 2;
		
		int replay = 0;
		while(replay != yes && replay != no) {
		       String input = reader.readLine();
		try {
			 replay = Integer.parseInt(input);
			if(replay == 1) {
				Blackjack.start(reader);
			}
			else if(replay == 2) {
				System.out.println("ゲームを終了します。");
			}
		}
		catch(Exception e) {
			System.out.println("正しい文字を入力してください。");	
			}
		}
	 }
	
	//ゲームの結果を表示するメソッド
	public static void showResult(Attender player, Attender dealer) {
		dealer.display();
		player.display();
	
		int dealerStrength = dealer.calculateStrength();
		int playerStrength = player.calculateStrength();
		
		if(playerStrength > dealerStrength) {
			System.out.println("あなたの勝ちです!");
		}
		else if(playerStrength < dealerStrength) {
			System.out.println("あなたの負けです。");
		}
		else {
			System.out.println("引き分けです。");
		}
	}
}

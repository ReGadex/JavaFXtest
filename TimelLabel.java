package fx;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

//カスタムラベルクラス(ラベルを継承して、リアルタイム時刻表示専用のラベルを作成)
public class TimelLabel extends Label {

    public TimelLabel(){
    	//親のコンストラクタを起動
    	super();
    	
    	 try{
    		//TimeLabel用のFXMLファイルを読み込み
 	        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource("../TimeLabel.fxml"));
    		 
	    	//スケジューラ設定
	        Timer t = new Timer();
	        t.schedule(new TimerLabelTask(), 0,1000);//1秒毎に実行
	        // FXMLのルートタグとして、自らを登録
	        fxmlLoader.setRoot(this);
	        fxmlLoader.setController(this);
        
        	//FXMLの読込
            fxmlLoader.load();
            
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
	
    //時刻設定関数
    public void setTime(){
    	//javaFXではApplicationスレッドと描画を同期しないといけない為,Platform.runLater(()->で同期してやる必要がある
    	 Platform.runLater(()->{
    		 this.setText(CommonMethod.getDate());
    	 });
    }
    
	//ラベルに時刻設定表示
	public class TimerLabelTask extends TimerTask {
		
		@Override
		public void run() {
			// TODO 自動生成されたメソッド・スタブ
			setTime();
		}
	}
}

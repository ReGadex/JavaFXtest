package fx;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

// 画面コントロールベースクラス
public abstract class BaseController{
	
	//表示画面サイズ
	private final double width  = 1920;
    private final double height = 1050; 
	
	//　コントローラーのinstanceは継承先で定義(getter,setterも同様)
	
	// 他のControllerから取得するためのStage
	private Stage presentStage;
	
	//Scene(シングルトン)
	private Scene scene;
	
	//FXMLへのパス
	private String fxmlpath;
	
	//画面タイトル設定関数
	protected final void setControlTitle(String title){
		this.presentStage.setTitle(title);
	}
	
	//初期設定関数(stage設定,画面リサイズ禁止,終了設定)
	public void Init(Stage localstage){
		this.presentStage = localstage;
		this.presentStage.setResizable(false);
		setExit(this.presentStage);
	}
	
	//Stage取得
	public final Stage ｇetStage(){
		return this.presentStage;
	}
	
	//設定したfxmlから画面遷移する関数
	protected void PageLoad(){
		//継承先で実装
	}

	//Scene:getter
 	protected final Scene getScene(){
		return this.scene;
	}
	
	//Scene:setter
	protected final void setScene(Scene localscine){
		this.scene = localscine;
	}
	
	//fxmlpath:getter
	protected final String getFxmlPath(){
		return this.fxmlpath;
	}
	
	//fxmlpath:setter
	protected final void setFxmlPath(String strpath){
		this.fxmlpath = strpath;
	}
	
	protected final double getWidth(){
		return width;
	}
	
	protected final double getHeight(){
		return height;
	}
	
	//instance:getter	
	//instance:setter	
	
	protected void show(){
		//詳細は継承先にて実装
	}
	
	//windowで×ボタンが押された場合に強制終了する。⇒確認ダイアログを出してから終了する様に改良とかできると思う
	public void setExit(Stage stage)
	{
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
            	System.out.println("終了ボタンが押された為、終了します。");
            	System.exit(1);
            }
        });
	}
}

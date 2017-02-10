package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;

public class JavaFXtest extends Application {
	  public static JavaFXtest singleton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		singleton = this;
		//ログ出力用変数
		final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("SampleLoging");
		try{

			primaryStage.setTitle(display.getTitleName(display.DispTitleId.JH01G010));
			setExit(primaryStage);
			//画面表示設定
			BorderPane testdisp;
			testdisp = FXMLLoader.load(getClass().getResource("../test.fxml"));
			Scene scene = new Scene(testdisp,1920,1050);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);//画面のリサイズを禁止
			primaryStage.show();

		}
		catch(Exception ex)
		{
			logger.info("エラーが発生しました。");
			logger.info(ex.getMessage());
		}
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
	
	//画面遷移用関数
	public void SetPage(Stage primaryStage){
		Test1Controller t1 = new Test1Controller(primaryStage);
		t1.Init(primaryStage);
		t1.setControlTitle(display.getTitleName(display.DispTitleId.JH01G010));
		t1.setFxmlPath("../test.fxml");
		try{
			t1.setScene(new Scene(FXMLLoader.load(getClass().getResource(t1.getFxmlPath())),t1.getWidth(),t1.getHeight()));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
	}
	
	public  static JavaFXtest getInstance(){
        return singleton;
    }
	
	public static void main(final String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		launch(args); //アプリケーションの実行
	}
}

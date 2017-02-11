package fx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Test1Controller extends BaseController implements Initializable {
	private static Stage instance;
	 
	//FXML上で定義された部品と関連付け。
	@FXML private Button backButton;
	
	//表示する画面の形式
	private static BorderPane bpane; 
	 
	public Stage getInstance() {
	    return instance;
	}
	
	public void setInstance(Stage linstance) {
	    instance = linstance;
	}
	
	private void SetPane(BorderPane bp){
	    bpane = bp;
	}
	
	private BorderPane GetPane(){
	    return bpane;
	}
	
	public Test1Controller(Stage localstage){
		this.Init(localstage);
		this.setControlTitle(display.getTitleName(display.DispTitleId.JH01G010));
		setFxmlPath("../test.fxml");
		try{
			SetPane(FXMLLoader.load(getClass().getResource(getFxmlPath())));
			setScene(new Scene(GetPane(),this.getWidth(),this.getHeight()));
			setInstance(localstage);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
	}
		
	//⇒画面遷移の考え方
	//読み込んだFXML側でコントロールクラスを使う。
	//ボタンを押す⇒コントロールクラスのイベントへ発生⇒別画面のFXML読み込み
	
	//ページ読み込み
	@Override
	protected void PageLoad(){
		//遷移可能な別ページの設定を読み込む場合
		//インスタンス生成後、Stageに読み込み設定・・と思ったが、これではその遷移先からの遷移は？
		//全画面の遷移を実現するには各コントローラの定義を用意しておく
		//各コントローラは自分自身の中に遷移先の定義(コントローラ)を持つ
		//画面内の戻るボタンが押された場合など画面内のコントロールのイベントにより画面遷移(定義読み込みセット)
		//Test2Controller t2 = new Test2Controller(); 
		//t2.Test2Init(
	}
	
	@Override
        public void initialize(URL url, ResourceBundle bundle) {
            //初期化処理
        }
	
	protected void show(){
		instance.show();
	}
	
        public void onClick(ActionEvent event){
            JavaFXtest.getInstance().SetPage(this.getInstance());
        }
	
	@FXML
        public void onBackButtonClicked(ActionEvent event){
            JavaFXtest.getInstance().SetPage(this.getInstance());
        }
}

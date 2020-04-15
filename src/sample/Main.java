package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int WIDTH=500;
    public static final int HEIGHT=500;
    public static final int RADIUS=200;
    public static final String URL="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Mount-Everest.jpg/1024px-Mount-Everest.jpg";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle=new Circle(RADIUS);
        circle.translateXProperty().set(WIDTH/2);
        circle.translateYProperty().set(HEIGHT/2);
        Group group=new Group();
        group.getChildren().add(circle);
        Scene scene=new Scene(group,WIDTH,HEIGHT);
        primaryStage.setTitle("Circular Image");
        primaryStage.setScene(scene);
        primaryStage.show();
        if (URL != null) {
            Image image = new Image(URL,true);
            image.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    System.out.println(Math.rint(newValue.doubleValue() * 100));
                    if(newValue.intValue()==1){
                        ImagePattern imagePattern=new ImagePattern(image);
                        circle.setFill(imagePattern);
                    }
                }
            });
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

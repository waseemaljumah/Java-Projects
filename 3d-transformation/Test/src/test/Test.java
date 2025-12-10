package test;
//transformation FOR QUIZ

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Test extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Box cube;
    private Slider translateX;
    private Slider translateY;
    private Slider translateZ;
    private Slider rotateX;
    private Slider rotateY;
    private Slider rotateZ;
    private Slider scaleX;
    private Slider scaleY;
    private Slider scaleZ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("3D Transformation");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.WHITE);

        PerspectiveCamera cam = new PerspectiveCamera(true);
        cam.setNearClip(0.1);
        cam.setFarClip(10000.0);
        cam.translateZProperty().set(-1000);

        root.getChildren().add(createCube());
        root.getChildren().add(createControls());

        scene.setCamera(cam);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createControls() {
        VBox controls = new VBox(10);
        controls.setPadding(new Insets(10));

        translateX = createSlider("Translate X", -200, 200, 0);
        translateY = createSlider("Translate Y", -200, 200, 0);
        translateZ = createSlider("Translate Z", -200, 200, 0);

        rotateX = createSlider("Rotate X", -180, 180, 0);
        rotateY = createSlider("Rotate Y", -180, 180, 0);
        rotateZ = createSlider("Rotate Z", -180, 180, 0);

        scaleX = createSlider("Scale X", 0.1, 2, 1);
        scaleY = createSlider("Scale Y", 0.1, 2, 1);
        scaleZ = createSlider("Scale Z", 0.1, 2, 1);

        controls.getChildren().addAll(
                translateX, translateY, translateZ,
                rotateX, rotateY, rotateZ,
                scaleX, scaleY, scaleZ
        );

        return controls;
    }

    private Slider createSlider(String label, double min, double max, double initialValue) {
        Label sliderLabel = new Label(label);
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit((max - min) / 10);

        slider.setPrefWidth(150);
        slider.setPrefHeight(15);
        slider.setStyle("-fx-font-size: 10px;");

        slider.valueProperty().addListener((observable, oldValue, newValue) -> applyTransformations());

        VBox sliderBox = new VBox(5);
        sliderBox.getChildren().addAll(sliderLabel, slider);

        return slider;
    }

    private Box createCube() {
        cube = new Box(100, 100, 100);

        PhongMaterial material = new PhongMaterial(Color.BLUE);
        cube.setMaterial(material);

        cube.setTranslateX(0);
        cube.setTranslateY(0);
        cube.setTranslateZ(0);

        return cube;
    }

    private void applyTransformations() {
        cube.getTransforms().clear();
        cube.getTransforms().addAll(
                new Translate(translateX.getValue(), translateY.getValue(), translateZ.getValue()),
                new Rotate(rotateX.getValue(), Rotate.X_AXIS),
                new Rotate(rotateY.getValue(), Rotate.Y_AXIS),
                new Rotate(rotateZ.getValue(), Rotate.Z_AXIS),
                new Scale(scaleX.getValue(), scaleY.getValue(), scaleZ.getValue())
        );
    }
}

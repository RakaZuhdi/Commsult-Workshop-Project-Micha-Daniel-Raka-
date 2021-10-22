package id.ac.sgu.gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import actor.AirConditioner;
import actor.Blinder;
import actor.Light;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import sensor.SensorClass;
import sensor.Temperature;
import sensor.Time;
import sensor.Wind;
import world.StartSensor;

public class Controller implements Initializable {
	private StartSensor sensor;

	public Controller() {
		this.sensor = new StartSensor(new Time(0), new Wind(0, 90, 72), new Temperature(0, 40, 20), new Blinder(false),
				new AirConditioner(false), new Light(true, 18, 6));
		this.sensor.start();
	}

	private ScheduledExecutorService scheduledExecutorService;
	final int WINDOW_SIZE = 10;
	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	@FXML
	private Button graphicsView;
	@FXML
	private Button tableView;
	@FXML
	private Button controllerView;
	@FXML
	private Button exitView;
	@FXML
	private Pane graphicsPane;
	@FXML
	private Pane tablePane;
	@FXML
	private Pane controllerPane;
	@FXML
	private CategoryAxis xAxis1;
	@FXML
	private NumberAxis yAxis1;
	@FXML
	private LineChart<String, Number> lineChart1;
	@FXML
	private CategoryAxis xAxis2;
	@FXML
	private NumberAxis yAxis2;
	@FXML
	private LineChart<String, Number> lineChart2;
	private XYChart.Series<String, Number> series1 = new XYChart.Series<>();
	private XYChart.Series<String, Number> series2 = new XYChart.Series<>();
	@FXML
	private TableView results = new TableView();
	@FXML
	private TableColumn<SensorClass, String> timeColumn = new TableColumn();
	@FXML
	private TableColumn<SensorClass, String> windColumn = new TableColumn();
	@FXML
	private TableColumn<SensorClass, String> temperatureColumn = new TableColumn();
	@FXML
	private TableColumn<SensorClass, String> blinderColumn = new TableColumn();
	@FXML
	private TableColumn<SensorClass, String> lightColumn = new TableColumn();
	@FXML
	private TableColumn<SensorClass, String> airConditionerColumn = new TableColumn<>("Air Conditioner");
	
	@FXML
	private Line hourHand;
	private ArrayList<Integer> hourX = new ArrayList<Integer>();
	private ArrayList<Integer> hourY = new ArrayList<Integer>();
	private int i = 0;
	
	@FXML
	private Circle blindsIndicatorGreen;
	@FXML
	private Circle lightsIndicatorGreen;
	@FXML
	private Circle airconIndicatorGreen;
	@FXML
	private Circle blindsIndicatorRed;
	@FXML
	private Circle lightsIndicatorRed;
	@FXML
	private Circle airconIndicatorRed;
	
	@FXML
	private CheckBox blindersCheck;
	@FXML
	private CheckBox lightsCheck;
	@FXML
	private CheckBox airConCheck;
	
	

	public void graphicsButtonClicked() {
		graphicsPane.setVisible(true);
		tablePane.setVisible(false);
		controllerPane.setVisible(false);
	}

	public void tableButtonClicked() {
		graphicsPane.setVisible(false);
		tablePane.setVisible(true);
		controllerPane.setVisible(false);
	}

	public void controllerButtonClicked() {
		graphicsPane.setVisible(false);
		tablePane.setVisible(false);
		controllerPane.setVisible(true);
	}
	
	public void closeButtonAction() {
		Stage stage = (Stage) exitView.getScene().getWindow();
		stage.close();
	}
	
	public void setHourPos() {
		hourX.add(119);
		hourX.add(135);
		hourX.add(138);
		hourX.add(130);
		
		hourX.add(117);
		hourX.add(93);
		hourX.add(73);
		hourX.add(60);
		
		hourX.add(52);
		hourX.add(56);
		hourX.add(70);
		hourX.add(93);
		
		hourY.add(18);
		hourY.add(37);
		hourY.add(57);
		hourY.add(77);
		
		hourY.add(85);
		hourY.add(98);
		hourY.add(87);
		hourY.add(77);
		
		hourY.add(57);
		hourY.add(37);
		hourY.add(18);
		hourY.add(15);
	}
	
	
	public void checkBlinds(Boolean active) {
		if(active == true) {
			blindsIndicatorRed.setVisible(false);
		}
		else {
			blindsIndicatorRed.setVisible(true);
		}
	}
	
	public void checkLights(Boolean active) {
		if(active == true) {
			lightsIndicatorRed.setVisible(false);
		}
		else {
			lightsIndicatorRed.setVisible(true);
		}
	}
	
	public void checkAirCon(Boolean active) {
		if(active == true) {
			airconIndicatorRed.setVisible(false);
		}
		else {
			airconIndicatorRed.setVisible(true);		
		}
	}
	
	public void deactivateBlinders() {
		
	}
	public void deactivateLights() {
		
	}
	public void deactivateAirCon() {
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setHourPos();

		ObservableList<SensorClass> data = FXCollections.observableArrayList();
		int days = 0;

		results.getColumns().addAll(timeColumn, windColumn, temperatureColumn, blinderColumn, lightColumn, airConditionerColumn);
		
		timeColumn.setMinWidth(9);
		timeColumn.setCellValueFactory(new PropertyValueFactory<>("formattedTime"));
		
		windColumn.setCellValueFactory(new PropertyValueFactory<>("wind"));
		windColumn.setText("Wind Speed (km/h)");;
		
		temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
		temperatureColumn.setText("Temperature (C)");
		
		blinderColumn.setCellValueFactory(new PropertyValueFactory<>("blinds"));
		
		lightColumn.setCellValueFactory(new PropertyValueFactory<>("light"));
		
		airConditionerColumn.setCellValueFactory(new PropertyValueFactory<>("airConditioner"));
		
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		results.setItems(data);

		lineChart1.getData().add(series1);
		lineChart2.getData().add(series2);

		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Integer random = ThreadLocalRandom.current().nextInt(10);

			Platform.runLater(() -> {
				Date now = new Date();

				series1.getData().add(
						new XYChart.Data<>(String.valueOf(sensor.getTime().getFormattedTime()), sensor.getWind().getInfo()));
				series2.getData().add(
						new XYChart.Data<>(String.valueOf(sensor.getTime().getFormattedTime()), sensor.getTemp().getInfo()));

				// Table View
				results.getItems().add(
						new SensorClass(this.sensor.getTime().getInfo(),
						this.sensor.getWind().getInfo(), this.sensor.getTemp().getInfo(),
						this.sensor.getBlinder().getInfo(), this.sensor.getLight().getInfo(),
						this.sensor.getAirConditioner().getInfo()));

				
				//series1.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getWind().getInfo()));
				//series2.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getTemp().getInfo()));

				
				//Table View
//				results.setItems(getSensor());
//				results.getColumns().addAll(timeColumn, windColumn, temperatureColumn, blinderColumn, lightColumn, airConditionerColumn);
//				
				
				//Analog clock View
				hourHand.setEndX(hourX.get(i));
				hourHand.setEndY(hourY.get(i));
				i = i == 11? 0 : i+1;
				
				//Lights Indicator
				checkBlinds(sensor.getLight().getStatus());
				checkLights(sensor.getLight().getStatus());
				checkAirCon(sensor.getAirConditioner().getStatus());
				
				
				if (series1.getData().size() > WINDOW_SIZE) {
					series1.getData().remove(0);
				}
					
				if (series2.getData().size() > WINDOW_SIZE) {
					series2.getData().remove(0);
				}
					
			});
		}, 0, 1, TimeUnit.SECONDS);

	}

}
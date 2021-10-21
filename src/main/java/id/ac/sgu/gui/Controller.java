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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
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
	@FXML
	private Button exitButton;
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

	// Get all of the Sensors
	public ObservableList<StartSensor> getSensor() {
		ObservableList<StartSensor> sensors = FXCollections.observableArrayList();
		while (true) {
			sensors.add(new StartSensor(sensor.getTime(), sensor.getWind(), sensor.getTemp(), sensor.getBlinder(),
					sensor.getAirConditioner(), sensor.getLight()));
		}
		return sensors;
	}
	
	@FXML
	private Line hourHand;
	private ArrayList<Integer> hourX = new ArrayList<Integer>();
	private ArrayList<Integer> hourY = new ArrayList<Integer>();
	private int i = 0;
	
	private ImageView blindsIndicatorGreen = new ImageView(new Image(getClass().getResourceAsStream("pngegg.png")));
	private ImageView lightsIndicatorGreen = new ImageView(new Image(getClass().getResourceAsStream("pngegg.png")));
	private ImageView airconIndicatorGreen = new ImageView(new Image(getClass().getResourceAsStream("pngegg.png")));
	private ImageView blindsIndicatorRed = new ImageView(new Image(getClass().getResourceAsStream("png-clipart-traffic-light-computer-icons-red-red-light-color-light.png")));
	private ImageView lightsIndicatorRed = new ImageView(new Image(getClass().getResourceAsStream("png-clipart-traffic-light-computer-icons-red-red-light-color-light.png")));
	private ImageView airconIndicatorRed = new ImageView(new Image(getClass().getResourceAsStream("png-clipart-traffic-light-computer-icons-red-red-light-color-light.png")));
	

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
	
	public void addImages() {
		blindsIndicatorGreen.setX(50); 
	    blindsIndicatorGreen.setY(25); 
	    blindsIndicatorGreen.setFitHeight(71); 
	    blindsIndicatorGreen.setFitWidth(71); 
	    blindsIndicatorGreen.setPreserveRatio(true);
	    
	    lightsIndicatorGreen.setX(50); 
	    lightsIndicatorGreen.setY(25); 
	    lightsIndicatorGreen.setFitHeight(71); 
	    lightsIndicatorGreen.setFitWidth(71); 
	    lightsIndicatorGreen.setPreserveRatio(true);
	    
	    airconIndicatorGreen.setX(50); 
	    airconIndicatorGreen.setY(25); 
	    airconIndicatorGreen.setFitHeight(71); 
	    airconIndicatorGreen.setFitWidth(71); 
	    airconIndicatorGreen.setPreserveRatio(true);
	    
	    blindsIndicatorRed.setX(50); 
	    blindsIndicatorRed.setY(25); 
	    blindsIndicatorRed.setFitHeight(71); 
	    blindsIndicatorRed.setFitWidth(71); 
	    blindsIndicatorRed.setPreserveRatio(true);
	    
	    lightsIndicatorRed.setX(50); 
	    lightsIndicatorRed.setY(25); 
	    lightsIndicatorRed.setFitHeight(71); 
	    lightsIndicatorRed.setFitWidth(71); 
	    lightsIndicatorRed.setPreserveRatio(true);
	    
	    airconIndicatorRed.setX(50); 
	    airconIndicatorRed.setY(25); 
	    airconIndicatorRed.setFitHeight(71); 
	    airconIndicatorRed.setFitWidth(71); 
	    airconIndicatorRed.setPreserveRatio(true);
	    Group root = new Group(blindsIndicatorGreen);
	}
	
	public void checkBlinds(Boolean active) {
		if(active == true) {
			blindsIndicatorGreen.setVisible(true);
		}
		else {
			blindsIndicatorGreen.setVisible(false);
		}
	}
	
	public void checkLights(Boolean active) {
		if(active == true) {
			lightsIndicatorGreen.setVisible(true);
		}
		else {
			lightsIndicatorGreen.setVisible(false);
		}
	}
	
	public void checkAirCon(Boolean active) {
		if(active == true) {
			airconIndicatorGreen.setVisible(true);
		}
		else {
			airconIndicatorGreen.setVisible(false);		}
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
				
				/*
				checkBlinds();
				checkLights();
				checkAirCon();
				*/
				
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
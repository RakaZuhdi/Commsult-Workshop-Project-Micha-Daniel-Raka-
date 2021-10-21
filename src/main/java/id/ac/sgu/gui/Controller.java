package id.ac.sgu.gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import actor.AirConditioner;
import actor.Blinder;
import actor.Light;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
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
	private Button button;
	private XYChart.Series<String, Number> series1 = new XYChart.Series<>();
	private XYChart.Series<String, Number> series2 = new XYChart.Series<>();

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		lineChart1.getData().add(series1);
		lineChart2.getData().add(series2);

		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Integer random = ThreadLocalRandom.current().nextInt(10);
			series1.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getWind().getInfo()));
			series2.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getTemp().getInfo()));


			Platform.runLater(() -> {
				Date now = new Date();
				
				series1.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getWind().getInfo()));
				series2.getData().add(new XYChart.Data<>(String.valueOf(sensor.getTime().getInfo()), sensor.getTemp().getInfo()));

				
				if (series1.getData().size() > WINDOW_SIZE)
					series1.getData().remove(0);

				if (series2.getData().size() > WINDOW_SIZE)
					series2.getData().remove(0);

			});
		}, 0, 1, TimeUnit.SECONDS);

	}

}
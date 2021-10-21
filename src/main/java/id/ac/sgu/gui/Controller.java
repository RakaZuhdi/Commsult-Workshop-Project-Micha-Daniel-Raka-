package id.ac.sgu.gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controller implements Initializable {
	
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
	private LineChart.Series<String, Number> series1 = new LineChart.Series<>();
	private LineChart.Series<String, Number> series2 = new LineChart.Series<>();
	
	
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
		
	}
	
	final SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH:mm:ss");
	
//	ScheduledExecutorService scheduledExecutorService;
//	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//	
//	scheduledExecutorService.scheduleAtFixedRate(() -> {
//		Integer random = ThreadLocalRandom.current().nextInt(10);
//		
//		Platform.runLater(() -> {
//			lineChart1.getData().add(series1);
//			lineChart2.getData().add(series2);
//			Date now = new Date();
//			series1.getData().add(new lineChart1.Data<>(simpleDateFormat.format(now), random));
//			series2.getData().add(new lineChart2.Data<>(simpleDateFormat.format(now), random));
//		});
//	}, 0, 1, TimeUnit.SECONDS);
	
//	final int WINDOW_SIZE = 10;
	
//	if (series.getData().size() > WINDOW_SIZE)
//	    series.getData().remove(0);
//	
//	
	
}

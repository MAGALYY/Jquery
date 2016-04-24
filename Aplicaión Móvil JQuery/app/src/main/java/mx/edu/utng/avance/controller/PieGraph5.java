package mx.edu.utng.avance.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieGraph5 {

	public Intent getIntent(Context context) {

		int[] values = { 1, 2, 3, 4, 5, 6, };
		CategorySeries series = new CategorySeries("Grafica de aprovechamiento");
		int k = 0;
		for (int value : values) {
			series.add("Tema " + ++k, value);
		}

		int[] colors = new int[] { Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE};

		DefaultRenderer renderer = new DefaultRenderer();
		for (int color : colors) {
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			renderer.addSeriesRenderer(r);
		}
		renderer.setChartTitle("Gráfica De Aprovechamiento");
		renderer.setChartTitleTextSize(20);
		renderer.setZoomButtonsVisible(true);

		Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");
		return intent;
	}
}

package com.example.mpchart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }
    private void setupUI(){
        pieChart = findViewById(R.id.PieChart);
        lineChart = findViewById(R.id.LineChart);
        setPieChart();
        setLineChart();
    }

    private void setPieChart(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(10f, "A"));
        entries.add(new PieEntry(20f, "B"));
        entries.add(new PieEntry(30f, "C"));
        entries.add(new PieEntry(40f, "D"));

        PieDataSet dataSet = new PieDataSet(entries, "PieChartData");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12f);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);

        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("PieChart");
        pieChart.animateY(1000);
    }
    private void setLineChart(){
        lineChart.setDrawMarkers(true);
        lineChart.setDrawBorders(true);
        List<Entry> entries = new ArrayList<>();
        for(int i=0;i<10;i++){
            entries.add(new Entry(i, (float) (Math.random()) * 80));
        }
        LineDataSet lineDataSet = new LineDataSet(entries,"溫度");
        lineDataSet.setCircleColor(ColorTemplate.COLORFUL_COLORS[0]);
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS[0]);
        LineData data = new LineData(lineDataSet);
        lineChart.setData(data);
    }
}


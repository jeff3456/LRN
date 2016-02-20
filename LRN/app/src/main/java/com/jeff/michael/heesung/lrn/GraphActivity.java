package com.jeff.michael.heesung.lrn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.Random;


public class GraphActivity extends AppCompatActivity {

    private static final Random RANDOM = new Random();
    private int last = 0;
    private LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_graph_view);

        // we get graph view instance
        GraphView graph = (GraphView) this.findViewById(R.id.graph);

        // data
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);

        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(10);
        viewport.setScrollable(true);
    }


    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                // we add 100 new entries
                for (int i = 0; i < 100; i++) {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            addEntry(series);
                        }
                    });

                    // sleep to slow down the add of entries
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        // manage error ...
                    }
                }
            }
        }).start();
    }
    // add random data to graph
    public void addEntry(LineGraphSeries<DataPoint> series) {
        // here, we choose to display max 10 points on the viewport and we scroll to end
        this.series.appendData(new DataPoint(last++, RANDOM.nextDouble() * 10d), true, 10);
    }

}


package gif.ganesh.pushnotififirebase.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class PieChartWithArrays extends AppCompatActivity
{

    PieChart pie_chart;
    float f1[]={89.f,99.3f,9f,45.5f,58.2f,7f,8f,8f,90.0f,10f,12f,12f};
    String names[]={"one","two","three","four","five","six","seven","eigt","nine","ten","elkeven","twelev"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_with_arrays);
        pie_chart=findViewById(R.id.pie_chart);

        addindPiechart();
    }
    public void addindPiechart()
    {

        List<PieEntry> entry=new ArrayList<>();

        for (int i=0;i<f1.length;i++)
        {
            entry.add(new PieEntry(f1[i],names[i]));
        }

        PieDataSet dset=new PieDataSet(entry,"sample");
        dset.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pd=new PieData(dset);

        pie_chart.setData(pd);
        pie_chart.animateY(1000);
        pie_chart.invalidate();

    }
}

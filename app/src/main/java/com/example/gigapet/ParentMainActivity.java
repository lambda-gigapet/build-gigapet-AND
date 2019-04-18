package com.example.gigapet;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ParentMainActivity extends AppCompatActivity {

    static GraphView graphView;
    static PieChartView pieChartView;
    static int fragmentCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_main);
        fragmentCounter = 1;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button foodButton = findViewById(R.id.food_config_button);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAddFoodFragment();
            }
        });

        Button dailyHistoryButton = findViewById(R.id.daily_button);
        dailyHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDailyFragment();
            }
        });

        Button monthlyHistoryButton = findViewById(R.id.monthly_button);
        monthlyHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMonthlyFragment();
            }
        });

        Button weeklyHistoryButton = findViewById(R.id.weekly_button);
        weeklyHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadWeeklyFragment();
            }
        });


    }

    public void loadWeeklyFragment() {
        fragmentCounter = 3;
        Bundle arguments = new Bundle();
        arguments.putString(WeeklyHistoryFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(WeeklyHistoryFragment.ARG_ITEM_ID));
        WeeklyHistoryFragment fragment = new WeeklyHistoryFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    public void loadMonthlyFragment() {
        fragmentCounter = 4;
        Bundle arguments = new Bundle();
        arguments.putString(MonthlyHistoryFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(MonthlyHistoryFragment.ARG_ITEM_ID));
        MonthlyHistoryFragment fragment = new MonthlyHistoryFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    public void loadDailyFragment() {
        fragmentCounter = 2;
        Bundle arguments = new Bundle();
        arguments.putString(DailyHistoryFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(DailyHistoryFragment.ARG_ITEM_ID));
        DailyHistoryFragment fragment = new DailyHistoryFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    public void loadAddFoodFragment() {
        fragmentCounter = 1;
        Bundle arguments = new Bundle();
        arguments.putString(AddFoodFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(AddFoodFragment.ARG_ITEM_ID));
        AddFoodFragment fragment = new AddFoodFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_parent_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_select_child:
                break;
            case R.id.action_add_child:
                break;
            case R.id.action_remove_child:
                break;
            case R.id.action_mealtype_all:
                Parent.setMealIndex(Constants.MEAL_TYPE_ALL);
                break;
            case R.id.action_mealtype_breakfast:
                Parent.setMealIndex(Constants.MEAL_TYPE_BREAKFAST);
                break;
            case R.id.action_mealtype_lunch:
                Parent.setMealIndex(Constants.MEAL_TYPE_LUNCH);
                break;
            case R.id.action_mealtype_dinner:
                Parent.setMealIndex(Constants.MEAL_TYPE_DINNER);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public static void loadHistoryData() {
        //TODO: pull in history data based on currentChildIndex
        //JSONObject jsonObject =  ChildDao.getFoodHistory();

        switch (fragmentCounter) {
            case 1:
                break;
            case 2: //load daily data
                break;
            case 3: //load weekly data
                break;
            case 4: //load monthly data
                break;
        }


        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>();
        switch (Parent.getMealIndex()) {
            case 0:
                break;
            case 1:
                series3 = new LineGraphSeries<>(new DataPoint[]{
                        new DataPoint(0, 2),
                        new DataPoint(1, 4),
                        new DataPoint(2, 3),
                        new DataPoint(3, 5),
                        new DataPoint(4, 2),
                        new DataPoint(5, 3),
                        new DataPoint(6, 2)});
                break;
            case 2:
                break;
        }

        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(34, Color.YELLOW));
        pieData.add(new SliceValue(34, Color.BLUE));
        pieData.add(new SliceValue(20, Color.RED));
        pieData.add(new SliceValue(54, Color.GREEN));

        PieChartData pieChartData = new PieChartData(pieData);

        pieChartView.setPieChartData(pieChartData);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 2),
                new DataPoint(1, 4),
                new DataPoint(2, 3),
                new DataPoint(3, 5),
                new DataPoint(4, 2),
                new DataPoint(5, 3),
                new DataPoint(6, 2)
        });

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 6),
                new DataPoint(2, 2),
                new DataPoint(3, 3),
                new DataPoint(4, 6),
                new DataPoint(5, 2),
                new DataPoint(6, 1)
        });
        graphView.addSeries(series1);
        graphView.addSeries(series2);
        graphView.addSeries(series3);
        graphView.getViewport().setMaxX(6);
        graphView.getViewport().setXAxisBoundsManual(true);
    }


    public static class AddFoodFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        AddFoodListAdapter listAdapter;
        RecyclerView recyclerView;

        public AddFoodFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_parent_food_config, container, false);
            graphView = rootView.findViewById(R.id.gv_line_graph);
            recyclerView = rootView.findViewById(R.id.recycler_view_parent_add_food);
            recyclerView.setHasFixedSize(true);
            listAdapter = new AddFoodListAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());

            recyclerView.setAdapter(listAdapter);
            recyclerView.setLayoutManager(layoutManager);
            return rootView;
        }
    }


    public static class DailyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";

        public DailyHistoryFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_parent_history, container, false);
            graphView = rootView.findViewById(R.id.gv_line_graph);
            pieChartView = rootView.findViewById(R.id.pc_pie_chart);
            loadHistoryData();


            return rootView;
        }
    }


    public static class WeeklyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";

        public WeeklyHistoryFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_parent_history, container, false);
            graphView = rootView.findViewById(R.id.gv_line_graph);
            pieChartView = rootView.findViewById(R.id.pc_pie_chart);
            loadHistoryData();

            return rootView;
        }
    }


    public static class MonthlyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";

        public MonthlyHistoryFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_parent_history, container, false);
            graphView = rootView.findViewById(R.id.gv_line_graph);
            pieChartView = rootView.findViewById(R.id.pc_pie_chart);
            loadHistoryData();

            return rootView;
        }
    }
}


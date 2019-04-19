package com.example.gigapet;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
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
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
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

        loadAddFoodFragment();

    }

    public void loadWeeklyFragment() {
        fragmentCounter = 3;
        Bundle arguments = new Bundle();
        arguments.putString(WeeklyHistoryFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(WeeklyHistoryFragment.ARG_ITEM_ID));
        WeeklyHistoryFragment fragment = new WeeklyHistoryFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
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
                .replace(R.id.container, fragment)
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
                .replace(R.id.container, fragment)
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
                .replace(R.id.container, fragment)
                .commit();
    }

    public void loadSelectChildFragment() {
        fragmentCounter = 5;
        Bundle arguments = new Bundle();
        arguments.putString(SelectChildFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(SelectChildFragment.ARG_ITEM_ID));
        SelectChildFragment fragment = new SelectChildFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void loadRemoveChildFragment() {
        fragmentCounter = 6;
        Bundle arguments = new Bundle();
        arguments.putString(RemoveChildFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(RemoveChildFragment.ARG_ITEM_ID));
        RemoveChildFragment fragment = new RemoveChildFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void loadAddChildFragment() {
        fragmentCounter = 7;
        Bundle arguments = new Bundle();
        arguments.putString(AddChildFragment.ARG_ITEM_ID,
                getIntent().getStringExtra(AddChildFragment.ARG_ITEM_ID));
        AddChildFragment fragment = new AddChildFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
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
                loadSelectChildFragment();
                break;
            case R.id.action_add_child:
                loadAddChildFragment();
                break;
            case R.id.action_remove_child:
                loadRemoveChildFragment();
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
        BarGraphSeries<DataPoint> seriesSwith = new BarGraphSeries<>();
        List<SliceValue> pieData = new ArrayList<>();
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);

        switch (fragmentCounter) {
            case 2:
                pieData = new ArrayList<>();
                pieData.add(new SliceValue(34, Color.RED));
                pieData.add(new SliceValue(34, Color.GREEN));
                pieData.add(new SliceValue(20, Color.YELLOW));
                pieData.add(new SliceValue(54, Color.BLUE));
                pieData.add(new SliceValue(54, Color.GRAY));
                pieData.add(new SliceValue(54, Color.MAGENTA));

                seriesSwith = new BarGraphSeries<>(new DataPoint[]{
                        new DataPoint(0, 2),
                        new DataPoint(1, 4),
                        new DataPoint(2, 3),
                        new DataPoint(3, 5),
                        new DataPoint(4, 2),
                        new DataPoint(5, 3),
                        new DataPoint(6, 2)});
                graphView.getViewport().setMaxX(7);
                graphView.getViewport().setMinX(7);
                staticLabelsFormatter.setHorizontalLabels(new String[]{
                        "Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"});
                break;
            case 3:

                pieData = new ArrayList<>();
                pieData.add(new SliceValue(34, Color.RED));
                pieData.add(new SliceValue(34, Color.GREEN));
                pieData.add(new SliceValue(20, Color.YELLOW));
                pieData.add(new SliceValue(54, Color.BLUE));
                pieData.add(new SliceValue(20, Color.GRAY));
                pieData.add(new SliceValue(54, Color.MAGENTA));

                seriesSwith = new BarGraphSeries<>(new DataPoint[]{
                        new DataPoint(0, 2),
                        new DataPoint(1, 4),
                        new DataPoint(2, 3),
                        new DataPoint(6, 2)});
                graphView.getViewport().setMaxX(4);
                graphView.getViewport().setMinX(4);
                staticLabelsFormatter.setHorizontalLabels(new String[]{
                        "Week - 1", "Week - 2", "Week - 3", "Week - 4"});
                break;
            case 4: //load weekly data

                pieData = new ArrayList<>();
                pieData.add(new SliceValue(34, Color.RED));
                pieData.add(new SliceValue(34, Color.GREEN));
                pieData.add(new SliceValue(20, Color.YELLOW));
                pieData.add(new SliceValue(54, Color.BLUE));
                pieData.add(new SliceValue(20, Color.GRAY));
                pieData.add(new SliceValue(54, Color.MAGENTA));

                seriesSwith = new BarGraphSeries<>(new DataPoint[]{
                        new DataPoint(0, 2),
                        new DataPoint(1, 4),
                        new DataPoint(2, 3),
                        new DataPoint(3, 5),
                        new DataPoint(4, 2),
                        new DataPoint(5, 3),
                        new DataPoint(6, 4),
                        new DataPoint(7, 3),
                        new DataPoint(8, 5),
                        new DataPoint(9, 2),
                        new DataPoint(10, 3),
                        new DataPoint(11, 2)});
                graphView.getViewport().setMaxX(12);
                graphView.getViewport().setMinX(12);
                staticLabelsFormatter.setHorizontalLabels(new String[]{
                        "Jan", "Feb", "Mar", "Apr", "May", "June",
                        "July", "Aug", "Sep", "Oct", "Nov", "Dec"});
                break;
            case 1:
                break;
        }


        PieChartData pieChartData = new PieChartData(pieData);

        pieChartView.setPieChartData(pieChartData);

        graphView.addSeries(seriesSwith);

        //StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        // staticLabelsFormatter.setHorizontalLabels(new String[]{"Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"});

        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graphView.getViewport().setXAxisBoundsManual(true);
    }


    public static class AddFoodFragment extends Fragment implements View.OnClickListener {
        public static final String ARG_ITEM_ID = "item_id";
        AddFoodListAdapter listAdapter;
        RecyclerView recyclerView;
        Button btnMealBreakfast;
        Button btnMealLunch;
        Button btnMealDinner;
        Button btnSubmitFood;
        Boolean foodGroupSelected = false;

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
            btnMealBreakfast = rootView.findViewById(R.id.meal_type_breakfast);
            btnMealLunch = rootView.findViewById(R.id.meal_type_lunch);
            btnMealDinner = rootView.findViewById(R.id.meal_type_dinner);
            btnSubmitFood = rootView.findViewById(R.id.btn_submit_add_food);


            btnSubmitFood.setOnClickListener(this);
            {


                btnMealBreakfast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnMealBreakfast.setBackgroundResource(R.color.colorAccent);
                        btnMealLunch.setBackgroundResource(R.color.colorPrimary);
                        btnMealDinner.setBackgroundResource(R.color.colorPrimary);
                        Parent.setMealIndex(Constants.MEAL_TYPE_BREAKFAST);
                        foodGroupSelected = true;
                    }
                });

                btnMealLunch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnMealBreakfast.setBackgroundResource(R.color.colorPrimary);
                        btnMealLunch.setBackgroundResource(R.color.colorAccent);
                        btnMealDinner.setBackgroundResource(R.color.colorPrimary);
                        Parent.setMealIndex(Constants.MEAL_TYPE_LUNCH);
                        foodGroupSelected = true;
                    }
                });

                btnMealDinner.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnMealBreakfast.setBackgroundResource(R.color.colorPrimary);
                        btnMealLunch.setBackgroundResource(R.color.colorPrimary);
                        btnMealDinner.setBackgroundResource(R.color.colorAccent);
                        Parent.setMealIndex(Constants.MEAL_TYPE_DINNER);
                        foodGroupSelected = true;
                    }
                });

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

        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ChildDao.AddFood(Constants.ADD_FOOD_ARRAY);
                    Constants.ClearFoodArray();
                }
            }).start();
        }
    }


    public static class DailyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        TextView tvCurrentChildName;
        TextView tvMealType;
        TextView tvTimeFrame;

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
            tvCurrentChildName = rootView.findViewById(R.id.section_label);
            tvMealType = rootView.findViewById(R.id.tv_meal_type);
            tvTimeFrame = rootView.findViewById(R.id.tv_history_time);
            tvCurrentChildName.setText(ChildDao.getCurrentChild().getName());
            tvMealType.setText(Constants.MEAL_TYPES[Parent.getMealIndex()]);
            tvTimeFrame.setText("Daily");
            loadHistoryData();


            return rootView;
        }
    }

    public static class WeeklyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        TextView tvCurrentChildName;
        TextView tvMealType;
        TextView tvTimeFrame;

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
            tvCurrentChildName = rootView.findViewById(R.id.section_label);
            tvMealType = rootView.findViewById(R.id.tv_meal_type);
            tvTimeFrame = rootView.findViewById(R.id.tv_history_time);
            tvCurrentChildName.setText(ChildDao.getCurrentChild().getName());
            tvMealType.setText(Constants.MEAL_TYPES[Parent.getMealIndex()]);
            tvTimeFrame.setText("Weekly");
            loadHistoryData();

            return rootView;
        }
    }

    public static class MonthlyHistoryFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        TextView tvCurrentChildName;
        TextView tvMealType;
        TextView tvTimeFrame;

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
            tvCurrentChildName = rootView.findViewById(R.id.section_label);
            tvMealType = rootView.findViewById(R.id.tv_meal_type);
            tvTimeFrame = rootView.findViewById(R.id.tv_history_time);
            graphView = rootView.findViewById(R.id.gv_line_graph);
            pieChartView = rootView.findViewById(R.id.pc_pie_chart);

            tvCurrentChildName.setText(ChildDao.getCurrentChild().getName());
            tvMealType.setText(Constants.MEAL_TYPES[Parent.getMealIndex()]);
            tvTimeFrame.setText("Monthly");
            loadHistoryData();

            return rootView;
        }
    }

    public static class AddChildFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        Button btnAddChild;
        EditText etAddChild;

        public AddChildFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_add_child, container, false);
            btnAddChild = rootView.findViewById(R.id.button_add_child_fragment);
            etAddChild = rootView.findViewById(R.id.et_add_child_fragment);

            btnAddChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ChildDao.addChild(new Child(etAddChild.getText().toString(), ChildDao.getHighestId() + 1));
                            ChildDao.importChildrenFromDb();
                        }
                    }).start();
                    Toast.makeText(rootView.getContext(), etAddChild.getText().toString() + "  Has Been Added", Toast.LENGTH_SHORT).show();
                    etAddChild.setText("");
                }
            });
            return rootView;
        }
    }

    public static class RemoveChildFragment extends Fragment {
        public static final String ARG_ITEM_ID = "item_id";
        RemoveChildListAdapter listAdapter;
        RecyclerView recyclerView;

        public RemoveChildFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_remove_child, container, false);
            recyclerView = rootView.findViewById(R.id.recycler_view_remove_child);
            recyclerView.setHasFixedSize(true);
            listAdapter = new RemoveChildListAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());

            recyclerView.setAdapter(listAdapter);
            recyclerView.setLayoutManager(layoutManager);
            return rootView;
        }
    }

    public static class SelectChildFragment extends Fragment {

        public static final String ARG_ITEM_ID = "item_id";
        SelectChildListAdapter listAdapter;
        RecyclerView recyclerView;

        public SelectChildFragment() {
        }

        @Nullable
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_select_child, container, false);
            recyclerView = rootView.findViewById(R.id.recycler_view_select_child);
            recyclerView.setHasFixedSize(true);
            listAdapter = new SelectChildListAdapter();
            LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(listAdapter);

            return rootView;
        }
    }


}


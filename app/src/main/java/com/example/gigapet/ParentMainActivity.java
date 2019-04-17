package com.example.gigapet;

import android.support.v7.app.AppCompatActivity;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONObject;

import java.util.zip.Inflater;

public class ParentMainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private static int spinnerChildCurrentSelection;
    private static int spinnerMealTypeCurrentSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_parent_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static class PlaceholderFragment extends Fragment {
        static GraphView graphView;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public static void loadHistoryData(int mealPos, int childPos) {
            //TODO: pull in history data based on currentChildIndex
            JSONObject jsonObject =  ChildDao.getFoodHistory(mealPos, childPos);
            switch (mealPos) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0,2),
                    new DataPoint(1,4),
                    new DataPoint(2,3),
                    new DataPoint(3,5),
                    new DataPoint(4,2),
                    new DataPoint(5,3),
                    new DataPoint(6,2)
            });

            LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0,1),
                    new DataPoint(1,6),
                    new DataPoint(2,2),
                    new DataPoint(3,3),
                    new DataPoint(4,6),
                    new DataPoint(5,2),
                    new DataPoint(6,1)
            });
            graphView.addSeries(series1);
            graphView.addSeries(series2);
            graphView.getViewport().setMaxX(6);
            graphView.getViewport().setXAxisBoundsManual(true);
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            TextView textView;
            if (getArguments().getInt(ARG_SECTION_NUMBER) != 1) {
                rootView = inflater.inflate(R.layout.fragment_parent_history, container, false);
                textView = rootView.findViewById(R.id.tv_history_time);
                graphView = rootView.findViewById(R.id.gv_line_graph);

                loadHistoryData(setMealSpinner(rootView).getSelectedItemPosition(), setChildSpinner(rootView).getSelectedItemPosition());

                String fragmentTitle = "default";
                switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                    case 2:
                        fragmentTitle = "Daily";
                        break;
                    case 3:
                        fragmentTitle = "Weekly";
                        break;
                    case 4:
                        fragmentTitle = "Monthly";
                        break;
                }
                textView.setText(fragmentTitle);
                loadHistoryData(setMealSpinner(rootView).getSelectedItemPosition(), setChildSpinner(rootView).getSelectedItemPosition());
            } else {
                rootView = inflater.inflate(R.layout.fragment_parent_food_config, container, false);



                ImageView ivFruitPlus = rootView.findViewById(R.id.iv_button_fruit_plus);
                ImageView ivFruitMinus = rootView.findViewById(R.id.iv_button_fruit_minus);
                final TextView tvFruitNum = rootView.findViewById(R.id.tv_fruit);

                int[] food = ChildDao.getCurrentChild().getAllFood();
                tvFruitNum.setText(String.valueOf(food[Constants.FOOD_TYPE_FRUIT]));

                ivFruitPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvFruitNum.setText(String.valueOf(Integer.parseInt(tvFruitNum.getText().toString())+1));
                    }
                });

                ivFruitMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(Integer.parseInt(tvFruitNum.getText().toString()) > 0) {
                            tvFruitNum.setText(String.valueOf(Integer.parseInt(tvFruitNum.getText().toString()) - 1));
                        }
                    }
                });


                ImageView ivVeggiePlus = rootView.findViewById(R.id.iv_button_veggie_plus);
                ImageView ivVeggieMinus = rootView.findViewById(R.id.iv_button_veggie_minus);
                TextView tvVeggieNum = rootView.findViewById(R.id.tv_veggie);

                ImageView ivCarbPlus = rootView.findViewById(R.id.iv_button_carb_plus);
                ImageView ivCarbMinus = rootView.findViewById(R.id.iv_button_carb_minus);
                TextView tvCarbNum = rootView.findViewById(R.id.tv_carb);

                ImageView ivDairyPlus = rootView.findViewById(R.id.iv_button_dairy_plus);
                ImageView ivDairyMinus = rootView.findViewById(R.id.iv_button_dairy_minus);
                TextView tvDairyNum = rootView.findViewById(R.id.tv_dairy);

                ImageView ivProteinPlus = rootView.findViewById(R.id.iv_button_protein_plus);
                ImageView ivProteinMinus = rootView.findViewById(R.id.iv_button_protein_minus);
                TextView tvProteinNum = rootView.findViewById(R.id.tv_protein);

                ImageView ivTreatPlus = rootView.findViewById(R.id.iv_button_treat_plus);
                ImageView ivTreatMinus = rootView.findViewById(R.id.iv_button_treat_minus);
                TextView tvTreatNum = rootView.findViewById(R.id.tv_treat);




                Spinner childSpinner = setChildSpinner(rootView);
                Spinner mealSpinner = setMealSpinner(rootView);

            }
            return rootView;
        }

        public void updateFoodCount(){
            int[] food = ChildDao.getCurrentChild().getAllFood();
            //tvFruitNum.setText(String.valueOf(food[Constants.FOOD_TYPE_FRUIT]));
        }

        public Spinner setChildSpinner(final View root){
            final String[] namesArr = new String[Parent.getChildrensNamesAsArray().length + 1];
            for (int i = 0; i < Parent.getChildrensNamesAsArray().length; ++i) {
                namesArr[i] = Parent.getChildrensNamesAsArray()[i];
            }
            namesArr[Parent.getChildrensNamesAsArray().length] = "Add New Child";
            final ArrayAdapter<String> spinnerChildArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,namesArr);
            spinnerChildArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner spinner;
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                spinner = root.findViewById(R.id.spinner_child_select);
            }else{spinner = root.findViewById(R.id.spinner_child_select_history);}

            spinner.setAdapter(spinnerChildArrayAdapter);

            spinner.setSelection(spinnerChildCurrentSelection);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spinnerChildCurrentSelection = position;
                    if(position == namesArr.length-1){
                        final EditText etChildName = root.findViewById(R.id.et_add_child);
                        final Button button = root.findViewById(R.id.button_add_child);
                        //TODO: null object reference
                        etChildName.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ChildDao.addChild(new Child(etChildName.getText().toString(), ChildDao.getHighestId()+1));
                                Parent.setChildIndex(ChildDao.getHighestId());
                                button.setVisibility(View.GONE);
                                etChildName.setVisibility(View.GONE);
                                setChildSpinner(root);
                                spinnerChildArrayAdapter.notifyDataSetChanged();
                            }
                        });

                    }else {Parent.setChildIndex(position);}
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            return spinner;
        }

        public Spinner setMealSpinner(View root){
            final ArrayAdapter<String> spinnerMealArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,Constants.MEAL_TYPES);
            spinnerMealArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            final Spinner spinner;
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                spinner = root.findViewById(R.id.spinner_meal_type_food_config);
            }else{spinner = root.findViewById(R.id.spinner_meal_type);}
            spinner.setAdapter(spinnerMealArrayAdapter);
            spinner.setSelection(spinnerMealTypeCurrentSelection);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spinnerMealTypeCurrentSelection = position;
                    spinnerMealArrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            return spinner;
        }

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }



}

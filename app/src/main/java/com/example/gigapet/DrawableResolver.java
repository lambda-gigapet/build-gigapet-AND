package com.example.gigapet;

public class DrawableResolver {

    public static final int FRUIT = 1;
    public static final int VEGETABLE = 2;
    public static final int DAIRY = 3;
    public static final int CARBS = 4;
    public static final int PROTEIN = 5;
    public static final int SWEETS = 6;

    public static int[] getDrawableId(int category) {
        int[] drawable;
        try {
            switch (category) {
                case 0:
                    drawable = fruits;
                    break;
                case 1:
                    drawable = veggies;
                    break;
                case 2:
                    drawable = dairy;
                    break;
                case 3:
                    drawable = carbs;
                    break;
                case 4:
                    drawable = proteins;
                    break;
                case 5:
                    drawable = sweets;
                    break;
                default:
                    drawable = veggies;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            drawable = veggies;
        }
        return drawable;
    }

    public static int getDrawableIcon(int category) {
        int drawable;
        try {
            switch (category) {
                case 0:
                    drawable = R.drawable.fruit_icon;
                    break;
                case 1:
                    drawable = R.drawable.veggie_icon;
                    break;
                case 2:
                    drawable = R.drawable.dairy_icon;
                    break;
                case 3:
                    drawable = R.drawable.carbs_icon;
                    break;
                case 4:
                    drawable = R.drawable.protein_icon;
                    break;
                case 5:
                    drawable = R.drawable.protein_icon;
                    break;
                default:
                    drawable = R.drawable.protein_icon;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            drawable = R.drawable.protein_icon;
        }
        return drawable;
    }


    public static final int[] fruits = new int[]{
            R.drawable.fruit_apple};

    public static final int[] veggies = new int[]{
            R.drawable.fruit_banana};


    public static final int[] dairy = new int[]{
            R.drawable.fruit_blueberry};


    public static final int[] carbs = new int[]{
            R.drawable.fruit_cherry};

    public static final int[] proteins = new int[]{
            R.drawable.fruit_orange};

    public static final int[] sweets = new int[]{
            R.drawable.fruit_peach};

}



package com.example.nutritionscanner;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritionscanner.NutritionScannerUsers.Meal;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Meal> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView calories, fat, protein, carb, food_name;

        public MyViewHolder(View v) {
            super(v);
            calories = v.findViewById(R.id.item_calories);
            carb = v.findViewById(R.id.item_carb);
            protein = v.findViewById(R.id.item_protein);
            fat = v.findViewById(R.id.item_fat);
            food_name = v.findViewById(R.id.item_food_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Meal> myDataset) {
        System.out.println(mDataset);
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.food_name.setText(mDataset.get(position).getFoodName());
        holder.calories.setText("Calories:" + mDataset.get(position).getCalories());
        holder.carb.setText("Carbs:" + mDataset.get(position).getCarb());
        holder.fat.setText("Fat:" + mDataset.get(position).getFat());
        holder.protein.setText("Protien:" + mDataset.get(position).getProtein());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
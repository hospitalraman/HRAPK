package com.example.hrapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class country_adapter extends RecyclerView.Adapter<country_adapter.myViewHolder> {

    private final CountryData[] countryData;


    public country_adapter(CountryData[] countryData) {
        this.countryData = countryData;
    }
    @NonNull
    @Override
    public country_adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_countrycase,parent,false);
        return new country_adapter.myViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i ){
        i++;
        String stateName = countryData[i].getCountry();
        String confirmed = countryData[i].getConfirmed();
        String active = countryData[i].getActive();
        String recovered = countryData[i].getRecovered();
        String deaths = countryData[i].getDeaths();

        holder.name_of_the_country.setText(stateName);
        holder.confirmed_country.setText(confirmed);
        holder.active_country.setText(active);
        holder.recovered_country.setText(deaths);
        holder.deaths_country.setText(recovered);
    }

    @Override
    public int getItemCount() {
        return countryData.length-1;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView name_of_the_country,confirmed_country,active_country,recovered_country,deaths_country;
        public myViewHolder(@NonNull View itemView){
            super(itemView);

            name_of_the_country = itemView.findViewById(R.id.Name_of_country);
            confirmed_country = itemView.findViewById(R.id.confirmed_country);
            active_country = itemView.findViewById(R.id.active_country);
            recovered_country = itemView.findViewById(R.id.recovered_country);
            deaths_country = itemView.findViewById(R.id.deaths_country);


        }
    }

}





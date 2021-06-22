package com.example.hrapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class tnadapter extends RecyclerView.Adapter<tnadapter.myViewHolder> {

    private final String[] district_tn;
    private final String[] cases_tn;
    private final String[] active_tn;
    private final String[] recoverd_tn;
    public tnadapter(String[] district_tn, String[] cases_tn, String[] active_tn, String[] recovered_tn) {
        this.district_tn = district_tn;
        this.active_tn = active_tn;
        this.cases_tn = cases_tn;
        this.recoverd_tn = recovered_tn;
    }

    @NonNull
    @Override
    public tnadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_tamilnadu,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull tnadapter.myViewHolder holder, int position) {

        String tnName = district_tn[position];
        String confirmed_tn = cases_tn[position];
        String active_tamilnadu = active_tn[position];
        String recoverd_tamilnadu = recoverd_tn[position];


        holder.txt_distictname.setText(tnName);
        holder.txt_cases.setText(confirmed_tn);
        holder.txt_active.setText(active_tamilnadu);
        holder.txt_recovered.setText(recoverd_tamilnadu);


    }

    @Override
    public int getItemCount(){
        return district_tn.length;
    }


    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView txt_distictname,txt_cases,txt_active,txt_recovered;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            txt_distictname = itemView.findViewById(R.id.tamilnadu_dis);
            txt_cases = itemView.findViewById(R.id.confirmed_tn);
            txt_active = itemView.findViewById(R.id.active_tn);
            txt_recovered = itemView.findViewById(R.id.recovered_tn);


        }
    }







}

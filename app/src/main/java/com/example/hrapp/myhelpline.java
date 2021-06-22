package com.example.hrapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myhelpline extends RecyclerView.Adapter<myhelpline.myViewHolder> {

    private final helpLine[] helplines;

    public myhelpline(helpLine[] helplines) {
        this.helplines = helplines;

    }

    @NonNull
    @Override
    public myhelpline.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.helpline_layout,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
        //i++;
        String stateName_helpline = helplines[i].getStatename();
        String state_number_helpline = helplines[i].getStatename_num();
        holder.state_helpline.setText(stateName_helpline);
        holder.number_helpline.setText(state_number_helpline);

    }

    @Override
    public int getItemCount() {
        return helplines.length;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView state_helpline,number_helpline;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            state_helpline = itemView.findViewById(R.id.state_helpline_Name);
            number_helpline =itemView.findViewById(R.id.helpine_number_india);
        }

        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
            //deal with catstatus
        }
        public void onClick(View view){
        }

    }
}

package com.example.hrapp;
// adapter for displying the states...
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    private final StateData[] stateData;


    public myAdapter(StateData[] stateData) {
        this.stateData = stateData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_state,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder,int i ){
        i++;
        String stateName = stateData[i].getStateName();
        String confirmed = stateData[i].getConfirmed();
        String active = stateData[i].getActive();
        String recovered = stateData[i].getRecovered();
        String deaths = stateData[i].getDeaths();
        String lastupdatedtime = stateData[i].getLastupdatedtime();



        holder.Name_of_states.setText(stateName);
        holder.confirmed_states.setText(confirmed);
        holder.active_states.setText(active);
        holder.deaths_states.setText(deaths);
        holder.recovered_states.setText(recovered);
        holder.txtdate_updated.setText(lastupdatedtime);

    }


    @Override
    public int getItemCount() {
        return stateData.length-1;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        TextView confirmed_states,active_states,recovered_states,deaths_states,Name_of_states,txtdate_updated;
        public myViewHolder(@NonNull View itemView){
            super(itemView);

            confirmed_states = itemView.findViewById(R.id.confirmed_states);
            active_states = itemView.findViewById(R.id.active_states);
            deaths_states = itemView.findViewById(R.id.deaths_states);
            Name_of_states = itemView.findViewById(R.id.Name_of_state);
            txtdate_updated = itemView.findViewById(R.id.txtdate_updated);
            recovered_states = itemView.findViewById(R.id.recovered_state);


        }
    }
}

package bkonecsni.plsocers.ui.livematches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.api.Fixture;
import bkonecsni.plsocers.model.api.Result;

public class LiveMatchesAdapter extends RecyclerView.Adapter<LiveMatchesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Fixture> fixtureList;

    public LiveMatchesAdapter(Context context, ArrayList<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    public LiveMatchesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.match_row, viewGroup, false);
        return new LiveMatchesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LiveMatchesAdapter.ViewHolder holder, int position) {
        Fixture fixture = fixtureList.get(position);

        holder.tvDate.setText(fixture.getDate());
        holder.tvStatus.setText(fixture.getStatus());
        holder.tvHomeTeam.setText(fixture.getHomeTeamName());
        holder.tvAwayTeam.setText(fixture.getAwayTeamName());

        Result result = fixture.getResult();
        holder.tvHomeTeamGoals.setText(result == null ? "-" : result.getGoalsHomeTeam());
        holder.tvAwayTeamGoals.setText(result == null ? "-" : result.getGoalsAwayTeam());
    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvStatus;
        TextView tvHomeTeam;
        TextView tvAwayTeam;
        TextView tvHomeTeamGoals;
        TextView tvAwayTeamGoals;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            tvHomeTeam = (TextView) itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeam = (TextView) itemView.findViewById(R.id.tvAwayTeam);
            tvHomeTeamGoals = (TextView) itemView.findViewById(R.id.tvHomeTeamGoals);
            tvAwayTeamGoals = (TextView) itemView.findViewById(R.id.tvAwayTeamGoals);
        }
    }
}
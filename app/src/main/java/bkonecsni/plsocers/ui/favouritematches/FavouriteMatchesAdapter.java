package bkonecsni.plsocers.ui.favouritematches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bkonecsni.plsocers.R;
import bkonecsni.plsocers.model.db.FavouriteMatch;

public class FavouriteMatchesAdapter extends RecyclerView.Adapter<FavouriteMatchesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FavouriteMatch> favouriteMatchList;

    public FavouriteMatchesAdapter(Context context, ArrayList<FavouriteMatch> favouriteMatchList) {
        this.context = context;
        this.favouriteMatchList = favouriteMatchList;
    }

    public FavouriteMatchesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.match_row, viewGroup, false);
        return new FavouriteMatchesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavouriteMatchesAdapter.ViewHolder holder, int position) {
        FavouriteMatch favouriteMatch = favouriteMatchList.get(position);

        String[] dateAndTime = favouriteMatch.getDate().split("T");
        holder.tvDate.setText(dateAndTime[0]);
        holder.tvTime.setText(dateAndTime[1].substring(0,dateAndTime[1].lastIndexOf(":")));

        holder.tvDate.setText(favouriteMatch.getDate());
        holder.tvHomeTeam.setText(favouriteMatch.getHomeTeamName());
        holder.tvAwayTeam.setText(favouriteMatch.getAwayTeamName());
        holder.tvHomeTeamGoals.setText(String.valueOf(favouriteMatch.getHomeTeamGoals()));
        holder.tvAwayTeamGoals.setText(String.valueOf(favouriteMatch.getAwayTeamGoals()));
    }

    @Override
    public int getItemCount() {
        return favouriteMatchList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvTime;
        TextView tvHomeTeam;
        TextView tvAwayTeam;
        TextView tvHomeTeamGoals;
        TextView tvAwayTeamGoals;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvHomeTeam = (TextView) itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeam = (TextView) itemView.findViewById(R.id.tvAwayTeam);
            tvHomeTeamGoals = (TextView) itemView.findViewById(R.id.tvHomeTeamGoals);
            tvAwayTeamGoals = (TextView) itemView.findViewById(R.id.tvAwayTeamGoals);
        }
    }
}
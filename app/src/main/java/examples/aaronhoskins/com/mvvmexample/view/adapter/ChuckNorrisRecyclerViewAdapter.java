package examples.aaronhoskins.com.mvvmexample.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import examples.aaronhoskins.com.mvvmexample.R;
import examples.aaronhoskins.com.mvvmexample.model.chucknorris.ChuckNorris;

public class ChuckNorrisRecyclerViewAdapter extends RecyclerView.Adapter<ChuckNorrisRecyclerViewAdapter.ViewHolder> {
    ChuckNorris chuckNorris;

    public ChuckNorrisRecyclerViewAdapter(ChuckNorris chuckNorris) {
        this.chuckNorris = chuckNorris;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chuck_norris_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String joke = chuckNorris.getValue().get(position).getJoke();
        holder.tvJoke.setText(joke);
    }

    @Override
    public int getItemCount() {
        return chuckNorris.getValue().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJoke;
        public ViewHolder(View itemView) {
            super(itemView);
            tvJoke = itemView.findViewById(R.id.tvJoke);
        }
    }
}

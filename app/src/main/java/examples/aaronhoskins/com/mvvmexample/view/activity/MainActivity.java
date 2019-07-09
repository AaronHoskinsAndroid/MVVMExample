package examples.aaronhoskins.com.mvvmexample.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import examples.aaronhoskins.com.mvvmexample.R;
import examples.aaronhoskins.com.mvvmexample.databinding.ActivityMainBinding;
import examples.aaronhoskins.com.mvvmexample.model.chucknorris.ChuckNorris;
import examples.aaronhoskins.com.mvvmexample.view.adapter.ChuckNorrisRecyclerViewAdapter;
import examples.aaronhoskins.com.mvvmexample.viewmodel.ChuckNorrisViewModel;

public class MainActivity extends AppCompatActivity {
    ChuckNorrisViewModel chuckNorrisViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chuckNorrisViewModel = new ChuckNorrisViewModel();
        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewmodel(chuckNorrisViewModel);
        chuckNorrisViewModel.getChuckNorrisData();
    }

    @BindingAdapter("bind:chuckNorris")
    public static void initRecyclerView(RecyclerView recyclerView, ChuckNorris chuckNorris){
        if(chuckNorris != null) {
            ChuckNorrisRecyclerViewAdapter adapter = new ChuckNorrisRecyclerViewAdapter(chuckNorris);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }

}

package examples.aaronhoskins.com.mvvmexample.viewmodel;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import examples.aaronhoskins.com.mvvmexample.model.chucknorris.ChuckNorris;
import examples.aaronhoskins.com.mvvmexample.model.datasource.remote.ButtKickingObserver;
import examples.aaronhoskins.com.mvvmexample.model.datasource.remote.CallBack;
import examples.aaronhoskins.com.mvvmexample.model.datasource.remote.RetrofitHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ChuckNorrisViewModel extends ViewModel
        implements CallBack, Observable {
    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @Bindable
    public ChuckNorris chuckNorris;
    public String chuckNorrisName = "Chuck Norris";

    public void getChuckNorrisData() {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getButtKickingService()
                .getRandomJokes("5")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ButtKickingObserver(this));
    }

    @Override
    public void onButtKickingResult(ChuckNorris chuckNorris) {
        this.chuckNorris = chuckNorris;
        notifyOfAllPropertiesChanged();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }

    public void notifyOfAllPropertiesChanged() {
        propertyChangeRegistry.notifyChange(this, 0);
    }

    public void notifyOfSinglePropertyChange(int fieldId) {
        propertyChangeRegistry.notifyChange(this, fieldId);
    }

    public ChuckNorris getChuckNorris() {
        return chuckNorris;
    }

    public void setChuckNorris(ChuckNorris chuckNorris) {
        this.chuckNorris = chuckNorris;
    }
}

package examples.aaronhoskins.com.mvvmexample.model.datasource.remote;

import android.util.Log;

import examples.aaronhoskins.com.mvvmexample.model.chucknorris.ChuckNorris;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ButtKickingObserver implements Observer<ChuckNorris> {
    CallBack callback;
    ChuckNorris chuckNorris;

    public ButtKickingObserver(CallBack callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ChuckNorris chuckNorris) {
        this.chuckNorris = chuckNorris;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "onError: CHUCK NORRIS HAS FAILED", e);
    }

    @Override
    public void onComplete() {
        callback.onButtKickingResult(chuckNorris);
    }
}

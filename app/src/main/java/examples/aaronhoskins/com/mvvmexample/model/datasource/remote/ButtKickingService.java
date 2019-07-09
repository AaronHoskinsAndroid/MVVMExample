package examples.aaronhoskins.com.mvvmexample.model.datasource.remote;

import examples.aaronhoskins.com.mvvmexample.model.chucknorris.ChuckNorris;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ButtKickingService {
    @GET("jokes/random/{count}")
    Observable<ChuckNorris> getRandomJokes(@Path("count") String count);
}

package bkonecsni.plsocers.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String ENDPOINT_ADDRESS = "http://api.football-data.org/v1/";

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    public FootballDataApi provideFootballDataApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(ENDPOINT_ADDRESS).build().create(FootballDataApi.class);
    }
}
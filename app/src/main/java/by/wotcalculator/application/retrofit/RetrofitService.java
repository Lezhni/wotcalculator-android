package by.wotcalculator.application.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "http://api.worldoftanks.ru/wot/";

    private static final String API_APP_ID = "0b0439f85486bd0f964f5af92eb7b3af";

    public static TankopediaAPI getTankopediaApi() {
        return getInstance().create(TankopediaAPI.class);
    }

    private static Retrofit getInstance() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ImplementAppIdInterceptor())
                .build();
        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static class ImplementAppIdInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();
            HttpUrl url = originalHttpUrl
                    .newBuilder()
                    .addQueryParameter("application_id", API_APP_ID)
                    .build();
            Request.Builder requestBuilder = original
                    .newBuilder()
                    .url(url);
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }
}

package com.stevehechio.apps.payoneer;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevehechio on 8/5/21
 */

@RunWith(JUnit4.class)
public class ApiAbstract<T> {
    private MockWebServer mockWebServer;

    @Before
    public void mockServer() throws IOException {
      mockWebServer = new MockWebServer();
      mockWebServer.start();
    }




    public void enqueueResponse(String fileName) throws IOException {
        InputStream inputStream = Objects.requireNonNull(ApiAbstract.class.getClassLoader())
                .getResourceAsStream(String.format("api-response/%s", fileName));
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        mockWebServer.enqueue(mockResponse.setBody(source.readString(StandardCharsets.UTF_8)));
    }

    public T createService(Class<T> clazz){
        return new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(clazz);
    }

    @After
    public void closeServer() throws IOException {
        mockWebServer.shutdown();
    }

}

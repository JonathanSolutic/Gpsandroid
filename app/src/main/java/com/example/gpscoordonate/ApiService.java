package com.example.gpscoordonate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/gps")
    Call<GpsCoordinate> sendGpsCoordinates(@Body GpsCoordinate gpsCoordinate);
}

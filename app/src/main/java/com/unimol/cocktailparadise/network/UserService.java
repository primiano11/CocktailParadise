package com.unimol.cocktailparadise.network;

import com.unimol.cocktailparadise.models.LoginDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET
    Call<LoginDTO> login(String mail, String password);

}

package com.example.spring160.services;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class CurrencyService {
    public double getUsdPrice(int bynPrice) throws Exception{
        double usdPrice = 0;

        URL url = new URL("https://www.nbrb.by/api/exrates/rates/usd?parammode=2");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(url.openStream())
        );
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        double course =
                Double.parseDouble(jsonObject.getString("Cur_OfficialRate").toString());
        usdPrice = bynPrice/course;
        return usdPrice;
    }
    public double getEurPrice(int bynPrice) throws Exception{
        double eurPrice = 0;

        URL url = new URL("https://www.nbrb.by/api/exrates/rates/eur?parammode=2");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(url.openStream())
        );
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        double course =
                Double.parseDouble(jsonObject.getString("Cur_OfficialRate").toString());
        eurPrice = bynPrice/course;
        return eurPrice;
    }
}

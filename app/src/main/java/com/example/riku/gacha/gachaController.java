package com.example.riku.gacha;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by riku on 2015/10/25.
 */
public class gachaController {
    public String TAG = "gachaController";
    public double border;
    public static String[] job = {"剣"};

    public gachaController(double mborder){
        border = mborder;
    }


    public int selectStar(){
        double n;
        int no;
        n = Math.random();

        if( n <= border ){
            no = 4;
        }else if(border <= n && n <= 0.4){
            no = 3;
        }else{
            no = 2;
        }
        Log.d(TAG, "星" + n);

        return no;
    }

    public static String selectType(){
        int min = 0;
        int max = 0;
        int n;

        n = (int)( Math.random() * 10000 ) % (max - min + 1 );

        return job[n];
    }

    public HashMap resultGacha(){
        String result = null;
        HashMap gachaResult = new HashMap();

        int rank = selectStar();
        result = "星" + rank + " " + selectType();

        gachaResult.put("str", result);
        gachaResult.put("rank", rank);

        return gachaResult;
    }
}

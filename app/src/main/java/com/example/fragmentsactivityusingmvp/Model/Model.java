package com.example.fragmentsactivityusingmvp.Model;

import com.example.fragmentsactivityusingmvp.Util.Contract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import android.os.Handler;

public class Model implements Contract.Model {

    private List<String> arrayList = Arrays.asList(
            "DIA_DEV_TS-09 : Acquérir les bases de développement Android",
            "DIA_DEV_TS-10 : Programmer en KOTLIN",
            "DIA_DEV_TS-11 : Découvrir la gestion de projet",
            "DIA_DEV_TS-12 : S’initier aux composants et modèle d’une application Android",
            "DIA_DEV_TS-13 : Développer des interfaces utilisateurs sous Android",
            "DIA_DEV_TS-14 : Elaborer une application Android sécurisée",
            "DIA_DEV_TS-15 : Découvrir les bases de développement des applications IOS",
            "DIA_DEV_TS-16 : Découvrir les bases de développement multiplateforme");
    @Override
    public void getNextCourse(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getRandomString());
            }
        }, 2000);
    }

    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}

package com.stevehechio.apps.payoneer.ui.activities;


import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by stevehechio on 8/5/21
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void appLaunchesWithoutCrash(){
        ActivityScenario.launch(MainActivity.class);
    }
}
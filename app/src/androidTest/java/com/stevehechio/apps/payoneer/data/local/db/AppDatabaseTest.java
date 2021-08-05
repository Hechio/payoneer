package com.stevehechio.apps.payoneer.data.local.db;

import static org.junit.Assert.*;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Created by stevehechio on 8/5/21
 */

@RunWith(AndroidJUnit4ClassRunner.class)
public abstract class AppDatabaseTest {
    protected AppDatabase database;

    @Before
    public void setUp()  {
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                AppDatabase.class).build();
    }

    @After
    public void tearDown() {
        database.close();
    }
}
package com.stevehechio.apps.payoneer.data;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by stevehechio on 8/5/21
 */
@RunWith(JUnit4.class)
public class ResourceTest {

    @Test
    public void success(){
        Resource resource = Resource.success("payoneer");
        Assert.assertEquals("payoneer",resource.data);
        Assert.assertEquals(Status.SUCCESS,resource.status);
    }

    @Test
    public void error(){
        Exception exception = new Exception("payoneer");
        Resource resource = Resource.error(exception.getMessage(),exception);
        Assert.assertEquals("payoneer",resource.message);
        Assert.assertEquals(Status.ERROR,resource.status);
    }


}
package test2;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ServiceLoader;

import static org.testng.Assert.assertEquals;

public class Start {

    @AfterMethod
    public void afterMethod(ITestResult result) {
        ServiceLoader<ITestListener> serviceLoader = ServiceLoader.load(ITestListener.class);
        serviceLoader.findFirst().get().onTestSuccess(result);
    }

    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() {
        assertEquals(1, 1);
    }


}

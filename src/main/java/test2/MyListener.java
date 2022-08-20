package test2;

import com.google.auto.service.AutoService;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.lang.reflect.Method;

@AutoService(ITestListener.class)
public class MyListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        try {
            Method methodReal = method.getRealClass().getMethod(result.getName());
            TestMethodInfo annotations = methodReal.getAnnotation(TestMethodInfo.class);
            System.out.println(annotations.priority());
            System.out.println(annotations.author());
            System.out.println(annotations.lastModified());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

package test2;

import com.google.auto.service.AutoService;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

@AutoService(ITestListener.class)
public class ListenerTest implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Method methodReal = result.getMethod().getRealClass().getMethod(result.getName());
            TestMethodInfo annotations = methodReal.getAnnotation(TestMethodInfo.class);
            System.out.println(annotations.priority());
            System.out.println(annotations.author());
            System.out.println(annotations.lastModified());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

package test1;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MethodInterception {

    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {
        MainPage mainPageImp = new MainPageImp();
        return (MainPage) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                mainPageImp.getClass().getInterfaces(),
                new Handler(mainPageImp));
    }
}

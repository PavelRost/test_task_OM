package test1;

public class MainPageImp implements MainPage {

    @Override
    public String textInputSearch() {
        return ".//*[@test-attr='input_search']";
    }

    @Override
    public String buttonSearch() {
        return ".//*[@test-attr='button_search']";
    }
}

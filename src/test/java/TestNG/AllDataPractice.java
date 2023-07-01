package TestNG;

import org.testng.annotations.DataProvider;

public class AllDataPractice {
    @DataProvider(name = "couples")
    public Object [][] getData(){
        return new Object[][]{
                {"Ahmet", "Leyla", " Brown"},
                {"Anna", "Ivan", " Blue"},
                {"Mavlen", "Ayse", " Black"},
                {"Zinah", "Ozan", " Blue"},
                {"Nazgul", "Nurik", " Black"}
        };
    }
}

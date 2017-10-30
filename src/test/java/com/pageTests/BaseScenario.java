package com.pageTests;

import com.specs.SpecWithPageStoreImpl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class BaseScenario {

    WebDriver driver;
    PageStore pageStore;
    SpecWithPageStoreImpl user;
    String url = "https://www.cleartrip.com/";


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        pageStore = new PageStore();
        user = new SpecWithPageStoreImpl(pageStore);
        driver = pageStore.getDriver();
        driver.get(url);
        System.out.println("----Inside Before Method-------");
        driver.manage().window().maximize();
        System.out.println("-----Driver maximizes the window-----");
    }

    protected <T extends SpecWithPageStoreImpl> T given(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImpl> T when(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImpl> T then(T dsl) {
        return dsl;
    }

    protected <T extends SpecWithPageStoreImpl> T and(T dsl) {
        return dsl;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result){
        captureScreenShotInCaseOfFailure(result);
        pageStore.destroy();
        System.out.println("------Inside After Method-------");
    }


    protected void captureScreenShotInCaseOfFailure(ITestResult result) {
        if (result.isSuccess()) {
            return;
        }
        String screenShotFolder = "screenshots";
        File screenShotSourceFile = ((TakesScreenshot) pageStore.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            createFolder(screenShotFolder);
            String fileName = result.getMethod().getMethodName();
            File screenShotTargetFile = getTargetFile(screenShotFolder, fileName, "png");
            FileUtils.copyFile(screenShotSourceFile, screenShotTargetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFolder(String folderName) throws IOException {
        if (!(new File(folderName).exists())) new File(folderName).mkdir();
    }

    private File getTargetFile(String folderName, String fileName, String ext) throws IOException {
        String rootPath = new File(".").getCanonicalPath();
        String fullPath = String.format("%s//%s//%s.%s", rootPath, folderName, fileName, ext);
        return new File(fullPath);
    }
}





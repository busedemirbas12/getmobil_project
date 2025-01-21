package com.getmobil;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.getmobil.BaseTest.driver;

public class BaseClass {
    public WebElement element;
    public WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void goToUrl(String url) {
        driver.get(url);
        Logger.info("Opened Website:" + url);
    }

    public boolean isElementVisible(By by) {
        boolean flag;
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            flag = true;
        } catch (NoSuchElementException | TimeoutException n) {
            System.out.println("Element is invisible");
            flag = false;
        }
        return flag;
    }

    public void assertTrue(boolean assertion, String message) {
        Assert.assertTrue(assertion, message);
    }

    public void assertEquals(String actual, String excepted, String message) {
        Assert.assertEquals(actual, excepted, message);
    }

    public boolean isElementClickable(By by) {
        boolean flag;
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
            flag = true;
        } catch (ElementClickInterceptedException | TimeoutException n) {
            System.out.println("Element is unclickable");
            flag = false;
        }
        return flag;
    }

    public void clickElement(By by) {
        findElement(by).click();
        Logger.info("Elemente tıklandı.");
    }

    public void clickElementWithJs(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void clickWebElementWithJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void sendKeys(String value, By by) {
        WebElement send = driver.findElement(by);
        send.click();
        send.sendKeys(value);
        Logger.info("Value written " + value);
    }

    public void sendKeysWithWebElement(String value, WebElement element) {
        element.click();
        element.sendKeys(value);
        Logger.info("Value written " + value);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void scrollToElement(By by) {
        WebElement scrollElement = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.scrollToElement(scrollElement).perform();
    }

    public Integer getRandomNumber(int beginIndex, int endIndex) {
        return (int) Math.floor(Math.random() * (endIndex - beginIndex + 1) + beginIndex);
    }

    public void waitSecondsPageLoading(int second) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(second));
    }

    public void waitSeconds(long second) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public void getFindElementsList(By findElements, By findElement, String name) {
        List<WebElement> list = findElements(findElements);
        for (WebElement webElement : list) {
            element = webElement.findElement(findElement);
            if (name.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}


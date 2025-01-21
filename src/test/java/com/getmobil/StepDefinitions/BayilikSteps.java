package com.getmobil.StepDefinitions;

import com.getmobil.BaseClass;
import com.getmobil.Logger;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.getmobil.PageVariables.*;

public class BayilikSteps extends BaseClass {

    @When("{string} sayfası açılır")
    public void sayfasiAcilir(String pageName) {
        getFindElementsList(ANASAYFA_BUTON_LIST, ANASAYFA_BUTON_LIST_NAME, pageName);
        String url = getUrl();
        waitSeconds(5);
        assertEquals(url, BAYILIK_URL, pageName + " Sayfası Açılmadı. Açılan Sayfa: " + url);
    }

    @Then("Başvuru formu açılır")
    public void basvuruFormuAcilir() {
        assertTrue(isElementVisible(SIFIR_BAYILIK_BASVUR_BTN), "Hemen Başvur Buton Görüntülenemedi!");
        clickElementWithJs(SIFIR_BAYILIK_BASVUR_BTN);
        assertTrue(isElementVisible(BAYILIK_BASVURU_FORM), "Başvuru Formu Görüntülenemedi!");
        String getText = findElement(BAYILIK_BASVURU_FORM).getText();
        assertEquals(getText, BAYILIK_BASVURU_FORM_TXT, "Bayilik Başvuru Formu Text Hatası!");
    }

    public void createFormFranchise(String name, String surname, String phone, String mail, String job) {
        List<WebElement> elementList = findElements(FORM_TEXT_LIST);
        String formText;
        WebElement formTextInput;
        for (WebElement webElement : elementList) {
            formText = webElement.findElement(FORM_TEXT_LIST_LABEL).getText().replace("*", "");
            formTextInput = webElement.findElement(FORM_TEXT_LIST_INPUT);
            switch (formText) {
                case "Adınız" -> sendKeysWithWebElement(name, formTextInput);
                case "Soyadınız" -> sendKeysWithWebElement(surname, formTextInput);
                case "Telefon numaranız" -> sendKeysWithWebElement(phone, formTextInput);
                case "e-Posta adresiniz" -> sendKeysWithWebElement(mail, formTextInput);
                case "Mesleğiniz" -> sendKeysWithWebElement(job, formTextInput);
                default -> Logger.info("Yanlış Değer Girdiniz!");
            }
        }
    }

    @Then("Form doldurulur")
    public void formDoldurulur() {
        createFormFranchise("Buse", "Demirbas", "555 555 55 55", "busedemirbas8@gmail.com", "Software Tester");
        clickElement(BAYILIK_IL_BTN);
        findElements(BAYILIK_FORMLIST).get(0).click();
        clickElement(BAYILIK_ILCE_BTN);
        findElements(BAYILIK_FORMLIST).get(0).click();
        clickElement(BAYILIK_SEMT_BTN);
        findElements(BAYILIK_FORMLIST).get(0).click();
        sendKeys("Bayilik Basvuru", BAYILIK_BASVURU_ACIKLAMA);
    }


    @Then("Talep oluşturulur")
    public void talepOlusturulur() {
        assertTrue(isElementVisible(BAYILIK_BASVURU_GONDER_BUTON), "Gönder Butonu Görüntülenemedi!");
        clickElement(BAYILIK_BASVURU_GONDER_BUTON);
    }

    @Then("Talep başarıyla gönderilir")
    public void talepBasariylaGonderilir() {
        assertTrue(isElementVisible(TALEP_MSG), "Talep Başarılı Popup Görüntülenemedi!");
        assertEquals(getText(TALEP_MSG), BASARILI_TALEP_MSG_TXT, "Talep Formu Gonderilemedi!");
    }

    @Then("Talebin hatalı olduğu görüntülenir")
    public void talebinHataliOlduguGoruntulenir() {
        if (isElementVisible(TALEP_MSG)) {
            //Hatalı çalışması bekleniyor.
            assertEquals(getText(TALEP_MSG), BASARISIZ_TALEP_MSG_TXT, "Talep Başarısız Beklenirken Hatalı Gönderildi!");
        } else {
            assertTrue(isElementVisible(TALEP_MSG), "Talebiniz Oluşturuldu Popup Görüntülenemedi");
        }
    }
}

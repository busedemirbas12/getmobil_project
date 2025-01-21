package com.getmobil.StepDefinitions;

import com.getmobil.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.getmobil.PageVariables.*;

public class TelefonSatSamsungSteps extends BaseClass {
    @Given("Anasayfa açılır")
    public void anaSayfaAcilir() {
        goToUrl(BASE_URL);
        if (isElementVisible(COOKIE)) {
            clickElement(COOKIE);
        }
    }

    /**
     * Dropdown menüye tıklar ve rastgele bir marka seçer.
     *
     * @param brand Satılmak istenen telefonun markası.
     */
    @When("{string} Random bir ürün seçilir")
    public void randomBirUrunSecilir(String brand) {
        assertTrue(isElementVisible(TELEFON_SAT_DROPDOWN), "Telefon Sat Dropdown Ekranda Görüntülenemedi!");
        clickElement(TELEFON_SAT_DROPDOWN);
        getFindElementsList(POPULER_MARKALAR_LIST, POPULER_MARKALAR_LIST_NAME, brand);
    }

    /**
     * Sayfanın doğru açılıp açılmadığını kontrol eder.
     *
     * @param brand Dropdown listeden seçilecek marka adı.
     */
    @When("{string} sayfası açıldığı kontrol edilir")
    public void sayfasiAcildigiKontrolEdilir(String brand) {
        String url = getUrl();
        if (brand.equals("Samsung")) {
            assertTrue(url.contains(SAMSUNG_SATIS_URL), "Seçilen Marka İle Açılan Sayfa Birbirinden Farklı!");
        } else {
            System.out.println("Diğer Markalar else ile devam ettirilecek!");
        }
    }

}

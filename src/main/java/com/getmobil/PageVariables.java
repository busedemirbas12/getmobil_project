package com.getmobil;

import org.openqa.selenium.By;

public class PageVariables {
    public static final String BASE_URL = "https://getmobil.com/";
    public static final String SAMSUNG_SATIS_URL = "https://getmobil.com/sat/telefon/cihaz-sec/samsung";
    public static final String BAYILIK_URL = "https://getmobil.com/franchise/";
    public static final String BAYILIK_BASVURU_FORM_TXT = "Getmobil Bayilik Başvuru Formu";
    public static final String BASARILI_TALEP_MSG_TXT = "Talebiniz oluşturuldu.";
    public static final String BASARISIZ_TALEP_MSG_TXT = "Talebiniz oluşturulamadı.";



    public static final By COOKIE = By.cssSelector("#butons > #btn2");
    public static final By TELEFON_SAT_DROPDOWN = By.id("sellPhoneDropdown");
    public static final By POPULER_MARKALAR_LIST = By.cssSelector(".col-md-3 .nav-item");
    public static final By POPULER_MARKALAR_LIST_NAME = By.cssSelector(".col-md-3 .nav-item button");
    public static final By ANASAYFA_BUTON_LIST = By.cssSelector(".topbar .col-md-auto");
    public static final By ANASAYFA_BUTON_LIST_NAME = By.cssSelector(".col-md-auto .btn");
    public static final By SIFIR_BAYILIK_BASVUR_BTN = By.cssSelector(".col-md-6:nth-of-type(1) [data-target='#modalFranchise']");
    public static final By BAYILIK_BASVURU_FORM = By.cssSelector("#modalFranchise .modal-title");
    public static final By FORM_TEXT_LIST_LABEL = By.cssSelector(".col-sm-6 .floating-label");
    public static final By FORM_TEXT_LIST = By.cssSelector(".col-sm-6 .floatingInput");
    public static final By FORM_TEXT_LIST_INPUT = By.cssSelector(".col-sm-6 [required='required']");
    public static final By BAYILIK_IL_BTN = By.cssSelector(".col-sm-6:nth-of-type(7) .dropdown");
    public static final By BAYILIK_ILCE_BTN = By.cssSelector(".col-sm-6:nth-of-type(8) .dropdown");
    public static final By BAYILIK_SEMT_BTN = By.cssSelector(".col-sm-6:nth-of-type(9) .dropdown");
    public static final By BAYILIK_FORMLIST = By.cssSelector(".dropdown-menu.show .inner.show .dropdown-item");
    public static final By BAYILIK_BASVURU_ACIKLAMA = By.cssSelector("[placeholder='Açıklama']");
    public static final By BAYILIK_BASVURU_GONDER_BUTON = By.cssSelector(".modalFranchise  .modal-body .col-12 [type='button']");
    public static final By TALEP_MSG = By.cssSelector("#modalSuccess .col-12.mt-4 p");
}

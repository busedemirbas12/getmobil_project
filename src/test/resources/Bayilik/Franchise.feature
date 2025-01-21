Feature:

  @WebTest
  Scenario: Başarılı Franchise Başvurusu
    Given Anasayfa açılır
    When "Bayilik" sayfası açılır
    When Başvuru formu açılır
    Then Form doldurulur
    Then Talep oluşturulur
    Then Talep başarıyla gönderilir


    @WebTest
    Scenario: Başarısız Franchise Başvurusu
      Given Anasayfa açılır
      When "Bayilik" sayfası açılır
      When Başvuru formu açılır
      Then Talep oluşturulur
      Then Talebin hatalı olduğu görüntülenir
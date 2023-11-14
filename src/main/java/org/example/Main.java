
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;

import java.net.http.HttpClient;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    // Bir sınıf, değişken veya metod public olarak belirlenirse,
    // bu onun genel olarak "her yerden!" erişilebilir olduğu anlamına gelir

    // Bir sınıf, değişken veya metod private olarak belirlenirse,
    // bu onun sadece "kendi sınıfında!" kullanılabileceği anlamına gelir.



    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hakan\\selenium java klasör\\chromeDriver\\chromedriver.exe");

        // ChromeDriver'ı kullanarak WebDriver oluştur
        WebDriver driver = new ChromeDriver();

        // İşlemler
        driver.get("https://www.example.com");
        driver.navigate().to("https://www.amazon.com.tr/");
        driver.manage().window().maximize(); // web sayfasını büyütüyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println(driver.getTitle());
        driver.navigate().back(); // instagramdan gittik
        driver.navigate().forward(); // instagram geri geldik
        driver.navigate().refresh();

        WebElement aramakutusu = driver.findElement(By.id(""));
        aramakutusu.sendKeys("Nutella");
        aramakutusu.sendKeys(Keys.ENTER); // aramakutusu.sendKeys(Keys.TAB);,aramakutusu.sendKeys(Keys.SHIFT)... gibi gibi
        WebElement sonucYaziElement = driver.findElement(By.xpath(""));
        String actualYaziStr = sonucYaziElement.getText()
        // 1-48 of 105 results for "Nutella"
        String bulunacakKelime = "Nutella";

        int hakanYas=20;
        int emeklilikYas=55;

        Assert.assertTrue(actualYaziStr.contains(bulunacakKelime));
        Assert.assertFalse(hakanYas>emeklilikYas); // bazen olumsuz cevap çıkmasını isteriz
        // mesala kullanıcı adı yanlışsa PASSED olarak geçer yani işlev doğru çalışıyor
        Assert.essertEqual(55,emeklilikYas); // bazende iki şeyi karşılaştırırız
        // mesala sonuç yazısının 1-48 of 105 results for "Nutella" olduğunu test edin

        if (actualYaziStr.contains(bulunacakKelime)) {
            System.out.println("PASSED içeriyor");
        } else{
            System.out.println("FAILED içermiyor");
        }



        WebElement logoElement = driver.findElement(By.xpath());
        Assert.assertTrue(logoElement.isDisplayed());
        WebElement signUpLinki = driver.findElement(By.xpath(""));
        signUpLinki.click();
        WebElement loginYaziElementi = driver.findElement(By.xpath(""));
        Assert.assertTrue(loginYaziElementi.isDisplayed()) // yazinin görünür olup olmadığını test ediyor
        // çünkü signUp sayfasına gidip gitmediğimizi anlamak için o sayfadaki herhangi bir yazıyı test
        // etmekten geçer !!!
        WebElement emailAdresKutusu = driver.findElement(By.xpath(""));
        emailAdresKutusu.sendKeys("hakan@gmail.com");
        WebElement passwordKutusu = driver.findElement(By.xpath(""));
        passwordKutusu.sendKeys("12345");
        driver.findElement(By.xpath("")).click();
        WebElement loggedInYazisi = driver.findElement(By.xpath("")); // burada çıkacak yazı
        // sayesinde giriş yapıp yapmadığımızı anlamış olacağız !!!
        System.out.println(loggedInYazisi.getText()); // Logged in as hakan
        Assert.assertTrue(loggedInYazisi.isDisplayed());
        driver.findElement(By.xpath(""));
        String beklenenUrl = "";
        String gerceklesenUrl = driver.getCurrentUrl();
        Assert.assertEquals(beklenenUrl,gerceklesenUrl);






        List<WebElement> buttonListesi=driver.findElements(By.tagName("button"));
        System.out.println(buttonListesi.size()); // button sayisini verir
        for (WebElement each:buttonListesi
        ){ System.out.println(each.getText());
        }






        WebElement nameElement = driver.findElement(By.id("userName"));
        nameElement.click();
        nameElement.sendKeys("Hakan"); // tıkladı ve Hakan yazdı !

        WebElement email = driver.findElement(new By.ByCssSelector("")); // kullanımı bu şekilde
        email.click();
        email.sendKeys("SADKJSDJK@gmail.com");

        WebElement currentAddress = driver.findElement(new By.ByCssSelector(""));
        currentAddress.click();
        currentAddress.sendKeys("İzmir");

        WebElement permanentAddress = driver.findElement(By.id(""));
        permanentAddress.click();
        permanentAddress.sendKeys("İstanbul,Ankara");

        WebElement nameText = driver.findElement(By.xpath(""));  // new koymaya gerek yok !
        String name = nameText.getText();
        System.out.println(name);       // email,currentAddress,paramentAddress lerinde text yani metinini alabiliriz

        WebElement CheckBox = driver.findElement(new By.ByCssSelector(""));
        CheckBox.click();

        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        boolean tiklaniyormu = sportCheckbox.isEnabled(); // isEnabled checkbox etkin olup olmadığı tıklanıp taklanmadığını kontrol eder tıklanıyorsa True yoksa False döner
        if (tiklaniyormu) { // true ise şarta girer !
            try {
                sportCheckbox.click();
            } catch (ElementClickInterceptedException e) {
                sportCheckbox.click();
            }
        }

        boolean isSelected = sportCheckbox.isSelected();
        System.out.println(isSelected); // checkbox'ın seçili olup olmadığını kontrol eder !

        WebElement yesRadioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        boolean RadioButton = yesRadioButton.isEnabled(); // bu sefer isEnabled RadioButton etkin olup olmadığı tıklanıp taklanmadığını kontrol eder tıklanıyorsa True yoksa False döner
        if (RadioButton) { // true ise şarta girer !
            try {
                yesRadioButton.click();
            } catch (ElementClickInterceptedException e) {
                yesRadioButton.click();
            }
        }

        WebElement text = driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(text.getText());

        // çift tıklama işlemi aşağıdaki kod
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();
        // sağ tıklama işlemi
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickButton).perform();

        //DİNAMİK ELEMENTLER
        WebElement dynamicClickButton = driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]"));
        dynamicClickButton.click();

        // WebDriverWait
        WebElement firstButton = driver.findElement(By.xpath("//div/p[starts-with(text(),'This text has random Id')]"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(firstButton)); // tıklanabilir olana kadar bekleyecek max bekleme süresi 5 sn
        firstButton.click();
        // yani Explicit Wait tam olarak o test durumuna özel özelleştiririlmiş ama Implicit Wait hep aynıdır
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String className = colorChangeButton.getAttribute("class");
        System.out.println("class renk değiştirmeden önceki hali: " + className);
        WebDriverWait waitAttribute = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.attributeToBe(colorChangeButton,5,"mt-4 text-danger btn btn-primary")); // burada class yani Attribute bu olana kadar bekle
        // Attributelar bunlardır class,name,id...
        className = colorChangeButton.getAttribute("class");
        System.out.println("class renk değiştirdikten sonraki hali: " + className);




        // SELENİUM KIRIK LİNK OLUP OLMADIĞINI BULMA (Broken Links)
        HttpClient client = HttpClientBuilder.create().build(); // HttpClient nesnesi, HTTP isteklerini göndermek ve yanıtları almak için kullanılır !
        HttpGet request = new HttpGet("http://the-internet.herokuapp.com/status_codes/500");
        HttpResponse response = client.execute(request); // client.execute(request) ifadesi, oluşturulan GET isteğini sunucuya gönderir ve yanıtı alır
        int statusCode = response.getStatusLine().getStatusCode(); // yanıt durum lodunu alır !
        System.out.println(statusCode);
        // yukardaki kod linkin statusCode döndürür 200,201,403,404,500


        WebElement links = driver.findElements(By.tagName("a"));
        HttpClient client = HttpClientBuilder.create().build();

        int linkCount = Math.min(10, links.size());
        for (int i = 0; i < linkCount; i++) {
            WebElement link = links.get(i);
            String url = link.getAttribute("href"); // Her bir bağlantının URL'sini alın
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
        }
        // WebElement link = links.get(i);  Java İçin !!!
        // link = links[i] Python için !!!


        // SELENİUM KIRIK GÖRSEL OLUP PLMADIĞINI BULMA (Broken Image)
        WebElement brokenImage = driver.findElement(By.xpath("//img[@src='/images/Toolsqa_1.jpg']"))
        String brokenImageUrl = brokenImage.getAttribute("src");

        HttpClient client = HttpClientBuilder.create().build(); // HttpClient nesnesi, HTTP isteklerini göndermek ve yanıtları almak için kullanılır !
        HttpGet request = new HttpGet(brokenImageUrl);
        HttpResponse response = client.execute(request); // client.execute(request) ifadesi, oluşturulan GET isteğini sunucuya gönderir ve yanıtı alır
        int statusCode = response.getStatusLine().getStatusCode(); // yanıt durum lodunu alır !
        System.out.println(statusCode);
        if (statusCode == 200) {
            System.out.println("Sorunsuz img!");
        } else if (statusCode == 500) {
            System.out.println("Kırık img!");
        }

        //div[id='framesWrapper'] div --> div içinde div

        // SAYFA İÇİNDE SAYFA iFrame (Frames)
        driver.switchTo().frame(0);
        WebElement baslik = driver.findElement(By.id("sampleHeading"));
        String text1 = baslik.getText();
        System.out.println(text1);

        driver.switchTo().parentFrame(); // paraentFrame ile sayfa içinde sayfadan çıkıp normal hale geliyoruz !
        // switchTo() metodu, Selenium WebDriver ile tarayıcı penceresinin farklı içerik alanları arasında geçiş yapmanızı sağlar.


        // Modal Dialogs
        WebElement smallButton = driver.findElement(By.id("showSmallModal"));
        smallButton.click();
        WebElement smallCloseButton = driver.findElement(By.id("closeSmallModal"));
        smallCloseButton.click();

        // ACCORDİAN : açık kapalı kontrol etme
        WebElement firstCard = driver.findElement(By.xpath("//div[@class='card'][1]/div[2]"));
        String className = firstCard.getAttribute("class");
        System.out.println(className); // class html kodun simgesi onun ismini class='collapse show'
        WebElement kapatma = driver.findElement(By.id("section1Heading"));
        kapatma.click();
        String DegisenClassName = firstCard.getAttribute("class");
        System.out.println(DegisenClassName);


        // Auto Complete
        WebElement input = driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"));
        input.sendKeys("R"); // Red,Green...
        List<WebElement> aramalardaCikanlar = driver.findElements(By.xpath("")); // findElemens dedik s takısı ekledik List olacağı için çıkan hepsini alacağımız için!!!
        for(WebElement aramalardaCikan : aramalardaCikanlar){

            String text = aramalardaCikan.getText();

            System.out.println(aramalardaCikan.getText());
            if (text.toLowerCase().contains("r")){
                System.out.println(text + "r harfi bulunuyor");
            }
            if (text.equalsIgnoreCase("red")) {
                aramalardaCikan.click();
            }

            Assert.assertTrue(text.toLowerCase().contains("r")); // tester böyle yapmali
        }

        aramalardaCikanlar.get(0).click(); // Red seçer


        // Actions
        WebElement signUp = driver.findElement(By.xpath(""));
        Actions actions = new Actions(driver);
        actions.click(signUp).perform();
        WebElement nameKutusu = driver.findElement(By.xpath(""));
        actions.click(nameKutusu);
        actions.sendKeys("Ahmet").sendKeys(Keys.TAB).sendKeys("h@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // BİZİ BU WebElement passwordKutusu = driver.findElement(By.xpath("")); OLAYDAN azaltıyor
        String girisBasarili = "GİRİS BASARİLİ";
        String EkrandakiYazi=driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(girisBasarili,EkrandakiYazi);



        // DatePicker
        WebElement selectDate = driver.findElement(By.id("datePickerMonthYearInput"));
        selectDate.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        monthElement.click();
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByVisibleText("April");

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        yearElement.click();
        Select selectYear = new Select(yearElement);
        selectYear.selectByVisibleText("2003");

        List<WebElement> daysElement = driver.findElements(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker__day')]"));
        for (WebElement dayElement : daysElement) {

            String dayText = dayElement.getText();
            if (dayText == "19") {
                dayElement.click();
                break;
            }


        }

        //for (int i = 0; i < daysElement.size(); i++) {
        //  String dayText = daysElement.get(i).getText();
        // if (dayText.equals("19")) {
        //  daysElement.get(i).click();
        // break;
        //}


        // alert(uyarı)
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText()); // uyarı mesajı
        driver.switchTo().alert().dismiss();
        // switchTo() metodu, Selenium WebDriver ile tarayıcı penceresinin farklı içerik alanları arasında geçiş yapmanızı sağlar.


        //Slider
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,10,0).perform();
        WebElement sliderValue = driver.findElement(By.cssSelector("input[class='range-slider range-slider--primary']"));
        String sliderValueText = sliderValue.getAttribute("value"); // getAttributer yerine getText() olur aslında ama içi boş olacak
        System.out.println(sliderValueText);













    }
    private void selectDate(String year, String month, String day,String time) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hakan\\selenium java klasör\\chromeDriver\\chromedriver.exe");

        // ChromeDriver'ı kullanarak WebDriver oluştur
        WebDriver driver = new ChromeDriver();

        // İşlemler
        driver.get("https://www.example.com");
        driver.manage().window().maximize();

        WebElement selectDate = driver.findElement(By.id("datePickerMonthYearInput"));
        selectDate.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        monthElement.click();
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByVisibleText(month);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        yearElement.click();
        Select selectYear = new Select(yearElement);
        selectMonth.selectByVisibleText(year);

        List<WebElement> daysElement = driver.findElements(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker__day')]"));
        for (WebElement dayElement : daysElement) {

            String dayText = dayElement.getText();
            if (dayText == day) {
                dayElement.click();
                break;
            }


        }

        List<WebElement> timesAlani = driver.findElements(By.xpath("//li[starts-with(@class,'react-datepicker__time-list-item')]"));
        for (WebElement timeElement : timesAlani) {
            if (timeElement.getText().equals(time)) {
                timeElement.click();
                break;
            }
        }


    }
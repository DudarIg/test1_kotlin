import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class Main {
    companion object {

        init {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe")
        }
        val driver = ChromeDriver()

        @JvmStatic
        fun main(args: Array<String>) {

            driver.get("https://swetotehnika.ru")

            var menu  = driver.findElements(By.cssSelector(".main_menu_item"))
            println("${menu.size}")
            val length = menu.size

            for (i in 0 until length) {
                menu[i].click()
                if (i == 0) {
                    page0(5)
                    driver.get("https://swetotehnika.ru")
                }
                menu = driver.findElements(By.cssSelector(".main_menu_item"))
            }
            driver.quit()
        }

        fun page0(count: Int) {
            var menu : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/catalog/")
            for (i in 1..count) {
                menu = driver.findElements(By.cssSelector(".txt-black"))
                var rnds = (0..menu.size-1).random()
                menu[rnds].click()
                driver.executeScript("window.history.go(-1)")
            }
        }





    }

}
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
            val length = menu.size

            for (i in 0 until length) {
                menu[i].click()
                when(i) {
                    0 -> { page0(5)
                            driver.get("https://swetotehnika.ru") }
                    1 -> { page1(5)
                        driver.get("https://swetotehnika.ru") }
                    2 -> { page2(5)
                        driver.get("https://swetotehnika.ru") }
                    4 -> { page4(5)
                        driver.get("https://swetotehnika.ru") }
                    6 -> { page6(5)
                        driver.get("https://swetotehnika.ru") }
                }

                menu = driver.findElements(By.cssSelector(".main_menu_item"))
            }
            Thread.sleep(5000)
            driver.quit()
        }

        fun page0(count: Int) {
            var links : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/catalog/")
            for (i in 1..count) {
                links = driver.findElements(By.cssSelector(".txt-black"))
                val randoms = (0..links.size-1).random()
                links[randoms].click()
                driver.executeScript("window.history.go(-1)")
            }
        }

        fun page1(count: Int) {
            var links : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/shop/apparatura_puskoreguliruyushchaya/")
            for (i in 1..count) {
                links = driver.findElements(By.cssSelector("a[href^='/shop/']"))
                val randoms = (0..links.size-1).random()
                links[randoms].click()
                driver.executeScript("window.history.go(-1)")
            }

        }
        fun page2(count: Int) {
            var links : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/services/")
            for (i in 1..count) {
                links = driver.findElements(By.cssSelector("a[href^='/services/']"))
                val randoms = (0..links.size-1).random()
                links[randoms].click()
                driver.executeScript("window.history.go(-1)")
            }

        }

        fun page4(count: Int) {
            var links : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/proizvoditeli-svetotekhniki/")
            for (i in 1..count) {
                links = driver.findElements(By.cssSelector("a[href^='/proizvoditeli-svetotekhniki/']"))
                val randoms = (0..links.size-1).random()
                links[randoms].click()
                driver.executeScript("window.history.go(-1)")
            }

        }
        fun page6(count: Int) {
            var links : MutableList<WebElement>? = null
            driver.get("https://swetotehnika.ru/news/")
            for (i in 1..count) {
                links = driver.findElements(By.cssSelector(".news-detail-link"))
                val randoms = (0..links.size-1).random()
                links[randoms].click()
                driver.executeScript("window.history.go(-1)")
            }

        }

    }

}
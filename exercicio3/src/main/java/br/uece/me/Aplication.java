package br.uece.me;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aplication {
	
	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");

    	System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://google.com.br";
        String esperadoTitle = "Google";
        String actualTitle = "";
        	
        // inicie o Chrome e direcione-o para a URL base
        driver.get(baseUrl);

        // obtém o valor real do título
        actualTitle = driver.getTitle ();

        /*
         * compare o título real da página com o esperado e imprima
         * o resultado foi "Aprovado" ou "Reprovado"
         */
        if (actualTitle.contentEquals (esperadoTitle)) {
            System.out.println ("Teste aprovado!");
        } else {
            System.out.println ("Teste falhou");
        }
       
        // feche Fire fox
        //driver.close ();

	}
	
}

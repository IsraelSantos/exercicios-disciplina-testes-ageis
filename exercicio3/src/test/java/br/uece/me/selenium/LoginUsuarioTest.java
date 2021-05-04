package br.uece.me.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsuarioTest {
	
	@Test
	public void deveEfetuarLoginCorretamente() {
		String path = System.getProperty("user.dir");
		
		//Baixar esse driver no link e colocar no diretorio driver
		//https://chromedriver.storage.googleapis.com/index.html?path=90.0.4430.24/

    	System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
        String baseUrl = path+"/site/index.html";
        driver.get(baseUrl);
        
        WebElement login = driver.findElement(By.id("idUsuario"));
        login.sendKeys("inovarsempre");
        
        WebElement senha = driver.findElement(By.id("idSenha"));
        senha.sendKeys("*&¨*&¨JHHUJ");
        
        WebElement button = driver.findElement(By.id("idButton"));
        button.click();
        
        String atualUrl = driver.getCurrentUrl();
        String esperadoUrl = "file:///"+path.replace("\\", "/")+"/site/dashboard.html";
        
        driver.close ();

        assertEquals(esperadoUrl,atualUrl);
       
	}
	
	@Test
	public void deveSolicitarUsuario() {
		String path = System.getProperty("user.dir");
		
		//Baixar esse driver no link e colocar no diretorio driver
		//https://chromedriver.storage.googleapis.com/index.html?path=90.0.4430.24/

    	System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
        String baseUrl = path+"/site/index.html";
        driver.get(baseUrl);
        
        WebElement senha = driver.findElement(By.id("idSenha"));
        senha.sendKeys("*&¨*&¨JHHUJ");
        
        WebElement button = driver.findElement(By.id("idButton"));
        button.click();
        
        String tituloAtual = driver.getTitle();
        String tituloEsperado = "Login";//Não saiu da página
        
        driver.close ();

        assertEquals(tituloEsperado,tituloAtual);
       
	}
	
	@Test
	public void deveSolicitarSenha() {
		String path = System.getProperty("user.dir");
		
		//Baixar esse driver no link e colocar no diretorio driver
		//https://chromedriver.storage.googleapis.com/index.html?path=90.0.4430.24/

    	System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
        String baseUrl = path+"/site/index.html";
        driver.get(baseUrl);
        
        WebElement login = driver.findElement(By.id("idUsuario"));
        login.sendKeys("inovarsempre");
        
        WebElement button = driver.findElement(By.id("idButton"));
        button.click();
        
        String tituloAtual = driver.getTitle();
        String tituloEsperado = "Login";//Não saiu da página
        
        driver.close ();

        assertEquals(tituloEsperado,tituloAtual);
       
	}

}

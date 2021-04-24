package br.uece.me.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
 * @RunWith(Cucumber.class)
   @CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste",
   glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
 * 
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
glue = "br.uece.me.cucumber.passos")
public class RunCucumberTest {

}

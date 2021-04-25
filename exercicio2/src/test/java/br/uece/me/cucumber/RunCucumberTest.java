package br.uece.me.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

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

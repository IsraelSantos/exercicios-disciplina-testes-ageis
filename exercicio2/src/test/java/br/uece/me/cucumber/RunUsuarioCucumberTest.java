package br.uece.me.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
glue = "br.uece.me.cucumber.passos")
public class RunUsuarioCucumberTest {

}

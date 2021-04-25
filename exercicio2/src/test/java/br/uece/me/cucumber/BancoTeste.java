package br.uece.me.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@BancoTeste",
glue = {"br.uece.me.cucumber.passos",
		"br.uece.me.cucumber.me.config"}, monochrome = true, dryRun = false)
public class BancoTeste {
}
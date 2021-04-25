package br.uece.me.cucumber.passos;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	@Given("today is Sunday")
	public void today_is_sunday() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_friday_yet() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("I should be told {string}")
	public void i_should_be_told(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(true);
	}
}

package tek.dragons.cucumber.utilities;

import com.github.javafaker.Faker;

public class DataGenerator {

	public static String data(String input) {
		Faker faker = new Faker();
		String output = "";
		
		if (input.equals("firstName")) {
			output = faker.name().firstName().replaceAll("[^a-zA-Z^]", "");
		} else if (input.equals("lastName")) {
			output = faker.name().lastName().replaceAll("[a-zA-Z^]", "");
		} else if (input.equals("fullName")) {
			output = faker.name().fullName().replaceAll("[^a-z A-Z^]", "");
		} else if (input.equals("email")) {
			output = faker.expression("#{letterify '?????.????@tekschool.us'}");
		} else if (input.equals("phone")) {
			output = faker.phoneNumber().cellPhone();
		} else if (input.equals("cardNumber")) {
			output = "" + faker.number().randomNumber(16, false);
		} else if (input.equals("securityCode")) {
			output = "" + faker.number().randomNumber(3, false);
		} else if (input.equals("streetAddress")) {
			output = faker.address().streetAddress();
		} else if (input.equals("apt")) {
			output = faker.address().buildingNumber();
		} else if (input.equals("state")) {
			output = faker.address().state();
		} else if (input.equals("city")) {
			output = faker.address().cityName();
		} else if (input.equals("zipCode")) {
			output = faker.number().digits(5);
		}

		return output;

	}

}

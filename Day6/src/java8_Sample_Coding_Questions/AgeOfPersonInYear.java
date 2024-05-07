package java8_Sample_Coding_Questions;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeOfPersonInYear {
	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(2001,1,14);
		LocalDate today = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthday, today)+ " Years old");

	}

}

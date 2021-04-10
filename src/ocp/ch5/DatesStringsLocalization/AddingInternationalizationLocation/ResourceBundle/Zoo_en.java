package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.ResourceBundle;

import java.util.ListResourceBundle;

//equivalent resource bundle
public class Zoo_en extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] { { "hello", "Hello!!!" }, { "open", "The zoo is open" } };
	}
}
package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.ResourceBundle;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tax_en_US extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] { { "tax", new UsTaxCode(.15) } };
	}
}

class UsTaxCode {

	private double tax;

	public UsTaxCode(double d) {
		this.tax = d;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsTaxCode [tax=");
		builder.append(tax);
		builder.append("]");
		return builder.toString();
	}

}
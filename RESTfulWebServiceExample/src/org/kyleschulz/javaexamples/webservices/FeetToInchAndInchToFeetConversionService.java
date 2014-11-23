package org.kyleschulz.javaexamples.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConversionService")
// Sets the path to base URL + /your_path_at_class_level. The base URL is based
// on your application name, the servlet and the URL pattern from the web.xml"
// configuration file.
public class FeetToInchAndInchToFeetConversionService {

	@GET
	@Path("/InchToFeet/{i}")
	// Sets path to base URL + /your_path_at_class_level+
	// /your_path_at_method_level
	@Produces(MediaType.TEXT_XML)
	// @Produces defines which MIME type is delivered by a method annotated with
	// @GET. In the example text ("text/XML") is produced.
	// @PathParam: Used to inject values from the URL into a method
	// parameter.This way you inject inch in convertFeetToInch method and
	// convert that to feet.
	public String convertInchToFeet(@PathParam("i") int i) {
		int inch = i;
		double feet = 0;
		feet = (double) inch / 12;

		return "<InchToFeetService>" + "<Inch>" + inch + "</Inch>" + "<Feet>"
				+ feet + "</Feet>" + "</InchToFeetService>";
	}

	@Path("/FeetToInch/{f}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String convertFeetToInch(@PathParam("f") int f) {
		int inch = 0;
		int feet = f;
		inch = 12 * feet;

		return "<FeetToInchService>" + "<Feet>" + feet + "</Feet>" + "<Inch>"
				+ inch + "</Inch>" + "</FeetToInchService>";
	}
}

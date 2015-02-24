package com.example.projetcoiffeur.lib;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextApplication {

	public static String LOGIN = "admin";
	public static String PASSWORD = "admin";
	private static final SimpleDateFormat format = new SimpleDateFormat(
			"dd/MM/yyyy");

	public static String formatDate(Date date) {
		return format.format(date);
	}
}
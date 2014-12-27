package de.oglimmer.dsacalc.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.SneakyThrows;

public enum DsacalcProperties {
	INSTANCE;

	private static final String DSACALC_PROPERTIES = "dsacalc.properties";
	private Properties prop = new Properties();

	@SneakyThrows(value = IOException.class)
	private DsacalcProperties() {
		if (System.getProperty(DSACALC_PROPERTIES) != null) {
			try (FileInputStream fis = new FileInputStream(System.getProperty(DSACALC_PROPERTIES))) {
				prop.load(fis);
				System.out.println("Successfully loaded " + DSACALC_PROPERTIES + " from "
						+ System.getProperty(DSACALC_PROPERTIES));
			}
		}
	}

}

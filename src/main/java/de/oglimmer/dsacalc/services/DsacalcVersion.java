package de.oglimmer.dsacalc.services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;

import lombok.Getter;

public enum DsacalcVersion {
	INSTANCE;

	@Getter
	private String version;
	@Getter
	private String commit;
	@Getter
	private String dsaCalcVersion;
	@Getter
	private String creationDate;
	@Getter
	private boolean runsOnDev;

	public void init(ServletContext context) {
		try (InputStream is = new FileInputStream(context.getRealPath("/META-INF/MANIFEST.MF"))) {
			Manifest mf = new Manifest(is);
			Attributes attr = mf.getMainAttributes();
			commit = attr.getValue("Git-Commit");
			dsaCalcVersion = attr.getValue("DSA-Talent-Calc-Version");
			long time = Long.parseLong(attr.getValue("Creation-Date"));
			creationDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(time));
		} catch (Exception e) {
			commit = "?";
			creationDate = "?";
			dsaCalcVersion = "?";
			runsOnDev = true;
		}

		version = "V" + dsaCalcVersion + " [Commit#" + commit + "] build " + creationDate;
	}

}

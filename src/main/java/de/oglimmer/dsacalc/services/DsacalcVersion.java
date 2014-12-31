package de.oglimmer.dsacalc.services;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;

import com.jcabi.manifests.Manifests;

public enum DsacalcVersion {
	INSTANCE;

	private final String prefix = "DSA-TalCalc-Web";

	@Getter
	private String version;
	@Getter
	private String commit;
	@Getter
	private String dsaCalcVersion;
	@Getter
	private String creationDate;

	private DsacalcVersion() {

		try {
			commit = Manifests.read(prefix + "-Git-Commit");
			long time = Long.parseLong(Manifests.read(prefix + "-Creation-Date"));
			creationDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(time));
			dsaCalcVersion = Manifests.read(prefix + "-Version");
		} catch (IllegalArgumentException e) {
			commit = "?";
			creationDate = "?";
			dsaCalcVersion = "?";
		}

		version = "V" + dsaCalcVersion + " [Commit#" + commit + "] build " + creationDate;
	}

}

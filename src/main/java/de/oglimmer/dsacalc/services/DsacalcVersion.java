package de.oglimmer.dsacalc.services;

import javax.servlet.ServletContextEvent;

import de.oglimmer.utils.VersionFromManifest;
import lombok.Getter;

public enum DsacalcVersion {
	INSTANCE;

	@Getter
	private String version;

	public void init(ServletContextEvent sce) {
		VersionFromManifest vfm = new VersionFromManifest();
		vfm.initFromFile(sce.getServletContext().getRealPath("/META-INF/MANIFEST.MF"));
		version = vfm.getLongVersion();
	}

}

package de.alpharogroup.user.db.init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import de.alpharogroup.db.init.AbstractDatabaseInitialization;


public class DatabaseInitialization extends AbstractDatabaseInitialization {

	public DatabaseInitialization(final Properties databaseProperties) {
		super(databaseProperties);
	}

	@Override
	protected List<File> getScriptFiles() {
		final File insertsDir = getInsertDir();
		final List<File> scriptFiles = new ArrayList<>();
		scriptFiles.add(new File(insertsDir, "insertPermissions.sql"));
		return scriptFiles;
	}

}
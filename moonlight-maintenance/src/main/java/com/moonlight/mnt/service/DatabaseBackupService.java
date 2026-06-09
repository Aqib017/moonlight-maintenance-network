package com.moonlight.mnt.service;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;
@Service
public class DatabaseBackupService {

	public String backupDatabase() throws Exception {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String backupFile = "backup_" + timestamp + ".sql";

		String command = "mysqldump -u root -pmySQL#0017 " + "moonlight_maintenance > " + backupFile;

		Process process = Runtime.getRuntime().exec(new String[] { "cmd", "/c", command });

		process.waitFor();

		return new File(backupFile).getAbsolutePath();
	}
}
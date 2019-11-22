package virpteq.updater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class VIRPTEQ_Updater {

	public static void main(String[] args) {
		VIRPTEQ_Updater_GUI.appendLog("Initiating update...");
		initUpdate();
	}

	public static void initUpdate() {
		try {
			//fetchLatestVersionTxt();
			fetchFromGithub();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private static boolean isRedirected(Map<String, List<String>> header) {
		for (String hv : header.get(null)) {
			if (hv.contains(" 301 ") || hv.contains(" 302 "))
				return true;
		}
		return false;
	}

	public static void fetchFromGithub() throws Throwable {
		VIRPTEQ_Updater_GUI.appendLog(">>>>> BEGIN FETCHING .JAR <<<<<");
		String version = fetchLatestVersionTxt();
		String fileName = "VIRPTEQ_Calculator_" + version + ".jar";
		VIRPTEQ_Updater_GUI.appendLog("Will search for file: " + fileName);
		String link = "https://github.com/GenElectrovise/VIRPTEQ-Calc/releases/download/" + version + "/" + fileName; // https://github.com/GenElectrovise/VIRPTEQ-Calc/releases/download/1.2/VIRPTEQ_Calculator_1.2.jar
		VIRPTEQ_Updater_GUI.appendLog("Will search for file: " + fileName + " :On site: " + link);
		URL url = new URL(link);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		VIRPTEQ_Updater_GUI.appendLog("Connection established");
		Map<String, List<String>> header = http.getHeaderFields();
		while (isRedirected(header)) {
			VIRPTEQ_Updater_GUI.appendLog("Being redirected by GitHub");
			link = header.get("Location").get(0);
			url = new URL(link);
			http = (HttpURLConnection) url.openConnection();
			header = http.getHeaderFields();
		}
		VIRPTEQ_Updater_GUI.appendLog("Opening InputStream!");
		InputStream input = http.getInputStream();
		byte[] buffer = new byte[4096];
		VIRPTEQ_Updater_GUI.appendLog("Byte buffer set");
		int n = -1;
		File fileOut = new File("scr/main/resources/from_git/" + fileName);
		VIRPTEQ_Updater_GUI.appendLog("Got file");
		VIRPTEQ_Updater_GUI.appendLog("Writing file to: " + fileOut.getAbsolutePath());
		OutputStream output = new FileOutputStream(fileOut);
		VIRPTEQ_Updater_GUI.appendLog("Opening OutputStream. Writing!");
		while ((n = input.read(buffer)) != -1) {
			output.write(buffer, 0, n);
		}
		VIRPTEQ_Updater_GUI.appendLog("Written. Closing writer."); // https://github.com/GenElectrovise/VIRPTEQ-Calc
		output.close();
	}

	public static String fetchLatestVersionTxt() {
		try {
			VIRPTEQ_Updater_GUI.appendLog(">>>>> BEGIN FETCHING VERSION <<<<<");

			String fileName = "latestversion.txt";

			VIRPTEQ_Updater_GUI.appendLog("Will search for file: " + fileName);
			String link = "https://raw.githubusercontent.com/GenElectrovise/VIRPTEQ-Calc/master/" + fileName; // https://github.com/GenElectrovise/VIRPTEQ-Calc/releases/download/1.2/VIRPTEQ_Calculator_1.2.jar
			VIRPTEQ_Updater_GUI.appendLog("Will search for file: " + fileName + " :On site: " + link);
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			VIRPTEQ_Updater_GUI.appendLog("Connection established");
			Map<String, List<String>> header = http.getHeaderFields();
			while (isRedirected(header)) {
				VIRPTEQ_Updater_GUI.appendLog("Being redirected by GitHub");
				link = header.get("Location").get(0);
				url = new URL(link);
				http = (HttpURLConnection) url.openConnection();
				header = http.getHeaderFields();
			}
			VIRPTEQ_Updater_GUI.appendLog("Opening InputStream!");
			InputStream input = http.getInputStream();
			byte[] buffer = new byte[4096];
			VIRPTEQ_Updater_GUI.appendLog("Byte buffer set");
			int n = -1;
			File fileOut = new File("scr/main/resources/from_git/" + fileName);
			VIRPTEQ_Updater_GUI.appendLog("Got file");
			VIRPTEQ_Updater_GUI.appendLog("Writing file to: " + fileOut.getAbsolutePath());
			OutputStream output = new FileOutputStream(fileOut);
			VIRPTEQ_Updater_GUI.appendLog("Opening OutputStream. Writing!");
			while ((n = input.read(buffer)) != -1) {
				output.write(buffer, 0, n);
			}
			VIRPTEQ_Updater_GUI.appendLog("Written. Closing writer."); // https://github.com/GenElectrovise/VIRPTEQ-Calc
			output.close();

			BufferedReader br = new BufferedReader(new FileReader(fileOut.getAbsolutePath()));
			String versionOut = br.readLine();
			VIRPTEQ_Updater_GUI.appendLog("Found version: " + versionOut);
			br.close();
			return versionOut;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "1.2";
	}
}

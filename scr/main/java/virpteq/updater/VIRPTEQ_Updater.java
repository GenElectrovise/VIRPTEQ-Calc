package virpteq.updater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class VIRPTEQ_Updater {

	public static void main(String[] args) {
		VIRPTEQ_Updater_GUI.appendLog("Attempting connection");
		System.out.println("Starting");
		initUpdate();
	}

	public static void initUpdate() {
		try {
			fetchFromGithub("file", "1.2");
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

	public static void fetchFromGithub(String fileName, String version) throws Throwable {
		fileName = "VIRPTEQ_Calculator_" + version + ".jar";
		String link = "https://github.com/GenElectrovise/VIRPTEQ-Calc/releases/download/" + version + "/" + fileName; //https://github.com/GenElectrovise/VIRPTEQ-Calc/releases/download/1.2/VIRPTEQ_Calculator_1.2.jar
		URL url = new URL(link);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		Map<String, List<String>> header = http.getHeaderFields();
		while (isRedirected(header)) {
			link = header.get("Location").get(0);
			url = new URL(link);
			http = (HttpURLConnection) url.openConnection();
			header = http.getHeaderFields();
		}
		InputStream input = http.getInputStream();
		byte[] buffer = new byte[4096];
		int n = -1;
		File fileOut = new File("scr/main/resources/from_git/" + fileName);
		VIRPTEQ_Updater_GUI.appendLog(fileOut.getAbsolutePath());
		OutputStream output = new FileOutputStream(fileOut);
		while ((n = input.read(buffer)) != -1) {
			output.write(buffer, 0, n);
		}
		output.close();
	}
}

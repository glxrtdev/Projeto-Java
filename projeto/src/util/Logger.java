package util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "projeto/src/dados/log.txt";

    public static void registrar(String mensagem) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    try (FileWriter fw = new FileWriter(LOG_FILE, true);
         PrintWriter pw = new PrintWriter(fw)) {

        String timestamp = LocalDateTime.now().format(formatter);
        pw.println("[" + timestamp + "] " + mensagem);

    } catch (IOException e) {
        System.err.println("Erro ao escrever no log: " + e.getMessage());
    }
}
}

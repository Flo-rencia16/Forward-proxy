package src.main;

import src.ui.app.Proxy;
import src.ui.frame.MainFrame;
import src.network.proxyserver.ProxyServer;
import src.database.OracleConnection;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.extras.FlatUIDefaultsInspector;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup(); // Thème clair
        // FlatDarkLaf.setup(); // Thème sombre
        // FlatIntelliJLaf.setup(); // Style IntelliJ clair
        // FlatDarculaLaf.setup(); // Style IntelliJ sombre
        FlatInspector.install("ctrl shift alt X"); // Inspecteur d'interface utilisateur
        FlatUIDefaultsInspector.install("ctrl shift alt Y"); // Inspecteur des valeurs par défaut de l'interface
                                                             // utilisateur
        MainFrame mw = new MainFrame(new Proxy());
        mw.setVisible(true);
    }

    public static void shutdownHook() {
        System.out.println("Shutting down proxy...");
        // Ajoutez ici le code de nettoyage nécessaire avant la fermeture de
        // l'application

        proxyServer.arreterServeur();
        OracleConnection.getInstance().fermer();

        System.out.println("Nettoyage terminé.");
    }
}

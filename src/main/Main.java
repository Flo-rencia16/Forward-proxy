package src.main;

import src.ui.window.MainWindow;
import src.ui.app.Game;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.extras.FlatUIDefaultsInspector;

public class Main {
    public static void main(String[] args) {
        // FlatLightLaf.setup(); // Thème clair
        FlatDarkLaf.setup(); // Thème sombre
        // FlatIntelliJLaf.setup(); // Style IntelliJ clair
        // FlatDarculaLaf.setup(); // Style IntelliJ sombre
        FlatInspector.install("ctrl shift alt X");
        FlatUIDefaultsInspector.install("ctrl shift alt Y");
        MainWindow mw = new MainWindow(new Game());
        mw.setVisible(true);
    }
}

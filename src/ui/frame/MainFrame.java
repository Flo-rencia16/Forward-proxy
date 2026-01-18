package src.ui.frame;
import src.ui.app.Proxy;

public class MainFrame extends javax.swing.JFrame {
    private Proxy proxy;

    public MainFrame(Proxy proxy) {
        this.proxy = proxy;
        initComponents();
    }

    private void initComponents() {
        setTitle("Forward Proxy");
        setSize(800, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Ajoutez ici les composants de l'interface utilisateur
    }
    
}

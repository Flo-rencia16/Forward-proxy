package src.db;

public class OracleConnection {
    public static OracleConnection getInstance() {
        // Retourne l'instance unique de la connexion Oracle
        return new OracleConnection();
    }
    public void fermer() {
        // Code pour fermer la connexion Oracle
    }
}

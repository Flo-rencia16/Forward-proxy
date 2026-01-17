=====================================================
        PROJET : PROXY CACHE VIDEO - JAVA
=====================================================

Langage : Java
UI : Java Swing
Base de données : Oracle
Equipe :
- Florencia (Flo) : Réseau & coeur proxy
- Steeve : Base de données Oracle
- Hiraina : Interface graphique Swing

=====================================================
================= PACKAGE main ======================
=====================================================

[Flo : avant 18/01/2026 21:00]

Main.java

{
	Responsabilité :
	- point d’entrée du programme
	- initialisation globale du système

	Attributs :
	config (AppConfig)
	proxyServer (ProxyServer)

	Méthodes :
	void main(String[] args)
	- charge la configuration
	- initialise la base Oracle
	- lance le proxy réseau
	- lance l’interface Swing

	methodes utils :
	shutdownHook()

	Avec constructeurs progressifs
}

=====================================================
================ PACKAGE config =====================
=====================================================

[Flo : avant 18/01/2026 22:00]

AppConfig.java

{
	Responsabilité :
	- centraliser la configuration du projet

	Attributs :
	proxyPort (int)
	cacheDirectory (String)
	cacheMaxSize (long)
	oracleUrl (String)
	oracleUser (String)
	oraclePassword (String)

	Méthodes :
	void chargerConfiguration()
	getteurs & setteurs
}

=====================================================
================ PACKAGE network ====================
=====================================================

[Flo : avant 18/01/2026 23:00]

ProxyServer.java

{
	Responsabilité :
	- autorité réseau du proxy
	- accepter les connexions clientes

	Attributs :
	serverSocket (ServerSocket)
	running (boolean)

	Méthodes :
	void demarrerServeur(int port)
	- initialise le serveur TCP
	- accepte les clients

	void arreterServeur()
	- ferme le serveur proprement

	methodes utils :
	getteurs & setteurs

	Avec constructeurs progressifs
}

-----------------------------------------------------

[Flo : avant 18/01/2026 23:00]

ClientHandler.java

{
	Responsabilité :
	- gérer un client connecté
	- traiter sa requête HTTP

	Attributs :
	clientSocket (Socket)
	input (InputStream)
	output (OutputStream)

	Méthodes :
	void run()
	- lit la requête client
	- crée un HttpRequest
	- interroge le CacheManager
	- redirige vers serveur distant si besoin

	methodes utils :
	fermerConnexion()
}

=====================================================
================= PACKAGE http ======================
=====================================================

[Flo : avant 19/01/2026 22:00]

HttpRequest.java

{
	Responsabilité :
	- représenter une requête HTTP

	Attributs :
	method (String)
	url (String)
	host (String)
	port (int)
	headers (Map<String, String>)

	Méthodes :
	void parser(InputStream in)
	getteurs & setteurs
}

=====================================================
================= PACKAGE cache =====================
=====================================================

[Flo : avant 19/01/2026 23:00]

CacheEntry.java

{
	Responsabilité :
	- représenter une ressource mise en cache

	Attributs :
	resourceId (String)
	filePath (String)
	size (long)
	accessCount (int)
	lastAccess (Date)

	Méthodes :
	getteurs & setteurs
}

-----------------------------------------------------

[Flo : avant 19/01/2026 23:00]

CacheManager.java

{
	Responsabilité :
	- décider la mise en cache
	- gérer les accès aux ressources

	Attributs :
	cacheMap (Map<String, CacheEntry>)
	popularityThreshold (int)

	Méthodes :
	boolean estEnCache(String resourceId)
	void incrementerAcces(String resourceId)
	void stockerRessource(HttpRequest request, InputStream data)
	InputStream lireDepuisCache(String resourceId)

	methodes utils :
	synchronisation multi-threads
}

=====================================================
================ PACKAGE storage ====================
=====================================================

[Flo : avant 20/01/2026 22:00]

DiskStorage.java

{
	Responsabilité :
	- gestion physique des fichiers cache

	Attributs :
	cacheDirectory (File)

	Méthodes :
	void ecrireFichier(String id, InputStream data)
	InputStream lireFichier(String id)
	void supprimerFichier(String id)

	methodes utils :
	verification espace disque
}

=====================================================
================= PACKAGE db ========================
=====================================================

[Steeve : avant 18/01/2026 20:00]

OracleConnection.java

{
	Responsabilité :
	- gestion de la connexion Oracle

	Attributs :
	connection (Connection)

	Méthodes :
	void connecter()
	Connection getConnection()
	void fermer()

	Avec singleton
}

-----------------------------------------------------

[Steeve : avant 18/01/2026 21:00]

ResourceDAO.java

{
	Responsabilité :
	- persistance des ressources cache

	Attributs :
	connection (Connection)

	Méthodes :
	void insererRessource(CacheEntry entry)
	void incrementerAcces(String resourceId)
	CacheEntry trouverParId(String resourceId)
}

=====================================================
================= PACKAGE ui ========================
=====================================================

[Hiraina : avant 18/01/2026 19:00]

MainFrame.java

{
	Responsabilité :
	- fenêtre principale Swing

	Attributs :
	startButton (JButton)
	stopButton (JButton)
	statusLabel (JLabel)

	Méthodes :
	void initialiserUI()
	void mettreAJourEtat(String etat)
}

-----------------------------------------------------

[Hiraina : avant 18/01/2026 20:00]

CachePanel.java

{
	Responsabilité :
	- affichage du cache en temps réel

	Attributs :
	tableCache (JTable)

	Méthodes :
	void rafraichirDonnees()
}

=====================================================
================= PACKAGE util ======================
=====================================================

[Steeve : avant 18/01/2026 19:00]

HashUtil.java

{
	Responsabilité :
	- génération d’identifiant unique des ressources

	Méthodes :
	String sha256(String input)
}

=====================================================
                FIN DU DOCUMENT
=====================================================

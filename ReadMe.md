Fedora Solr Camel Documentation
====

**Inhalt:**
[1. Einführung und Ziele](#1)
[2. Voraussetzungen](#2)
[3. Instalation](#3)

<a name="1"></a>
## 1. Einführung und Ziele ##

Das Ziel des Projektes ist die Datentransformation und Datenübertragung aus unterschiedlichen
Quellen und Formaten, wie Xml, Pdf, Text, Datenbank mit Hilfe von Apache Camel nach Solr und Fedora.
Die Idee ist - möglichst versuchen in eine Sprache die komplete Datenübertragung und Datenspeicherung zu realisieren.
Die Daten müssen in Fedora und Solr nach eine Transformation gespeichert werden. 
<a name="2"></a>
## 2. Voraussetzungen ##
  * Java 1.8
  * Apache Solr (http://lucene.apache.org/solr/)
  * Apache ActiveMQ (http://activemq.apache.org/)
  * Fedora (http://fedorarepository.org/)
  * Apache Camel (http://camel.apache.org/)

## 3. Instalation ##
In diesem Abschnitt wird die nötige Instalationsschritte beschrieben:  
  
  * Apache Solr
    1. Aus http://lucene.apache.org/solr letzte Version herunterladen. 
    2. In passende Stelle auspacken
    3. Mit bin/solr start - Starten Sie den Solr. 
   Es wird als default auf folgende Adresse gestartet: host:8980/solr.
   Es ist möglich mit folgende Kommando zu starten und den Port zselbst einlegen:
   bin/solr start -p 8980
    4. solr create -c myCollection - Erstellen von neue Kollektion
    5. Solr Konfiguration befindet sich unter ../server/solr/collection_Name/conf
    6. Um neue Felder einzulegen muss man schema.xml erweitern.
   
   
     <field name="book_id" type="int" indexed="true" stored="true" multiValued="false" required="false" />
     <field name="chapter_id" type="int" indexed="true" stored="true" multiValued="true" required="false" />
  
  * Apache Camel
  * Fedora
   
  Apache Camel bietet ideale Mecanismus um die Daten aus unterschiedlichen Formaten
  zu übertragen. Parallel




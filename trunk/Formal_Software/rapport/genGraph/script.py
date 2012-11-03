#Compilation du .dot avec la commande
#dot -Tpng output.dot -o petri.png

# Ouverture d'un fichier en *lecture*:
rd = open("Projet-untimed.txt", "r")
# Ouverture d'un fichier en *ecriture*:
wr = open("output.dot", "w")


wr.write("digraph G {\n")
for ligne in rd:
    if ligne[0] != "-" :
        result = ligne.split()
        wr.write(result[0] + " -> " + result[4] +";\n")
wr.write("}")
    
 # Fermeture des fichiers
wr.close()
rd.close()

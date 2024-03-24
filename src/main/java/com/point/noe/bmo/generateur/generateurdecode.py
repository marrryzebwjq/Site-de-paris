fileuml = open("classes.dotuml", 'r')

def isDebutDeClasse(ligne) :
    isClass = False
    hasAccolades = False
    className = ''
    isAbstract = False #inutilisé
    
    words = ligne.split()
    if(len(words)>0) :
        if(words[0] == 'abstract') :
            isClass = True
            hasAccolades = '{' in line
            className = words[2]
            isAbstract = True
        elif(words[0] == 'class') :
                isClass = True
                hasAccolades = '{' in line
                className = words[1]
        elif(words[0] == '{') :
                isClass = True
                hasAccolades = True
    
    return isClass, hasAccolades, className, isAbstract

def createClassFile(className) :
    return open(className+'.java', 'w')


# main

writeLine = False
isOpen = False

for line in fileuml :
    
    isClass, hasAccolades, className, isAbstract = isDebutDeClasse(line)
    
    if ( not(writeLine) and isClass ) : # Si une classe est définie on écrit tout jusque la fin de la classe
        
        writeLine = True                # On va écrire la première ligne :
    
        if not(line.split()[0]=='{') :    # On créé d'abord un nouveau fichier.
            filejava = createClassFile(className)
            filejava.write('public ')
            isOpen = True
        else :
            filejava.write('    ')
            
    
        for word in line.split() :     # Pour chaque mot de la ligne,
            filejava.write(word + ' ') # on écrit le mot,

            if '}' in word :           # on regarde si le mot est un },
                filejava.write("\n")    # si c'est le cas on ferme le fichier.
                writeLine = False
                filejava.close()
                isOpen = False

        if isOpen :
            filejava.write("\n")           #fin de ligne.
        
            if not(hasAccolades) :
                filejava = False
                filejava.close()
                isOpen = False

    

    elif writeLine : # Lignes à l'intérieur d'une classe :
        filejava.write('    ')
        for word in line.split() :
            filejava.write(word + ' ')

            if '}' in word : #fin du fichier
                filejava.write("\n")
                writeLine = False
                filejava.close()
                isOpen = False

        if isOpen :
            filejava.write("\n") #fin de ligne
        

fileuml.close()
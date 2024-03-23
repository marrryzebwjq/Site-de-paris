fileuml = open("classes.dotuml", 'r')
filejava = open("test2.txt", 'w')


def isDebutDeClasse(ligne) :
    isClass = False
    hasAccolades = False
    
    words = line.split()
    if(len(words)>0) :
        if(words[0] == 'class' or words[0] == 'abstract' or words[0] == '{') :
            isClass = True
            hasAccolades = '{' in line
    
    return isClass, hasAccolades




# main

writeLine = False

for line in fileuml :
    
    isClass, hasAccolades = isDebutDeClasse(line)
    
    if ( not(writeLine) and isClass ) : # Si une classe est définie on écrit tout jusque la fin de la classe
    
        writeLine = True                # On écrit la première ligne
    
        if line.split()[0] == '{' : #(tabulation)
            filejava.write('    ')
            
    
        for word in line.split() :     # Pour chaque mot de la ligne
            filejava.write(word + ' ') # on écrit le mot

            if '}' in word :           # on regarde si le mot est un }
                filejava.write("\n")
                writeLine = False

        filejava.write("\n")           #fin de ligne
        
        if not(hasAccolades) :
            writeLine = False

    

    elif writeLine : # Lignes à l'intérieur d'une classe :
        filejava.write('    ')
        for word in line.split() :
            filejava.write(word + ' ')

            if '}' in word :
                filejava.write("\n")
                writeLine = False

        filejava.write("\n") #fin de ligne
        


fileuml.close()
filejava.close()
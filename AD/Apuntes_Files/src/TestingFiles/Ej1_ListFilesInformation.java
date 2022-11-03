package TestingFiles;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * Realiza un programa Java que utilice o método listFiles() para amosar a lista
 * de ficheiros nun directorio calquera pasado como argumento da main ou no seu
 * defecto no directorio actual. A información a amosar será para cada ficheiro
 * ou directorio o tamaño (se é un ficheiro), os permisos dos que se dispón
 * sobre o ficheiro ou directorio, a súa última data de modificación (en
 * calquera formato). Os permisos hai que visualizalos no formato habitual de
 * Linux (tres caracteres seguidos: r se hai permiso de lectura ou - se non o
 * hai, w se hai permiso de escritura ou - se non o hai e x se hai permiso de
 * execución se se trata dun ficheiro ou para entrar nel si se trata dun
 * directorio ou - se non hai)
 */
public class Ej1_ListFilesInformation {

    /**
     * Realiza un programa Java que utilice o método listFiles() para amosar a
     * lista de ficheiros nun directorio calquera pasado como argumento da main
     * ou no seu defecto no directorio actual.
     *
     * @param args Leer la ruta.
     */
    public static void main(String[] args) {
        /**
         * Primero declaro la ruta que voy a utilizar. Ahorro mucho código
         * usando ternario. Declaro también el file a usar.
         */
        String pathName = args.length > 0 ? args[0] : ".";
        File fileToSearchFrom = new File(pathName);
        File[] listedFiles = fileToSearchFrom.listFiles();

        if (fileToSearchFrom.exists()) {
            Arrays.stream(listedFiles).forEachOrdered((eachFile) -> {
                System.out.println(generateInfo(eachFile));
            });
        } else {
            System.out.println("No existe el archivo pasado por argumento. Fin del programa.");
        }
    }
    /**
     * Generará la información del archivo que pases.
     * No es necesario hacer checks ya que la existencia del fichero es evidente.
     * En caso contrario, if(x.isEmpty()) throw new FileNotFoundException("No hay nada.");
     * @param fileToCheck
     * @return 
     */
    private static String generateInfo(File fileToCheck) {
        return normalizeStringSize(fileToCheck.getName()) + "\t\t\t" + fileToCheck.length() + "\t" + retrievePriviledges(fileToCheck) + "\t" + new Date(fileToCheck.lastModified());
    }
    /**
     * Recorta el nombre del fichero para curar mi TOC.
     * @param name
     * @return 
     */
    private static String normalizeStringSize(String name) {
        if (name.length() > 16) {
            return name.substring(0, 5) + "..." + name.substring(name.length() - 5, name.length());
        }
        return name;
    }
    /**
     * Genera la cadena de permisos del fichero recibido.
     * Exception checks: Igual que en generateInfo(x);
     * @param fileToCheck
     * @return 
     */
    private static String retrievePriviledges(File fileToCheck) {
        StringBuilder builder = new StringBuilder();
        builder.append((fileToCheck.canRead() ? "r" : "-"))
                .append((fileToCheck.canWrite() ? "w" : "-"))
                .append((fileToCheck.canExecute() ? "x" : "-"));
        return builder.toString();
    }
}
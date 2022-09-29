/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package victorgomez.victorgomezcli;

import org.apache.commons.cli.*;

/**
 *
 * @author DAM2
 */
public class VictorGomezCLI {

    public static void main(String[] args) {
        CommandLine cmdLine = null;
        Options options = new Options();
        options.addOption("w", "hello-world", false,
                "Imprime Hola mundo...");
        options.addOption(new Option("h", "help", false, 
                "Ayuda"));
        options.addOption(new Option("y", "years", true,
                "tras N anyos de vida"));
        // No pueden aparecen las dos opciones simultáneamente.  
        OptionGroup group = new OptionGroup();
        group.addOption(new Option("n", "nice", false, 
                "... es bueno"));
        group.addOption(new Option("c", "cruel", false,
                "... es cruel"));
        options.addOptionGroup(group);
        try {

            CommandLineParser parser = new DefaultParser();
            cmdLine = parser.parse(options, args);

            if (cmdLine.hasOption("h")) {  
                new HelpFormatter().printHelp
        (VictorGomezCLI.class.getCanonicalName(), options);
            } else {
            if (cmdLine.hasOption("w")) {  
                System.out.print("Hola mundo ");
            
            if (cmdLine.hasOption("n")) {
                System.out.print("bonito");
            } else if (cmdLine.hasOption("c")) {
                System.out.print("cruel");
            }
            }
            if (cmdLine.hasOption("y")){
                System.out.println("Tras "+ cmdLine.getOptionValue("y")
                        + " años de vida");
            }
            }

        } catch (org.apache.commons.cli.ParseException ex) {
            System.out.println(ex.getMessage());
            new HelpFormatter().printHelp(VictorGomezCLI.class.
                    getCanonicalName(), options);    
        } catch (java.lang.NumberFormatException ex) {
            new HelpFormatter().printHelp(VictorGomezCLI.class.
                    getCanonicalName(), options);   
        }
    }
}

/*
Software para que los enfermeros (usuario) puedan recopilar una serie inicial de datos del paciente.
Hay que solicitar al usuario una serie de datos, y luego mostrarlos en pantalla.
Hay que identificar si introduce un dato erróneo, y volver a solicitarlo.
Datos a solicitar:
1. NUSS
2. Síntoma
3. Exploración inicial que dependerá del resultado del dato 2
4. Nivel de prioridad
5. Temperatura
Por último, hay que mostrar todos los datos introducidos por el usuario.
*/

//Importo librería(s)
import java.util.Scanner;

//Abro clase
public class Proyecto1 {

    //Defino constantes
    private static final int
            MIN_NUSS = 100000, MAX_NUSS = 999999;
    private static final byte
            MIN_SINT_EXPL = 0, MAX_SINT_EXPL = 3,
            MIN_PRIO = 0, MAX_PRIO = 5,
            MIN_TEMP = 27, MAX_TEMP = 45;

    public static void main(String[] args) {

        //Defino librería Scanner
        Scanner scn = new Scanner(System.in);

        // Defino variables
        int nuss = 0;
        byte sintoma = -1, exploracion = -1, prioridad = -1, temperatura = -1;

        //Solicito NUSS
        while (nuss < MIN_NUSS || nuss > MAX_NUSS) {

            System.out.print("Introduzca el NUSS del paciente (valor de 6 dígitos): ");
            nuss = scn.nextInt ();

            if (nuss < MIN_NUSS || nuss > MAX_NUSS) {
                System.out.println("ERROR: valor incorrecto");
            }

        }

        //Solicito Síntoma, y Exploración inicial según resultado del primero
        while (sintoma < MIN_SINT_EXPL || sintoma > MAX_SINT_EXPL) {

            System.out.println("Indique el síntoma del paciente:\n Dolor (0)\n Lesión traumática (1)\n Fiebre alta (2)\n Confusión o desorientación (3)");
            System.out.print("(Valor de 0 a 3): ");
            sintoma = scn.nextByte ();
            if (sintoma < MIN_SINT_EXPL || sintoma > MAX_SINT_EXPL) {
                System.out.println("ERROR: valor incorrecto");

            }
            else {

                switch (sintoma) {

                    case 0:
                        while (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {

                            System.out.println("Indique el resultado de la exploración inicial:\n Dolor torácico (0)\n Dolor abdominal (1)\n Dolor de cabeza (2)\n Migraña (3)");
                            exploracion = scn.nextByte();
                            if (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {
                                System.out.println("ERROR: valor incorrecto");
                            }
                        }
                        break;

                    case 1:
                        while (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {

                            System.out.println("Indique el resultado de la exploración inicial:\n Fractura ósea (0)\n Herida de bala (1)\n Quemadura (2)\n Lesión cerebral traumática (3)");
                            exploracion = scn.nextByte();
                            if (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {
                                System.out.println("ERROR: valor incorrecto");
                            }
                        }
                        break;

                    case 2:
                        while (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {

                            System.out.println("Indique el resultado de la exploración inicial:\n Neumonía (0)\n Meningitis (1)\n Infección viral (2)\n Reacción alérgica (3)");
                            exploracion = scn.nextByte();
                            if (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {
                                System.out.println("ERROR: valor incorrecto");
                            }
                        }
                        break;

                    case 3:
                        while (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {

                            System.out.println("Indique el resultado de la exploración inicial:\n Intoxicación por drogas o alcohol (0)\n Deshidratación severa (1)\n Accidente cerebrovascular (2)\n Hipoglucemia severa (3)");
                            exploracion = scn.nextByte();
                            if (exploracion < MIN_SINT_EXPL || exploracion > MAX_SINT_EXPL) {
                                System.out.println("ERROR: valor incorrecto");
                            }
                        }
                        break;
                }
            }
        }

        //Solicitio Nivel de prioridad
        while (prioridad < MIN_PRIO || prioridad > MAX_PRIO) {

            System.out.print("Indique el nivel de prioridad del paciente (valor de 0 a 5): ");
            prioridad = scn.nextByte ();

            if (prioridad < MIN_PRIO || prioridad > MAX_PRIO) {
                System.out.println("ERROR: valor incorrecto");
            }
        }

        //Solicito Temperatura
        while (temperatura < MIN_TEMP || temperatura > MAX_TEMP) {

            System.out.print("Introduzca la temperatura del paciente (valor en ºC): ");
            temperatura = scn.nextByte ();

            if (temperatura < MIN_TEMP || temperatura > MAX_TEMP) {
                System.out.println("ERROR: valor incorrecto");
            }
        }

        //Muestro resumen de los datos introducidos por el usuario
        String [] sintomas = {"Dolor", "Lesión traumática", "Fiebre alta", "Confusión o desorientación"};
        String [] [] exploraciones = {
                {"Dolor torácico", "Dolor abdominal", "Dolor de cabeza", "Migraña"},
                {"Fractura ósea", "Herida de bala", "Quemadura", "Lesión cerebral traumática"},
                {"Neumonía", "Meningitis", "Infección viral", "Reacción alérgica"},
                {"Intoxicación por drogas o alcohol", "Deshidratación severa", "Accidente cerebrovascular", "Hipoglucemia severa"}
        };
        System.out.println("Resumen de los datos introducidos:");
        System.out.println("NUSS: " + nuss);
        System.out.println("Síntoma: " + sintomas[sintoma]);
        System.out.println("Exploración inicial: " + exploraciones[sintoma][exploracion]);
        System.out.println("Nivel de prioridad: " + prioridad);
        System.out.println("Temperatura: " + temperatura + "ºC");

        //Cierro librería Scanner
        scn.close();
    }
}
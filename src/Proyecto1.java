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
        boolean valorCorrecto = false;

        //Solicito NUSS
        System.out.print("Introduzca el NUSS del paciente (valor de 6 dígitos): ");

        while (!valorCorrecto) {

            if (scn.hasNextInt()) {
                nuss = scn.nextInt();
                if (nuss >= MIN_NUSS && nuss <= MAX_NUSS) {
                    valorCorrecto = true;
                    scn.nextLine();
                } else {
                    System.out.println("ERROR: el número debe tener 6 dígitos, vuelva a intentarlo:");
                    scn.nextLine();
                }
            } else {
                System.out.println("ERROR: formato incorrecto, introduzca un número de 6 dígitos:");
                scn.nextLine();
            }
        }

        //Reset valorCorrecto
        valorCorrecto = false;

        //Solicito Síntoma, y Exploración inicial según resultado del primero
        System.out.println("Indique el síntoma del paciente:\n Dolor (0)\n Lesión traumática (1)\n Fiebre alta (2)\n Confusión o desorientación (3)");
        System.out.print("(Valor de 0 a 3): ");

        while (!valorCorrecto) {

            if (scn.hasNextByte()) {
                sintoma = scn.nextByte();
                if (sintoma >= MIN_SINT_EXPL && sintoma <= MAX_SINT_EXPL) {
                    valorCorrecto = true;
                    scn.nextLine();
                } else {
                    System.out.println("ERROR: valor incorrecto, introduzca un número de " + MIN_SINT_EXPL + " a " + MAX_SINT_EXPL + " según el síntoma:");
                    scn.nextLine();
                }
            } else {
                System.out.println("ERROR: formato incorrecto, introduzca un número de " + MIN_SINT_EXPL + " a " + MAX_SINT_EXPL + " según el síntoma:");
                scn.nextLine();
            }

            switch (sintoma) {

                case 0:
                    System.out.println("Indique el resultado de la exploración inicial:\n Dolor torácico (0)\n Dolor abdominal (1)\n Dolor de cabeza (2)\n Migraña (3)");
                    break;

                case 1:
                    System.out.println("Indique el resultado de la exploración inicial:\n Fractura ósea (0)\n Herida de bala (1)\n Quemadura (2)\n Lesión cerebral traumática (3)");
                    break;

                case 2:
                    System.out.println("Indique el resultado de la exploración inicial:\n Neumonía (0)\n Meningitis (1)\n Infección viral (2)\n Reacción alérgica (3)");
                    break;

                case 3:
                    System.out.println("Indique el resultado de la exploración inicial:\n Intoxicación por drogas o alcohol (0)\n Deshidratación severa (1)\n Accidente cerebrovascular (2)\n Hipoglucemia severa (3)");
            }
        }

        //Reset valorCorrecto
        valorCorrecto = false;

        while (!valorCorrecto) {

            if (scn.hasNextByte()) {
                exploracion = scn.nextByte();
                if (exploracion >= MIN_SINT_EXPL && exploracion <= MAX_SINT_EXPL) {
                    valorCorrecto = true;
                    scn.nextLine();
                } else {
                    System.out.println("ERROR: valor incorrecto, introduzca un número de " + MIN_SINT_EXPL + " a " + MAX_SINT_EXPL + " según el resultado de la exploración:");
                    scn.nextLine();
                }
            } else {
                System.out.println("ERROR: formato incorrecto, introduzca un número de " + MIN_SINT_EXPL + " a " + MAX_SINT_EXPL + " según el resultado de la exploración:");
                scn.nextLine();
            }
        }

        //Reset valorCorrecto
        valorCorrecto = false;

        //Solicitio Nivel de prioridad
        System.out.print("Indique el nivel de prioridad del paciente (valor de 0 a 5): ");

        while (!valorCorrecto) {

            if (scn.hasNextInt()) {
                prioridad = scn.nextByte();
                if (prioridad >= MIN_PRIO && prioridad <= MAX_PRIO) {
                    valorCorrecto = true;
                    scn.nextLine();
                } else {
                    System.out.println("ERROR: valor incorrecto, introduzca un número de" + MIN_PRIO + " a " + MAX_PRIO + " según el grado de prioridad:");
                    scn.nextLine();
                }
            } else {
                System.out.println("ERROR: formato incorrecto, introduzca un número de" + MIN_PRIO + " a " + MAX_PRIO + " según el grado de prioridad:");
                scn.nextLine();
            }
        }

        //Reset valorCorrecto
        valorCorrecto = false;

        //Solicito Temperatura
        System.out.print("Introduzca la temperatura del paciente (valor en ºC): ");

        while (!valorCorrecto) {

            if (scn.hasNextInt()) {
                temperatura = scn.nextByte();
                if (temperatura >= MIN_TEMP && temperatura <= MAX_TEMP) {
                    valorCorrecto = true;
                    scn.nextLine();
                } else {
                    System.out.println("ERROR: valor incorrecto, introduzca un número entre " + MIN_TEMP + " y " + MAX_TEMP + " según la temperatura registrada en ºC:");
                    scn.nextLine();
                }
            } else {
                System.out.println("ERROR: formato incorrecto, introduzca un número entre " + MIN_TEMP + " y " + MAX_TEMP + " según la temperatura registrada en ºC:");
                scn.nextLine();
            }
        }

        //Muestro resumen de los datos introducidos por el usuario

        String[] sintomas = {"Dolor", "Lesión traumática", "Fiebre alta", "Confusión o desorientación"};
        String[][] exploraciones = {
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


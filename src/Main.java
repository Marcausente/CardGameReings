
import java.util.Random;
import java.util.Scanner;

public class Reigns {
    private static Scanner input = new Scanner(System.in);
    static int [] poderes = new int [4], añosArray = new int[20];
    static int años = 0, auxiliar = 0;
    static String nombre = "";
    static String[] nombres = {"Adrian", "Paco"};
    public static void main(String[] args) {
        int menu1 = 0;
        int menu2 = 0;

        do {
            menu1 = printmenu(menu1); /*Funcion unicamente para printear el menu inicial*/
            switch (menu1){
                case 1:
                    System.out.println("Se ha coronado un nuevo rey");
                    do {
                        iniciarjuego(menu2);
                    }while (menu2==2); //Bucle hasta que se selecciona la oppción de salir del otro menu

                    break;
                case 2:
                    normas();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERROR, introduce un numero valido"); //Control de errores
                    break;
            }
        }while (menu1 != 3); //Bucle hasta que se selecciona la oppción de salir del menu
    }

    private static void normas() {
        String yellow = "\u001B[33m"; //Print del menu inicial
        Scanner scanner = new Scanner(System.in);
        String resetColorCode = "\u001B[0m";
        System.out.println(" ");
        System.out.println(yellow+"¡Bienvenido a Reigs!"+resetColorCode);
        System.out.println("Reigns es un juego en el que te conviertes en el rey encargado de gobernar una nación bastante curiosa.");
        System.out.println(" ");
        System.out.println("Durante tu reinado, apareceran consejeros de cuatro facciones, iglesia, pueblo, economia y ejercito, tu");
        System.out.println("mision es intentar mantener estos cuatro poderes equilibrados. En caso de que alguno de estos poderes  ");
        System.out.println("llegue a 4 o a -4 pierdes automaticamente. Tus decisiones pueden influir a cualquier facción, así que  ");
        System.out.println("debes pensar cuidadosamente cada uno de tus movimientos. ¡Suerte, alteza!");
        System.out.println("");
        System.out.println("Pulsa cualquier tecla para continuar...");
        scanner.nextLine();
    }

    private static int printmenu(int menu1) {
        String green = "\u001B[36m"; //Print del menu inicial, sin mucho misterio
        String resetColorCode = "\u001B[0m";
        String Yellow = "\u001B[33m";
        System.out.println(green+"======================="+resetColorCode);
        System.out.println(Yellow+"      THE REIGNS "+resetColorCode);
        System.out.println(green+"======================="+resetColorCode);
        System.out.println("Bienvenido a Reigns BY Marc & Adrian");
        System.out.println("1. Nueva partida");
        System.out.println("2. Normas del juego");
        System.out.println("3. Salir");
        menu1 = input.nextInt(); //Seleccionador del menu, despues lo devuelve al main
        return menu1;
    }

    private static void iniciarjuego(int menu2) {
        String red = "\033[31m"; /*Ejercito*/
        String reset = "\u001B[0m";
        String green = "\u001B[32m"; /*Economia*/
        String yellow = "\u001B[33m"; /*Iglesia*/
        String blue = "\u001B[34m"; /*Pueblo*/
        Scanner nombreScanner = new Scanner(System.in);
        resetearvariableglobal();
        System.out.println("Elige el nombre del nuevo rey: ");
        nombres[0] = nombreScanner.nextLine(); //Guarda tu nombre para saber como llamarte en el menu de la partida
        do {
            for (int i = 0;i<4;i++){ //Este es el menu de derrota, se estará repitiendo cada vez que se ejecuta el juego y dependiendo de los puntos de poder ejecuta una opción o otra
                if (poderes[i] <= -4 || poderes[i] >= 4) { //En este caso comprueba si cualquiera de los poderes esta en 4 o -4
                    switch (i){ //En caso de que uno de los poderes cumpla la opcion del if comprobara cual es y ejecutara el mensaje de derrota
                        case 0:
                            if (poderes[i] <= -4){
                                System.out.println("DERROTA");
                                System.out.println("El pueblo rechaza el poder de la iglesia y tras esto, el de la corona, mueres por una masa enfurecida a las puertas del castillo");

                            }else{
                                System.out.println("DERROTA");
                                System.out.println("Una cruzada es enviada para reclamar tu reino en el nombre de la iglesia, eres exiliado por el mismo pontifice");

                            }
                            menu2 = 2;
                            break;

                        case 1:
                            if (poderes[i] <= -4){
                                System.out.println("DERROTA");
                                System.out.println("El pueblo se ha ido, vuestra corte se dispersa y solo os quedan como ultimos súbditos las palomas");
                                ;

                            }else{
                                System.out.println("DERROTA");
                                System.out.println("El pueblo toma el control del palacio, vuestro reino se termina aquí, pero nadie se atreve a tocaros. Morís varios años después");
                                ;
                            }
                            menu2 = 2;
                            break;

                        case 2:
                            if (poderes[i] <= -4){
                                System.out.println("DERROTA");
                                System.out.println("Aprovechando la flaqueza del reino, un ejercito extranjero os asalta, acompañado por los ultimos soldados fieles a la corona morís en las escaleras del trono");



                            }else{
                                System.out.println("DERROTA");
                                System.out.println("El general Adolfo de Douvres acude al palacio junto a la guarnición entera para reclamar el trono, sois enviado al exilio junto a los ultimos hombres fieles a la corona");


                            }
                            menu2 = 2;
                            break;

                        case 3:
                            if (poderes[i] <= -4){
                                System.out.println("DERROTA");
                                System.out.println("El pais esta arruinado, el pueblo asalta el palacio y la nueva oligarquía os envia al exilio");



                            }else{
                                System.out.println("DERROTA");
                                System.out.println("Los rumores de vuestra gran riqueza han llegado a todos los reinos, un ejercito de saqueadores asalta la capital y morís torturado por ellos mientras buscan el tesoro real");

                            }
                            menu2 = 2;
                            break;
                    }
                }
            }
            if (años == 40){
                System.out.println("VICTORIA"); //En este caso es el mensaje de victoria, si se llega a 40 años de reinado mueres de viejo y ganas
                System.out.println("Morís por causas naturales tras cuaranta años en el trono, vuestro nombre es alavado y tu reino será recordado como legendario");
                menu2 = 2;
            }
            if (menu2 == 2){
                años = 0;
            }else{
                System.out.println("================================"); //Print general del menu, se imprime tras la recogida de cada carta y te muestra cuantos puntos tienes de cada uno
                System.out.println("Rey " + nombres[auxiliar] + "   Años en el poder: " + años);
                System.out.println(yellow+"Iglesia: "+poderes[0]+reset);
                System.out.println(blue+"Pueblo: "+poderes[1]+reset);
                System.out.println(red+"Ejercito: "+poderes[2]+reset);
                System.out.println(green+"Economia: "+poderes[3]+reset);
                System.out.println("================================");
                System.out.println("1. Coger una carta");
                System.out.println("2. Salir");
                menu2 = input.nextInt();
            }


            switch (menu2) { //El menu de inicio de partida, se printea tras cada turno (año)
                case 1:

                    randomizadordecartas(); //Te manda a la seleccion de cartas para hacer una aleatoria
                    años++; //En este caso cada vez que un turno pasa se suma un año, se ejecuta siempre
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("ERROR, elige un numero valido");
                    break;

            }
        }while (menu2!=2);
    }

    private static void resetearvariableglobal() {

        for(int i=0;i<4;i++){

            poderes[i] = 0; //Ya que es una variable global, la reseteamos si acaba la partida para que se pueda iniciar otra bien
        }
    }

    private static void randomizadordecartas() {
        String reset = "\u001B[0m";
        String red = "\033[31m"; /*Ejercito*/
        String green = "\u001B[32m"; /*Economia*/
        String yellow = "\u001B[33m"; /*Iglesia*/
        String blue = "\u001B[34m"; /*Pueblo*/
        int decision = 0;
        int evento = 0;
        Random random = new Random();
        evento = random.nextInt(30); //Creación de los treinta randomizadores para la recogida de cartas en el juego
        switch (evento) { //Cada vez que se genere una carta nueva el switch te llevará a ella gracias al radomizador
            case 0:
                costruirembajadas(blue, reset, decision);
                break;
            case 1:
                cosechabuenamatt(blue, reset, decision);
                break;
            case 2:
                atacarsur(red, reset, decision);
                break;
            case 3:
                costruiriglesia(yellow, reset, decision);
                break;
            case 4:
                continuarinvestigacion(green, reset, decision);
                break;
            case 5:
                construirpuentes(blue, reset, decision);
                break;
            case 6:
                minerosaumento(blue, reset, decision);
                break;
            case 7:
                reclutarsoldados(red, reset, decision);
                break;
            case 8:
                estadodelbanco(green, reset, decision);
                break;
            case 9:
                curaenfadado(yellow, reset, decision);
                break;
            case 10:
                medicoencuentro(green, reset, decision);
                break;
            case 11:
                alianzavikinga(red, reset, decision);
                break;
            case 12:
                oroenelrio(blue, reset, decision);
                break;
            case 13:
                construirfortal(red, reset, decision);
                break;
            case 14:
                campesinosatacados(blue, reset, decision);
                break;
            case 15:
                cazadebrujas(red, reset, decision);
                break;
            case 16:
                explosionenlaciudad(red, reset, decision);
                break;
            case 17:
                comercioexterior(blue, reset, decision);
                break;
            case 18:
                negociarlapaz(red, reset, decision);
                break;
            case 19:
                explosionenlamina(blue, reset, decision);
                break;
            case 20:
                saqueoabadia(yellow, reset, decision);
                break;
            case 21:
                impuestoiglesiacorona(yellow, reset, decision);
                break;
            case 22:
                preciodelpollo(blue, reset, decision);
                break;
            case 23:
                hierroparaarmas(red, reset, decision);
                break;
            case 24:
                granjacomunal(blue, reset, decision);
                break;
            case 25:
                plomoenoro(green, reset, decision);
                break;
            case 26:
                toquedequeda(red, reset, decision);
                break;
            case 27:
                terremoto(red, reset, decision);
                break;
            case 28:
                ducadosenguerra(red, reset, decision);
                break;
            case 29:
                envenenamientocenteno(green, reset, decision);
                break;
            case 30:
                preciodelcereal(blue, reset, decision);
                break;
            default:
                System.out.println("Ha habido un error");
                break;
        }
    }

    private static void costruirembajadas(String blue, String reset, int decision) {
        System.out.println(blue+"--Duque Tomás de Roz--"+reset);
        System.out.println("Podemos construir embajadas en los paises vecinos. Así evitaríamos que la guerra se eternice");
        System.out.println("1. Sí, las construiremos");
        System.out.println("2. No, no lo haremos");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La construcción es cara, pero el ejercito podrá negociar mejor con ellas. El pueblo esta contento con estas embajadas");
            poderes[3] = poderes[3]-1;
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]+1;
            /*Economia -1, ejercito +1, pueblo +1*/
        }else if(decision==2){
            System.out.println("El pueblo no ve con buenos ojos que rechazaras la construcción, pero el dinero no se mueve de las arcas");
            poderes[1] = poderes[1]-1;
            /*pueblo -1*/
        }else{
            System.out.println("ERROR, introduce un numero valido");
        }
    }

    //A partir de aquí se generan los metodos para las cartas, todos tienen una estructura igual
    private static void preciodelcereal(String blue, String reset, int decision) {

        System.out.println(blue+"--Harry, lider de granjeros--"+reset);
        System.out.println("El precio de los cereales es muy barato, creo que es bueno para todos reajustar su precio");
        System.out.println("1. Aumentad el precio un poco");
        System.out.println("2. ¡Duplicadlo!");
        decision = input.nextInt();
        if(decision==1){ //En este caso es si el usuario responde positivamente a la decisión
            System.out.println("El precio del cereal se reajusta correctamente y las arcas consiguen un pequeño empujon");
            poderes[3] = poderes[3]+1;
            /*Economia +1*/
        }else if(decision==2){
            System.out.println("El precio del cereal aumenta mucho y la poblacion más pobre empieza a sufrir una severa hambruna, pese a esto las arcas crecen exponencialmente");
            poderes[3] = poderes[3]+2;
            poderes[1] = poderes[1]-1;
            /*Economia +2, poblacion -1*/
        }else{
            System.out.println("ERROR, introduce un numero valido"); //Control de errores
        }
    }

    private static void envenenamientocenteno(String green, String reset, int decision) {
        System.out.println(green+"--Joseph, el medico de la corte--"+reset);
        System.out.println("He estado investigando la locura colectiva de las ultimas semanas, se debe a un envenenamiento por centeno, ¿Quemamos nuestras reservas?");
        System.out.println("1. Sí, quemadlas");
        System.out.println("2. No, no quemaremos nada");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El pueblo esta hambriento, pero se ha controlado la plaga");
            /*Poblacion -1, ejercito +1*/
            poderes[1] = poderes[1]-1;
            poderes[2] = poderes[2]+1;
        }else if (decision==2) {

            System.out.println("Se mantienen las reservas de centeno, pero el envenenamiento se propaga y hay que enviar el ejercito a controlarlo");
            /*ejercito -1 Poblacion -1*/
            poderes[1] = poderes[1]-1;
            poderes[2] = poderes[2]-1;
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void ducadosenguerra(String red, String reset, int decision) {
        System.out.println(red+"--General Adolfo de Douvres--"+reset);
        System.out.println("Señor, los ducados del este vuelven a estar en guerra y su población quiere cruzar la frontera, ¿Que hacemos?");
        System.out.println("1. Dejadles pasar");
        System.out.println("2. ¡Cerrad la frontera!");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El pueblo y la economia se ven beneficiados por la entrada de nueva gente, pero al ejercito y a la iglesia les parece una situación insostenible");
            poderes[0] = poderes[0]-1;
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]-1;
            poderes[3] = poderes[3]+1;
            /*Ejercito -1, iglesia -1, economia +1, pueblo +1*/
        }else if (decision==2) {
            System.out.println("Era una gran oportunidad para la economia, pero el general y el pontifice habrian hecho lo mismo");
            /*Ejercito +1, iglesia +1, economia -1*/
            poderes[0] = poderes[0]+1;
            poderes[2] = poderes[2]+1;
            poderes[3] = poderes[3]-1;
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void terremoto(String red, String reset, int decision) {
        System.out.println(red+"--Capitán de la guardia Matthew Rosenberg--"+reset);
        System.out.println("¡Un terremoto ha destruido una parte de la capitál! La guardia espera tus ordenes");
        System.out.println("1. Salvad el tesoro");
        System.out.println("2. Salvad a las victimas");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La guardia pone a salvo el tesoro, con un costo de vidas enorme");
            poderes[1] = poderes[1]-2;
            /*Población -2*/
        }else if (decision==2) {
            System.out.println("La guardia pone a salvo a muchos ciudadanos, pero parte del tesoro termina bajo tierra");
            poderes[3] = poderes[3]-1;
            /*Economia -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void toquedequeda(String red, String reset, int decision) {
        System.out.println(red+"--Investigador jefe John Magnusson--"+reset);
        System.out.println("Las calles de la capital son inseguras, llevamos unos días encontrando cadaveres durante la noche ¡Deberiamos organizar un toque de queda mientras investigamos!");
        System.out.println("1. Sí, aplicaremos el toque de queda");
        System.out.println("2. No, vamos a mantenernos sin toque");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La población no concuerda la decisión del toque de queda, pero la investigación se lleva a cabo sin incidentes y la economia vuelve a circular rapidamente");
            poderes[2] = poderes[2]+1;
            poderes[1] = poderes[1]-1;
            poderes[3] = poderes[3]+1;
            /*Ejercito +1, poblacion -1, economia +1*/
        }else if (decision==2) {
            System.out.println("Pese a que el culpable es encontrado, sin el toque de queda la investigación se vuelve mucho más complicada, el equipo de investigadores parece descontento");
            poderes[2] = poderes[2]-1;
            /*Ejercito -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void plomoenoro(String green, String reset, int decision) {
        System.out.println(green+"--Joseph, el medico de la corte--"+reset);
        System.out.println("Creo que se como cumplir el sueño de cualquier alquimista, ¡Convertir el plomo en oro!");
        System.out.println("1. Sí, ponlo a prueba");
        System.out.println("2. No, deja de hacer esas tonterias");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Tras unos intentos fallidos Joseph tenia razon, el oro creado nos da un buen empujon a las arcas, aunque el cardenal se ha enterado y no parece estar contento");
            poderes[3] = poderes[3]+1;
            poderes[0] = poderes[0]-1;
            /*Economia +1, iglesia -1*/
        }else if (decision==2) {
            System.out.println("Joseph asiente y cierra la investigación, el cardenal parece compartir tus ideas sobre este tema");
            poderes[0] = poderes[0]+1;
            /*Iglesia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }


    private static void granjacomunal(String blue, String reset, int decision) {
        System.out.println(blue+"--Matt, lider del sindicato del pueblo--"+reset);
        System.out.println("Señor, debemos gastar algo de dinero en construir una graja comunal para evitar la hambruna ");
        System.out.println("1. Sí, hagamoslo");
        System.out.println("2. No, no construire algo así");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Gastas parte del dinero de las arcas en construir esta granja, el pueblo agradece tu gesto");
            poderes[3] = poderes[3]-1;
            poderes[1] = poderes[1]+1;
            /*Economia -1, pueblo +1*/
        }else if  (decision==2) {
            System.out.println("El pueblo organiza una revuelta para protestar por tu decisión, aunque tras unos dias se calma sin eviar a las tropas");
            poderes[1] = poderes[1]-1;
            /*pueblo -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void hierroparaarmas(String red, String reset, int decision) {
        System.out.println(red+"--Comandante John Garryson--"+reset);
        System.out.println("Las minas no producen hierro suficiente para fabricar armas. ¡Hay que comprarlas al extranjero!");
        System.out.println("1. Sí, compremoslas");
        System.out.println("2. No, hay que apañarselas");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Decides comprar las armas al extranjero, esto te cuesta algo de dinero pero el ejercito se ve reforzado con ello");
            poderes[3] = poderes[3]-1;
            poderes[2] = poderes[2]+1;
            /*Economia -1, ejercito +1*/
        }else if  (decision==2) {
            System.out.println("No gastas dinero en esto, pero parte de tu ejercito esta armado con... ¿Espadas de madera?");
            poderes[3] = poderes[3]+1;
            poderes[2] = poderes[2]-1;
            /*Ejercito -1, economia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void preciodelpollo(String blue, String reset, int decision) {
        System.out.println(blue+"--Maestro Farringon--"+reset);
        System.out.println("El precio del pollo aumenta sin cesar, ¡La gente esta especulando! Hay que hacer algo para regular el mecado");
        System.out.println("1. Sí, tomaremos medidas");
        System.out.println("2. No, ¡Que coman ternera!");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Vuestras amenazas de regular el comercio del pollo han funcionado, aun sin aplicar las medidas anunciadas");
            poderes[3] = poderes[3]+1;
            /*Economia +1*/
        }else if  (decision==2) {
            System.out.println("La población comienza a especular y los más pobres padecen una notable hambruna");
            poderes[1] = poderes[1]-1;
            /*Población -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void impuestoiglesiacorona(String yellow, String reset, int decision) {
        System.out.println(yellow+"--Arzobispo del cardenal--"+reset);
        System.out.println("Queremos crear un nuevo impuesto para la iglesia, compartido con la corona, por supuesto");
        System.out.println("1. Sí, hagamoslo");
        System.out.println("2. No, no lo hagas");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El impuesto os beneficia a la corona y a la iglesia, pero el pueblo no esta muy contento con este nuevo pago");
            poderes[0] = poderes[0]+1;
            poderes[3] = poderes[3]+1;
            poderes[1] = poderes[1]-1;
            /*Iglesia +1, economia +1, pueblo -1*/
        }else if  (decision==2) {
            System.out.println("El cardenal no esta contento con la decisión y se retira a la catedral");
            poderes[0] = poderes[0]-1;
            /*Iglesia -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void saqueoabadia(String yellow, String reset, int decision) {
        System.out.println(yellow+"--Padre Black--"+reset);
        System.out.println("Algunos de vuestros soldados han saqueado mi abadia. ¡Exigimos justicia!");
        System.out.println("1. Sí, habrá justicia");
        System.out.println("2. No, apañatelas solo");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Inicias una investigación contra los soldados, el comandante Garryson esta descontento con esta decisión");
            poderes[0] = poderes[0]+1;
            poderes[2] = poderes[2]-1;
            /*Iglesia +1, ejercito -1*/
        }else if  (decision==2) {
            System.out.println("El padre decide dimitir de su puesto debido a tu decisión, el Cardenal no aprueba tu desinteres");
            poderes[0] = poderes[0]-1;
            poderes[2] = poderes[2]+1;
            /*Iglesia -1, ejercito +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void explosionenlamina(String blue, String reset, int decision) {
        System.out.println(blue+"--Kyle, del sindicato minero--"+reset);
        System.out.println("Ha habido una explosion en la mina y han muerto 100 personas, ¿Debemos continuar picando?");
        System.out.println("1. Sí, continuad");
        System.out.println("2. No, podeis parar");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Encuentras algo más de oro, pero otra explosión azota la mina y los trabajadores hacen una revuelta");
            poderes[1] = poderes[1]-2;
            poderes[3] = poderes[3]+1;
            /*pueblo -2, economia +1*/
        }else if  (decision==2) {
            System.out.println("Los mineros se retiran de la mina, dejando algo de oro en su interior");
            /*Economia -1*/
            poderes[3] = poderes[3]-1;
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void negociarlapaz(String red, String reset, int decision) {
        System.out.println(red+"--General Adolfo de Douvres--"+reset);
        System.out.println("Estamos en guerra con demasiados enemigos a la vez, negociemos un alto al fuego");
        System.out.println("1. Sí, hagamoslo");
        System.out.println("2. No, no negociaremos algo asi");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Se negocia un alto al fuego a cambio de dinero, el ejercito se refuerza y el pueblo agradece la tregua");
            poderes[3] = poderes[3]-1;
            poderes[2] = poderes[2]+1;
            poderes[1] = poderes[1]+1;
            /*Ejercito +1, economia -1, pueblo +1*/
        }else if (decision==2) {
            System.out.println("Destinas a una gran parte del ejercito a la frontera para ir a la guerra");
            poderes[2] = poderes[2]-2;
            /*Ejercito -2*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void comercioexterior(String blue, String reset, int decision) {
        System.out.println(blue+"--Mercader Lucid Amnersio--"+reset);
        System.out.println("Queremos montar unos puestos en ciudades vecinas para incentivar el comercio fuera de la capital");
        System.out.println("1. Sí, hazlo");
        System.out.println("2. No, monta más puestos en la capital");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El comercio exterior funciona explendidamente bien, la economia se incentiva gracias a esto");
            poderes[3] = poderes[3]+1;
            /*Econimia +1*/
        }else if (decision==2) {
            System.out.println("Abrir más puestos en la capital no ha servido de nada, has malgastado dinero del reino abriendolos");
            poderes[3] = poderes[3]-1;
            /*Economia -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void explosionenlaciudad(String red, String reset, int decision) {
        System.out.println(red+"--Investigador jefe John Magnusson--"+reset);
        System.out.println("Ha habido una gran explosion en la ciudad, ¿Quieres que el ejercito cierre las puertas del reino mientras investigamos?");
        System.out.println("1. Sí, cerradlas");
        System.out.println("2. No, mantenedlas abiertas");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Se realiza la investigación y dos sospechosos son llevados al las mazmorras, la paz se restablece pero la economia no ha fluido durante unos dias");
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]+1;
            poderes[3] = poderes[3]-1;
            /*Ejercito +1, poblacion +1, econimia -1*/
        }else if (decision==2) {
            System.out.println("La economia sigue fluyendo, pero la investigacion se ve obstruida y se tarda una semana en establecer el orden nuevamente");
            poderes[3] = poderes[3]+1;
            poderes[2] = poderes[2]-1;
            poderes[1] = poderes[1]-1;
            /*Ejercito -1, poblacion -1, economia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void cazadebrujas(String red, String reset, int decision) {
        System.out.println(red+"--Comandante John Garryson--"+reset);
        System.out.println("Unos vecinos de la capital se han enfurecido y estan cazando brujas, ¿Hace falta recurrir a la fuerza?");
        System.out.println("1. Sí, hazlo");
        System.out.println("2. No, no hace falta");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El ejercito recurre a la fuerza y disuelve a los cazadores, las tropas se animan, pero la gente protesta y no entiende tus movimientos");
            poderes[2] = poderes[2]+1;
            poderes[1] = poderes[1]-1;
            /*Ejercito +1, pueblo -1*/
        }else if  (decision==2) {
            System.out.println("El pueblo termina las trifulcas dejando unas supuestas brujas muertas, agradecen haberles dejado cumplir su labor");
            poderes[1] = poderes[1]+1;
            poderes[0] = poderes[0]+1;
            /*Pueblo +1, iglesia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void campesinosatacados(String blue, String reset, int decision) {
        System.out.println(blue+"--Sir Leonid de Gilneas--"+reset);
        System.out.println("Los campesinos de mi aldea dicen haber sido atacados por seres de otro lugar, ¿Puedes enviar a las tropas?");
        System.out.println("1. Sí, enviare a las tropas");
        System.out.println("2. No, seguro que mienten para pagar menos impuestos");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Las tropas son enviadas, unas extrañas criaturas humanoides se encuentran en el bosque, defiendes la aldea pero pierdes unos buenos soldados");
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]+1;
            /*Ejercito -1, pueblo +1*/
        }else if  (decision==2) {
            System.out.println("El pueblo es dejado a su suerte, con el tiempo empiezan a desaparecer extrañamente algunos campesinos durante la noche");
            poderes[1] = poderes[1]-1;
            /*Pueblo -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }

    }

    private static void construirfortal(String red, String reset, int decision) {
        System.out.println(red+"--Comandante John Garryson--"+reset);
        System.out.println("Dejadnos construir fortalezas alrededor de la capital, es costoso, pero valdrá mucho la pensa");
        System.out.println("1. Sí, Construyelas");
        System.out.println("2. No, no gastaremos tanto dinero en eso");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Varias imponentes fortelezas se alzan en la frontera del reino, sin duda atacarnos será complicado");
            poderes[2] = poderes[2]+2;
            poderes[3] = poderes[3]-1;
            /*Ejercito +2, economia -1*/
        }else if  (decision==2) {
            System.out.println("El comandante reniega de tu decisión y se retira del castillo");
            poderes[2] = poderes[2]-1;
            /*Ejercito -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void oroenelrio(String blue, String reset, int decision) {
        System.out.println(blue+"--Matt, lider del sindicato del pueblo--"+reset);
        System.out.println("Hemos encontrado oro en la orilla del rio, ¿Que hacemos con el?");
        System.out.println("1. ¡Somos ricos!");
        System.out.println("2. ¡Soy rico!");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El reino florece en todos los sentidos gracias al oro");
            poderes[0] = poderes[0]+1;
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]+1;
            /*pueblo +1, ejercito +1, iglesia +1*/
        }else if  (decision==2) {
            System.out.println("El oro encontrado se suma a las arcas del reino, aumentando su riqueza");
            poderes[3] = poderes[3]+2;
            /*Economia +2*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void alianzavikinga(String red, String reset, int decision) {
        System.out.println(red+"--General Adolfo de Douvres--"+reset);
        System.out.println("Los reinos del sur proponen una alianza con los Vikingos, yo me fio de ellos");
        System.out.println("1. Sí, aliemonos");
        System.out.println("2. Pero yo no me fio de vos");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La alianza surge efecto, junto a los Vikingos las defensas del reino se fortalecen");
            poderes[2] = poderes[2]+1;
            /*Ejercito +1*/
        }else if (decision==2) {
            System.out.println("El general se retira del castillo, no con la mejor cara");
            poderes[2] = poderes[2]-1;
            /*Ejercito -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void medicoencuentro(String green, String reset, int decision) {
        System.out.println(green+"--Joseph, el medico de la corte--"+reset);
        System.out.println("Me gustaria organizar un encuentro cientifico con los doctores del oeste, en vuestro castillo");
        System.out.println("1. Sí, adelante con ello");
        System.out.println("2. No, no organices nada");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Se organiza una gran convencion de cientificos en tu reino, la economia florece y el pueblo esta contento, aunque el cardenal lo ve con malos ojos");
            poderes[0] = poderes[0]-1;
            poderes[1] = poderes[1]+1;
            poderes[3] = poderes[3]+1;
            /*Iglesia -1, pueblo +1, economia +1*/
        }else if (decision==2) {
            System.out.println("El doctor no esta de acuerdo con tu decisión y la convencion se cancela, el Arzobispo viene personalmente a agradecertelo");
            poderes[0] = poderes[0]+1;
            poderes[1] = poderes[1]-1;
            /*Iglesia +1, pueblo -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void curaenfadado(String yellow, String reset, int decision) {
        System.out.println(yellow+"--Arzobisto del Cartalejo--"+reset);
        System.out.println("Joseph, el medico esta realizando experimentos impios. ¡Su presencia en el seno de nuestro corte es blasfemia!");
        System.out.println("1. Sí, le pararemos los pies");
        System.out.println("2. No, dejalo trabajar");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Las investigaciones son frenadas, los doctores organizan una revuelta");
            poderes[0] = poderes[0]+1;
            poderes[1] = poderes[1]-1;
            /*Iglesia +1, pueblo -1*/
        }else if (decision==2) {
            System.out.println("El cardenal se siente ofendido con tu decisión");
            poderes[0] = poderes[0]-1;
            /*Iglesia -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void estadodelbanco(String green, String reset, int decision) {
        System.out.println(green+"--Thomas, contable de la corte--"+reset);
        System.out.println("La conomia esta receolsa, deberiamos ahorrar para evitar problemas");
        System.out.println("1. Sí, ahorraremos");
        System.out.println("2. No, no vamos a ahorrar");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Ahorras algo de dinero, el banco se estabiliza");
            poderes[3] = poderes[3]+2;
            /*Economia +2*/
        }else if (decision==2) {
            System.out.println("La crisis no es tan fuerte como pensabas, pero las arcas se ven afectadas por no ahorrar.");
            poderes[3] = poderes[3]-1;
            poderes[1] = poderes[1]+1;
            /*Economia -1*/
            /*Pueblo +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void reclutarsoldados(String red, String reset, int decision) {
        System.out.println(red+"--Comandante John Garryson--"+reset);
        System.out.println("Hay que estar dispuesto a todo. ¡Reclutemos más soldados!");
        System.out.println("1. Sí, reclutaremos");
        System.out.println("2. No, no es momento de reclutar");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El reclutamiento surge efecto, nuevos soldados se unen a tus tropas, pero el prueblo se queja por el reclutamiento forzoso");
            poderes[1] = poderes[1]-1;
            poderes[2] = poderes[2]+2;
            /*Pueblo -1, ejercito +2*/
        }else if (decision==2) {
            System.out.println("El pueblo agradece que evites el reclutamiento, pero el comandante no parece contento");
            poderes[1] = poderes[1]+1;
            poderes[2] = poderes[2]-1;
            /*Pueblo +1, ejercito -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void minerosaumento(String blue, String reset, int decision) {
        System.out.println(blue+"--Matt, lider del sindicato del pueblo--"+reset);
        System.out.println("Los mineros exigen un aumento, se niegan a cavar mas profundo");
        System.out.println("1. Sí, aumentaremos los salarios");
        System.out.println("2. No, los salarios se quedan como estan");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Los mineros aplauden tu decisión, las arcas se resienten");
            poderes[3] = poderes[3]-1;
            poderes[1] = poderes[1]+1;
            /*Economia -1, pueblo +1*/
        }else if (decision==2) {
            System.out.println("Los mineros estan descontentos, pero el banco te lo agradece");
            poderes[1] = poderes[1]-1;
            poderes[3] = poderes[3]+1;
            /*Pueblo -1, economia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void construirpuentes(String blue, String reset, int decision) {
        System.out.println(blue+"--James, del sindicato del pueblo--"+reset);
        System.out.println("¡Necesitamos más caminos para conectar las aldeas!");
        System.out.println("1. Sí, los construiremos");
        System.out.println("2. No, no construiremos los puentes");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("Los costes de la obra son pagados, nuevos caminos conectan el reino");
            poderes[3] = poderes[3]-1;
            poderes[1] = poderes[1]+1;
            /*Economia -1, pueblo +1*/
        }else if  (decision==2) {
            System.out.println("Te niegas a la construcción, las tensiones con el pueblo crecen");
            poderes[1] = poderes[1]-1;
            /*Pueblo -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void continuarinvestigacion(String green, String reset, int decision) {
        System.out.println(green+"--Joseph, el medico de la corte--"+reset);
        System.out.println("Mis investigaciones no son concluyentes, ¿Puedo continuarlas?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La investigacion ha sido costosa, pero se ha llegado a una nueva cura para la peste y hemos podido negociar con ella, las arcas crecen");
            poderes[3] = poderes[3]+1;
            /*Economia +1*/
        }else if  (decision==2) {
            System.out.println("La investigacion se cierra, la iglesia esta contenta con tu decisión");
            poderes[0] = poderes[0]+1;
            /*Iglesia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void costruiriglesia(String yellow, String reset, int decision) {
        System.out.println(yellow+"--Arzobispo del cardenal--"+reset);
        System.out.println("Hay que construir una nueva iglesia");
        System.out.println("1. Sí, costruyamosla");
        System.out.println("2. No, no vamos a construirla");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("La nueva iglesia ha sido costoosa, pero el cardenal esta contento con ella");
            poderes[0] = poderes[0]+1;
            poderes[3] = poderes[3]-1;
            /*Iglesia +1, economia -1*/
        }else if  (decision==2) {
            System.out.println("No se han movido las monedas de las arcas, pero el cardenal no esta contento con tu decisión");
            poderes[0] = poderes[0]-1;
            /*Iglesia -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void atacarsur(String red, String reset, int decision) {
        System.out.println(red+"--General Adolfo de Douvres--"+reset);
        System.out.println("¡Ataquemos el reino del sur! Su poder es mas debil cada dia");
        System.out.println("1. Sí, iniciad el ataque");
        System.out.println("2. No, no ataqueis");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El ataque ha surgido efecto, pero hemos perdido a buenos soldados");
            poderes[2] = poderes[2]-1;
            /*Ejercito -1*/
        }else if (decision==2) {
            System.out.println("Los ejercitos del sur han tomado una de nuestras aldeas");
            poderes[1] = poderes[1]-1;
            /*Pueblo -1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }

    private static void cosechabuenamatt(String blue, String reset, int decision) {
        System.out.println(blue+"--Mat, lider del sindicato del pueblo--"+reset);
        System.out.println("¡La cosecha es magnifica este año!");
        System.out.println("1. Alimentad al pueblo");
        System.out.println("2. Alimentad al ejercito");
        decision = input.nextInt();
        if(decision==1){
            System.out.println("El pueblo ha sido bien alimentado, pese a las quejas del ejercito la ecomomia florece");
            poderes[0] = poderes[0]+1;
            poderes[1] = poderes[1]+2;
            poderes[2] = poderes[2]-1;
            poderes[3] = poderes[3]+1;
            /*Ejercito -1, pueblo +2, iglesia +1, economia +1*/
        }else if (decision==2) {
            System.out.println("El ejercito ha sido bien alimentado, pese a las quejas del pueblo laeconomia florece");
            poderes[0] = poderes[0]+1;
            poderes[1] = poderes[1]-1;
            poderes[2] = poderes[2]+2;
            poderes[3] = poderes[3]+1;
            /*Ejercito +2, pueblo -1, iglesia +1, economia +1*/
        }else{
            System.out.println("Error, introduce un numero valido");
        }
    }
}

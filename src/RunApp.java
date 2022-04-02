import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database myDatabase = new Database();

        String name;
        String surname;

        int day;
        int month;
        int year;

        float gpa;

        boolean run = true;

        while(run) {
            System.out.println("Vyberte požadovanou činnost:\n");
            System.out.println(" 01  přidat studenta");
            System.out.println(" 02  nová známka");
            System.out.println(" 03  odstranit studenta");
            System.out.println(" 04  informace o studentovi");
            System.out.println(" 05  spustit studentovu schopnost");
            System.out.println(" 06  vypsat seznam všech studentů");
            System.out.println(" 07  průměr oborů");
            System.out.println(" 08  množství studentů v oborech");
            System.out.println(" 09  načíst databázi ze souboru");
            System.out.println(" 10  uložit databázi do souboru");
            System.out.println(" 11  smazat databází");
            System.out.println(" 00  ukončit program\n\n");

            int option = Controls.onlyInt(sc);

            switch (option) {
                case 1:
                    System.out.println("Vyberte obor: ");
                    System.out.println(" 1  Technický obor");
                    System.out.println(" 2  Humanitní obor");
                    System.out.println(" 3  Kombinovaný obor");

                    int branch = Controls.onlyInt(sc);
                    switch (branch) {
                        case 1:

                    }
                case 11:
                    myDatabase = new Database();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    run = true;
                    break;

            }
        }



    }


}

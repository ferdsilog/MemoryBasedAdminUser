import java.util.Scanner;

public class MemoryBased {

    public static void main(String[] args) {
        int maximum = 100;
        String[] userName = new String[maximum];
        String[] passWord = new String[maximum];
        int[] id = new int[maximum];
        int count = 0;
        String choose2 = "y";
        boolean access = false;
        boolean exist = false;
        String userAdmin = "admin123";
        String passAdmin = "password123";

        Scanner input = new Scanner(System.in);

        System.out.println("---Log in---");
        System.out.print("User: ");
        String enterUser = input.nextLine();

        System.out.print("Pass: ");
        String enterPass = input.nextLine();


        if (enterUser.equals(userAdmin) && enterPass.equals(passAdmin)) {
            System.out.println("Access Granted!");
            access = true;
        }

        if (access) {
            do {



                System.out.println("---SELECT----");
                System.out.println("1. Add user");
                System.out.println("2. User list");
                System.out.println("3. Delete user");
                System.out.println("4. Search user by ID");
                System.out.println("5. Exit");
                System.out.print("Choose (1 - 5) :");

                if (!input.hasNextInt()){
                    System.out.println("Invalid Input!");
                    input.nextLine();
                    continue;
                }

                int choose = input.nextInt();
                input.nextLine();


                if (choose == 1) {
                    if (count == maximum) {
                        System.out.println();
                        System.out.println("User storage is FULL!");
                        System.out.println();
                        continue;
                    } else {
                        System.out.print("Enter ID: ");

                        if(!input.hasNextInt()) {
                            System.out.println("Invalid ID!");
                            input.nextLine();
                            continue;
                        }


                        id[count] = input.nextInt();
                        input.nextLine();

                        exist = false;

                        for (int i = 0; i < count; i++){
                            if (id[count]==id[i]){
                                System.out.println("ID exist! try another ID.");
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            System.out.print("Username: ");
                            userName[count] = input.nextLine();

                            System.out.print("Password: ");
                            passWord[count] = input.nextLine();

                            count++;

                            System.out.println("Registered!");
                        }
                    }

                } else if (choose == 2) {
                    if (count == 0) {
                        System.out.println("No users registered!");
                    } else {
                        System.out.println("---User List---");
                        System.out.println();
                        for (int i = 0; i < count; i++) {


                            System.out.println("User ID : " + id[i]);
                            System.out.println("Name : " + userName[i]);
                            System.out.println("Password : " + passWord[i]);
                        }
                    }
                } else if (choose == 3) {
                    boolean deleted = false;
                    System.out.println("Enter ID to delete user");

                    if(!input.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        input.nextLine();
                        continue;
                    }

                    int EnterID = input.nextInt();
                    input.nextLine();

                    for (int i = 0; i < count; i++) {
                        if (id[i] == EnterID) {
                            for (int j = i; j < count - 1; j++) {
                                id[j] = id[j + 1];
                                userName[j] = userName[j + 1];
                                passWord[j] = passWord[j + 1];
                            }
                            count--;
                            System.out.println("Deleted!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("\n" + "No user found with that ID.");
                    }
                } else if (choose == 4) {
                    boolean found = false;

                    System.out.println("Enter user ID: ");

                    if(!input.hasNextInt()) {
                        System.out.println("Invalid ID!");
                        input.nextLine();
                        continue;
                    }

                    int searchID = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < count; i++) {
                        if (searchID == id[i]) {
                            System.out.println("----User Information----");
                            System.out.println("ID :" + id[i]);
                            System.out.println("Name :" + userName[i]);
                            System.out.println("Password: " + passWord[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found!");
                    }
                } else if (choose == 5) {
                    return;
                } else {
                    System.out.println("Invalid Choice!");
                }

                System.out.println();
                System.out.println("choose (y) back to menu, (n) to exit");
                choose2 = input.nextLine();


            } while (choose2.equalsIgnoreCase("y"));

            System.out.println("Exiting...");
        }

        if (!access) {
            System.out.println("Access Denied!");
        }

        input.close();
    }
}

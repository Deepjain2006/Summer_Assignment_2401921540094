interface LibraryUser {
    void registerAccount();
    void requestBook();
}

class KidUser implements LibraryUser {
    int age;
    String bookType;
    @Override
    public void registerAccount() {
        if (age < 12) {
            System.out.println("You have successfully registered under a Kids Account");
        } else {
            System.out.println("Sorry, Age must be less than 12 to register as a kid");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equalsIgnoreCase("Kids")) {
            System.out.println("Book Issued successfully, please return the book within 10 days");
        } else {
            System.out.println("Oops, you are allowed to take only kids books");
        }
    }
}


class AdultUser implements LibraryUser {
    int age;
    String bookType;

    @Override
    public void registerAccount() {
        if (age > 12) {
            System.out.println("You have successfully registered under an Adult Account");
        } else {
            System.out.println("Sorry, Age must be greater than 12 to register as an adult");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equalsIgnoreCase("Fiction")) {
            System.out.println("Book Issued successfully, please return the book within 7 days");
        } else {
            System.out.println("Oops, you are allowed to take only adult Fiction books");
        }
    }
}

public class LibraryInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("----- Test Case #1 : KidUser -----");
        KidUser kid = new KidUser();
        kid.age = 10;
        kid.registerAccount();
        kid.age = 18;
        kid.registerAccount();
        kid.bookType = "Kids";
        kid.requestBook();
        kid.bookType = "Fiction";
        kid.requestBook();

        System.out.println("\n----- Test Case #2 : AdultUser -----");
        AdultUser adult = new AdultUser();
        adult.age = 5;
        adult.registerAccount();
        adult.age = 23;
        adult.registerAccount();
        adult.bookType = "Kids";
        adult.requestBook();
        adult.bookType = "Fiction";
        adult.requestBook();
    }
}


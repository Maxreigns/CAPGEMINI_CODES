package capgemeini_training;

public class Assignment_22Jan_Relationship {
    public static void main(String[] args) {
        Passport p = new Passport("36728267");
        Person person = new Person("Mayank", p);
        System.out.println("Person " + person.name + ", pass no: " + person.passport.passNo);

        Engine e = new Engine("132637");
        Car car = new Car("Range Rover", e);
        System.out.println("Car Name: " + car.carName + ", Engine No: " + car.engine.engineNo);

        Book b=new Book("Atomic Habits");
        Library lib=new Library("GCET library", new Book[]{b});
        System.out.println("Library Name: " + lib.libraryName + ", Book Title: " + lib.books[0].bookTitle);
    }
}

// Person-Passport (1:1)
class Passport {
    String passNo;

    Passport(String passNo) {
        this.passNo = passNo;
    }
}

class Person {
    String name;
    Passport passport;

    Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}

// car-engine(1:1)
class Engine {
    String engineNo;

    Engine(String engineNo) {
        this.engineNo = engineNo;
    }
}

class Car {
    String carName;
    Engine engine;

    Car(String carName, Engine engine) {
        this.carName = carName;
        this.engine = engine;
    }
}
//Library - Book (1:Many)
class Library {
    String libraryName;
    Book[] books;

    Library(String libraryName, Book[] books) {
        this.libraryName = libraryName;
        this.books = books;
    }
}
class Book {
    String bookTitle;

    Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}

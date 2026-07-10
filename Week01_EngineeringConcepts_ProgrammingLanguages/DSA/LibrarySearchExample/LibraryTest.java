public class LibraryTest {

    public static void main(String[] args) {

        Book[] unsortedBooks = {
            new Book(105, "The Hobbit", "J.R.R. Tolkien"),
            new Book(101, "1984", "George Orwell"),
            new Book(110, "To Kill a Mockingbird", "Harper Lee"),
            new Book(102, "Brave New World", "Aldous Huxley"),
            new Book(108, "Moby Dick", "Herman Melville")
        };

        Book[] sortedBooks = {
            new Book(101, "1984", "George Orwell"),
            new Book(102, "Brave New World", "Aldous Huxley"),
            new Book(108, "Moby Dick", "Herman Melville"),
            new Book(105, "The Hobbit", "J.R.R. Tolkien"),
            new Book(110, "To Kill a Mockingbird", "Harper Lee")
        };

        String targetTitle = "Moby Dick";

        long startLinear = System.nanoTime();
        Book linearResult = LinearSearchBook.search(unsortedBooks, targetTitle);
        long endLinear = System.nanoTime();

        System.out.println("=== Linear Search ===");
        System.out.println("Result: " + linearResult);
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        System.out.println();

        long startBinary = System.nanoTime();
        Book binaryResult = BinarySearchBook.search(sortedBooks, targetTitle);
        long endBinary = System.nanoTime();

        System.out.println("=== Binary Search ===");
        System.out.println("Result: " + binaryResult);
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");

        System.out.println();

        String missingTitle = "The Great Gatsby";
        System.out.println("=== Searching for a non-existent book: \"" + missingTitle + "\" ===");
        Book linearMiss = LinearSearchBook.search(unsortedBooks, missingTitle);
        Book binaryMiss = BinarySearchBook.search(sortedBooks, missingTitle);
        System.out.println("Linear Search result: " + linearMiss);
        System.out.println("Binary Search result: " + binaryMiss);
    }
}
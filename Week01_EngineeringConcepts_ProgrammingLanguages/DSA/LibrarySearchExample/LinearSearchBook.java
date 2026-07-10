public class LinearSearchBook {

    public static Book search(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return books[i];
            }
        }
        return null; 
    }
}
public class BinarySearchBook {

    public static Book search(Book[] sortedBooks, String targetTitle) {
        int low = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midTitle = sortedBooks[mid].getTitle();

            int comparison = midTitle.compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return null; 
    }
}
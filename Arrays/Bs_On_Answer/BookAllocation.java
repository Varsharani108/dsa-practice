public class BookAllocation {

    public static int allocateBooks(int[] books, int students) {

        // Not enough books for every student
        if (books.length < students) {
            return -1;
        }

        int low = 0;
        int high = 0;

        // Minimum possible answer = maximum book pages
        // Maximum possible answer = total pages
        for (int pages : books) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int studentsRequired = 1;
            int currentPages = 0;

            // Allocate books sequentially
            for (int pages : books) {

                if (currentPages + pages <= mid) {
                    currentPages += pages;
                } else {
                    studentsRequired++;
                    currentPages = pages;
                }
            }

            if (studentsRequired <= students) {

                // Possible
                ans = mid;

                // Try smaller maximum pages
                high = mid - 1;

            } else {

                // Need more students,
                // so maximum pages must increase
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] books = {10, 20, 30, 40};
        int students = 2;

        System.out.println(allocateBooks(books, students));
    }
}
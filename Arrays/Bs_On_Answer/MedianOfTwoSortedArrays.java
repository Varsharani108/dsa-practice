public class MedianOfTwoSortedArrays {

    public static double findMedian(int[] nums1, int[] nums2) {

        // Binary search on smaller array
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[cut1 - 1];

            int right1 = (cut1 == n1)
                    ? Integer.MAX_VALUE
                    : nums1[cut1];

            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[cut2 - 1];

            int right2 = (cut2 == n2)
                    ? Integer.MAX_VALUE
                    : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements
                if ((n1 + n2) % 2 != 0) {
                    return Math.max(left1, left2);
                }

                // Even number of elements
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // Move partition to left
            if (left1 > right2) {
                high = cut1 - 1;
            }

            // Move partition to right
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 8};
        int[] nums2 = {2, 4, 9, 10};

        System.out.println(findMedian(nums1, nums2));
    }
}
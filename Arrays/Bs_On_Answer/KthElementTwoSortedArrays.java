public class KthElementTwoSortedArrays {

    public static int kthElement(int[] nums1, int[] nums2, int k) {

        // Always binary search on smaller array
        if (nums1.length > nums2.length) {
            return kthElement(nums2, nums1, k);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Number of elements taken from nums1
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

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

                return Math.max(left1, left2);
            }

            // Took too many elements from nums1
            if (left1 > right2) {
                high = cut1 - 1;
            }

            // Took too few elements from nums1
            else {
                low = cut1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};

        int k = 5;

        System.out.println(kthElement(nums1, nums2, k));
    }
}
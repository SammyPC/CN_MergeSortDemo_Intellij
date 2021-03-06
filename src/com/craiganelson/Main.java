package com.craiganelson;

public class Main
{  // Begin Main Class

    public static void main(String[] args)
    { // Begin main method

        MergeSortDemo();
        
    }  // End main method

    public static void  MergeSortDemo()

    { // Start MergeSortDemo()

        int[] a = {1, 6, 2, 5, 8, 4, 3, 9, 7}; // is an integer array
        int[] temp = new int[a.length];     // empty temporary array, the same size and type as a[]

        // display array before sorting
        displayArray(a);

        // sort the entire array
        mergeSort(a, temp, 0, (a.length - 1));

        // display array after sorting
        displayArray(a);

    }// Start MergeSortDemo()

    //*******************************************************************

    public static void mergeSort(int[] a, int[] temp, int low, int high)

    {  // Begin mergeSort(int[] a, int[] temp, int low, int high)


        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted

        int mid;  // the middle of the array – last item in low half

        // if high > low then there is more than one item in the list to be sorted
        if (high > low)
        {  // Begin  if (high > low)

            // split into two halves and mergeSort each part

            // find middle (last element in low half)
            mid = (low+high)/2;
            mergeSort(a, temp, low, mid );
            mergeSort(a, temp, mid+1, high);

            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);

        }  // End   if (high > low)

        return;

    }// End  mergeSort(int[] a, int[] temp, int low, int high)

    //********************************************************************


    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     *
     * The work of sorting occurs as the two halves are merged back into one
     * sorted set.
     *
     * This version of mergesort copies the set to be sorted into the same
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */
    public static void merge(int[] a, int[] temp, int low, int mid, int high)
    { // Start merge(int[] a, int[] temp, int low, int mid, int high)

        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half

        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++)
        { // Begin (int i = low; i <= high; i++)

            temp[i] = a[i];

        } // End (int i = low; i <= high; i++)

        //set up necessary pointers
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half
        while ((lowP <= mid) && (highP <= high))
        {  // Begin while ((lowP <= mid) && (highP <= high))

            // if current item in low half <= current item in high half
            if (temp[lowP] <= temp[highP])
            {  // Begin (temp[lowP] <= temp[highP])

                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;

            } //  End  (temp[lowP] <= temp[highP])

            else
            { // Begin else (temp[lowP] <= temp[highP])

                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;

            } // End else (temp[lowP] <= temp[highP])

            // increment pointer for location in original array
            aP++;

        } // End while ((lowP <= mid) && (highP <= high))

        /* When the while loop is done, either the low half or the high half is done.
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */

        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid)
            // Begin if (lowP > mid)

            for (int i = highP; i <= high; i++)
            {  // Begin for (int i = highP; i <= high; i++)

                a[aP] = temp[i];
                aP++;

            }   // End for (int i = highP; i <= high; i++)

            // End  if (lowP > mid)

        else // high half is done, move rest of low half
            // Begin else (lowP > mid)

            for (int i = lowP; i <= mid; i++)
            { // Begin   for (int i = lowP; i <= mid; i++)

                a[aP] = temp[i];
                aP++;

            }// End   for (int i = lowP; i <= mid; i++)

        // End  else (lowP > mid)
        return;

    } // End merge(int[] a, int[] temp, int low, int mid, int high)

    // *************************************************************

    public static void displayArray(int[] a)
    {  // Begin displayArray(int[] a)

        for (int i = 0; i < a.length; i++)
        {  // Begin (int i = 0; i < a.length; i++)

            System.out.print(a[i] + " ");

        }   // End  (int i = 0; i < a.length; i++)

        System.out.println();

    } // end displayArray(int[] a)


}// Begin Main Class

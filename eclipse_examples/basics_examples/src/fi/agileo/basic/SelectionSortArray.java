package fi.agileo.basic;

public class SelectionSortArray {
    public static void main(String[] args) {
        int i;

        int[] data = generateData(20);

        System.out.println("Original:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        selectionSort(data );
        System.out.println("After sorting:");
        for (i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    /**
     * Metodi järjestää parametrina annettavan datajoukon ja palauttaa
     * järjestetyn taulukon.
     *
     * @param data Sorting array
     * @exception ArrayIndexOutOfBoundsException
     *
     */
    public static void selectionSort(int[] data) {
        int i, k;
        int smallest;
        int length = data.length;
        for (i = length -1; i > 0; i--) {
            smallest = 0;
            // try to find the smallest element
            for (k = 1; k <= i; k++) {
                if (data[smallest] < data[k]) {
                    smallest = k;
                }
            }

            // vaihtaa pienimmän elementin paikassa i olevan elementin kanssa
            int tmp = data[i];
            data[i] = data[smallest];
            data[smallest] = tmp;
        }
    }

    public static int[] generateData(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n);
        }
        return arr;
    }
}

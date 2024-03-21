public class Array3D {
    public static void main(String[] args) {
        String arr [][][] = {{{"Veda", "2217051004", "D"}, {"Febri", "2217051019", "D"}, {"Heru", "2217051071", "D"}, {"Veda", "2217051004", "D"}, {"Veda", "2217051004", "D"}, {"Veda", "2217051004", "D"}, {"Veda", "2217051004", "D"}, {"Veda", "2217051004", "D"}, {"Veda", "2217051004", "D"}, {"Naura", "2217051079", "D"} }};
 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Mahasiswa #" + (j+1));
                System.out.println("Nama \t: " + arr[i][j][0]);
                System.out.println("NPM \t: " + arr[i][j][1]);
                System.out.println("Kelas \t: " + arr[i][j][2]);
                System.out.println();
            }
        }
    }
}
package Nomor3;



public class Classroom {
    private static String[] roomList = {"GIK L1 C", "GIK L2", "MIPA T L1 A", "MIPA T L1 B"};

    public static String[] getRoomList() {
        return Classroom.roomList;
    } 

    public static boolean isValidRoom(String room) {
        for (int i = 0; i < Classroom.roomList.length; ++i) {
            if (Classroom.roomList[i] == room) {
                return true;
            }
        }

        return false;
    }
}

public class Sinhvien{

    String svID;
    String tenSinhvien;
    String diachi;

    //operation

    public void ganTenSV(String tenSV){
        tenSinhvien = tenSV;
    }

    public void inTenSV(){

        System.out.println("Sinh vien co ten la: " + tenSinhvien);
    }
}
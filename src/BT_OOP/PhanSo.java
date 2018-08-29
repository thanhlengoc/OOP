/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT_OOP;

/**
 *
 * @author ThanhLe
 */
import java.io.*;

public class PhanSo {
    protected int ts, ms;
    PhanSo(){}
    PhanSo(int tu, int mau) {
        ts = tu;
        ms = mau;
    }
    static int nhapgt() throws IOException {
        //String str;
        //DataInputStream cin = new DataInputStream(System.in);
        InputStreamReader ip = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        return Integer.parseInt(br.readLine());
    }
    PhanSo nhapps(int x) throws IOException{
        InputStreamReader ip = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        System.out.println("Nhap phan so thu "+x);
        System.out.print("Tu so: ");
        int tu = Integer.parseInt(br.readLine());
        System.out.print("Mau so: ");
        int mau = Integer.parseInt(br.readLine());
        while(mau == 0){                       
            System.out.print("nhap lai mau so: ");
            mau= Integer.parseInt(br.readLine());
        } 
        PhanSo ps = new PhanSo(tu, mau);
        return ps;
    }
    static int UCLN(int a, int b) {
        if(b == 0 ) return a;
        return UCLN(b, a%b);
    }
    static PhanSo toigian(PhanSo ps){
        PhanSo p = new PhanSo();
        p.ts = ps.ts/UCLN(Math.abs(ps.ts), Math.abs(ps.ms));
        p.ms = ps.ms/UCLN(Math.abs(ps.ts), Math.abs(ps.ms));
        return p;
    }
    static PhanSo tong(PhanSo ps1, PhanSo ps2) {
        PhanSo pstong = new PhanSo();
        pstong.ts = ps1.ts*ps2.ms + ps2.ts*ps1.ms;
        pstong.ms = ps1.ms*ps2.ms;
        if(pstong.ts != 0)
            pstong = toigian(pstong);
        return pstong;
    }
    static PhanSo hieu(PhanSo ps1, PhanSo ps2){
        PhanSo pshieu = new PhanSo();
        pshieu.ts = ps1.ts*ps2.ms - ps2.ts*ps1.ms;
        pshieu.ms = ps1.ms*ps2.ms;
        if(pshieu.ts != 0)
            pshieu = toigian(pshieu);
        return pshieu;
    }
    static PhanSo tich(PhanSo ps1, PhanSo ps2){
        PhanSo pstich = new PhanSo();
        pstich.ts = ps1.ts*ps2.ts;
        pstich.ms = ps2.ms*ps1.ms;
        if(pstich.ts != 0)
            pstich = toigian(pstich);
        return pstich;
    }
    static PhanSo thuong(PhanSo ps1, PhanSo ps2){
        PhanSo psthuong = new PhanSo();
        psthuong.ts = ps1.ts*ps2.ms;
        psthuong.ms = ps1.ms*ps2.ts;
        if(psthuong.ts != 0)
            psthuong = toigian(psthuong);
        return psthuong;
    }
    static void hienthi(PhanSo ps) {
        if(ps.ts==0 || ps.ms==1) 
            System.out.println(ps.ts);
        else
            System.out.println(ps.ts+"/"+ps.ms);
    }
    public static void main(String args[]) throws IOException{
        PhanSo ps1 = new PhanSo();
        PhanSo ps2 = new PhanSo();
        ps1=ps1.nhapps(1);
        ps2=ps2.nhapps(2);
        if(ps1.ts != 0)
            ps1= toigian(ps1);
        if(ps2.ts != 0)
            ps2= toigian(ps2);
        System.out.print("phan so 1 toi gian: "); hienthi(ps1);
        System.out.print("phan so 2 toi gian: "); hienthi(ps2);
        System.out.print("tong 2 phan so: "); hienthi(tong(ps1, ps2));
        System.out.print("hieu 2 phan so: "); hienthi(hieu(ps1, ps2));
        System.out.print("tich 2 phan so: "); hienthi(tich(ps1, ps2));
        if(ps2.ts != 0){
            System.out.print("thuong cua phanso1/phanso2: "); 
            hienthi(thuong(ps1, ps2));
        }
        else
            System.out.println("khong the thuc hien ps1/ps2."); 
    }
}

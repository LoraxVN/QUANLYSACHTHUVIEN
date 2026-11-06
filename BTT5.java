import java.util.ArrayList;
import java.util.Scanner;

// Lớp biểu diễn thông tin Sách
class Sach {
    String maSach;
    String tenSach;
    double donGia;
    int soLuong;

    // Constructor
    public Sach(String maSach, String tenSach, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Hiển thị thông tin sách dạng hàng
    public void xuatThongTin() {
        double thanhTien = donGia * soLuong;
        System.out.printf("Mã: %-8s | Tên: %-22s | Đơn giá: %,10.0f | SL: %-4d | Thành tiền: %,12.0f VND\n",
                maSach, tenSach, donGia, soLuong, thanhTien);
    }
}

public class BTT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon;

        // BÀI 3: Menu lặp liên tục cho đến khi chọn 0 để Thoát
        do {
            System.out.println("\n=================== MENU QUẢN LÝ THƯ VIỆN (TUẦN 5) ===================");
            System.out.println("1. [Bài 1] Nhập n sách bằng vòng lặp");
            System.out.println("2. [Bài 2] Tính tổng số lượng và tổng giá trị sách");
            System.out.println("3. [Bài 4] Tìm sách theo mã");
            System.out.println("4. [Bài 5 - Mở rộng] Tìm sách có giá cao nhất / Sắp xếp theo giá");
            System.out.println("5. [Bài 5 - Mở rộng] Xóa sách theo mã");
            System.out.println("0. [Bài 3] Thoát");
            System.out.println("=====================================================================");
            System.out.print("Mời bạn chọn chức năng (0-5): ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Tránh trôi lệnh do phím Enter

            switch (luaChon) {
                case 1:
                    // BÀI 1: Nhập n sách bằng vòng lặp for
                    System.out.print("\nNhập số lượng sách cần thêm (n): ");
                    int n = sc.nextInt();
                    sc.nextLine(); // Tránh trôi lệnh

                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập sách thứ " + (i + 1) + " ---");
                        System.out.print("Nhập mã sách: ");
                        String ma = sc.nextLine();

                        System.out.print("Nhập tên sách: ");
                        String ten = sc.nextLine();

                        System.out.print("Nhập đơn giá: ");
                        double gia = sc.nextDouble();

                        System.out.print("Nhập số lượng: ");
                        int sl = sc.nextInt();
                        sc.nextLine(); // Tránh trôi lệnh

                        danhSachSach.add(new Sach(ma, ten, gia, sl));
                    }
                    System.out.println("=> Đã nhập thành công " + n + " cuốn sách!");
                    break;

                case 2:
                    // BÀI 2: Tính tổng số lượng và tổng giá trị sách
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[!] Thư viện chưa có cuốn sách nào. Vui lòng chọn 1 để nhập trước!");
                    } else {
                        System.out.println("\n----------------- DANH SÁCH SÁCH TRONG THƯ VIỆN -----------------");
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;

                        for (Sach s : danhSachSach) {
                            s.xuatThongTin();
                            tongSoLuong += s.soLuong;
                            tongGiaTri += (s.soLuong * s.donGia);
                        }
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println(">> TỔNG SỐ LƯỢNG SÁCH: " + tongSoLuong + " cuốn");
                        System.out.printf(">> TỔNG GIÁ TRỊ SÁCH : %,.0f VND\n", tongGiaTri);
                    }
                    break;

                case 3:
                    // BÀI 4: Tìm sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[!] Danh sách rỗng, vui lòng nhập sách trước!");
                    } else {
                        System.out.print("\nNhập mã sách cần tìm: ");
                        String maCanTim = sc.nextLine();

                        boolean timThay = false;
                        for (Sach s : danhSachSach) {
                            if (s.maSach.equalsIgnoreCase(maCanTim)) {
                                System.out.println("\n[+] ĐÃ TÌM THẤY SÁCH:");
                                s.xuatThongTin();
                                timThay = true;
                                break;
                            }
                        }

                        if (!timThay) {
                            System.out.println("[-] Không tìm thấy sách có mã: " + maCanTim);
                        }
                    }
                    break;

                case 4:
                    // BÀI 5 (Chức năng mở rộng 1): Tìm sách có giá cao nhất
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[!] Danh sách rỗng!");
                    } else {
                        double giaMax = danhSachSach.get(0).donGia;
                        // Tìm giá cao nhất
                        for (Sach s : danhSachSach) {
                            if (s.donGia > giaMax) {
                                giaMax = s.donGia;
                            }
                        }

                        System.out.printf("\n[+] CÁC SÁCH CÓ ĐƠN GIÁ CAO NHẤT (%,.0f VND):\n", giaMax);
                        for (Sach s : danhSachSach) {
                            if (s.donGia == giaMax) {
                                s.xuatThongTin();
                            }
                        }
                    }
                    break;

                case 5:
                    // BÀI 5 (Chức năng mở rộng 2): Xóa sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("\n[!] Danh sách rỗng!");
                    } else {
                        System.out.print("\nNhập mã sách muốn xóa: ");
                        String maXoa = sc.nextLine();

                        boolean daXoa = false;
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            if (danhSachSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                                danhSachSach.remove(i);
                                daXoa = true;
                                System.out.println("=> Đã xóa thành công sách có mã: " + maXoa);
                                break;
                            }
                        }

                        if (!daXoa) {
                            System.out.println("[-] Không tìm thấy mã sách để xóa!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nĐã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng chọn lại (0-5)!");
            }
        } while (luaChon != 0);

        sc.close();
    }
}


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NhanVienServiceTest {
    private NhanVienService service;

    @BeforeEach
    public void setUp() {
        service = new NhanVienService();
    }

//unit test hàm thêm
    @Test
    //Phân vùng họp lệ
    public void themnhanvien_luonghoplela8tr() {
        NhanVien nv = new NhanVien("NV01", "Nguyễn Trường", 25, 8_000_000, "IT");
        assertTrue(service.themNhanVien(nv));
    }

    @Test
    public void themnhanvien_luonghople99tr() {
        NhanVien nv = new NhanVien("NV02", "Nguyễn Hoàng Nam", 28, 99_000_000, "Kế toán");
        assertTrue(service.themNhanVien(nv));
    }
    @Test
    public void themnhanvien_Luonghople1trieu() {
        NhanVien nv = new NhanVien("NV03", "Nguyễn Trường", 40, 1_000_000, "IT");
        assertTrue(service.themNhanVien(nv));
    }

    @Test
    public void themnhanVien_Luongkhonghopleluongam() {
        NhanVien nv = new NhanVien("NV02", "Phạm Mai", 30, -5000, "HR");
        assertThrows(IllegalArgumentException.class, () -> service.themNhanVien(nv));
    }


    @Test
    public void themhhanvien_Luongkhonghoplebang0() {
        NhanVien nv = new NhanVien("NV03", "Le Thi nga", 28, 0, "kế toán");
        assertThrows(IllegalArgumentException.class, () -> service.themNhanVien(nv));
    }


    @Test
    public void themnhanvien_LuongkhongHopLeluongqualon() {
        NhanVien nv = new NhanVien("NV04", "Hoang Thi Huong", 35, 150_000_000, "Marketing");
        assertThrows(IllegalArgumentException.class, () -> service.themNhanVien(nv));
    }


    @Test
    public void themNhanVien_khongHopLe_tentrong() {
        NhanVien nv = new NhanVien("NV05", "", 26, 800000, "IT");
        assertThrows(IllegalArgumentException.class, () -> service.themNhanVien(nv));
    }


    @Test
    public void themNhanVien_khongHopLenull() {
        assertThrows(IllegalArgumentException.class, () -> service.themNhanVien(null));
    }

// unit test sửa nhân viên

    @Test
    public void suaNhanVien_hople() {
        // thêm trước 1 nhân viên để đảm bảo có mã NV01 trong danh sách
        service.themNhanVien(new NhanVien("NV01", "Nguyễn Thị Mai", 25, 5000000, "IT"));

        NhanVien nvMoi = new NhanVien("NV01", "Nguyễn ", 30, 10_000_000, "HR");
        assertTrue(service.suaNhanVien("NV01", nvMoi));
    }
    //viết thêm case sửa lương hợp lệ 1tr,99 tr, 5 tr

    @Test
    public void suaNhanVien_khonghople_matrong() {
        NhanVien nvMoi = new NhanVien("NV01", "Phạm Bình ", 25, 5_000_000, "IT");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("", nvMoi));
    }

    @Test
    public void suaNhanVien_khonghople_manull() {
        NhanVien nvMoi = new NhanVien("NV01", "Phạm Bảo", 25, 5_000_000, "IT");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien(null, nvMoi));
    }

    @Test
    public void suaNhanVien_khongHopLenull() {
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("NV01", null));
    }

    @Test
    public void suaNhanVien_khongHopLe_tenTrong() {
        NhanVien nvMoi = new NhanVien("NV01", "", 30, 8_000_000, "HR");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("NV01", nvMoi));
    }

    @Test
    public void suaNhanVien_khongHopLe_phongbanTrong() {
        NhanVien nvMoi = new NhanVien("NV01", "Nguyễn Văn Nam", 30, 8_000_000, "");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("NV01", nvMoi));
    }

    @Test
    public void suaNhanVien_khongHopLe_luongAm() {
        NhanVien nvMoi = new NhanVien("NV01", "Nguyen Hoàng", 28, -1000, "IT");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("NV01", nvMoi));
    }

    @Test
    public void suaNhanVien_khongHopLe_luongquaLon() {
        NhanVien nvMoi = new NhanVien("NV01", "Nguyen B", 28, 200_000_000, "IT");
        assertThrows(IllegalArgumentException.class, () -> service.suaNhanVien("NV01", nvMoi));
    }
}

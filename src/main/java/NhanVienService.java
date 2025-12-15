import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    private List<NhanVien> dsNhanVien = new ArrayList<>();

    //thêm nhân viên
    public boolean themNhanVien(NhanVien nv) {
        if (nv == null) {
            throw new IllegalArgumentException("Đối tượng nhân viên không được null");
        }

        if (nv.getMaNV().isEmpty() || nv.getTenNV().isEmpty() || nv.getPhongBan().isEmpty()) {
            throw new IllegalArgumentException("Các trường không được để trống");
        }

        if (nv.getLuong() <= 0 || nv.getLuong() > 100_000_000) {
            throw new IllegalArgumentException("Lương phải > 0 và <= 100,000,000");
        }

        dsNhanVien.add(nv);
        return true;
    }

    //hàm sửa
    public boolean suaNhanVien(String maNV, NhanVien nvMoi) {
        if (maNV == null || maNV.isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không hợp lệ");
        }

        if (nvMoi == null) {
            throw new IllegalArgumentException("Đối tượng nhân viên mới không được null");
        }

        // Kiểm tra dữ liệu mới hợp lệ
        if (nvMoi.getTenNV().isEmpty() || nvMoi.getPhongBan().isEmpty()) {
            throw new IllegalArgumentException("Các trường không được để trống");
        }

        if (nvMoi.getLuong() <= 0 || nvMoi.getLuong() > 100_000_000) {
            throw new IllegalArgumentException("Lương phải > 0 và <= 100,000,000");
        }


        return true;
    }

    // lấy danh sách nhân viên
    public List<NhanVien> getAll() {
        return dsNhanVien;
    }
}


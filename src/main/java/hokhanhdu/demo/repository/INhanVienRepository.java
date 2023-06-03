package hokhanhdu.demo.repository;


import hokhanhdu.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}

package hokhanhdu.demo.repository;


import hokhanhdu.demo.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhongBanRepository extends JpaRepository<PhongBan, String> {
}

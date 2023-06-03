package hokhanhdu.demo.services;

import hokhanhdu.demo.entity.PhongBan;
import hokhanhdu.demo.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    public PhongBan getPhongBanById(String id){
        Optional<PhongBan> optional = phongBanRepository.findById(id);
        return  optional.orElse(null);
    }
    public void addPhongBan(PhongBan phongBan){
        phongBanRepository.save( phongBan);
    }
    public void updatePhongBan(PhongBan phongBan){
        phongBanRepository.save(phongBan);
    }
    public void deletePhongBan(String id){
       phongBanRepository.deleteById(id);
    }
}

package hokhanhdu.demo.services;


import hokhanhdu.demo.entity.NhanVien;
import hokhanhdu.demo.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanvienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanvienRepository.findAll();
    }
    public NhanVien getNhanVienById(String id){
        Optional<NhanVien> optional = nhanvienRepository.findById(id);
        return  optional.orElse(null);
    }
    public void addNhanVien(NhanVien nhanVien){
        nhanvienRepository.save(nhanVien);
    }
    public void updateNhanVien(NhanVien nhanVien){
        nhanvienRepository.save(nhanVien);
    }
    public void deleteNhanVien(String id){
        nhanvienRepository.deleteById(id);
    }
}

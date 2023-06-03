package hokhanhdu.demo.controller;



import hokhanhdu.demo.entity.NhanVien;
import hokhanhdu.demo.services.NhanVienService;
import hokhanhdu.demo.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class NhanVienController {
    @Autowired
    private NhanVienService NhanVienService;

    @Autowired
    private PhongBanService phongBanService;


    @GetMapping("")
    public String index(){
        return "nhanvien/index";
    }
    @GetMapping("/nhanviens")
    public String showAllNhanViens(Model model) {
        List<NhanVien> NhanViens = NhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens",NhanViens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model) {

        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }

    @GetMapping("/edit/{id}")
    public String EditNhanVienFrom(@PathVariable("id") String id , Model model){
        NhanVien edit = null;
        for(NhanVien nhanVien: NhanVienService.getAllNhanVien()){
            if(nhanVien.getMa_nv().equals(id)){
                edit = nhanVien;
            }
        }
        if(edit !=null ){
            model.addAttribute("nhanvien",edit);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return  "nhanvien/edit";
        }
        else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String edit( @ModelAttribute("nhanvien")NhanVien update, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        NhanVienService.getAllNhanVien().stream()
                .filter(nhanvien -> nhanvien.getMa_nv() == update.getMa_nv())
                .findFirst()

                .ifPresent(nhanvien -> {
                    NhanVienService.updateNhanVien(update);
                });
        return "redirect:/nhanviens";
    }
    @PostMapping("/add")
    public String addNhanVien( @ModelAttribute("nhanvien") NhanVien nhanVien , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        NhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        NhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }

}

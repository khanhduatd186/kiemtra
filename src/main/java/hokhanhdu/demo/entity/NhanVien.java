package hokhanhdu.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhan_vien")
public class NhanVien {

    @Id
    @Column(name = "ma_nv")
    private String ma_nv;

    @Column(name = "ten_nv")
    @NotNull(message = "Employee name is required")
    private String ten_nv;

    @Column(name = "phai")
    private String phai;

    @Column(name = "noi_sinh")
    private String noi_sinh;
    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongban;
    @Column(name = "luong")
    private int luong;


}

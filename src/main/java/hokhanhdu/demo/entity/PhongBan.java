package hokhanhdu.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phong_ban")
public class PhongBan {
    @Id
    @Size(max =2 , min = 1)
    @Column(name = "ma_phong")
    private String Ma_Phong ;

    @Size(max =30 , min = 1)
    @NotNull
    @Column(name ="Ten_Phong")
    private String Ten_Phong;

    @OneToMany(mappedBy = "phongban", cascade = CascadeType.ALL)
    private List<NhanVien> nhanviens;

}

package tas.tes.tis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pesanan")
public class Pesanan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    private Integer noMeja;

    private Long keranjang;

    @ManyToOne
    @JoinColumn(name = "keranjang", referencedColumnName = "id", insertable = false, updatable = false)
    private Keranjang keranjangs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNoMeja() {
        return noMeja;
    }

    public void setNoMeja(Integer noMeja) {
        this.noMeja = noMeja;
    }

    public Long getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Long keranjang) {
        this.keranjang = keranjang;
    }

    public Keranjang getKeranjangs() {
        return keranjangs;
    }

    public void setKeranjangs(Keranjang keranjangs) {
        this.keranjangs = keranjangs;
    }
}

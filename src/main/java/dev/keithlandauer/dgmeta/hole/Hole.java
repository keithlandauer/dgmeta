package dev.keithlandauer.dgmeta.hole;

import dev.keithlandauer.dgmeta.layout.Layout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "holes")
public class Hole {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "par")
    private Integer par;

    @Column(name = "feet")
    private Integer feet;

    @Column(name = "tips")
    private List<String> tips;

    @Column(name = "imgurl")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "layout_id")
    private Layout layout;


    public Hole(Integer par, Integer feet, List<String> tips, String imgUrl, Layout layout_id) {
        this.par = par;
        this.feet = feet;
        this.tips = new ArrayList<String>(tips); 
        this.imgUrl = imgUrl;
        this.layout = layout_id;

    }

    public void setPar(Integer par) {
        this.par = par;
    }
    
}

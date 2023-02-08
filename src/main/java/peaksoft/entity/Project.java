package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "project_id_generator")
    @SequenceGenerator(name = "project_id_generator",sequenceName = "project_seq",allocationSize = 1)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;
    private int price;
    @ManyToMany(fetch = FetchType.EAGER,
            mappedBy = "projects",
    cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    } )
    private List<Programmer> programmers;

    public Project(String projectName, String description, LocalDate dateOfStart, LocalDate dateOfFinish, int price) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
    }
}

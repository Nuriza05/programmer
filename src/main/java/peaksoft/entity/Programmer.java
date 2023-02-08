package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Status;

import java.time.LocalDate;
import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "location")
@Table(name = "programmers")
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "programmer_id_generator")
    @SequenceGenerator(name = "programmer_id_generator",sequenceName = "programmer_seq",allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column( name = "date_of_birth")
    private LocalDate dateOfBirth ;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne( fetch = FetchType.EAGER,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Address location;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    private List<Project> projects;


    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;

    }

    private void dateOf(LocalDate dateOfBirth) throws Exception {
        if(dateOfBirth.isBefore(LocalDate.now())){
            this.dateOfBirth = dateOfBirth;
        }
        else {
            throw new Exception("Date of birth is wrong!");
        }
    }

}

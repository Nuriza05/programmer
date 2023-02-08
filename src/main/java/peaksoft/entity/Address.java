package peaksoft.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "countryId")
@Table(name = "addresses")
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,
generator = "address_id_generator")
@SequenceGenerator(name = "address_id_generator",sequenceName = "address_seq",allocationSize = 1)
    private Long id;
    private String regionName;
    private String street;
    private int homeNumber;
    @ManyToOne( fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
            })
    private Country countryId;
    @OneToOne(fetch = FetchType.EAGER,
            mappedBy = "location" , cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Programmer programmer;
    public Address(String regionName, String street, int homeNumber) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;

    }
}

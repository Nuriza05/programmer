package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "addressId")
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "country_id_generator")
    @SequenceGenerator(name = "address_id_generator",sequenceName = "country_seq",allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private peaksoft.enums.Country country;
    private String description;
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "countryId",
    cascade = CascadeType.ALL)
    private List<Address> addressId;
    public Country(peaksoft.enums.Country country, String description) {
        this.country = country;
        this.description = description;
    }
}

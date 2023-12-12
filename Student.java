import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Size(max = 10)
    private String quota = "N/A";

    @NotNull
    @Size(max = 100)
    private String country = "Bangladeshi";

    // getters and setters

}

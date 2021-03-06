package cat.udl.eps.softarch.learnphysics.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Theory extends UriEntity<Integer> {
    //public class Theory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(min = 1, max = 256)
    @NotBlank
    @Column(unique = true)
    private String name;

    private String contentLink;

    @Lob
    @Type(type="text")
    @Column(length = 2000 * 1025)
    private String text;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Topic topic;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Level level;

    @Override
    public Integer getId() {
        return id;
    }
}

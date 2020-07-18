package ge.mycompany.lms.usermanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import ge.mycompany.lms.usermanagement.entities.Authority;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
@SequenceGenerator(name ="userIdSeq" ,sequenceName = "user_id_seq")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userIdSeq")
    @Column(name ="id")
    private Integer id;

    @Column(name = "username")
    @NotBlank(message = "username should not be empty")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password should not be empty")
    @Size(min = 6,message = "size must be more than 6 chars")
//    @JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "enabled")
    @ColumnDefault(value = "true")
//    @JsonIgnore
    private Boolean enabled = true;

    @Transient
    @JsonIgnore
    @NotBlank(message = "confirm password should not be empty")
    @JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
    private String confirmPassword;

    public User(String username,String password,String confirmPassword){
        this.password = password;
        this.username = username;
        this.confirmPassword = confirmPassword;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "user_authorities",
            joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id",referencedColumnName = "id") }
    )

    @JsonManagedReference
    private List<Authority> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
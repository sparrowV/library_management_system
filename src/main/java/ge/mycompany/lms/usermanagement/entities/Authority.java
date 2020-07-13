package ge.mycompany.lms.usermanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "authorities")
@SequenceGenerator(name="authorityIdSeq",sequenceName ="authority_id_seq")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authorityIdSeq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "authorities")
    @JsonBackReference
    private List<User> users;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
package co.edu.polijic.taller.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "projectName", unique = true)
    @NotEmpty(message = "No puede estar en blanco")
    private String projectName;
    @Column(name = "projectIdentifier", unique = true, updatable = false)
    @Length(min = 5,max = 7)
    @NotEmpty(message = "No puede estar en blanco")
    private String projectIdentifier;
    @NotEmpty(message = "No puede estar en blanco")
    private String description;
    private Date startDate;
    private Date endDate;
    @OneToOne(mappedBy="project", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(ignoreUnknown = true, value = {"project"})
    private Backlog backlog;
}

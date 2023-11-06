package umc.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Require extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 10)
    private String type;

    @Lob
    private String content;

    @Lob
    private Blob picture;

    @Column(nullable = false)
    private boolean isResponse;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

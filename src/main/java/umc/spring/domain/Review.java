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
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private int reviewStar;

    @Lob
    private Blob picture;

    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market market;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

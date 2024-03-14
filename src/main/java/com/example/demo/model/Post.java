package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/* @Data 어노테이션:
@Data 어노테이션은 Lombok 라이브러리에서 제공하는 어노테이션으로,
주로 자바 클래스에서 Getter, Setter, toString(), equals(), hashCode() 등의 메소드를 자동으로 생성해주는 기능을 제공합니다.
이 어노테이션을 사용하면 코드의 가독성을 높이고, 반복적인 코드 작성을 줄일 수 있습니다.
예를 들어, @Data를 사용하면 Getter, Setter 메소드를 명시적으로 작성하지 않아도 됩니다.
 */
/* @Entity 어노테이션:
@Entity 어노테이션은 JPA(Java Persistence API)에서 엔티티 클래스를 나타내는 어노테이션입니다.
JPA는 데이터베이스와 자바 객체를 매핑하는 ORM(Object-Relational Mapping) 기술을 제공하는데, 이때 엔티티 클래스에 @Entity 어노테이션을 붙여야 합니다.
@Entity 어노테이션이 붙은 클래스는 데이터베이스 테이블과 매핑되어 영속성을 갖게 되며, JPA를 사용하여 데이터베이스와 상호작용할 수 있습니다.
*/
@Data
@AllArgsConstructor
public class Post {
    private String postId;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdDateTime;

    
}

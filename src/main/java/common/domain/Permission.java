package common.domain;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="Permission")
@DynamicUpdate(true)
public class Permission {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="permissionName")
    String permissionName;


}

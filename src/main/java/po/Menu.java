package po;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "Menu")
@DynamicUpdate(true)
public class Menu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "parent_menu")
    private Menu menu;

    @Column(name = "name")
    private String name; 	// 名称

    @Column(name = "href")
    private String href; 	// 链接
//    private String target; 	// 目标（ mainFrame、_blank、_self、_parent、_top）
//    private String icon; 	// 图标

    @Column(name = "sort")
    private Integer sort; 	// 排序

    @Column(name = "isShow")
    private String isShow; 	// 是否在菜单中显示（1：显示；0：不显示）


    @Column(name = "permission")
    private String permission; // 权限标识

}

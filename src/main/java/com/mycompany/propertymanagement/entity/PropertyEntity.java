package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name="EMAIL", nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;

    /*
    * sql > show columns from PROPERTY_TABLE ;
        FIELD  	        TYPE  	        NULL  	KEY  	DEFAULT
        ID	            BIGINT(19)	    NO	    PRI	    NULL
        ADDRESS	        VARCHAR(255)	YES		        NULL
        DESCRIPTION	    VARCHAR(255)	YES		        NULL
        EMAIL	        VARCHAR(255)	NO		        NULL
        OWNER_NAME	    VARCHAR(255)	YES		        NULL
        PRICE	        DOUBLE(17)	    YES		        NULL
        PROPERTY_TITLE	VARCHAR(255)	NO		        NULL
    * */
}

package com.example.hibernate_querydsl.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Entity
@Data
public class Person {


    @Id
    @GeneratedValue
    private Long id;
    private String name;


//    	 For H2 2.0.202+ one must use the varbinary DDL type
		@Column(name = "pswd", columnDefinition = "varbinary(100)")
		@ColumnTransformer(
			read = "AES_DECRYPT( pswd,'00') ",
			write = "AES_ENCRYPT(?,'00')"
		)
    private String pswd;


}

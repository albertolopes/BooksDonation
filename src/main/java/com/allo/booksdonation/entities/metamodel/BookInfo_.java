package com.allo.booksdonation.entities.metamodel;

import com.allo.booksdonation.entities.BookInfo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookInfo.class)
public class BookInfo_ {

    public static volatile SingularAttribute<BookInfo , String> authors;
    public static volatile SingularAttribute<BookInfo , String> categories;
}

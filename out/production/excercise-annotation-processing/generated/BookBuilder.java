package org.pieuler.domain;
public class BookBuilder{
public static BookBuilder create(){
return new BookBuilder();}

private Book object;
private BookBuilder(){
this.object = new Book();}
public Book build(){return this.object;}
}
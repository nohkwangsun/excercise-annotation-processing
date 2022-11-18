package org.pieuler.domain;
public class TodoBuilder{
public static TodoBuilder create(){
return new TodoBuilder();}

private Todo object;
private TodoBuilder(){
this.object = new Todo();}
public Todo build(){return this.object;}
}